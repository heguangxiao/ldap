<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html lang="en">
    <head>
        <title>${title}</title>
        <tiles:insertAttribute name="header" />
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <tiles:insertAttribute name="content" />

            <div id="layoutAuthentication_footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>