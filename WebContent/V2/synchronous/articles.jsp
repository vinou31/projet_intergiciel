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
<script src="css/5grid/jquery.js"></script>
<script
	src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
<!--[if IE 9]><link rel="stylesheet" href="css/style-ie9.css" /><![endif]-->
</head>

<body>



	<div id="wrapper">
		<header id="header">
		<div class="5grid-layout">
			<div class="row">
				<div class="12u" id="logo">
					<!-- Logo -->
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
						<%Collection<Categorie> cat = (HashSet<Categorie>) request.getAttribute("categorie");
						%>
						<ul class="niveau1">
						<%
						
						for (Categorie c : cat){
							%>							
								<li><% out.print(c.getNomCategorie()); %>
									<ul class="niveau2">
									<%
									HashSet<Categorie> souscat = (HashSet<Categorie>) c.getSousCategorie();
									for (Categorie c2: souscat){
										%>
										<li><% out.print(c2.getNomCategorie()); %></li>

										<%
									} %>
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
							
						
						

						<% }%>
					</div>


					<div class="9u mobileUI-main-content">
						<div id="content">
							<div id="mainwrapper">


			<%HashSet<Article> art = (HashSet<Article>) m.getPropose();
			//Article Hollande = new Article("hollande", 0.1, "flamby", "P2Intergiciel/WebContent/V2/Synchronous/images/fr.jpg", new java.sql.Date(new java.util.Date().getTime()), new Membre());
			//HashSet<Article> art = new HashSet<Article>();
			//art.add(Hollande);
			if (art.isEmpty()){
				out.print("aucun article  à disposition pour la catégorie demandée");
			}
			else {for(Article a : art){%>
								
								<section>
								<div id="box-6" class="box">
								<form method="get", action = "ServArticle">
									<img id="image-6" src= "<%a.getImage();%>"/> <span
										class="caption scale-caption">
										<h3><%out.println(a.getNom()); %></h3>
										<input type="hidden" , name="op" , value="articleEnVue" />
									</span>
									</form>
								</div>
								</section>
								
			<%
			}}
			%>

								<section>
								<div id="box-6" class="box">
									<img id="image-6" src="images/cham.jpg" /> <span
										class="caption scale-caption">
										<h3>Gentil Chameau</h3>
										<p>Chameau de compétition, éxécute le 0 à 30km/h en 6.5s,
											trés sympathique</p>
									</span>
								</div>
								</section>
								<section>
								<div id="box-6" class="box">
									<img id="image-6" src="images/cham.jpg" /> <span
										class="caption scale-caption">
										<h3>Gentil Chameau</h3>
										<p>Chameau de compétition, éxécute le 0 à 30km/h en 6.5s,
											trés sympathique</p>
									</span>
								</div>
								</section>
								
								
							</div>
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