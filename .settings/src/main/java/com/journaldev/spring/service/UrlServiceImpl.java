package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.UrlDAO;
import com.journaldev.spring.model.Url;

@Service
public class UrlServiceImpl implements UrlService {
	private UrlDAO UrlDAO;

	public void setUrlDAO(UrlDAO urlDAO) {
		UrlDAO = urlDAO;
	}

	@Override
	@Transactional
	public void addUrl(Url url) {
		this.UrlDAO.addUrl(url);
	}

	@Override
	@Transactional
	public Url getUrlByShortLink(String shortLink) {
		return this.UrlDAO.getUrlByShortLink(shortLink);
	}

	@Override
	@Transactional
	public void updateUrl(Url url) {
		this.UrlDAO.updateUrl(url);
	}

	@Override
	@Transactional
	public List<Url> listUrl() {
		return this.UrlDAO.listUrl();
	}

}
