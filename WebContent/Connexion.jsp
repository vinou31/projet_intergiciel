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
	<link rel="stylesheet" href="css/5grid/core.css" />
	<link rel="stylesheet" href="css/5grid/core-desktop.css" />
	<link rel="stylesheet" href="css/5grid/core-1200px.css" />
	<link rel="stylesheet" href="css/5grid/core-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
<script src="css/5grid/jquery.js"></script>
<script
	src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
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
									<li><a href="index.html">Les articles</a></li>
									<li><a href="threecolumn.html">Three Column</a></li>
									<li class="current_page_item"><a href="twocolumn1.html">Two
											Column #1</a></li>
									<li><a href="twocolumn2.html">Connection</a></li>
									<li><a href="onecolumn.html">Inscription</a></li>
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

						
					</div>


					<div class="9u mobileUI-main-content">
						<div id="content">
							<header>
								<h2>Inscription</h2>
							</header>
							<div class="inscriptio">
								<form method="post" action="/PIntergiciel/ServConnexion">
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
					<h2>Maecenas lectus</h2>
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