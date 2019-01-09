<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>超级管理员基本信息</title>
    <style>
        input{
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }
        form{
            width: 80%;
            margin: auto;
            padding: 40px;
        }
    </style>
</head>
<b> ${error}</b>
<body>
    <form action="/admin/superUserShowById">
        <input type="text" name="id" value="${superUser.id}" hidden>
        <label>登录姓名</label>
        <input type="text" readonly name="userLoginName" value="${superUser.userLoginName}"><br/>
        <label>真实姓名</label>
        <input type="text" readonly name="userName" value="${superUser.userName}"><br/>
        <%--<label>用户密码</label>--%>
        <%--<input type="password" readonly name="password" value="${superUser.userPassword}">--%>
        <label>状态</label>
        <c:choose>
            <c:when test="${superUser.userStatus}=0">
                <input type="text" readonly name="userStatus" value="可用"><br/>
            </c:when>
            <c:otherwise>
                <input type="text" readonly name="userStatus" value="冻结"><br/>
        </c:otherwise>
        </c:choose>
        <a href="/admin/updateById?id=${superUser.id}">修改资料</a>
        <a href="/WEB-INF/page/index.jsp">返回</a>

    </form>

</body>
</html>
