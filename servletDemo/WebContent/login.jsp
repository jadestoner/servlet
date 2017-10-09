<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript" src="js/external/jquery-3.2.1.js"></script>
</head>
<body>
<form id="form">
账号：<input type="text" id="name" name="name"/><br/>
密码：<input type="text" id="pass" name="pass"/><br/>
<input type="button" id="register" value="注册"/>
<input type="button" id="submit" value="登录"/>
</form>
</body>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var data = {
			name:$("#name").val(),
			pass:$("#pass").val(),
			method:"login"
		};
		$.post("login",data,function(result){
			if(result.status=="success"){
				window.location.href='index.jsp';
			}else{
				$('#form')[0].reset()
				alert(result.message);				
			}
		});
	});
	
	$("#register").click(function(){
		var data = {
			name:$("#name").val(),
			pass:$("#pass").val(),
			method:"register"
		};
		$.post("login",data,function(result){
			if(result.status=="success"){
				window.location.href='index.jsp';
			}else{
				$('#form')[0].reset()
				alert(result.message);				
			}
		});
	})
})
</script>
</html>