<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="/fileformProc" method="post" enctype="multipart/form-data">
<input type="text" id="key" name="key"><br>
<input type="file" id="file" name="file"><br>
<input type="submit" value="전송">

</form>

</body>
</html>