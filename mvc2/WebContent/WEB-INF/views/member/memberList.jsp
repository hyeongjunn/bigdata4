<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script>
	function insertForm() {
		location.href="${cpath}/insertForm.do"; //위치 바꾸기
	} //엥 EL태그가 먹히네
	function deleteFn(num) {
		location.href="${cpath}/delete.do?num="+num;
		
	}
</script>
</head>
<body>
	<h1>회원 리스트 보기(MVC-Step1)</h1>
	
	
	<table width="1000px" border="1">
<tr>
   <td>번호</td>
   <td>이름</td>
   <td>전화번호</td>
   <td>주소</td>
   <td>위도</td>
   <td>경도</td>
   <td>삭제</td>
   
</tr>
<c:forEach items="${list}" var="vo">
<tr>
   <td>${vo.num}</td>
   <td><a href ="${cpath}/content.do?num=${vo.num}">${vo.name}</a></td>
   <td>${vo.phone}</td>
   <td>${vo.addr}</td>
   <td>${vo.lat}</td>
   <td>${vo.lng}</td>
   <td><input type = "button" value ="삭제" onclick ="deleteFn(${vo.num})"/></td>
</tr>
</c:forEach>
<tr>
	<td colspan ="6" align = "left">
	<input value="회원가입" type="button" onclick="insertForm()"/>
	</td>
</tr>
</table>
	

</body>
</html>