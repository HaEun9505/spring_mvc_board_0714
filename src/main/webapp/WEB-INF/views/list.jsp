<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글목록</title>
</head>
<body>
	<h2>자유게시판 글목록</h2>
	<hr>
	<table width="600" cellpadding="0" cellspacing="0" border="1">
		<tr align="center" bgcolor="#D9E5FF">
			<td>번호</td>
			<td>글쓴이</td>
			<td>제목</td>
			<td>등록일</td>
			<td>조회수</td>			
		</tr>
		<!-- dto 안의 list 목록(배열), var - arraylist안에서 뽑아낸 하나의 객체 이름을 지정해줌-->
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bid }</td>
				<td>${dto.bname }</td>
				<td><a href="content_view?bid=${dto.bid }">${dto.btitle }</a></td>
				<td>${dto.bdate }</td>
				<td>${dto.bhit }</td>	
			</tr>
		</c:forEach>
		
		<tr align="right">
			<td colspan="5"><input type="button" value="글작성" onclick="href.location='write_form'"></td>	
		</tr>	
	</table>
</body>
</html>