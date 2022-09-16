<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function stringjson(){
	$.ajax({
		type:"get",
		url:"/stringjson",
		success:function(data){
			var obj=JSON.parse(data);
			$('div').text(obj.key);
		}
	});
}

function objectjson(){
	$.ajax({
		type:"get",
		url:"/objectjson",
		success:function(data){
			$('div').text(data.key);
		}
	});
}

function jsonstringify() {
	
	// 중괄호 내부에 저장하는 것은 클래스 형태로 저장하는 것과 같음 -> .으로 불러올 수 있음
	var obj={x:5,y:10};
	var sobj=JSON.stringify({x:5,y:10});
	
	// 오브젝트 형태 : object {x: 5, y: 10 }
	console.log({x:5,y:10});
	
	// 더블쿼터 없는 형태 : {"x":5,"y":10}
	console.log(JSON.stringify({x:5,y:10}));
	
	// 객체 내부 x값 불러오기 : 5
	console.log(obj.x);
	
	// 문자열 내부 x값 불러오기 : undefined
	console.log(sobj.x);
	
	// sobj 값 출력 : {"x":5,"y":10}
	console.log(sobj);
	
	// 객체인지 확인 : true
	console.log(obj instanceof Object);
	
	// 객체인지 확인 : false
	console.log(sobj instanceof Object);
	
}

</script>
</head>
<body>
<div></div>

<button onclick="stringjson()">문자열</button>
<button onclick="objectjson()">객체</button>
<button onclick="jsonstringify()">JSON Stringify</button>

<script>

// $.ajax({
// 	type:"get",
// 	url:"/stringjson",
// 	success:function(data){
// 		$('div').text(data);
// 	}
// });

// $.ajax({
// 	type:"get",
// 	url:"/objectjson",
// 	success:function(data){
// 		$('div').text(data);
// 	}
// });

</script>
</body>
</html>