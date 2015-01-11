<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="ServInscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
                
                <label for="adresse">Adresse</label>
                <input type="text" id="adresse" name="adresse" value="<c:out value="${utilisateur.adresse}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['adresse']}</span>
                <br />
                
                <label for="telephone">Telephone</label>
                <input type="text" id="telephone" name="telephone" value="<c:out value="${utilisateur.telephone}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['telephone']}</span>
                <br />

                <label for="mail">Adresse email <span class="requis">*</span></label>
                <input type="mail" id="mail" name="mail" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['mail']}</span>
                <br />
                
                <label for="pseudonyme">Pseudo</label>
                <input type="text" id="pseudonyme" name="pseudonyme" value="<c:out value="${utilisateur.pseudonyme}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['pseudonyme']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />
                
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
    </body>
</html>