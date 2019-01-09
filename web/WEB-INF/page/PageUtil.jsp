<%@ page contentType="text/html;charset=UTF-8" language="java" %>
第<b>${requestScope.Map.currentPage}</b>页&nbsp;&nbsp;
<a class="layui-btn" href="${pageContext.request.contextPath }${Map.url}1">首页</a>
<a class="layui-btn" href="${pageContext.request.contextPath }${Map.url}${Map.currentPage-1>0?Map.currentPage-1:1}">上一页</a>
<a class="layui-btn" href="${pageContext.request.contextPath }${Map.url}${Map.currentPage+1<Map.totalPage?Map.currentPage+1:Map.totalPage}">下一页</a>
<a class="layui-btn" href="${pageContext.request.contextPath }${Map.url}${Map.totalPage}">尾页</a>
&nbsp;&nbsp;共<b>${requestScope.Map.totalPage}</b>页 &nbsp;&nbsp;

<select id="jumpNumber">
    <c:forEach begin="1" varStatus="num" end="${requestScope.Map.totalPage}">
        <option name="option1" value="${num.count}">-${num.count}页-</option>
    </c:forEach>
</select>
&nbsp;&nbsp;
<b class="layui-btn" onclick="jump()">跳转</b>
<script>
    document.getElementsByName("option1")[${requestScope.Map.currentPage-1}].selected = true;
    function jump() {
        var number = document.getElementById("jumpNumber").value;
        //open("doTea?action=queryAll&currentPage="+number,"iframe_context");
        location = "${pageContext.request.contextPath }${Map.url}"+number;
    }
</script>
