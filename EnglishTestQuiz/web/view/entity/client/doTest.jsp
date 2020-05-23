<%-- 
    Document   : doTest
    Created on : Jul 23, 2019, 1:10:10 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="../doTest/css/main.css" rel="stylesheet" type="text/css"/>
<script src="../doTest/js/main.js" type="text/javascript"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function submitdata(action, id)
            {
                document.location.href = action + '?testID=' + id;
            }
        </script>
    </head>
    <body>

        <form action="submittest" method="POST">
            <% String testid = request.getAttribute("testID").toString();
            %>
            <input type="hidden" value="${testID}" name="tid">
            <ul class="quiz">
                <c:forEach items="${questions}" var="list">
                    <li>
                        <h4>${list.questionID}.${list.question}</h4>
                        <ul class="choices">
                            <li><label><input type="radio" name="${list.questionID}" value="A"><span>${list.option1}</span></label></li>
                            <li><label><input type="radio" name="${list.questionID}" value="B"><span>${list.option2}</span></label></li>
                            <li><label><input type="radio" name="${list.questionID}" value="C"><span>${list.option3}</span></label></li>                   
                        </ul>
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Submit Test">
            <!--<input type="button" value="Add to your tests list" onclick="submitdata('http://localhost:8080/Assignment/entityClient/submittest',${testID})"/>-->
        </form>
    </body>
</html>
