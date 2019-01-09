<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    </style>
</head>
<body>
<script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>

<form action="/goods/getGoodsList" method="post">

    <label>编号:</label>
    <input type="text" name="id" placeholder="请输入编号" />
    <label>商品名:</label>
    <input type="text" name="goodsName" placeholder="请输入商品名"  />
    <label>所属分类:</label>
    <select name="goodsSmallId">
        <option value="">请选择</option>
    </select>
    <%--<label>折扣</label>
    <select name="goodsDiscId">
        <option value="">请选择</option>
    </select>--%>
    <input class="layui-btn " type="submit"  value="查询"/>
</form>
    <c:choose>
        <c:when test="${not empty requestScope.Map.pageData}">
            ${error}
            <table id="cus" width="90%" class="layui-table" lay-size="sm">
                <tr>
                    <th>编号</th>
                    <th>商品名</th>
                    <th>所属分类</th>
                    <th>商品价格</th>
                    <th>商品数量</th>
                    <th>商品图片</th>
                    <th>商品运费</th>
                    <th>商品类型</th>
                    <th>商品折扣</th>
                    <th colspan="2">操作</th>
                </tr>
                <c:forEach items="${requestScope.Map.pageData}" var="goods">
                    <tr>
                        <td>${goods.id}</td>
                        <td>${goods.goodsName}</td>
                        <td>${goods.smallClass.smallName}</td>
                        <td>${goods.goodsMoney}</td>
                        <td>${goods.goodsNumber}</td>
                        <td><img class="layui-nav-img" width="36px" src="static/back/Image/${goods.goodsImage}"></td>
                        <td>${goods.goodsCarriage}</td>
                        <td><c:if test="${goods.goodsType==0}">新品</c:if>
                            <c:if test="${goods.goodsType==1}">二手</c:if></td>
                        <td><c:if test="${goods.discount.discRate==1}">不打折</c:if>
                            <c:if test="${goods.discount.discRate!=1}">${goods.discount.discRate*10}折</c:if> </td>
                        <td><b class="layui-btn layui-btn-sm" onclick="del(${goods.id})">删除</b></td>
                        <td><a class="layui-btn layui-btn-sm" href="/goods/queryById?id=${goods.id}">修改</a></td>

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
            <h3>暂无顾客信息</h3>
        </c:otherwise>
    </c:choose>
</body>

<script>
    // 删除
    function del(id){
        var delStatus=window.confirm("是否删除该商品！")
        if (delStatus){
            open("/goods/delById?id="+id,"iframe_context");
        }
    }

       // error
        if (${not empty error}){
            alert("${error}")
        }

       // 小分类下拉框
        $(function (){
            var smallNameUrl="/smallClass/ajaxQuery";
            $.getJSON(smallNameUrl,function (smallClass) {
                $.each(smallClass,function (index, sc) {
                    $("select[name='goodsSmallId']").append("<option value='"+sc.id+"'>"+sc.smallName+"</option>")
                })
            })
        })
    /*//打折下拉框
    $(function (){
        var discountUrl="/discount/ajaxQuery";
        $.getJSON(discountUrl,function (discountList) {
            $.each(discountList,function (index, dc) {
                $("select[name='goodsSmallId']").append("<option value='"+dc.id+"'>"+sc.discRate+"</option>")
            })
        })
    })*/
</script>
</html>
