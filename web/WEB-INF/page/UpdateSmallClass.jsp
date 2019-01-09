<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<base href="<%=request.getContextPath() %>/" />--%>
    <base href="${pageContext.request.contextPath}/"/>
    <%@include file="layUI.jsp"%>
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
    <script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>
</head>
<body>
    <form action="/smallClass/updateById" method="post">
        <label>编号:</label><input type="text" name="id" value="${smallClass.id}" readonly/><br>
        <label>小分类名称:</label><input type="text" name="bigName" value="${smallClass.smallName}" /><br>
        <label>大分类名称：</label>
        <select name="smallBigId" >
        </select><br/>
        <label>描述信息:</label><input type="text" name="bigText" value="${smallClass.smallText}" /><br>
        <input type="submit" value="保存修改" class="layui-btn"/>
    </form>
</body>
<script>
    $(function () {
        var url="/bigClass/ajaxQuery";
        $.getJSON(url,function (bigClassList) {
            $.each(bigClassList,function (index, bigClass) {
                $("select[name='smallBigId']").append("<option value='"+bigClass.id+"'>"+bigClass.bigName+"</option>")
            })
        })
    })
</script>
</html>
