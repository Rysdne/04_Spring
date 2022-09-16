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
		// �Ϲ� Object : json ����
		// ���� ������ : formData ����
		var obj = {"key":$('#key').val()}
		
		// �Ϲݰ�ü�� ���ϰ�ü�� ���� ����
		// �������ۿ� ��ü ����
		var formData = new FormData();
		
		// �Ϲݰ�ü
		// stringify : JSON������ ���ڿ�ȭ
		// [] ���ο� �ִ� ���� �ϳ��� ��ü
		// type���� json��ü���� �˷���
		formData.append("obj", new Blob([JSON.stringify(obj)],{type:"application/json"}));
		
		// ���ϰ�ü
		// file�� ������ ��ϵ� ��츣�� ����� �迭�� ���޹���
		formData.append("file1", $('#file1')[0].files[0]);
		
		console.log(obj.key);
		console.log($('#file1').val());
		
		// AJAX ���
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
	<input type="button" value="����" onclick="jsonformsend()">

</body>
</html>