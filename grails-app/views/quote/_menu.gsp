<html>
<head>
    <meta charset="utf-8">

<asset:stylesheet src="PageStyle.css"/>
<asset:stylesheet src="AllElementsTableStyle.css"/>


<style>#second {
    left: -105px;
    top: 400px;
    background-color: #333;
    color: white;
    position: absolute;
    font-size: 18pt;
    transition: 1s;
}

#second:hover {
    left: 0px;
}</style>

    </head>
    <body>
    <header>
        <h1>Tweettie</h1>
        <ul class="hr">
 <li style="margin: 5pt">
    <g:link action="home">
        Home
    </g:link>
    </li>
            <li style="margin: 5pt">
                <g:link action="random">
                    Random Quote
                </g:link>
            </li>
            <li style="margin: 5pt">
                <g:link action="quoteEditor">
                    New Quote
                </g:link>
            </li>
            <li style="margin: 5pt">
                <g:link controller="user" action="allUsers">
                    Find Friends
                </g:link>
            </li>
</ul>
</header>

</body>
</html>