package com.zrzy.dao;

import com.zrzy.entity.User;
import com.zrzy.util.Hibernateutil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/12
 * Time: 16:28
 */
public class UserDao {

    // 分页查询，页码，每页条数数

    public List<User> queryPage(int pageIndex,int pageCount){

        List<User> list = null;
        Session session = null; // 获取session
        try {
            list = new ArrayList<>();
            session = Hibernateutil.getSession();
            session.beginTransaction(); // 开始事物

            Query query = session.createQuery("from User");
            query.setFirstResult((pageIndex-1)*pageCount); // (索引-1)*每页条数
            query.setMaxResults(pageCount); // 每页条数

            list = query.list();
            session.getTransaction().commit(); // 事物提交
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return list;

    }


    public int pages(int pageCount){
        int pages=1; // 从第一页开始
        Session session = Hibernateutil.getSession(); // 获取session
        session.beginTransaction(); // 开启事物

        Query query = session.createQuery("select count (1) from User");
        Number number = (Number) query.uniqueResult(); // 获取总条数
        int i = number.intValue(); //
        session.getTransaction().commit();
        session.close();

        pages = (i + pageCount - 1) / pageCount;

        return pages;
    }

    public static void main(String[] args) {

        List<User> users = new UserDao().queryPage(1,5);

        for (User user:users) {

            System.out.println(user);
        }

        System.out.println(new UserDao().pages(3));

    }


}
