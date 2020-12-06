<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr><th>Login utilisateur</th>
	    <th>Name</th>
	    <th>Email</th>
	    <th>Ville</th>
		<c:forEach items="${userlist}" var="useritem">
			<tr>
				<td><p>${useritem.getLogin()}</p></td>
				<td><p>${useritem.getName()}</p></td>
				<td><p>${useritem.getEmail()}</p></td>
				<td><p>${useritem.getVille()}</p></td>
				<td><a href="ServletDelete?login=${useritem.getLogin()}"}>Supprimer</a></td>
				<td><a href="ServletUpdate?login=${useritem.getLogin()}"}>Mise à jour</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="Bienvenue.jsp">Retour</a>
</body>
</html>