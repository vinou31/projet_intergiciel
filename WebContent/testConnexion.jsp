<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="ServConnexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
                
                <label for="pseudonyme">Pseudo</label>
                <input type="text" id="pseudonyme" name="pseudonyme" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                ${erreurs['exception']}
                <!-- <span class="erreur">${form.erreurs['nom']}</span> -->
                <br />
                
                <label for="password">Mot de passe</label>
                <input type="text" id="motDePasse" name="motDePasse" value="<c:out value="${utilisateur.adresse}"/>" size="20" maxlength="20" />
                <!--  <span class="erreur">${form.erreurs['adresse']}</span> -->
                <br />
                ${erreurs['exception']}
                
                
             <!--   <label for="portemonnaie">Montant du porte-monnaie</label>
                <input type="text" id="portemonnaie" name="portemonnaie" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['']}</span>
                <br />
                
                 --> 

                

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
        
        <a href=Accueil>retour a l'accueil</a>
    </body>
</html>