package com.zrzy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/12
 * Time: 16:19
 */
public class Hibernateutil {

    private static SessionFactory sessionFactory=null;
    private static Session session=null;

    static {

        // 注册服务
        Configuration configuration = new Configuration().configure();
        // 获取sessionfactory
        sessionFactory=configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }
    public static Session getSession(){

        session=sessionFactory.openSession();
        return session;
    }
}
