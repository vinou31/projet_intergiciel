<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>

<%
	Membre membre = (Membre) session.getAttribute("session");
	if (membre != null) {
%>
<section>
	<h2>Informations sur Compte</h2>
	<ul>
		<li>
			<p>Photo de profil:</p>
		</li>
		<img
			src="<%if(membre.getPhotoProfil()!=null){membre.getPhotoProfil();}else{out.println("${pageContext.request.contextPath}/V2/synchronous/images/197.jpg");}%>"
			alt="" class="imgprofile">
		<li>
			<p>
				<strong><%=membre.getPrenom()%> <%=membre.getNom()%></strong>
			</p>
		</li>
		<li>
			<p>
				<strong><%=membre.getPseudonyme()%></strong>
			</p>
		</li>
		<li><a
			href="${pageContext.request.contextPath}/ServArticle?op=articlesEnVente">
				Article en vente :<%=membre.getPropose().size()%></a></li>
		<li><a
			href="${pageContext.request.contextPath}/V2/synchronous/AjouterArticle.jsp">
				Ajouter un article</a></li>
		<li><a
			href="${pageContext.request.contextPath}/ServCompte?op=gestionCompte">
				Page de compte</a></li>
		<li><a
			href="${pageContext.request.contextPath}/ServAvis?op=listeAvisPerso">
				Liste des avis</a></li>
		<li>
			<!--  <form method="get", action = "ServDeconnexion">
									<p class="button-style">Déconnexion</p>
									<input type="hidden"/>
								</form>--> <a
			href="${pageContext.request.contextPath}/ServDeconnexion">Deconnexion</a>
		</li>
	</ul>
</section>
<% }%>