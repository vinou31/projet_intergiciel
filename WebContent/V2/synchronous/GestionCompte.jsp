<%@page import="metier.Article"%>
<%@page import="metier.Membre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

							<li><a href="${pageContext.request.contextPath}/Accueil">Accueil</a></li>
							<%
								Membre m = (Membre) session.getAttribute("membre");
								if (m == null) {
									%>
									<!-- <li><a href="${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/Inscription.jsp\">Inscription</a>
									<li><a href="${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/Connexion.jsp\">Connexion</a> -->
									<li><a href="${pageContext.request.contextPath}/V2/synchronous/Inscription.jsp">Inscription</a>
									<li><a href="${pageContext.request.contextPath}/V2/synchronous/Connexion.jsp">Connexion</a>
							
								<%}else {								
									%>
									<li><a href="${pageContext.request.contextPath}/ServCompte?op=gestionCompte">Compte</a></li>
									<%} %>

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
	
				<div class="6u mobileUI-main-content">
				<div id="content">
					<section>
					<form action="ServCompte" method="get">
						<div class="post">
						<%if (m != null){%>						
					<h2>Compte de :<%=m.getNom() %></h2>
							<div class="attributCompte">
							<li>Numéro de téléphone : 
							<input class="searchfield" name="telephone" type="text" value=<%=m.getTelephone() %>  onblur="if (this.value !=<%=m.getTelephone()%>) {this.value = <%=m.getTelephone() %>;}"></li>
							<li>Pseudonyme : 
							<input class="searchfield" name="pseudo" type="text" value=<%=m.getPseudonyme() %> onfocus="if (this.value == <%=m.getPseudonyme() %>) {this.value = '';}" onblur="if (this.value == '') {this.value = <%=m.getPseudonyme() %>;}"></li>
							<li>Mail : 
							<input class="searchfield" name="mail" type="text" value=<%=m.getMail() %> onfocus="if (this.value == <%=m.getMail() %>) {this.value = '';}" onblur="if (this.value == '') {this.value = <%=m.getMail() %>;}"></li>
							<li>Adresse : 
							<input class="searchfield" name="adresse" type="text"  value=<%=m.getAdresse() %> onfocus="if (this.value == <%=m.getAdresse() %>) {this.value = '';}" onblur="if (this.value == '') {this.value = <%=m.getAdresse() %>;}"></li>
							<li>Mot de passe :
							<input class="searchfield" name="mdp" type="password" value=<%=m.getMotDePasse() %> onfocus="if (this.value == <%=m.getMotDePasse() %>) {this.value = '';}" onblur="if (this.value == '') {this.value = <%=m.getMotDePasse() %>;}"></li>
							<li> Photo de profil :
							<input type="file" name="file" id="file" size="60"/></li>
							<input type="submit" value="Enregistrer Modification" id="EnregistrerModification" name="op"/>
							
							Vos articles :
							<%if (m.getPropose().size() == 0) { %>
							 Vous n'avez proposé encore aucun article
							 <input type="submit" value="proposer un article" id="ProposerUnArticle" name="op">
							
							 <%} else { %>
							 	<input type="submit" value="mes articles" id="ProposerUnArticle" name="op">
							 	<%}%>	 	
							<%} else { %>
								Vous allez être redirigé là où vous pouvez vous inscrire
								<jsp:forward page="Inscription.jsp"></jsp:forward>
							<%}%>							
						</div>
						</form>
					</section>
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
				<h2><a href="${pageContext.request.contextPath}/V2/synchronous/accueil2.jsp">A propos du site</a></h2>
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
</body>
</html>