<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글내용 보기</h2>
	<hr>
	<!-- cellpadding: 셀과 글자 사이의 간격, cellspacing : 셀 간의 간격 -->
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify">
			<!-- submit버튼을 누르면 bid 값이 넘어가지만 안보이게 숨김 -->
			<input type="hidden" name="bid" value="${dto.bid }">
			<tr>
				<td>글쓴이</td>
				<!-- 데이터베이스 필드명과 동일하게 -->
				<td><input type="text" name="bname" size="50" value="${dto.bname }"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="btitle" size="50" value="${dto.btitle }"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea name="bcontent" rows="10" cols="40">${dto.bcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="삭제" onclick="location.href='delete?bid='+${dto.bid}">
					<input type="button" value="목록" onclick="location.href='list'">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>