<html>
<head>
    <title>Random Quote</title>
    <asset:stylesheet src="AllElementsTableStyle.css"/>

</head>

<body>
<g:render template="menu"/>

<div id="user">
    <p>${user.username}</p>

    <p>${user.email}</p>
</div>

<div>

    <button><g:link action="follow" params="${[id: user.id]}">
       Follow
    </g:link>
    </button>
</div>

%{--<g:each var="user" in="${users}">--}%
%{--<div id="user">--}%
%{--${user.username}--}%
%{--</div>--}%
%{--<div>--}%

%{--<button><g:link action="show" id="${user.id}">--}%
%{--Show user--}%
%{--</g:link>--}%
%{--</button>--}%
%{--</div>--}%
%{--<hr>--}%
%{--</g:each>--}%
</body>
</html>