<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>

<section>
	<div class="article">
		<a href="${pageContext.request.contextPath}/ServArticles?op=articlesEnVente"><h2>Articles</h2></a>
		<%Collection<Categorie> cat = (Collection<Categorie>) request.getAttribute("categorie");%>
		<div class="cssmenu">
		<ul>
			<%if(cat != null){
						for (Categorie c : cat){%>
			<li class='has-sub'>
				<% out.print(c.getNomCategorie()); %>
				<ul> 
					<%
					Collection<Categorie> souscat = (Collection<Categorie>) c.getSousCategorie();
					for (Categorie c2: souscat){
					%>
					<li>
					<a href="${pageContext.request.contextPath}/ServArticles?op=articlesEnVenteCat&idCat=<%=c2.getID()%>">
						<span><% out.print(c2.getNomCategorie()); %></span>
						</a>
					</li>
					<%}%>
				</ul>
			</li>
			<% 	}}%>
		</ul>
		</div>
	</div>
</section>