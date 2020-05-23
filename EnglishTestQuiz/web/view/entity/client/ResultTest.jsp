<%-- 
    Document   : Result
    Created on : Jul 6, 2019, 5:49:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${msg}
        <c:forEach items="${questions}" var="q">
            <p>${q.questionID}. ${q.question}</p>
            <c:forEach items="${clientAnswer}" var="a">  
                <c:if test="${q.questionID == a.id}">
                     
                <c:if test="${q.correct eq 'A'}">
                    <c:if test="${a.answer eq 'A'}">
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option1}</p>
                        <p>${q.option2}</p>
                        <p>${q.option3}</p>
                    </c:if>
                    <c:if test="${a.answer eq 'B'}">
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option1}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/incorrect.jpg">${q.option2}</p>
                        <p>${q.option3}</p>
                    </c:if>
                    <c:if test="${a.answer eq 'C'}">
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option1}</p>
                        <p>${q.option2}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/incorrect.jpg">${q.option3}</p>
                    </c:if>
                </c:if>


                <c:if test="${q.correct eq 'B'}">
                    <c:if test="${a.answer eq 'A'}">
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/incorrect.jpg">${q.option1}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option2}</p>
                        <p>${q.option3}</p>
                    </c:if>
                    <c:if test="${a.answer eq 'B'}">
                        <p>${q.option1}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option2}</p>
                        <p>${q.option3}</p>
                    </c:if>
                    <c:if test="${a.answer eq 'C'}">
                        <p>${q.option1}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option2}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/incorrect.jpg">${q.option3}</p>
                        </c:if>
                </c:if>


                <c:if test="${q.correct eq 'C'}">
                    <c:if test="${a.answer eq 'A'}">
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/incorrect.jpg">${q.option1}</p>
                        <p>${q.option2}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option3}</p>
                    </c:if>
                    <c:if test="${a.answer eq 'B'}">
                        <p>${q.option1}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/incorrect.jpg">${q.option2}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option3}</p>
                    </c:if>
                    <c:if test="${a.answer eq 'C'}">
                        <p>${q.option1}</p>
                        <p>${q.option2}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/correct.jpg">${q.option3}</p>
                    </c:if>
                </c:if>
                        

                <c:if test="${a.answer eq null}">
                    <c:if test="${q.correct eq 'A'}">
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/images.png">${q.option1}</p>
                        <p>${q.option2}</p>
                        <p>${q.option3}</p>
                    </c:if>
                    <c:if test="${q.correct eq 'B'}">
                        <p>${q.option1}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/images.png">${q.option2}</p>
                        <p>${q.option3}</p>
                    </c:if>
                    <c:if test="${q.correct eq 'C'}">
                        <p>${q.option1}</p>
                        <p>${q.option2}</p>
                        <p><img height="20px" width="20px" alt="" src="../doTest/images/images.png">${q.option3}</p>
                    </c:if>
                </c:if>
            </c:if>
            </c:forEach>
        </c:forEach> 
    </body>
</html>
