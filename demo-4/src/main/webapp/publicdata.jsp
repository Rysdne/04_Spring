<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function publicdata() {
		var url="http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll";
		var ServiceKey="6%2B7%2Fszzwxhm2R9bnDsg4E7Xw%2FQQMWV8UHHYH9Dnu31KlIPRR5y3rJSLo7f9Hun%2BcXb8Ja1M6dlrx2rVhYs767A%3D%3D";
		var busRoutedId="100100118";
		var resultType="json";
		$.ajax({
			url:${url},
			type:"get",
			dataType:"jsonp",
			jsonp : "callback",
			headers : {
				'Access-Control-Allow-Credentials' : true,
				'Access-Control-Allow-Origin' : '*',
				'Access-Control-Allow-Methods' : 'GET',
				'Access-Control-Allow-Headers' : 'application/json'
			}
			data:{ServiceKey:${ServiceKey}, busRouteId:${busRouteId}, resultType:${resultType}},
			success:function(data){
				$('div').text(data)
			}
		});
	}
</script>
</head>
<body>
	<input type="button" onclick="publicdata()" value="�����">
	<div></div>
</body>
</html>