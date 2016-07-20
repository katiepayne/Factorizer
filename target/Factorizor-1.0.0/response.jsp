<%-- 
    Document   : response
    Created on : Jul 10, 2016, 10:02:07 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">
        <title>Factorizor</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/starter-template.css" rel="stylesheet" type="text/css">
        <link href="factorCSS.css" type="text/css" rel="stylesheet" />
        <title>Factorizor Results</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="container">
                <div class="page-header text-center">
                    <h1>Factorizor Results</h1>
                </div>
            </div>
            <div class="container">
                <div class="col-lg-12 text-center">                    
                    <c:if test="${hasFactors}">
                        <p>The factors of <c:out value="${number}"/> are:</p>
                        <p>
                            <c:forEach items="${factors}" var="factor">
                                ${factor}<br/>
                            </c:forEach>
                        </p>
                    </c:if>
                    <c:if test="${isPerfect}">
                        <p>The number you have chosen is a perfect number.</p>
                    </c:if>
                    <c:if test="${isPrime}">
                        <p>The number you have chosen is a prime number.</p>
                    </c:if>
                </div>
            </div>

        </div>
    </body>
</html>

