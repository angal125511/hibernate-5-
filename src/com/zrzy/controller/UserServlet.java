package com.zrzy.controller;

import com.zrzy.dao.UserDao;
import com.zrzy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/12
 * Time: 18:36
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageIndext=1; // 初始化页码
        String indext = request.getParameter("pageIndext"); // 初始化页码

        if(indext!=null){
            pageIndext= Integer.parseInt(indext);
        }

        int pageCount=5; // 每页条数
        UserDao userDao = new UserDao();
        int pages = userDao.pages(pageCount);

        List<User> users = userDao.queryPage(pageIndext, pageCount);

        request.setAttribute("pages",pages);
        request.setAttribute("users",users);

        request.getRequestDispatcher("/page.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
