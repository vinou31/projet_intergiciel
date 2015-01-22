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

<%@page import="java.util.Collection"%>
<%@page import="metier.Categorie"%>
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
							<header>
								<h2>Connexion</h2>
							</header>
							<div class="inscriptio">
								<form method="post" action="${pageContext.request.contextPath}/ServConnexion">
									<fieldset>
										<legend>Informations de compte</legend>
										<!-- Titre du fieldset -->


										<p>
											Pseudonyme: <input type="text" id="pseudonyme" name="pseudonyme" value="" size="20" maxlength="20" />
											<script type="text/javascript">
												var f1 = new LiveValidation(
														'f1',
														{
															validMessage : "  OK"
														});
												f1
														.add(
																Validate.Presence,
																{
																	failureMessage : "   Il semblerait qu'il soit déjà utilisé"
																});
											</script>
										</p>

										<p>
											Entrer un mot de passe: <input type="password" id="motDePasse" name="motDePasse" value="" size="20"	maxlength="20" /> <br> 
											<!--<span class=" LV_validation_message LV_invalid">Le mot de passe doit être identique</span>-->
											<script type="text/javascript">
												var f19 = new LiveValidation(
														'f19',
														{
															validMessage : "  OK"
														});
												f19
														.add(
																Validate.Confirmation,
																{
																	match : 'myPasswordField',
																	failureMessage : "  Les mots de passe ne correspondent pas!"
																});
											</script>
										</p>

										
										<input type="submit" value="Connexion" class="sansLabel" />
									</fieldset>
									
								</form>
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