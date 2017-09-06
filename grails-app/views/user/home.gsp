<html>
<head>
    <title>Random Quote</title>
    <asset:stylesheet src="AllElementsTableStyle.css"/>

</head>

<body>
<g:render template="menu"/>

<table>
    <g:each var="quote" in="${quotes}">
        <tr><div id="quote">
            <td><p style="margin: 20pt">${quote.author.username}</p></td>
            <td> <q>${quote.content}</q></td>
            <br>
        </div>
        </tr>
    </g:each>
</table>
</body>
</html>