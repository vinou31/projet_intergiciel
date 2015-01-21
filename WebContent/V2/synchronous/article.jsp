<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/Synchronous/css/5grid/core.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/Synchronous/css/5grid/core-desktop.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/Synchronous/css/5grid/core-1200px.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/Synchronous/css/5grid/core-noscript.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/Synchronous/css/style.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/WebContent/V2/Synchronous/css/style-desktop.css" />
</noscript>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANmySB4ly_bpVRrVFPRsnOQ0x65rkLVms&libraries=geometry&sensor=false"></script>
		<script src="http://openlayers.org/api/OpenLayers.js"></script>
<script src="css/5grid/jquery.js"></script>
<script src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
<!--[if IE 9]><link rel="stylesheet" href="css/style-ie9.css" /><![endif]-->
</head><body>
<div id="wrapper">
	<header id="header">
		<div class="5grid-layout">
			<div class="row">
				<div class="12u" id="logo"> <!-- Logo -->
					<h1>
						<a href="${pageContext.request.contextPath}/V2/synchronous/AccueilVrai.jsp" class="mobileUI-site-name">TrocMania</a>
					</h1>
					<p>La première forme de commerce au monde revient en version
						2.0</p>
				</div>
			</div>
		</div>
		<div class="5grid-layout">
			<div class="row">
				<div class="12u" id="menu">
					<div id="menu-wrapper">
						<nav class="mobileUI-site-nav">
						<ul>
							<li><a href="${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/AccueilVrai.jsp">Accueil</a></li>
							<%
								Membre m = (Membre) session.getAttribute("session");
								if (m == null) {
									out.print("<li><a href=\"${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/Inscription.jsp\">Inscription</a>");
									out.print("<li><a href=\"${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/Connexion.jsp\">Connexion</a>");
								}
							%>

							<li><form class="searchform">
									<input class="searchfield" type="text"
										value="Rechercher un article..."
										onfocus="if (this.value == 'Rechercher un article...') {this.value = '';}"
										onblur="if (this.value == '') {this.value = 'Rechercher un article...';}">
									<input class="searchbutton" type="button" value="OK">
								</form></li>
						</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
		</header>
	<div id="page">
		<div class="5grid-layout">
			<div class="row">
				<div class="3u" id="sidebar1">


						<section>
						<h2>Articles</h2>
						<%
							Collection<Categorie> cat = (HashSet<Categorie>) request.getAttribute("categorie");
						%>
						<ul class="niveau1">
							<%
								for (Categorie c : cat) {
							%>
							<li>
								<%
									out.print(c.getNomCategorie());
								%>
								<ul class="niveau2">
									<%
										HashSet<Categorie> souscat = (HashSet<Categorie>) c.getSousCategorie();
											for (Categorie c2 : souscat) {
									%>
									<li>
										<%
											out.print(c2.getNomCategorie());
										%>
									</li>

									<%
											}
									%>
								</ul>
							</li>

							<%
								}
							%>
						</ul>


						<div class="article">
							<ul class="niveau1">
								<li>Electroménager
									<ul class="niveau2">
										<li>Machine à laver</li>
										<li>Aspirateur</li>
									</ul>
								</li>
						</section>



						<%
						if (m != null) {

						%>
						<section>
						<h2>
						<a href="${pageContext.request.contextPath}/V2/synchronous/GestionCompte.jsp">Informations sur le Compte</a>
						</h2>
						<ul>
							<li>
								<p>Photo de profil</p>
							</li>
							<img src=<%m.getPhotoProfil();%> alt="" class="imgprofile">
							<li>
								<p>
									<strong><%m.getPrenom(); out.print(" "); m.getNom(); %></strong>
								</p>
							</li>
							<li>
								<p>
									<strong><%m.getPseudonyme();%></strong>
								</p>
							</li>
							<li>
								<form method="get", action = "ServArticles">
									<p>Article en vente :<%m.getPropose().size();%></p>
									<input type="hidden" , name="op" , value="articlesEnVente" />
								</form>
							</li>
							<li>
								<form method="get", action = "ServArticles">
									<p>Liste des avis</p>
									<input type="hidden" , name="op" , value="avisPersonne" />
								</form>
							</li>
							<li>
								<form method="get", action = "ServDeconnexion">
									<p class="button-style">Déconnexion</p>
									<input type="hidden"/>
								</form>
							</li>
							</ul>
						</section>
				</div>
				<%} %>
				
				<div class="9u mobileUI-main-content">
					<div id="content">
						<section>
							<div class="post">
							
									<ul class="breadcrumb">
										<li><a href="#">Articles</a></li>
										<li><a href="#">Véhicules</a></li>
										<li><a href="#">Vivant</a></li>
										<li><a href="#">Chameau</a></li>
									</ul>
									
									
								<h2><% out.println(request.getAttribute("nom")); %></h2>
								<img src= "<%out.println(request.getAttribute("img")); %>" alt="" class="imgarticle">
								<p>Prix proposé: <%out.println(request.getAttribute( "prix" ));%></p>
								<p>Descrpition de l'article: <%out.println("description");%></p>
								<p>Vendeur: <%out.println(request.getAttribute( "vendeur" ));%></p>
								<div id="carte" style="width:800px;height:400px;"></div>
								<div id="directions_panel" style="margin:20px;background-color:#FFEE77;"></div>
								
								<% if (m != null && m.getNom().equals(request.getAttribute("vendeur"))){ %>
								<form method="get", action = "ServArticle">
									<p>Liste des avis</p>
									<input type="hidden" , name="op" , value="supprimerArticle" />
								</form>
								<%} %>
								
								
								
								
								
								
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

google.maps.event.addDomListener(window, 'load', initialize);

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
				<h2><a href="${pageContext.request.contextPath}/V2/synchronous/AccueilVrai.jsp">A propos du site</a></h2>
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