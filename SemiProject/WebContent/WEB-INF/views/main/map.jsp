<%@page import="java.util.List"%>
<%@page import="review.dto.Seoul"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<% List<Seoul> list = (List<Seoul>)request.getAttribute("list"); %>
<style>
#mapwrapper {
/*  margin-top: 250px; */


}




</style>
<div id="mapwrapper">
<img alt="" src="/Resources/img/mapLogo.png" style="width: 50%">
<div id="map" style="width:100%;height:850px;">
</div>
<!-- 37.56677014292466, 126.97865227425055 -->

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	a0cf149f393c0b75e4343f25535745c2"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.56677014292466, 126.97865227425055), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
var imageSrc = "https://i.esdrop.com/d/rXPV9Cp583.png"; 
var imageSize = new kakao.maps.Size(120, 100);
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
   
    {
        title: '강서구', 
        latlng: new kakao.maps.LatLng(37.560227, 126.826411 ),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/3zPpnwx/image.png", imageSize)
    },
    {
        title: '양천구', 
        latlng: new kakao.maps.LatLng(37.523562, 126.855170),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/Jq0G3Kv/image.png", imageSize)
    },
    {
        title: '영등포구',
        latlng: new kakao.maps.LatLng(37.519549, 126.907992),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/sVK6NJh/image.png", imageSize)
    },
    {
        title: '구로구',
        latlng: new kakao.maps.LatLng(37.494065, 126.856500),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/Z6CZ1ZG/image.png", imageSize)
    },
    {
        title: '금천구',
        latlng: new kakao.maps.LatLng(37.461531, 126.901247),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/SXV4cDS/image.png", imageSize)
    },
    {
        title: '관악구',
        latlng: new kakao.maps.LatLng(37.480791, 126.951205),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/WvHJtRB/image.png", imageSize)
    },
    {
        title: '동작구',
        latlng: new kakao.maps.LatLng(37.498839, 126.950792),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/rkhjv6Q/image.png", imageSize)
    },
    {
        title: '서초구',
        latlng: new kakao.maps.LatLng(37.492375, 127.007208),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/J2Hmqsj/image.png", imageSize)
    },
    {
        title: '강남구',
        latlng: new kakao.maps.LatLng(37.497851, 127.061644),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/W6g7mNR/image.png", imageSize)
    },
    {
        title: '송파구',
        latlng: new kakao.maps.LatLng(37.505878, 127.114541),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/wgxxrvc/image.png", imageSize)
    },
    {
        title: '강동구',
        latlng: new kakao.maps.LatLng(37.549711, 127.148000),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/3pJDF7R/image.png", imageSize)
    },
    {
        title: '광진구',
        latlng: new kakao.maps.LatLng(37.542704, 127.086941),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/qM6kZ1D/image.png", imageSize)
    },
    {
        title: '중랑구',
        latlng: new kakao.maps.LatLng(37.596087, 127.091094),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/0j190kN/image.png", imageSize)
    },
    {
        title: '노원구',
        latlng: new kakao.maps.LatLng(37.651018, 127.071460),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/JjhwGFh/image.png", imageSize)
    },
    {
        title: '동대문구',
        latlng: new kakao.maps.LatLng(37.579027, 127.055091),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/bb6Z63x/image.png", imageSize)
    },
    {
        title: '성동구',
        latlng: new kakao.maps.LatLng(37.546991, 127.047101),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/vvMnsyj/image.png", imageSize)
    },
    {
        title: '성북구',
        latlng: new kakao.maps.LatLng(37.605866, 127.018380),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/8B25xVB/image.png", imageSize)
    },
    {
        title: '강북구',
        latlng: new kakao.maps.LatLng(37.640048, 127.027080),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/wygS1n7/image.png", imageSize)
    },
    {
        title: '도봉구',
        latlng: new kakao.maps.LatLng(37.664488, 127.036971),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/CKMQCHL/image.png", imageSize)
    },
    {
        title: '종로구',
        latlng: new kakao.maps.LatLng(37.573804, 126.982949),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/ZXXWQ3r/image.png", imageSize)
    },
    {
        title: '중구',
        latlng: new kakao.maps.LatLng(37.563738, 126.997492),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/Ht7CpBm/image.png", imageSize)
    },
    {
        title: '용산구',
        latlng: new kakao.maps.LatLng(37.531565, 126.980189),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/dcMv90N/image.png", imageSize)
    },
    {
        title: '마포구',
        latlng: new kakao.maps.LatLng(37.554871, 126.917390),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/W6g7mNR/image.png", imageSize)
    },
    {
        title: '서대문구',
        latlng: new kakao.maps.LatLng(37.576275, 126.935143),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/RYwBNGF/image.png", imageSize)
    },
    {
        title: '은평구',
        latlng: new kakao.maps.LatLng(37.619183, 126.921723),
        markerImage: new kakao.maps.MarkerImage("https://i.ibb.co/mqq0tcW/image.png", imageSize)
    }
];

    
for (var i = 0; i < positions.length; i ++) {
    

    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : positions[i].markerImage // 마커 이미지 
    });
 	// 마커에 표시할 인포윈도우를 생성합니다 
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    });

 	
    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'click', makeOverListener(map, i, marker, infowindow));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
}
//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, i, marker, infowindow) {
    return function() {
    	console.log("!!!!!")
    	console.log(positions[i].title)
    	map.setCenter(positions[i].latlng)
    	map.setLevel(3);
    	$.ajax({
	         type : 'POST',
	         data : {"title": positions[i].title},
	         url : "/main/map/titlecheck",
	         dataType : "html",
			 success : function (data) {
				console.log(data)
				$("#toprank").html(data);
			 }
		})
    
        infowindow.open(map, marker);
    };
}


// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}


function panTo() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(37.56677014292466, 126.97865227425055);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon); 
    map.setLevel(8);
}        



</script>

</div>


<div style="margin: 50px auto;">
<button class="btn btn-default btn-lg" onclick="panTo()">원위치로</button>
</div>
<div>
		  <img alt="" src="/Resources/img/맛집리스트.png" style="width: 20%; margin:0 auto;">

</div>

<div class="maplistwrapper" id="toprank">
<table class="table table-striped">
	<%for(int i=0;i<list.size();i++){ %>
	<tr>
		<td style="font-size: 50px; width: 150px;" >#<%=i+1 %></td>
		
		<td style="height: 100px;width: 300px; height: 150px;"><img width="100%" src="https://lh3.googleusercontent.com/proxy/5jQIs5mtkl_NYt3HUzlkYargOb7QKOe3dAe2nzfgUx28LH6PiTmg63WzNnHkmQ4u4VpuMNzH095lMpSGeCCIlzIMJwdxbpa1zb_X5stZG5LTfTHsNNX2R7ZJVuzWQCjOUAzzyxoIx-gpTjWwnS47LU26N-7VPzxqvRNt11QL4YgZ8-NEVfMJw_2CLAGNdiqC9mBsZi-mg5Q-HMk0H4ZRbjMF6hCeMOAzEdraFQd0w9V76g3ALezJ-tF9-UoyixkB9n5WRA"></td>
		<td style="font-size: 16px; width: 300px; text-align: left;">이름:<%=list.get(i).getUpso_nm() %><br><br><br>주소:<%=list.get(i).getRdn_code_nm() %><br><br><br>전화번호:<%=list.get(i).getTel_no() %></td>
			
	</tr>
	<%} %>

</table>



</div>













<%@include file="/WEB-INF/views/footer/footer.jsp" %>