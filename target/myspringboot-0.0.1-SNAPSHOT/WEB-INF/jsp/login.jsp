<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta name="generator"
	content="HTML Tidy for HTML5 for Windows version 5.2.0" />
<meta charset="utf-8" />
<title>登录</title>
<meta name="googlebot" content="noarchive" />
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
<link
	href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
<script>
function login() {
	var isChecked = $(".checkbox input").prop("checked");
	var rememberMe = "";
	if(!isChecked){
		rememberMe = "&rememberMe=no";
	}
	$.ajax({
		url:"${APP_PATH}/loginContr",
		type:"GET",		
		data: $('#form1').serialize()+rememberMe,
		success:function(response){
			console.log(response);
			if(response=="login"){
				reset();
				alert("用户名或者密码错误")
			}else{
			window.location.replace(response);				
			}
		}
		});
	$.ajax({
		url:"${APP_PATH}/set",
		type:"POST",		
		 contentType: "application/json", //必须有
		data:JSON.stringify({"id":1,"name":"李华","birthday":"2020-07-09","score":99.4}),
		success:function(response){
			console.log(response);
			
		}
		});
}
function reset() {
	//$('#form1')[0].reset();
	$.ajax({
		url:"${APP_PATH}/set",
		type:"POST",		
		data:"id=1&name=李华&birthday=2020-070-09&scor=99.4",
		success:function(response){
			console.log(response);
			
		}
		});
} 
    </script>
<style>
body {
	margin: 5% 40% 0% 40%;
}

button {
	margin: 0 10px 0 0;
}
</style>
</head>
<body background="${APP_PATH}/static/img/login_background.jpg">
<p>管理员账号：myfinanceweb</p>
<p>管理员密码：myfinanceweb31415926</p>
	<form id="form1">
		<div class="form-group">
			<label for="exampleInputEmail1">用户名</label> <input type="text"
				class="form-control" name="userName" placeholder="用户名">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">密码</label> <input
				type="password" class="form-control" name="password"
				placeholder="密码">
		</div>
		<div class="checkbox">
			<label> 
			<input type="checkbox" checked="true" name="rememberMe" value="yes">			
			在这台电脑上记住我
			</label>
		</div>
		<button type="button" class="btn btn-info" onclick="reset()">取消</button>
		<button type="button" class="btn btn-primary" onclick="login()">登录</button>
	</form>
	<a href="${APP_PATH}/register">注册</a>
</body>
</html>
