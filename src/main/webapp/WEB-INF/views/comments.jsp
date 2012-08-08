<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Comments</title>
		<style type="text/css">
		  span.label {
		    display: inline-block;
		    width: 100px;
		    text-align: right;
		    margin-right: 6px;
		  }
		  div {
		    margin: 4px;
		  }
		  .field {
		    width: 250px;
		  }
		</style>
	</head>
	<body>
		<h1>Comments</h1>
		<h2>Leave a comment</h2>
		<div>
		  <form:form method="post" modelAttribute="commentForm">
		    <div>
		      <span class="label">Message:</span>
		      <form:textarea class="field" path="message" />
		    </div>
		    <div>
		      <span class="label">Name:</span>
		      <form:input class="field" path="authorName" />
		    </div>
		    <div>
		      <span class="label">Email:</span>
		      <form:input class="field" path="authorEmail" />
		    </div>
		    <div>
		      <span class="label">URL:</span>
		      <form:input class="field" path="authorUrl" />
		    </div>
		    <div>
		      <span class="label"></span>
		      <input type="submit" value="add" />
		    </div>
		  </form:form>
		</div>
		<c:forEach var="comment" items="${comments}">
		  <div>
		    <h2>Comment ${comment.id}</h2>
		    <p>${comment.message}</p>
		    <p>${comment.authorName}</p>
		    <p>${comment.authorEmail}</p>
		    <p><a href="${comment.authorUrl}">${comment.authorUrl}</a></p>
		  </div>
		</c:forEach>
	</body>
</html>