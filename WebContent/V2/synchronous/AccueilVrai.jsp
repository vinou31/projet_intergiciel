<%@page import="javax.enterprise.context.SessionScoped"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="metier.*"%>
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
									<h2>Bienvenue sur TrocMania !!!</h2>
									<p>
										TrocMania est un site de troc, d'échange et de vente en ligne. Il vous
										permettra de trouver des personnes intéressées par ce que vous proposez 
										et les personnes vous contacteront.
									</p>
									<%if(m == null){ %>
									<p>&nbsp;</p>
									<p>L'inscription est rapide, n'hésitez pas à consulter notre catalogue d'articles
									pour voir ce qui pourrait vous intéresser.</p>
									<p>&nbsp;</p>
									
									<p class="button-style">
										<a href="${pageContext.request.contextPath}/ServInscription">Je m'inscris immédiatement</a>
									</p>
									<%} %>
								</div>
							</section>
							<section>
								<p>&nbsp;</p>
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