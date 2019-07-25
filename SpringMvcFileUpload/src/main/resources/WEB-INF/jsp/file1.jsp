<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<center>
		<h1>文件上传</h1><hr>
		<form action="${pageContext.request.contextPath}/file/upload1" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>文件1：</td>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr>
					<td>文件2：</td>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr>
					<td>文件3：</td>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="提交">
						<input type="reset" value="重置">
					</td>
				</tr>
				
			</table>
		</form>
	</center>
</body>
</html>