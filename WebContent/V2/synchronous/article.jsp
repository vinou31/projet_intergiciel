<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>

<!--
	Synchronous: A responsive HTML5 website template by HTML5Templates.com
	Released for free under the Creative Commons Attribution 3.0 license (html5templates.com/license)
	Visit http://html5templates.com for more great templates or follow us on Twitter @HTML5T
-->

<html>
<head>
<title>TrocMania</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<noscript>
<link rel="stylesheet" href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core-desktop.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core-1200px.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core-noscript.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/V2/synchronous/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/V2/synchronous/css/style-desktop.css" />
</noscript>
<script src="${pageContext.request.contextPath}/V2/synchronous/css/5grid/jquery.js"></script>
<script src="${pageContext.request.contextPath}/V2/synchronous/css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
<!--[if IE 9]><link rel="stylesheet" href="css/style-ie9.css" /><![endif]-->
</head>
<body>
<div id="wrapper">
<header id="header">
			<%@ include file="header.jsp" %>
		</header>
	<div id="page">
		<div class="5grid-layout">
			<div class="row">
				<div class="3u" id="sidebar1">	
					    <%@ include file="menuArticles.jsp" %>
					    <%@ include file="infoCompte.jsp" %>
					</div>				
				<div class="9u mobileUI-main-content">
					<div id="content">
						<section>
							<div class="post">
							
									<ul class="breadcrumb">
										
									</ul>
									
									<%Membre membre = (Membre)request.getAttribute("vendeur"); %>
								<h2><%=request.getAttribute("nom")%></h2>
								<img src= "<%=request.getAttribute("img")%>" alt="" class="imgarticle">
								<p>Prix proposé: <%=request.getAttribute( "prix")%></p>
								<p>Descrpition de l'article: <%=request.getAttribute("description")%></p>
								<p>Vendeur: <%=membre.getNom()%></p>
								<p>Telephone : <%=membre.getTelephone()%> </p>
								<p>Adresse : <%=membre.getAdresse() %></p>
								<div id="carte" style="width:800px;height:400px;"></div>
								<div id="directions_panel" style="margin:20px;background-color:#FFEE77;"></div>
								
								<a href="${pageContext.request.contextPath}/ServArticle?op=supprimerArticle&id=<%=request.getAttribute("id")%>">
								<p>Supprimer cet article de la vente</p></a>								
								
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>								
    <script>
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer();
  var chicago = new google.maps.LatLng(41.850033, -87.6500523);
  var mapOptions = {
    zoom: 6,
    center: chicago,
  };
  map = new google.maps.Map(document.getElementById('carte'), mapOptions);
  directionsDisplay.setMap(map);
  calcRoute();
}

function calcRoute() {
  /*var start = 'Marspich';
  var end = 'Metz';*/
  <%
  	String start = (String) request.getAttribute("start");
    String end = (String) request.getAttribute("end");
  %>
  var start = <%=start%>;
  var end = <%=end%>;
  var waypts = [];
  var checkboxArray = document.getElementById('waypoints');
  for (var i = 0; i < checkboxArray.length; i++) {
    if (checkboxArray.options[i].selected == true) {
      waypts.push({
          location:checkboxArray[i].value,
          stopover:true});
    }
  }

  var request = {
      origin: start,
      destination: end,
      waypoints: waypts,
      optimizeWaypoints: true,
      travelMode: google.maps.TravelMode.DRIVING
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
      var route = response.routes[0];
      var summaryPanel = document.getElementById('directions_panel');
      summaryPanel.innerHTML = '';
      for (var i = 0; i < route.legs.length; i++) {
        var routeSegment = i + 1;
        summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
      }
    }
  });
}

google.maps.event.addDomListener(window, 'load', calcRoute);

    </script>
								
								
								
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



	<div class="5grid-layout">
		<div class="row" id="footer-content">
			<div class="3u">
				<section id="box1">
				<h2 class="current_page_item">
					<p>&copy;TrocMania</p>
				</h2>
				</section>
			</div>
			<div class="6u">
				<section id="box2">
				<h2><a href="${pageContext.request.contextPath}/Accueil">A propos du site</a></h2>
				<p>Tout savoir sur le merveilleux univers de TrocMania!</p>
				</section>
			</div>
			<div class="3u">
				<section id="box3">
				<h2>Nous contacter</h2>
				<ul class="style1">
					<li class="first"><a href="#">Kevin</a></li>
					<li><a href="#">Ruddy</a></li>
					<li><a href="#">Marianne</a></li>
					<li><a href="#">Alvin</a></li>
				</ul>
				</section>
			</div>
		</div>
	</div>
	<div id="copyright" class="5grid-layout">
		<section>
			<p>&copy; TrocMania | Images: <a href="http://fotogrph.com/">Fotogrph</a></p>
		</section>
	</div>
</body>
</html>