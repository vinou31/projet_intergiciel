<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>

<section>
	<div class="article">
		<a href="${pageContext.request.contextPath}/ServArticles?op=articlesEnVente"><h2>Articles</h2></a>
		<%Collection<Categorie> cat = (Collection<Categorie>) request.getAttribute("categorie");
						%>
		<ul class="niveau1">
			<%if(cat != null){
						
						for (Categorie c : cat){
							%>
			<li>
				<% out.print(c.getNomCategorie()); %>
				<ul class="niveau2">
					<%
									Collection<Categorie> souscat = (Collection<Categorie>) c.getSousCategorie();
									for (Categorie c2: souscat){
										%>
					<li>
						<% out.print(c2.getNomCategorie()); %>
					</li>

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