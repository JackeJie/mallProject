<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">
<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
      $(function (){
    	//步骤一:创建异步对象
    	  var ajax = new XMLHttpRequest();
    	  //步骤二:设置请求的url参数,参数一是请求的类型,参数二是请求的url,可以带参数,动态的传递参数starName到服务端
    	  ajax.open('get','count.s');
    	  //步骤三:发送请求
    	  ajax.send();
    	  //步骤四:注册事件 onreadystatechange 状态改变就会调用
    	  ajax.onreadystatechange = function () {
    	     if (ajax.readyState==4 &&ajax.status==200) {
    	      //步骤五 如果能够进到这个判断 说明 数据 完美的回来了,并且请求的页面是存在的
    	  　　　　console.log(ajax.responseText);//输入相应的内容
    	    　　}
    	  }
      })
</script>
</head>
<body>
		<div style="width: 1320px;height: 20px;">
		    <span><label>我的购物车</label><i>${count }</i></span>
		</div>
</body>
</html>