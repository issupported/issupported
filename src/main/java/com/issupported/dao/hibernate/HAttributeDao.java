package com.issupported.dao.hibernate;

import com.issupported.dao.AttributeDao;
import com.issupported.model.Attribute;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HAttributeDao implements AttributeDao {

    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAll() {
        Session session = this.sessionFactory.openSession();
        List<Attribute> attributes = session.createQuery("select a from Attribute a").list();
        session.close();
        return attributes;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
