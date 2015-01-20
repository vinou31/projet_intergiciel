
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Collection"%>
<%@page import="metier.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TrocMania</title>
</head>
<body>
<header>
	<div id="titre_principal">
	<img src="images/zozor_logo.png" alt="Logo de Zozor" id="logo" />
		<div class="titre"><h1 class="t">TrocMania </h1>
		<h2 >Le site du troc en ligne</h2></div>
	</div>
	<nav>
	<ul>
		<li><a href="#">Accueil</a>
		<li><a href="#">Articles</a>
		<li><a href="#">Compte</a>
	</ul>
</nav>
</header>



<section>
<div class="gauche">
<aside>
		<h1>mon compte</h1>
		<img src="images/bulle.png" alt="" id="fleche_bulle" />
		<p id="photo_zozor"><img src="images/zozor_classe.png" alt="Photo de Zozor" /></p>
		<p>info comptes</p>
	</aside>
	<article>
	<form action="Accueil" method="post">
		<h1><img src="images/ico_epingle.png" alt="Catégorie voyage" class="ico_categorie" />les articles</h1>
		<% Collection<Article> listArticle = (Collection<Article>)request.getAttribute("article"); 
		if(listArticle.isEmpty()){}
		else{
			int i = 1;%>
			<% for(Article article : listArticle) { %>
			<img alt="article_"+<%=i%> src=<%=article.getImage()%> >
			<%i++;
			}
			}%>
		</form>
	</article>
</div>

<div class="centre">
	<h2>mes informations personnelles</h2>
	<img src="images/bulle.png" alt="" id="fleche_bulle" />
	<p id="photo_zozor"><img src="images/zozor_classe.png" alt="Photo de Zozor" /></p>
	<div class="infosPersos">
	prenom nom <br/>
	pseudo <br/>
	vous disposez de 0 noisettes
	</div>
	<div>
	téléphone<br/>
	mail<br/>
	adresse<br/>
	</div>
</div>
</section>


<footer>
	<p> copyright vinou- tous droits réservés</p>	
	<a href="#">nous contacter</a>
</footer>

</body>
</html>