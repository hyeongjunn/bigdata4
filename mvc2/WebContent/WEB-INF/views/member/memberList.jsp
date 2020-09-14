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
		location.href="${cpath}/insertForm.do"; //��ġ �ٲٱ�
	} //�� EL�±װ� ������
	function deleteFn(num) {
		location.href="${cpath}/delete.do?num="+num;
		
	}
</script>
</head>
<body>
	<h1>ȸ�� ����Ʈ ����(MVC-Step1)</h1>
	
	
	<table width="1000px" border="1">
<tr>
   <td>��ȣ</td>
   <td>�̸�</td>
   <td>��ȭ��ȣ</td>
   <td>�ּ�</td>
   <td>����</td>
   <td>�浵</td>
   <td>����</td>
   
</tr>
<c:forEach items="${list}" var="vo">
<tr>
   <td>${vo.num}</td>
   <td><a href ="${cpath}/content.do?num=${vo.num}">${vo.name}</a></td>
   <td>${vo.phone}</td>
   <td>${vo.addr}</td>
   <td>${vo.lat}</td>
   <td>${vo.lng}</td>
   <td><input type = "button" value ="����" onclick ="deleteFn(${vo.num})"/></td>
</tr>
</c:forEach>
<tr>
	<td colspan ="6" align = "left">
	<input value="ȸ������" type="button" onclick="insertForm()"/>
	</td>
</tr>
</table>
	

</body>
</html>