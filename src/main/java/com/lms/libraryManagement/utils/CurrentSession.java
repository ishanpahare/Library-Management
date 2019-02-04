package com.lms.libraryManagement.utils;

import org.hibernate.Session;

public class CurrentSession {

    private static final Session currentSession=HibernateUtil.getSession();

    public static Session getCurrentSession()
    {
        return currentSession;
    }

}
