package com.issupported.dao.hibernate;

import com.issupported.model.Attribute;
import com.issupported.model.BrowserSupported;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HBrowserSupportedDao implements com.issupported.dao.BrowserSupportedDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<BrowserSupported> getByAttribute(Attribute attribute) {
        Query query = sessionFactory.getCurrentSession().createQuery("select b from BrowserSupported b where b.attribute.id = :id");
        query.setParameter("id", attribute.getId());
        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
