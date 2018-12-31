<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加商品</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
	
	$("#insert").on("click",function(){
		
		
		    check();
		
		  var bookname=$("#bookname").val();
		  var booktypeid=$("#booktypeid").find("option:selected").val();
		  
		  alert(booktypeid);
	})
	
	
	
	function check(){
		if($("#bookname").val()==null||$("#bookname").val()==""){
			alert("商品需要填写的哦");
			$("#bookname").focus();
			return ;
		}
		if(("#bookauthor").val()==null||$("#bookauthor").val()==""){
			alert("需要填写作者名");
			$("#bookauthor").focus();
			return ;
		}
			if(("#bookmoney").val()==null||$("#bookmoney").val()==""){
				alert("需要填写金额");
				$("#bookmoney").focus();
				return ;
			}
			if(("#booknote").val()==null||$("#booknote").val()==""){
				alert("需要填写标签");
				$("#booknote").focus();
				return ;
			}
			
			
	}
	
	$("#booktypeid").on("change",function(){
		
	var booktypeid=	$("#booktypeid").find("option:selected").val();
	})
	
	
	})
	
	
	
	



</script>


<body>
<form   action="">
   <i>商品名:</i>  <input type="text" placeholder="商品名" name="bookname" id="bookname"><br>
	 <i>作者名:</i>  <input type="text" placeholder="作者名" name="bookauthor" id="bookauthor"><br>
	  <i>价    格:</i>  <input type="text" placeholder="价格" name="bookmoney" id="bookmoney"><br>
	   <i>标     签:</i>  <input type="text" placeholder="商品标签" name="booknote" id="booknote"><br>
	    <i>类    型:</i>  <select id="booktypeid" name="booktypeid">
	    					<option value="0" >书籍</option>
	    					<option value="1">衣服</option>
	    					<option value="2">零食</option>
	    					<option value="3">其它</option>
	    				</select>
	    				<br>
	    <input type="button" value="添   加"  id="insert">				
	    				
</form>
</body>
</html>