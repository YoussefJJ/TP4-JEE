<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="ServletUpdate?login=${login}">
		<table>
			<tr>
				<td>
					<p>login:</p>
				</td>
				<td><input type="text" name="newlogin"></td>
			</tr>
			<tr>
				<td><p>Name:</p></td>
				<td><input type="text" name="newname"></td>
			</tr>
			<tr>
				<td><p>E-mail:</p></td>
				<td><input type="email" name="newemail"></td>
			</tr>
			<tr>
				<td><p>Password:</p></td>
				<td><input type="password" name="newpassword"></td>
			</tr>
			<tr>
				<td><p>Ville:</p></td>
				<td><input type="text" name="newville"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit Query"></td>
			</tr>
		</table>
	</form>
</body>
</html>