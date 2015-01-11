<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="intergiciel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Liste des membres : 

<table>
	<thead>
		<tr>
			<th>nom</th>
			<th>pseudo</th>
			<th>adresse</th>
			<th>mail</th>
		</tr>
	</thead>
	
	<tbody> <!-- Corps du tableau -->
	<%
    	Collection<Membre> liste = (Collection<Membre>)request.getAttribute("membres");
        for(Membre m : liste){
        	   out.println("</tr>");
           
           
        	   out.println("<td>"+m.getNom()+"</td>");
        	   out.println("<td>"+m.getPseudonyme()+"</td>");
        	   out.println("<td>"+m.getAdresse()+"</td>");
        	   out.println("<td>"+m.getMail()+"</td>");
       
        	   out.println("</tr>");
        }
           
       
       %>
   </tbody>
   
</table>
</body>
</html>