<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html lang="en">
    <head>
        <title>${title}</title>
        <tiles:insertAttribute name="header" />
    </head>
    <body class="sb-nav-fixed">
        <tiles:insertAttribute name="menu" />
        <div id="layoutSidenav">
            <tiles:insertAttribute name="left" />            
            <div id="layoutSidenav_content">
                <tiles:insertAttribute name="content" />
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>