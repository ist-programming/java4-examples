<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <a href="${s:mvcUrl('DC#index').build()}">Default page</a>,
    <a href="${s:mvcUrl('DC#simple').build()}">Simple action</a>,
    <a href="${s:mvcUrl('DC#simpleMultiple').build()}">Simple action accessible by few URLs</a>,
    <a href="${s:mvcUrl('DC#responseBody').build()}">Response returned by controller</a>,
    <a href="${s:mvcUrl('DC#writer').build()}">Using of java.io.Writer</a>,
    <a href="${s:mvcUrl('DC#responseStatus').build()}">Response status code setting</a>,
    <a href="${s:mvcUrl('DC#requestMappingBunch').build()}">Additional request mapping options</a>,
    <a href="${s:mvcUrl('DC#requestParam').arg(0, 'someValue').build()}">Receiving request parameters</a>,
    <a href="${s:mvcUrl('DC#requestParamBanch').arg(0, 'someValue').build()}">Additional request parameters receiving options</a>,
    <a href="${s:mvcUrl('DC#pathVariable').arg(0, 'someValue').build()}">Path variable receiving</a>,
    <a href="${s:mvcUrl('DC#pathVariableBunch').arg(0, 'someValue').arg(1, 'someValue2').build()}">Additional path variable receiving options</a>,
    <a href="${s:mvcUrl('DC#requestHeader').build()}">Request header receiving</a>

    <div style="border:3px double black;margin:100px; padding:30px">
      ${viewVariable}
    </div>

  </body>
</html>
