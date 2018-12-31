<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询单条</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
		$("#count").attr("value","123")
	
	
         $("#but").on("click",function(){
        	 //返回上页
        	 window.history.back(-1);
         })

         $("#add").on("click",function(){
        	  var bookid=$("#bookid").val();
        	  var count=$("#count").val();
        	  $.post("")
         });
         
         

})
</script>

</head>
<body>
	<div>
		<jsp:include page="/resouce/head.jsp"></jsp:include>

	</div>
	<input type="button" value="返回" id="but">
	<div class="container">
		<table class="table table-bordered">

			<tr>
				<th>id</th>
				<td class="bookid">${BBookinfo.bookid }</td>
			</tr>
			<tr>
				<th>类型</th>
				<td><c:choose>
						<c:when test="${BBookinfo.booktypeid==0 }">书籍</c:when>
						<c:when test="${BBookinfo.booktypeid==1 }">衣服</c:when>
						<c:when test="${BBookinfo.booktypeid==2 }">零食</c:when>

						<c:otherwise>
         	 其它
         	</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<th>书名</th>
				<td>${BBookinfo.bookname }</td>
			</tr>
			<tr>
				<th>简介</th>
				<td>${BBookinfo.bookauthor }</td>
			</tr>
			<tr>
				<th>作者</th>
				<td>${BBookinfo.bookmoney }</td>
			</tr>
			<tr>
				<th>价格</th>
				<td>${BBookinfo.booknote }</td>
			</tr>
			<tr>
				<th>数量</th>
				<td><input type="text" id="count"></td>
			</tr>
		</table>
		<input type="button" value="加入购物车" id="add">
	</div>
</body>
</html>