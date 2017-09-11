<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <asset:stylesheet src="AllElementsTableStyle.css"/>

</head>
<body>
<g:render template="menu" />


<form controller="quote" action="postMessage">
    <label>Enter Your Quote: </label>
    <input type="text" name="content"/><br/>
    <input type="submit" value="Save" />
</form>

<hr>

<g:each var="quote" in="${quotes}">
    <div id="quote">
        <q>${quote.content}</q>
        <p>${quote.author.username}</p>
        <br>
    </div>
</g:each>
</body>
</html>