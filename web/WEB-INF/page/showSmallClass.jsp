<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--<base href="<%=request.getContextPath() %>/" />--%>
    <base href="${pageContext.request.contextPath}/"/>
    <%@include file="layUI.jsp"%>
</head>
<body>
<script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>
<form action="/smallClass/showInfo" method="post">
    <label>编号:</label>
    <input type="text" name="id" placeholder="请输入编号" />
    <label>小商品名称:</label>
    <input type="text" name="smallName" placeholder="请输入名称"  />
    <label>所属大分类:</label>
    <select name="smallBigId">
        <option value="">请选择</option>
    </select>
    <input class="layui-btn " type="submit"  value="查询"/>
</form>
<c:choose>
    <c:when test="${not empty Map.pageData}">
        ${error}
        <table id="stu" width="90%" class="layui-table" lay-size="sm">
            <tr>
                <th>编号</th>
                <th>小分类名称</th>
                <th>所属大分类</th>
                <th>小分类描述</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${Map.pageData}" var="smallClass">
                <tr>
                    <td>${smallClass.id}</td>
                    <td>${smallClass.smallName}</td>
                    <td>${smallClass.bigClass.bigName}</td>
                    <td><a class="layui-btn layui-btn-sm" href="/smallClass/delById?id=${smallClass.id}">删除</a></td>
                    <td><a class="layui-btn layui-btn-sm" href="/smallClass/queryById?id=${smallClass.id}">修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="9">
                    <%@include file="PageUtil.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <h3>暂无小分类信息</h3>
    </c:otherwise>
</c:choose>
</body>
<script>
    $(function () {
        var url="/bigClass/ajaxQuery";
        $.getJSON(url,function (bigClassList) {
            $.each(bigClassList,function (index, bg) {
                $("select[name='smallBigId']").append("<option value='"+bg.id+"'>"+bg.bigName+"</option>")
            })
        })
    })
</script>
</html>
