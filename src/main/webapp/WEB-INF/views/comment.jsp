<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Comment</title>
	</head>
	<body>
		<h1>Comment</h1>
		<div>
		  <h2>${comment.id}</h2>
		  <p>${comment.message}
		  <p>${comment.authorName}</p>
		  <p><a href="${comment.authorUrl}">${comment.authorUrl}</a></p>
		</div>
	</body>
</html>