package com.issupported.dao.hibernate;

import com.issupported.dao.AttributeSupportedByBrowserDao;
import com.issupported.model.Attribute;
import com.issupported.model.AttributeSupportedByBrowser;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HAttributeSupportedByBrowserDao implements AttributeSupportedByBrowserDao {

    private SessionFactory sessionFactory;

    @Override
    public AttributeSupportedByBrowser getByAttribute(Attribute attribute) {
        Query query = sessionFactory.getCurrentSession().createQuery("select asbb from AttributeSupportedByBrowser asbb where asbb.attribute = :attribute");
        query.setParameter("attribute", attribute);
        return (AttributeSupportedByBrowser) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
