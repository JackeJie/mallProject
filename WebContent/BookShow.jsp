<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function (){
	  // alert(1);
			// 2、$.get()方式，简单的 GET 请求功能以取代复杂 $.ajax
	    //   $.get("getAll.s",null,function(data){ //param为参数---键值对方式
	   //  	   alert(data.msg)
	   //  	   $("#info").html("");//清空info内容
	  //   	   $.each(data.data, function(i, item) {
		//             $("#info").append(
		//                    "<tr>"+
		// //                    "<td>"+   item.bookid +"</td>"+
		 //                   "<td>"+   item.booktypeid +"</td>"+
		 //                   "<td>"+   item.bookname +"</td>"+
		  //                  "<td>"+   item.bookauthor +"</td>"+
		                //                   "<td>"+   item.bookmoney +"</td>"+
		   //                 "<td>"+   item.booknote +"</td>"+
		   //                 "<td class='dd'   >"+   "查看" +"</td>"+
		    //                "</tr>"
		     //               );
		   //      });
	     //   })
        
   
   
   
   })
   
   


</script>
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>类型</th>
					<th>书名</th>
					<th>简介</th>
					<th>作者</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<!--  <tbody id="info">
	
	</tbody>

 -->
			<c:forEach items="${list }" var="c">
				<tr>
					<td>${c.bookid }</td>
					<td><c:choose>
							<c:when test="${c.booktypeid==0 }">书籍</c:when>
							<c:when test="${c.booktypeid==1 }">衣服</c:when>
							<c:when test="${c.booktypeid==2 }">零食</c:when>

							<c:otherwise>
         	 其它
         	</c:otherwise>
						</c:choose></td>
					<td>${c.bookname }</td>
					<td>${c.bookauthor }</td>
					<td>${c.bookmoney }</td>
					<td>${c.booknote }</td>
					<td><a href="selectOne.s?id=${c.bookid }" >查看</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>



</body>
</html>