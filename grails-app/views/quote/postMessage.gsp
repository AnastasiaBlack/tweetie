<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <asset:stylesheet src="AllElementsTableStyle.css"/>

</head>
<body>
<g:render template="menu" />

<div id="quote">
    <q>${quote.content}</q>
    <p>${quote.author.username}</p>
</div>

</body>
</html>