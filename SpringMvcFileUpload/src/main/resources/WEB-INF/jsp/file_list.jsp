<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
<script>
function download(name) {
	var fname = encodeURI(encodeURI(name));
	window.location.href = '${pageContext.request.contextPath}/file/download?fname=' + fname;	
}
</script>
</head>
<body>
	<center>
		<h1>文件下载</h1><hr>
		<table>
			<c:forEach items="${fnames}" var="fname">
			<tr>
				<td><a href="javascript:download('${fname}')">${fname}</a></td>
			</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>