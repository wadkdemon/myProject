<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath }/"/>
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
<script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>
<body>
<b> ${error}</b>
   <form action="/customer/update" method="post">
       <label>编号</label>
       <input type="text" name="id"  value="${cus.id}"readonly/><br>
        <label>姓名</label>
       <input type="text" name="cusName"  value="${cus.cusName}"/><br>
        <label>昵称</label>
       <input type="text" name="cusLoginName"  value="${cus.cusLoginName}"/><br>
        <label>密码</label>
       <input type="text" name="cusPassword"  value="${cus.cusPassword}"/><br>
       <input type="submit" value="修改">
   </form>
</body>
</html>
