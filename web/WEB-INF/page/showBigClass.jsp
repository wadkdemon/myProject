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
<c:choose>
    <c:when test="${not empty Map.bigClassList}">
        ${error}
        <table id="stu" width="90%" class="layui-table" lay-size="sm">
            <tr>
                <th>编号</th>
                <th>大分类名称</th>
                <th>大分类描述</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${Map.bigClassList}" var="bigClass">
                <tr>
                    <td>${bigClass.id}</td>
                    <td>${bigClass.bigName}</td>
                    <td>${bigClass.bigText}</td>
                    <td><a class="layui-btn layui-btn-sm" href="/bigClass/del?id=${bigClass.id}">删除</a></td>
                    <td><a class="layui-btn layui-btn-sm" href="/bigClass/updateById?id=${bigClass.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h3>暂无大分类信息</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
