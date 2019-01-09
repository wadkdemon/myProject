<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改管理员资料</title>
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
    <form action="/admin/updateSuperUser">
        <input type="text" name="id" value="${superUser.id}" hidden>
        <label>真实姓名</label>
        <input type="text" readonly name="userName" value="${superUser.userName}"><br/>
        <label>用户老密码</label>
        <input type="password" readonly name="oldPwd" value="${superUser.userPassword}"><br/>
        <label>用户新密码</label>
        <input type="password" readonly name="newPwd" value=""><br/>

        <input type="submit" name="btn" value="提交">
        <input type="submit" name="out" value="返回">
    </form>
</body>
    <script type="text/javascript">
        var oldPwd=document.getElementsByName("oldPwd")[0].value;
        alert(oldPwd);
    </script>
</html>
