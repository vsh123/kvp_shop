<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import ="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="도서 상세 정보" name="pageTitle"/>
</jsp:include>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<img src=${book.bookImage} width="100" height="150"><br>
isbn = ${book.isbn }<br>
-------------------------------<br>
저자명 = ${book.writerName }<br>
-------------------------------<br>
도서명 = ${book.bookTitle }<br>
-------------------------------<br>
가격   = ${book.bookPrice }원<br>
-------------------------------<br>
${info.get(0)}<br>
-------------------------------<br>
${info.get(1)}<br>
-------------------------------<br>
${info.get(2)}<br>
-------------------------------<br>
${info.get(3)}<br>
-------------------------------<br>

<!-- 카테고리 = ${item.bookCategory}<br>-->

Result2 페이지 <br />
</body>
</html>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>