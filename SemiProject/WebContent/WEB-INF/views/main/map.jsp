<%@page import="java.util.List"%>
<%@page import="review.dto.Seoul"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<% List<Seoul> list = (List<Seoul>)request.getAttribute("list"); %>
<style>
#mapwrapper {
 margin-top: 250px;


}
.area {
    position: absolute;
    background: #fff;
    border: 1px solid #888;
    border-radius: 3px;
    font-size: 12px;
    top: -5px;
    left: 15px;
    padding:2px;
}

.info {
    font-size: 12px;
    padding: 5px;
}
.info .title {
    font-weight: bold;
}

.maplistwrapper {
	margin-top: 150px;
}




</style>
<div id="mapwrapper">
<h1>맛지도</h1>
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
 
 
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
    {
        title: '서울특별시청', 
        latlng: new kakao.maps.LatLng(37.56677014292466, 126.97865227425055)
    },
    {
        title: '생태연못', 
        latlng: new kakao.maps.LatLng(<%=list.get(0).getY_dents()%>,<%=list.get(0).getX_cnts()%> )
    },
    {
        title: '텃밭', 
        latlng: new kakao.maps.LatLng(<%=list.get(1).getY_dents()%>,<%=list.get(1).getX_cnts()%>)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(<%=list.get(2).getY_dents()%>,<%=list.get(2).getX_cnts()%>)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(<%=list.get(3).getY_dents()%>,<%=list.get(3).getX_cnts()%>)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(<%=list.get(4).getY_dents()%>,<%=list.get(4).getX_cnts()%>)
    }
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
 	// 마커에 표시할 인포윈도우를 생성합니다 
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    });

    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
}
//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
    	console.log(this)
    	console.log("!!!!!")
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}






</script>

</div>

<div class="maplistwrapper">
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