<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String error=request.getParameter("error");
	if (error!=null){	
if ( error.equals("true") ){
%>
	<p style="background-color:red;">Error Authentification</p>
	<% }} %>
	<% String empty=request.getParameter("empty");
	if (empty!=null){	
if ( empty.equals("true") ){
%>
	<p style="background-color:red;">Empty Credentials</p>
	<% }} %>
		<% String sess=request.getParameter("session");
	if (sess!=null){	
if ( sess.equals("true") ){
%>
	<p style="background-color:red;">Session terminated</p>
	<% }} %>
	<P>Please fill out this form with your name. Thanks!
	<FORM METHOD="GET" action="ServletLogin">
		<P>Please enter your login and password:
		<P>
			login: <INPUT NAME="login" TYPE=" TEXT" SIZE=" 12" MAXLENGTH=" 20">
		<P>
			password: <INPUT NAME="password" TYPE=" TEXT" SIZE=" 12"
				MAXLENGTH=" 20">
		<P>
			Thank you! <INPUT TYPE="SUBMIT">
	</FORM>

</body>
</html>