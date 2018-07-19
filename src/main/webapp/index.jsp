<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>" />

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<div class="container">
	<!-- 		<div class="jumbotron">
			<h1 class="text-center">Hello MediPot</h1>
			<p class="text-center">메디팟은 병원 예약 서비스를 제공합니다.</p>
			<p class="text-center"><a class="btn btn-primary btn-lg" href="reservation.html" role="button">예약하러가기</a>
		</div> -->

	<!-- 캐러셀 시작 -->
	<!-- #region Jssor Slider Begin -->
	<!-- Generator: Jssor Slider Maker -->
	<!-- Source: https://www.jssor.com -->
	<script src="resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="resources/js/jssor.slider-27.4.0.min.js" type="text/javascript"></script>
	<script type="text/javascript">
        jQuery(document).ready(function ($) {

            var jssor_1_SlideshowTransitions = [
              {$Duration:500,$Delay:12,$Cols:10,$Rows:5,$Opacity:2,$Clip:15,$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Assembly:2049,$Easing:$Jease$.$OutQuad},
              {$Duration:500,$Delay:40,$Cols:10,$Rows:5,$Opacity:2,$Clip:15,$SlideOut:true,$Easing:$Jease$.$OutQuad},
              {$Duration:1000,x:-0.2,$Delay:20,$Cols:16,$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationStraight,$Assembly:260,$Easing:{$Left:$Jease$.$InOutExpo,$Opacity:$Jease$.$InOutQuad},$Opacity:2,$Outside:true,$Round:{$Top:0.5}},
              {$Duration:1600,y:-1,$Delay:40,$Cols:24,$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationStraight,$Easing:$Jease$.$OutJump,$Round:{$Top:1.5}},
              {$Duration:1200,x:0.2,y:-0.1,$Delay:16,$Cols:10,$Rows:5,$Opacity:2,$Clip:15,$During:{$Left:[0.3,0.7],$Top:[0.3,0.7]},$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Assembly:260,$Easing:{$Left:$Jease$.$InWave,$Top:$Jease$.$InWave,$Clip:$Jease$.$OutQuad},$Round:{$Left:1.3,$Top:2.5}},
              {$Duration:1500,x:0.3,y:-0.3,$Delay:20,$Cols:10,$Rows:5,$Opacity:2,$Clip:15,$During:{$Left:[0.2,0.8],$Top:[0.2,0.8]},$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Assembly:260,$Easing:{$Left:$Jease$.$InJump,$Top:$Jease$.$InJump,$Clip:$Jease$.$OutQuad},$Round:{$Left:0.8,$Top:2.5}},
              {$Duration:1500,x:0.3,y:-0.3,$Delay:20,$Cols:10,$Rows:5,$Opacity:2,$Clip:15,$During:{$Left:[0.1,0.9],$Top:[0.1,0.9]},$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Assembly:260,$Easing:{$Left:$Jease$.$InJump,$Top:$Jease$.$InJump,$Clip:$Jease$.$OutQuad},$Round:{$Left:0.8,$Top:2.5}}
            ];

            var jssor_1_options = {
              $AutoPlay: 1,
              $SlideshowOptions: {
                $Class: $JssorSlideshowRunner$,
                $Transitions: jssor_1_SlideshowTransitions,
                $TransitionsOrder: 1
              },
              $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
              },
              $BulletNavigatorOptions: {
                $Class: $JssorBulletNavigator$
              }
            };

            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

            /*#region responsive code begin*/
			
            
            var MAX_WIDTH = 3000;

            function ScaleSlider() {
                var containerElement = jssor_1_slider.$Elmt.parentNode;
                var containerWidth = containerElement.clientWidth;

                if (containerWidth) {

                    var expectedWidth = Math.min(MAX_WIDTH || containerWidth, containerWidth);

                    jssor_1_slider.$ScaleWidth(expectedWidth);
                }
                else {
                    window.setTimeout(ScaleSlider, 30);
                }
            }

            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            /*#endregion responsive code end*/
        });
    </script>
	<style>
