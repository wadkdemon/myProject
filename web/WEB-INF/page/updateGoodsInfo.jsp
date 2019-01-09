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
   <form action="/goods/updateById" method="post">
       <label>编号</label>
       <input type="text" name="id"  value="${goods.id}"readonly/><br>
        <label>商品名称</label>
       <input type="text" name="goodsName"  value="${goods.goodsName}"/><br>
        <label>商品所属分类</label>
       <select name="goodsSmalId">
       </select> <br>
        <label>商品价格</label>
       <input type="text" name="goodsMoney"  value="${goods.goodsMoney}"/><br>
       <label>商品数量</label>
       <input type="text" name="goodsNumber"  value="${goods.goodsNumber}"/><br>
       <label>商品图片</label>
       <input type="text" name="goodsImage"  value="${goods.goodsImage}"/><br>
       <label>商品运费</label>
       <input type="text" name="goodsCarriage"  value="${goods.goodsCarriage}"/><br>
       <label>商品类型</label>
       <input type="text" name="goodsType"  value="${goods.goodsType}"/><br>
       <label>商品折扣</label>
       <input type="text" name="goodsDiscId"  value="${goods.goodsDiscId}"/><br>
       <input type="submit" value="修改">
   </form>
</body>
<script>
    $(function () {
        var url="/smallClass/ajaxQuery";
        $.getJSON(url,function (Smaillclass) {
            $.each(Smaillclass,function (index, gd) {
                $("select[name='goodsSmalId']").append("<option value='"+gd.id+"'>"+gd.cusName+"</option>")
            })
        })
    })
</script>
</html>
