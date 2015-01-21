<%@page import="javax.enterprise.context.SessionScoped"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
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
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core-desktop.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core-1200px.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/synchronous/css/5grid/core-noscript.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/synchronous/css/style.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/V2/synchronous/css/style-desktop.css" />
</noscript>
<script
	src="${pageContext.request.contextPath}/V2/synchronous/css/5grid/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/V2/synchronous/css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
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
							<a href="#" class="mobileUI-site-name">TrocMania</a>
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

									<li><a href="Accueil">Accueil</a></li>
									<%
										Membre m = (Membre) session.getAttribute("membre");
										if (m == null) {
											%>
											
											<li><a href="${pageContext.request.contextPath}/V2/synchronous/Inscription.jsp">Inscription</a>
											<li><a href="${pageContext.request.contextPath}/V2/synchronous/Connexion.jsp">Connexion</a>
										<%}
									%>

									<li class="current_page_item"><a href="accueil2.jsp">A
											propos du site</a></li>
									<!-- Modifier les liens -->
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
							<div class="article">
								<ul class="niveau1">
									<li>Electroménager
										<ul class="niveau2">
											<li>Machine à laver</li>
											<li>Aspirateur</li>
										</ul>
									</li>
									<li>Informatique
										<ul class="niveau2">
											<li>Tablette</li>
											<li>Portable</li>
										</ul>
									</li>
									<li>Outillage</li>
									<li>Son-Vidéo</li>
								</ul>
							</div>
						</section>
						<%
							if (m != null) {
								out.print("<section>");
								out.print("<h2>Information de Compte</h2>");
								out.print("<ul >");
								out.print("<li >");
								out.print("<p>Photo de profil</p>");
								out.print("</li>");
								out.print("<img src=\"images/197.jpg\" alt=\"\" class=\"imgprofile\">");
								out.print("<li>");
								out.print("<p><strong>" + m.getNom() + " " + m.getPrenom()
										+ "</strong></p>");
								out.print("</li>");
								out.print("<li>");
								out.print("<p><strong>" + m.getPseudonyme() + "</strong></p>");
								out.print("</li>");
								out.print("<li>");
								out.print("<p>Article en vente : 4</p>");
								out.print("</li>");
								out.print("<li>");
								out.print("<p>Transactions effectuées : 4</p>");
								out.print("</li>");
								out.print("<li>");
								out.print("<p>Avis positif : 4</p>");
								out.print("</li>");
								out.print("<li>");
								out.print("<p>Avis négatif: 4*10^16</p>");
								out.print("</li>");

								out.print("</ul>");

								out.print("<p class=\"button-style\"><a href=\"/PIntergiciel/ServDeconnexion\">Déconnexion</a></p>");
								out.print("</section>");
							}
						%>
					</div>


					<div class="9u mobileUI-main-content">
						<div id="content">
							<!--  -->
							<form method="post" action="${pageContext.request.contextPath}/ServAjouterArticle" enctype="multipart/form-data">
								<fieldset>
									<legend>Ajout d'un article</legend>
									<!-- Titre du fieldset -->
									
									<p>
										nom: <input type="text" id="nom"
											name="nom" value="" />
									</p>


									<p>
										Description de l'article: <input type="text" id="description"
											name="description" value="" />
									</p>

									<p>
										Ajoutez l'image: <input type="file" name="file" size="60" /><br />
										<br /> <input type="submit" value="Upload" /><br>
									</p>


									<input type="submit" value="Inscription" class="sansLabel" />
								</fieldset>

							</form>
							<!--  -->
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
						<a href="accueil2.jsp">A propos du site</a>
					</h2>
					<ul class="style3">
						<li class="first">
							<p class="date">
								<a href="#">10.03.2012</a>
							</p>
							<p>
								<a href="#">Vestibulum sem magna, elementum ut, vestibulum
									eu, facilisis. Mauris a dolor. Nulla facilisi. Cum sociis
									natoque penatibus.</a>
							</p>
						</li>
						<li>
							<p class="date">
								<a href="#">10.03.2012</a>
							</p>
							<p>
								<a href="#">Pellentesque erat erat, tincidunt in, eleifend,
									malesuada bibendum. Suspendisse sit amet in eros bibendum
									condimentum. </a>
							</p>
						</li>
					</ul>
				</section>
			</div>
			<div class="6u">
				<section id="box2">
					<h2>Donec dictum metus</h2>
					<div class="border-img">
						<a href="#"><img src="images/pics02.jpg" alt=""></a>
					</div>
					<p>Nulla enim eros, porttitor eu, tempus id, varius non, nibh.
						Duis enim nulla, luctus eu, dapibus lacinia, venenatis id, quam.
						Vestibulum imperdiet, magna nec eleifend rutrum, nunc lectus
						vestibulum velit, euismod lacinia quam nisl id lorem. Quisque
						erat. Vestibulum pellentesque, justo mollis pretium suscipit,
						justo nulla blandit libero, in blandit augue justo quis nisl.</p>
				</section>
			</div>
			<div class="3u">
				<section id="box3">
					<h2>Nulla luctus eleifend</h2>
					<ul class="style1">
						<li class="first"><a href="#">Pellentesque quis elit non
								lectus gravida blandit luctus eleifend purus condimentum.</a></li>
						<li><a href="#">Lorem ipsum dolor sit amet, consectetuer
								adipiscing dictum metus in sapien elit.</a></li>
						<li><a href="#">Phasellus nec dictum metus in sapien erat
								sit amet nibh pellentesque congue.</a></li>
						<li><a href="#">Cras vitae metus aliquam risus dictum
								metus in sapien pellentesque pharetra.</a></li>
						<li><a href="#">Duis non dictum metus in sapien ante in
								metus commodo euismod lobortis.</a></li>
					</ul>
				</section>
			</div>
		</div>
	</div>
	<div id="copyright" class="5grid-layout">
		<section>
			<p>
				&copy; Your Site Name | Images: <a href="http://fotogrph.com/">Fotogrph</a>
				| Design: <a href="http://html5templates.com/">HTML5Templates.com</a>
			</p>
		</section>
	</div>
</body>
</html>