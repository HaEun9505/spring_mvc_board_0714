<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 입력</title>
</head>
<body>
	<h2>댓글 입력하기</h2>
	<hr>
	<!-- cellpadding: 셀과 글자 사이의 간격, cellspacing : 셀 간의 간격 -->
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<!-- submit 버튼 누르면 reply 페이지로 -->
		<form action="reply">
			<!-- submit버튼을 누르면 화면에 안보이지만 값을 넘김(request객체에 실어서 전달) -->
			<!-- 원글을 넘겨줌 -->
			<input type="hidden" name="bgroup" value="${dto.bgroup }" >
			<input type="hidden" name="bstep" value="${dto.bstep }" >
			<input type="hidden" name="bindent" value="${dto.bindent }" >
			<tr>
				<td>글번호</td>
				<td>
					<input type="text" name="bid" size="50" value="${dto.bid }">
				</td>
			</tr>
			<tr>
				<td>조회수</td>
				<!-- 데이터베이스 필드명과 동일하게 -->
				<td>
					<input type="text" name="bhit" size="50" value="${dto.bhit }">
				</td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<!-- 데이터베이스 필드명과 동일하게 -->
				<td>
					<input type="text" name="bname" size="50" value="${dto.bname }">
				</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>
					<input type="text" name="btitle" size="50" value="[답변] ${dto.btitle }">
				</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea name="bcontent" rows="10" cols="40">${dto.bcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="답변쓰기">
					<input type="button" value="목록" onclick="location.href='list'">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>