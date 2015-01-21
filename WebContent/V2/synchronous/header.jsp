<%@page import="java.sql.SQLData"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.*"%>
<%@ page import="java.util.*"%>

<div class="5grid-layout">
	<div class="row">
		<div class="12u" id="logo">
			<!-- Logo -->
			<h1>
				<a
					href="${pageContext.request.contextPath}/V2/synchronous/AccueilVrai.jsp"
					class="mobileUI-site-name">TrocMania</a>
			</h1>
			<p>La première forme de commerce au monde revient en version 2.0</p>
		</div>
	</div>
</div>
<div class="5grid-layout">
	<div class="row">
		<div class="12u" id="menu">
			<div id="menu-wrapper">
				<nav class="mobileUI-site-nav">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/AccueilVrai.jsp">Accueil</a></li>
						<%
								Membre m = (Membre) session.getAttribute("session");
								if (m == null) {
									out.print("<li><a href=\"${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/Inscription.jsp\">Inscription</a>");
									out.print("<li><a href=\"${pageContext.request.contextPath}/V2/synchronous/V2/synchronous/Connexion.jsp\">Connexion</a>");
								}
								else {								
									%>
						<li><a
							href="${pageContext.request.contextPath}/ServCompte?op=gestionCompte">Compte</a></li>
						<%} %>

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