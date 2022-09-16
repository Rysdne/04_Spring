<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	function jsonformsend() {
		// 일반 Object : json 형태
		// 파일 데이터 : formData 형태
		var obj = {"key":$('#key').val()}
		
		// 일반객체와 파일객체를 같이 전달
		// 파일전송용 객체 생성
		var formData = new FormData();
		
		// 일반객체
		// stringify : JSON내용을 문자열화
		// [] 내부에 있는 것이 하나의 객체
		// type으로 json객체임을 알려줌
		formData.append("obj", new Blob([JSON.stringify(obj)],{type:"application/json"}));
		
		// 파일객체
		// file이 여러개 등록될 경우르르 대비해 배열로 전달받음
		formData.append("file1", $('#file1')[0].files[0]);
		
		console.log(obj.key);
		console.log($('#file1').val());
		
		// AJAX 통신
		$.ajax({
			type:"post",
			url:"/fileformjson",
			data:formData,
			enctype:"multipart/form-data",
			dataType:"json",
			contentType:false,
			processData:false,
			success:function(result){
				alert(result);
			}
			
		});
		
	}
</script>

</head>
<body>

	<input type="text" id="key" name="key">
	<br>
	<input type="text" id="value" name="value">
	<br>
	<input type="file" id="file1" name="file1">
	<br>
	<input type="file" id="file2" name="file2">
	<br>
	<input type="button" value="전송" onclick="jsonformsend()">

</body>
</html>