/*jssor slider loading skin spin css*/
.jssorl-009-spin img {
	animation-name: jssorl-009-spin;
	animation-duration: 1.6s;
	animation-iteration-count: infinite;
	animation-timing-function: linear;
}

@
keyframes jssorl-009-spin {from { transform:rotate(0deg);
	
}

to {
	transform: rotate(360deg);
}

}

/*jssor slider bullet skin 053 css*/
.jssorb053 .i {
	position: absolute;
	cursor: pointer;
}

.jssorb053 .i .b {
	fill: #fff;
	fill-opacity: 0.5;
}

.jssorb053 .i:hover .b {
	fill-opacity: .7;
}

.jssorb053 .iav .b {
	fill-opacity: 1;
}

.jssorb053 .i.idn {
	opacity: .3;
}

/*jssor slider arrow skin 093 css*/
.jssora093 {
	display: block;
	position: absolute;
	cursor: pointer;
}

.jssora093 .c {
	fill: none;
	stroke: #fff;
	stroke-width: 400;
	stroke-miterlimit: 10;
}

.jssora093 .a {
	fill: none;
	stroke: #fff;
	stroke-width: 400;
	stroke-miterlimit: 10;
}

.jssora093:hover {
	opacity: .8;
}

.jssora093.jssora093dn {
	opacity: .6;
}

.jssora093.jssora093ds {
	opacity: .3;
	pointer-events: none;
}
</style>
	<div id="jssor_1"
		style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 980px; height: 380px; overflow: hidden; visibility: hidden;">
		<!-- Loading Screen -->
		<div data-u="loading" class="jssorl-009-spin"
			style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; text-align: center; background-color: rgba(0, 0, 0, 0.7);">
			<img
				style="margin-top: -19px; position: relative; top: 50%; width: 38px; height: 38px;"
				src="resources/img/carousel/spin.svg" />
		</div>
		<div data-u="slides"
			style="cursor: default; position: relative; top: 0px; left: 0px; width: 980px; height: 380px; overflow: hidden;">
			<div>
				<img data-u="image" src="resources/img/carousel/medi_1.jpg" />
			</div>
			<div>
				<img data-u="image" src="resources/img/carousel/medi_2.jpg" />
			</div>
			<div>
				<img data-u="image" src="resources/img/carousel/medi_3.jpg" />
			</div>
			<div>
				<img data-u="image" src="resources/img/carousel/medi_4.jpg" />
			</div>
			<div>
				<img data-u="image" src="resources/img/carousel/medi_5.jpg" />
			</div>
			<div>
				<img data-u="image" src="resources/img/carousel/medi_6.jpg" />
			</div>
		</div>
		<!-- Bullet Navigator -->
		<div data-u="navigator" class="jssorb053"
			style="position: absolute; bottom: 12px; right: 12px;"
			data-autocenter="1" data-scale="0.5" data-scale-bottom="0.75">
			<div data-u="prototype" class="i" style="width: 16px; height: 16px;">
				<svg viewbox="0 0 16000 16000"
					style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                    <path class="b"
						d="M11400,13800H4600c-1320,0-2400-1080-2400-2400V4600c0-1320,1080-2400,2400-2400h6800 c1320,0,2400,1080,2400,2400v6800C13800,12720,12720,13800,11400,13800z"></path>
                </svg>
			</div>
		</div>
		<!-- Arrow Navigator -->
		<div data-u="arrowleft" class="jssora093"
			style="width: 50px; height: 50px; top: 0px; left: 30px;"
			data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
			<svg viewbox="0 0 16000 16000"
				style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                <circle class="c" cx="8000" cy="8000" r="5920"></circle>
                <polyline class="a"
					points="7777.8,6080 5857.8,8000 7777.8,9920 "></polyline>
                <line class="a" x1="10142.2" y1="8000" x2="5857.8"
					y2="8000"></line>
            </svg>
		</div>
		<div data-u="arrowright" class="jssora093"
			style="width: 50px; height: 50px; top: 0px; right: 30px;"
			data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
			<svg viewbox="0 0 16000 16000"
				style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                <circle class="c" cx="8000" cy="8000" r="5920"></circle>
                <polyline class="a"
					points="8222.2,6080 10142.2,8000 8222.2,9920 "></polyline>
                <line class="a" x1="5857.8" y1="8000" x2="10142.2"
					y2="8000"></line>
            </svg>
		</div>
	</div>
	<!-- #endregion Jssor Slider End -->
	<!-- 케러셀 끝 -->
	<hr>
