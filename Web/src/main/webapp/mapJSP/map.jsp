<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>지도</title>
</head>
<body>
	<div id="map" style="width:80%;height:800px;"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c81fc8b02285d02508dc89a5a8615f74"></script>
	<script>
	
	
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}

	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
	
	var mapContainer = document.getElementById('map'),   
    mapOption = { 
        center: new kakao.maps.LatLng(37.48938, 126.91113), 
        level: 12 
    };

var map = new kakao.maps.Map(mapContainer, mapOption); 
 

var positions = [
    {
        content: '<div>아파트 월세</div>', 
        latlng: new kakao.maps.LatLng(36.34703, 127.45077)
    },
    {
        content: '<div>원룸 전세</div>', 
        latlng: new kakao.maps.LatLng(36.33747, 127.38923)
    },
    {
        content: '<div>투룸 매매</div>', 
        latlng: new kakao.maps.LatLng(36.58963, 127.51120)
    },
    {
        content: '<div>아파트 월세</div>',
        latlng: new kakao.maps.LatLng(35.14255, 126.87557)
    },
    {
        content: '<div>오피스텔 매매</div>',
        latlng: new kakao.maps.LatLng(35.149302, 126.91131)
    },
    {
        content: '<div>아파트 월세</div>',
        latlng: new kakao.maps.LatLng(35.15781, 129.06472)
    },
    {
        content: '<div>아파트 전세</div>',
        latlng: new kakao.maps.LatLng(35.10621, 128.99879)
    },
    {
        content: '<div>오피스텔 월세</div>',
        latlng: new kakao.maps.LatLng(35.12314, 129.043626)
    },
    {
        content: '<div>오피스텔 전세</div>',
        latlng: new kakao.maps.LatLng(35.87166, 128.59917)
    },
    {
        content: '<div>투룸 월세</div>',
        latlng: new kakao.maps.LatLng(35.852377, 128.49377)
    },
    {
        content: '<div>오피스텔 월세</div>',
        latlng: new kakao.maps.LatLng(37.36920, 127.93989)
    },
    {
        content: '<div>원룸 전세</div>',
        latlng: new kakao.maps.LatLng(37.39154, 128.63863)
    },
    {
        content: '<div>아파트 매매</div>',
        latlng: new kakao.maps.LatLng(37.20971, 126.82825)
    },
    {
        content: '<div>오피스텔 전세</div>',
        latlng: new kakao.maps.LatLng(37.30119, 127.06044)
    },
    {
        content: '<div>원룸 전세</div>',
        latlng: new kakao.maps.LatLng(37.27517, 127.01807)
    },
    {
        content: '<div>빌라 매매</div>',
        latlng: new kakao.maps.LatLng(37.65815, 127.01317)
    },
    {
        content: '<div>아파트 매매</div>',
        latlng: new kakao.maps.LatLng(37.60684, 127.10038)
    },
    {
        content: '<div>오피스텔 전세</div>',
        latlng: new kakao.maps.LatLng(37.60823, 127.10129)
    },
    {
        content: '<div>투룸 전세</div>',
        latlng: new kakao.maps.LatLng(37.59286, 127.09047)
    },
    {
        content: '<div>원룸 월세</div>',
        latlng: new kakao.maps.LatLng(37.48938, 126.91113)
    }
];


var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (let i = 0; i < positions.length; i ++) {
    // 브라우저에서 f12 - console 누르면 포지션보이게 함
	console.log(positions[i])
   
    var imageSize = new kakao.maps.Size(24, 35); 
    
   
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
   // !!!!!!!!마커안에 데이터가 없음
    var marker = new kakao.maps.Marker({
        map: map, 
        position: positions[i].latlng, 
        image : markerImage
    });
    
    
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content
    });
    
    
    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
}



	</script>
</body>
</html>