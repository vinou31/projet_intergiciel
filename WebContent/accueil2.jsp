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
									<li><a href="AccueilVrai.jsp">Accueil</a></li>
									<%
										Membre m = (Membre) session.getAttribute("session");
										if (m == null) {
											//out.print("<li><a href=\"testInscription.jsp\">Inscription</a>");
											//out.print("<li><a href=\"testConnexion.jsp\">Connexion</a>");
											out.print("<li><a href=\"/PIntergiciel/V2/synchronous/Inscription.jsp\">Inscription</a>");
											out.print("<li><a href=\"/PIntergiciel/V2/synchronous/Connexion.jsp\">Connexion</a>");
										}
									%>

									<li class="current_page_item"><a href="acceuil2.html">A
											propos du site</a></li>
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

						<section>
							<h2>Information de Compte</h2>
							<ul>
								<li>
									<p>Photo de profil</p>
								</li>
								<img src="images/197.jpg" alt="" class="imgprofile">
								<li>
									<p>
										<strong>ECCLI Kévin</strong>
									</p>
								</li>
								<li>
									<p>
										<strong>Gitandu57</strong>
									</p>
								</li>
								<li>
									<p>Article en vente : 4</p>
								</li>
								<li>
									<p>Transactions effectuées : 4</p>
								</li>
								<li>
									<p>Avis positif : 4</p>
								</li>
								<li>
									<p>Avis négatif: 4*10^16</p>
								</li>

							</ul>

							<p class="button-style">
								<a href="#">Déconnexion</a>
							</p>
						</section>
					</div>


					<div class="9u mobileUI-main-content">
						<div id="content">
							<section>
								<div class="post">
									<h2>Bienvenue sur TrocMania !!!</h2>
									<p>
										Description du site.... Cette plateforme d'échange a été
										développé dans le cadre d'un projet d'intergicielle à
										l'INP-ENSEEIHT Toulouse. Date création et origine Vous pouvez
										dés à présent <a href="http://html5templates.com/">consulter
											les articles</a> du site.
									</p>
									<p>&nbsp;</p>
									<p>L'inscription est rapide blablabla.... Mode marchand de
										tapis</p>
									<p>&nbsp;</p>
									<p class="button-style">
										<a href="#">Je m'inscris immédiatement</a>
									</p>
								</div>
							</section>
							<section>
								<h2>Bienvenue sur TrocMania</h2>
								<p>Consectetuer adipiscing elit. Nam pede erat, porta eu,
									lobortis eget, tempus et, tellus. Etiam neque. Vivamus
									consequat lorem at nisl. Nullam non wisi a sem semper eleifend.
									Donec mattis libero eget urna. Duis pretium velit ac mauris.
									Proin eu wisi suscipit nulla suscipit interdum. Aenean lectus
									lorem, imperdiet at, ultrices eget, ornare et, wisi.
									Pellentesque adipiscing purus ac magna. Pellentesque habitant
									morbi tristique senectus et netus et malesuada fames ac turpis
									egestas. Pellentesque pede. Donec pulvinar ullamcorper metus.
									In eu odio at lectus pulvinar mollis. Vestibulum sem magna,
									elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a
									dolor. Nulla facilisi. Cum sociis natoque penatibus et magnis
									dis parturient montes, nascetur ridiculus mus. Sed blandit.
									Phasellus pellentesque, ante nec iaculis dapibus, eros justo
									auctor lectus, a lobortis lorem mauris quis nunc. Praesent
									pellentesque facilisis elit. Class aptent taciti sociosqu ad
									litora torquent per conubia nostra, per inceptos hymenaeos. In
									hac habitasse platea dictumst. Nullam id ante eget dui
									vulputate aliquam. Pellentesque erat erat, tincidunt in,
									eleifend accumsan, malesuada eget, augue. Suspendisse sit amet
									tellus in eros bibendum condimentum. Vestibulum suscipit
									volutpat nulla. Maecenas pede nisl, elementum eu, ornare ac,
									malesuada at, erat. Proin gravida orci porttitor enim accumsan
									lacinia.</p>
								<p>&nbsp;</p>
								<p>Aliquam erat volutpat. Pellentesque tristique ante ut
									risus. Quisque dictum. Integer nisl risus, sagittis convallis,
									rutrum id, elementum congue, nibh. Suspendisse dictum porta
									lectus. Donec placerat odio vel elit. Nullam ante orci,
									pellentesque eget, tempus quis, ultrices in, est. Curabitur sit
									amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna,
									consequat vel, suscipit in, mattis placerat, nulla. Sed ac leo.
									Pellentesque imperdiet. Nulla enim eros, porttitor eu, tempus
									id, varius non, nibh. Duis enim nulla, luctus eu, dapibus
									lacinia, venenatis id, quam. Vestibulum imperdiet, magna nec
									eleifend. Praesent pellentesque facilisis elit. Class aptent
									taciti sociosqu ad litora torquent per conubia nostra, per
									inceptos hymenaeos. In hac habitasse platea dictumst. Nullam id
									ante eget dui vulputate aliquam. Pellentesque erat erat,
									tincidunt in, eleifend accumsan, malesuada eget, augue.
									Suspendisse sit amet tellus in eros bibendum condimentum.
									Vestibulum suscipit volutpat nulla. Maecenas pede nisl,
									elementum eu, ornare ac, malesuada at, erat.</p>
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