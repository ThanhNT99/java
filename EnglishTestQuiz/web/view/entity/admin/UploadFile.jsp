<%-- 
    Document   : HomeImportExcel
    Created on : Jul 20, 2019, 4:13:17 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colrolib Templates">
        <meta name="author" content="Colrolib">
        <meta name="keywords" content="Colrolib Templates">

        <!-- Title Page-->
        <title>Upload Test</title>


        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">



        <!-- Main CSS-->
        <link href="../colorlib-search-16/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="page-wrapper bg-img-1 p-t-165 p-b-100">
            <div class="wrapper wrapper--w680">
                <div class="card card-1">
                    <div class="card-body">
                        <ul class="tab-list">
                            <li class="tab-list__item active">
                                <a class="tab-list__link" href="#tab1" data-toggle="tab">Test information</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab1">
                                <form method="POST" enctype="multipart/form-data"  action="uploadFile">
                                    <div class="input-group">
                                        <label class="label">Questions file to upload:</label>
                                        <input class="input--style-1" type="file" name="upfile"><br/>
                                    </div>
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Test ID:</label>
                                                <input class="input--stylejava-1" type="number" name="testid" placeholder="Test ID">
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Test name:</label>
                                                <input class="input--style-1" type="text" name="name" placeholder="Test name">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group">
                                        <label class="label">User created test:</label>
                                        <input class="input--style-1" type="text" name="usercreated" placeholder="User created test">
                                    </div>

                                    ${msg}
                                    <c:forEach items="${arr}" var="list">
                                        <c:out value="${list}"/>              
                                    </c:forEach>
                                    <button class="btn-submit" type="submit">Press to submit this test</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
