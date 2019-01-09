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
        <%--文件上传必须加 enctype="multipart/form-data" ！！！！！！！！！！！--%>
   <form action="/goods/addGoods" method="post" enctype="multipart/form-data">
       <%--<label>编号</label>--%>
       <%--<input type="text" name="id"  value="${goods.id}"hidden/><br>--%>
        <label>商品名称</label>
       <input type="text" name="goodsName"  value="${goods.goodsName}" required/><br>
        <label>商品所属分类</label>
        <select name="goodsSmallId">
        </select> <br>
        <label>商品价格</label>
       <input type="text" name="goodsMoney"  value="${goods.goodsMoney}" required/><br>
       <label>商品数量</label>
       <input type="text" name="goodsNumber"  value="${goods.goodsNumber}" required/><br>
       <label>商品运费</label>
       <input type="text" name="goodsCarriage"  value="${goods.goodsCarriage}" required/><br>
       <label>商品类型</label>
       <select name="goodsType">
           <option value="0">新品</option>
           <option value="1">二手</option>
       </select><br>
       <label>商品折扣</label>
       <select name="goodsDiscId">
       </select><br>
        <label>商品图片</label>
        <input type="file" name="goodsImage"  value="${goods.goodsImage}" />
           <b id="imageMsg">文件大小必须不能超过5M</b><br>
        <input type="submit" value="增加">
   </form>
</body>
<script>
    $(function () {
        // 小分类下拉框
            var smallNameUrl="/smallClass/ajaxQuery";
            $.getJSON(smallNameUrl,function (smallClass) {
                $.each(smallClass,function (index, sc) {
                    $("select[name='goodsSmallId']").append("<option value='"+sc.id+"'>"+sc.smallName+"</option>")
                })
            });
       /* //打折下拉框
        $(function (){
            var discountUrl="/discount/ajaxQuery";
            $.getJSON(discountUrl,function (discountList) {
                $.each(discountList,function (index, dc) {
                    $("select[name='goodsSmallId']").append("<option value='"+dc.id+"'>"+sc.discRate+"</option>")
                })
            })
        })*/
        //图片上传
        $("input[type='file']").change(function () {
            // 从前端获取文件名
            var fileName=$(this).val();
            // 获取文件类型
            var fileType=fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            // 图片正则
            var fileTypeReg=/gif|bmp|png|jpg|jpeg|icon/;
            if (fileTypeReg.test(fileType)){
                $("#imageMsg").html("正确！")
            } else {
                $("#imageMsg").html("文件后缀错误！必须是gif|bmp|png|jpg|jpeg|icon").css("color","red");
                $(this).val();
            }
        })
    })
</script>
</html>
