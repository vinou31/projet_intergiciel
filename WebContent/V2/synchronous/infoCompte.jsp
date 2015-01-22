<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>


<%	
	if (m != null) {
%>
<section>
	<h2>Informations sur Compte</h2>
	<ul>
		<li>
			<p>Photo de profil:</p>
		</li>
		<img
			src=
			<%if(m.getPhotoProfil()!=null){
								out.println("\""+m.getPhotoProfil()+"\"");}else{%>
								"${pageContext.request.contextPath}/V2/synchronous/images/defaut.jpg"<%} %>
			alt="" class="imgprofile">
		<li>
			<p>
				<strong><%=m.getPrenom()%> <%=m.getNom()%></strong>
			</p>
		</li>
		<li>
			<p>
				<strong><%=m.getPseudonyme()%></strong>
			</p>
		</li>
		<li><p class="button-style"><a
			href="${pageContext.request.contextPath}/ServArticles?op=mes+articles">
				Article en vente :<%=m.getPropose().size()%></a></p></li>
		<li><p class="button-style"><a
			href="${pageContext.request.contextPath}/ServAjouterArticle?op=launch">
				Ajouter un article</a></p></li>
		<li><p class="button-style"><a
			href="${pageContext.request.contextPath}/ServCompte?op=gestionCompte">
				Page de compte</a></p></li>
		<li><p class="button-style"><a
			href="${pageContext.request.contextPath}/ServAvis?op=listeAvisPerso">
				Liste des avis</a></p></li>
		<li>
			<!--  <form method="get", action = "ServDeconnexion">
									<p class="button-style">Déconnexion</p>
									<input type="hidden"/>
								</form>--> <p class="button-style">
		<a href="${pageContext.request.contextPath}/ServDeconnexion">Deconnexion</a></p>
		</li>
	</ul>
</section>
<% }%>