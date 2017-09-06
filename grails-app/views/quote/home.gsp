<html>
<head>
    <title>Random Quote</title>
    <asset:stylesheet src="AllElementsTableStyle.css"/>

</head>

<body>
<g:render template="menu"/>

    <g:each var="quote" in="${quotes}">
        <div id="quote">
            <q>${quote.content}</q>
            <p>${quote.author.username}</p>
            <br>
        </div>
    </g:each>
</body>
</html>