<style>
	#useInfo>div{text-align: center;}
</style>
	<div class="row" id="useInfo">
		<div class="col-md-4">
			<h3>MediPot 서비스란?</h3>
			<p>전국 병원을 예약할 수 있는 사이트 입니다.</p>
			<p>메디팟에서는 많은 병원과 협약을 맺고있습니다.</p>
			<p>메디팟시스템을 이용하실 관리자분은 아래의 링크를 클릭하세요</p>
			<p>
				<a class="btn btn-default" data-target="#modal" data-toggle="modal">협약하러가기</a>
			</p>
		</div>
		<div class="col-md-2">
			<h4>MediPot이용방법</h4>
			<h1>1단계</h1>
			<p>우리동네 병원을 지역으로 검색</p>
		</div>
		<div class="col-md-1" style="padding-top:35px;padding-right:20px;">
			<img src="/pot/resources/img/common/arrow.png" width="80px" height="60px" >
		</div>
		<div class="col-md-2">
			<h4>MediPot이용방법</h4>
			<h1>2단계</h1>
			<p>진료과목을 선택하기</p>
		</div>
		<div class="col-md-1" style="padding-top:35px;padding-right:20px;">
			<img src="/pot/resources/img/common/arrow.png" width="80px" height="60px">
		</div>
		<div class="col-md-2">
			<h4>MediPot이용방법</h4>
			<h1>3단계</h1>
			<p>우리동네 병원 선택</p>
			<p>
				<a class="btn btn-default" href="#">예약하러 가기</a>
			</p>
		</div>
	</div>
	<hr>
	<!-- 중간 부분 끝 -->

	<!-- 판넬부분시작! -->
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-pencil"></span> &nbsp;&nbsp;Health
				Magazine
			</h3>
		</div>
		<div class="panel-body">
			<div class="media">
				<div class="media-left">
					<a href="#"><img class="media-object"
						src="${path }/resources/img/common/health.jpeg" width="200px"
						height="100px" alt="디톡스이미지"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">
						<a href="#">디톡스로 건강되찾기</a>&nbsp;<span class="badge">New</span>
					</h4>
					레몬 디톡스로 젊음을 되찾는, 건강지식 정보를 얻어가세요!
				</div>
			</div>
			<hr>

			<div class="media">
				<div class="media-left">
					<a href="#"><img class="media-object"
						src="${path }/resources/img/common/hopital.jpg" width="200px"
						height="100px" alt="디톡스이미지"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">
						<a href="#">(필독!)건강검진</a>&nbsp;<span class="badge">New</span>
					</h4>
					꾸준한 건강검진으로, 건강을 되찾으세요!
				</div>
			</div>
			<hr>

			<div class="media">
				<div class="media-left">
					<a href="#"><img class="media-object"
						src="${path }/resources/img/common/health.jpeg" width="200px"
						height="100px" alt="디톡스이미지"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">
						<a href="#">디톡스로 건강되찾기</a>&nbsp;<span class="badge">New</span>
					</h4>
					레몬 디톡스로 젊음을 되찾는, 건강지식 정보를 얻어가세요!
				</div>
			</div>
			<hr>

			<div class="media">
				<div class="media-left">
					<a href="#"><img class="media-object"
						src="${path }/resources/img/common/hopital.jpg" width="200px"
						height="100px" alt="디톡스이미지"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">
						<a href="#">(필독!)건강검진</a>&nbsp;<span class="badge">New</span>
					</h4>
					꾸준한 건강검진으로, 건강을 되찾으세요!
				</div>
			</div>




		</div>
	</div>
	<!-- 판넬부분 끝! -->
</div>
<!-- class="container" -->

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
