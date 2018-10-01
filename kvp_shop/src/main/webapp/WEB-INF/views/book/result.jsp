<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import ="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${book}" var="item">

<img src=${item.bookImage} width="100" height="150"><br>
isbn = ${item.isbn }<br>
저자명 = ${item.writerName }<br>
도서명 = ${item.bookTitle }<br>
가격   = ${item.bookPrice }원<br>
----------------------------------------------------------------<br>
</c:forEach>
Result 페이지 <br />
</body>
</html>