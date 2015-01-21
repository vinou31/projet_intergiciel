<!DOCTYPE HTML>

<!--
	Synchronous: A responsive HTML5 website template by HTML5Templates.com
	Released for free under the Creative Commons Attribution 3.0 license (html5templates.com/license)
	Visit http://html5templates.com for more great templates or follow us on Twitter @HTML5T
-->

<%@page import="metier.Categorie"%>
<%@page import="java.util.Collection"%>
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
<script
	src="${pageContext.request.contextPath}/V2/synchronous/css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
<script type="text/javascript"
	src="livevalidation_standalone.compressed.js"></script>
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
									<li><a href="${pageContext.request.contextPath}/ServArticle">Article</a></li>
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
						<div class="article">
						<h2>Articles</h2>
						<%Collection<Categorie> cat = (Collection<Categorie>) request.getAttribute("categorie");
						%>
						<ul class="niveau1">
						<%if(cat != null){
						
						for (Categorie c : cat){
							%>													
								<li><% out.print(c.getNomCategorie()); %>
									<ul class="niveau2">
									<%
									Collection<Categorie> souscat = (Collection<Categorie>) c.getSousCategorie();
									for (Categorie c2: souscat){
										%>
										<li><% out.print(c2.getNomCategorie()); %></li>

										<%}%>
									</ul>
								</li>
							
							<% 			
						}
						}
						%>
						</ul>			
							</div>
						</section>	

						
					</div>


					<div class="9u mobileUI-main-content">
						<div id="content">
							<header>
								<h2>Inscription</h2>
							</header>
							<div class="inscription">
								<form method="post" action="${pageContext.request.contextPath}/ServInscription">
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
											Entrer un mot de passe: <input type="text" id="motDePasse" name="motDePasse" value="" size="20"	maxlength="20" /> <br> 
											Confirmer le mot de passe: <input type="text" id="confirmation" name="confirmation" value="" size="20" maxlength="20" class="LV_invalid_field" />
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

										<p>
											E-mail: <input type="mail" id="mail" name="mail"  size="20" maxlength="60" />
											<script type="text/javascript">
												var f20 = new LiveValidation(
														'f20',
														{
															validMessage : "  OK"
														});
												f20
														.add(
																Validate.Email,
																{
																	failureMessage : "  Adresse non Valide"
																});
											</script>
										</p>



										<!--<script src="//s7.addthis.com/static/r07/menu169.js" type="text/javascript"></script><script src="//s7.addthis.com/static/r07/lang33/fr.js" type="text/javascript"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">-->

										<!-- <script type="text/javascript" src="javascripts/src/1.3/livevalidation_standalone.compressed.js"></script>-->
									</fieldset>

									<fieldset>
										<legend>Vos coordonnées</legend>
										<!-- Titre du fieldset -->

										<p>
											Nom: <input type="text" id="nom" name="nom" size="20" maxlength="20" />
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
																	failureMessage : "   Ce champs doit être rempli, sinon ca va pas le faire... du tout"
																});
											</script>
										</p>

										<p>
											Prénom: <input type="text" id="prenom" name="prenom">
											<script type="text/javascript">
												var f2 = new LiveValidation(
														'f2',
														{
															validMessage : "  OK"
														});
												f2
														.add(
																Validate.Presence,
																{
																	failureMessage : "   Le prénom aussi, fait pas ton parano"
																});
											</script>
										</p>

										<p>
											Numéro + Rue: <input type="text" id="adresse" name="adresse" size="20" maxlength="20" />
											<script type="text/javascript">
												var f4 = new LiveValidation(
														'f4',
														{
															validMessage : "  OK"
														});
												f4
														.add(
																Validate.Presence,
																{
																	failureMessage : "   Il faut entrer un truc du style: 56 rue des Gitans, compris?"
																});
											</script>
										</p>

										<p>
											Ville: <input type="text" id="ville" name="ville">
											<script type="text/javascript">
												var f3 = new LiveValidation(
														'f3',
														{
															validMessage : "  OK"
														});
												f3
														.add(
																Validate.Presence,
																{
																	failureMessage : "   Il faut entrer un nom de ville"
																});
											</script>
										</p>


										<label for="tel">Téléphone :</label><br> <input
											type="text" id="telephone" name="telephone" size="20" maxlength="20" />

										<p>
											Faites un souhait que vous voudriez voir exaucé :<br> <input
												type="radio" name="souhait" value="riche" id="riche">
											Etre riche<br> <input type="radio" name="souhait"
												value="celebre" id="celebre"> Etre célèbre <input
												type="radio" name="souhait" value="intelligent"
												id="intelligent"> Etre <strong>encore</strong> plus
											intelligent <input type="radio" name="souhait" value="autre"
												id="autre"> Autre...
										</p>

										<p>
											<label for="precisions">Si "Autre", veuillez préciser
												:</label><br>
											<textarea name="precisions" id="precisions" cols="40"
												rows="4"></textarea>
										</p>
										<input type="submit" value="Inscription" class="sansLabel" />
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
	<div id="copyright" class="5grid-layout">
		<section>
			<p>&copy; TrocMania | Images: <a href="http://fotogrph.com/">Fotogrph</a></p>
		</section>
</div>
</body>
</html>