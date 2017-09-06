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
    %{--<div>--}%

        %{--<button><g:link action="show" id="${user.id}">--}%
            %{--Show user--}%
        %{--</g:link>--}%
    %{--</button>--}%
    <div>

        <button><g:link action="singleUser" params="${[id: user.id]}">
            Show user
        </g:link>
        </button>
    </div>
    <hr>
</g:each>
</body>
</html>