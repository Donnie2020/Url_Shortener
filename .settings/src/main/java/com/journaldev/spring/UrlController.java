package com.journaldev.spring;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.PwdForm;
import com.journaldev.spring.model.Url;
import com.journaldev.spring.service.UrlService;

@Controller
public class UrlController {
	private UrlService urlService;

	@Autowired(required = true)
	@Qualifier(value = "urlService")
	public void setUrlService(UrlService us) {
		this.urlService = us;
	}

	@RequestMapping(value = "/link", method = RequestMethod.GET)
	public String createLink(Model model, HttpSession session) {
		model.addAttribute("url", new Url());
		model.addAttribute("linkGeneration", session.getAttribute("linkGeneration"));
		return "link";
	}

	@RequestMapping(value = "/link/add", method = RequestMethod.POST)
	public String createShortLink(@ModelAttribute("url") Url url, Model model, HttpSession session) {
		if (!url.getSourceLink().startsWith("http")) {
			url.setSourceLink("https://".concat(url.getSourceLink()));
		}
		url.setShortLink(RandomStringUtils.randomAlphanumeric(6).toLowerCase());
		session.setAttribute("linkGeneration", "http://localhost:8089/SpringMVCHibernate/".concat(url.getShortLink()));
		url.setDateCreate(new Date());
		this.urlService.addUrl(url);
		return "redirect:/link";
	}

	@RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
	public String method7(@PathVariable("shortLink") String shortLink, Model model, HttpSession session) {
		String target = null;
		Url url = this.urlService.getUrlByShortLink(shortLink);
		if (!hasPassword(url)) {
			url.setView(url.getView() + 1);
			this.urlService.updateUrl(url);
			target = "redirect:".concat(url.getSourceLink());
			return target;
		} else {
			session.setAttribute("shortLink", shortLink);
			target = "redirect:/password-validation";
		}
		return target;
	}

	@RequestMapping(value = "/url-list", method = RequestMethod.GET)
	public String getListUrl(Model model) {
		model.addAttribute("urlLits", this.urlService.listUrl());
		return "list";
	}
	
	@RequestMapping(value = "/password-validation", method = RequestMethod.GET)
	public String validatePassword(Model model) {
		model.addAttribute("pwdForm", new PwdForm());
		return "password-validation";
	}
	
	@RequestMapping(value = "/password-validation", method = RequestMethod.POST)
	public String submitPwd(@ModelAttribute("pwdForm") PwdForm pwdForm, Model model, HttpSession session){
		String target = "password-validation";
		String shortLink = session.getAttribute("shortLink").toString(); 
		if(checkPassword(pwdForm, shortLink)){
			Url url = this.urlService.getUrlByShortLink(shortLink);
			target = "redirect:".concat(url.getSourceLink());
			url.setView(url.getView() + 1);
			this.urlService.updateUrl(url);
		} else {
			model.addAttribute("msg","Sai mat khau");
		}
		return target;
	}

	protected boolean hasPassword(Url url) {
		if (url.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}
	
	protected boolean checkPassword(PwdForm pwdForm, String shortLink){
		boolean pwdResult = false;
		if(this.urlService.getUrlByShortLink(shortLink).getPassword().equals(pwdForm.getPassword())){
			pwdResult = true;
		}
		return pwdResult;
	}
	
}
