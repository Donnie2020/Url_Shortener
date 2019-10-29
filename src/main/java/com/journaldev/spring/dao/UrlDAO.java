package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Url;

public interface UrlDAO {
	public void addUrl(Url url);

	public Url getUrlByShortLink(String shortLink);
	
	public void updateUrl(Url url);
	
	public List<Url> listUrl();
}
