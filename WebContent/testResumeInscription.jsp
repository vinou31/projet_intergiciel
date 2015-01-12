<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="intergiciel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%Membre m = (Membre)request.getAttribute("utilisateur"); %>
	Vous etes inscrit en tant que : </br>
	Nom : <%=m.getNom() %></br>
	Adresse : <%=m.getAdresse() %></br>
	numero de telephone : <%=m.getTelephone() %></br>
	pseudo :<%=m.getPseudonyme() %> </br>
	porte monnaie : <%=m.getPorteMonnaie() %></br>
	mail :<%=m.getMail() %> </br>
	mot de passe : <%=m.getMotDePasse() %></br>
	
	
	
	<a href="Accueil">retour a la page d'accueil</a>
	<a href="ServInscription?op=liste">liste des membres</a>
</p>
</body>
</html>