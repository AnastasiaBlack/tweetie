<html>
  <head>
    <title>Random Quote</title>
      <asset:javascript src="jquery-2.2.0.min.js"/>
         %{--<g:javascript>--}%
             %{--function getAjaxRandom()    {--}%
                 %{--$.get( "ajaxRandom", function(data) {--}%
                     %{--$("#quote").html(data)--}%
                 %{--})--}%
             %{--}--}%
         %{--</g:javascript>--}%
  </head>
 <body>
 <ul id="menu">
         <li>
             %{--<a onclick="getAjaxRandom()" href="javascript:getAjaxRandom()">Next Quote</a>--}%
             <g:link action="random">
                 Next Quote
             </g:link>
         </li>
     <li>
         <g:link action="index">
             Admin
         </g:link>
     </li>
 </ul>
    <div id="quote">
      <q>${quote.content}</q>
      <p>${quote.author}</p>
    </div>
  </body>
</html>