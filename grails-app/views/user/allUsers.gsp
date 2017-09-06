<html>
<head>
    <title>Random Quote</title>
    <asset:stylesheet src="AllElementsTableStyle.css"/>

</head>

<body>
<g:render template="menu"/>

<g:each var="user" in="${users}">
    <div id="user">
        ${user.username}
    </div>
    <div>
    <div>
        <g:link action="show" id="${user.id}">
            Show user
        </g:link>
    </div>
</g:each>
</body>
</html>