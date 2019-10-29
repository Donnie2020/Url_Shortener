package com.journaldev.spring.dao;

import com.journaldev.spring.model.Url;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UrlDAOImpl implements UrlDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUrl(Url url) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(url);
	}

	@Override
	public Url getUrlByShortLink(String shortLink) {
		Url url = null;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Url where shortLink = :shortLink ");
		query.setParameter("shortLink", shortLink);
		url = (Url) query.uniqueResult();
		return url;
	}

	@Override
	public void updateUrl(Url url) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(url);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Url> listUrl() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Url> urlList = session.createQuery("from Url").list();
		return urlList;
	}

}
