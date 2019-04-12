<%@ page import="com.zrzy.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页</title>
</head>
<body>
<table>
    <%-- 表头 --%>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
    </tr>

    <%--数据--%>
    <%--<%--%>
        <%--List<User> users = (List<User>)request.getAttribute("UserServlet");--%>
        <%--for (User user:users) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<%=user.getId()%>--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<%=user.getUsername()%>java--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<%=user.getPassword()%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                    ${user.id}
            </td>
            <td>
                    ${user.username}
            </td>
            <td>
                    ${user.password}
            </td>
        </tr>
    </c:forEach>

</table>
<%-- 分页页码  --%>
<div>
    <c:forEach var="i" begin="1" end="${pages}" >
        <a href="/UserServlet?pageIndex=${i}">
                ${i}
        </a>
    </c:forEach>
</div>
</body>
</html>
