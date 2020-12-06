<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		Id User:${sessionScope.user.getIdUser()}</p>
	<p>
		Login:${sessionScope.user.getLogin()}</p>
	<p>
		Pass:${sessionScope.user.getPass()}</p>
	<p>
		Email:${sessionScope.user.getEmail()}</p>
	<p>
		Ville:${sessionScope.user.getVille()}</p>
		<a href="Ajout.html">Ajout</a><br>
		<a href="ServletAffichage">Liste des utilisateurs</a>
</body>
</html>