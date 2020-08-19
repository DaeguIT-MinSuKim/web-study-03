<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
    String season = request.getParameter("season");
    
    request.setAttribute("name", name);
    request.setAttribute("gender", gender);
    request.setAttribute("season", season);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <b>${name}</b><br>
	성별 : <b>${gender}</b><br>
	당신이 좋아하는 계절은 <b> ${season }</b>
	<br>
	<b><a href='javascript:history.go(-1)'>다시</a></b><br>
</body>
</html>