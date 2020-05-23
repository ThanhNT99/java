<%@page import="model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Template by Quackit.com -->
<!-- Images by various sources under the Creative Commons CC0 license and/or the Creative Commons Zero license. 
Although you can use them, for a more unique website, replace these images with your own. -->
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Business 2</title>

        <!-- Bootstrap Core CSS -->
        <link href="business-2/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
        <link href="business-2/css/custom.css" rel="stylesheet" type="text/css"/>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Custom Fonts from Google -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    </head>

    <body>

        <!-- Navigation -->
        <nav id="siteNav" class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Logo and responsive toggle -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://localhost:8080/Assignment/homeForward">
                        <span class="glyphicon glyphicon-fire"></span> 
                        Learning English
                    </a>
                </div>
                <!-- Navbar links -->
                <div class="collapse navbar-collapse" id="navbar">
                    <ul class="nav navbar-nav navbar-right">

                        <li class="active">
                            <a href="http://localhost:8080/Assignment/homeForward">Home</a>
                        </li>
                        <li>
                            <a href="#">Tests</a>
                        </li>
                        <li>
                            <a href="#">Contact</a>
                        </li>
                        <% Account a = (Account) request.getSession().getAttribute("currentaccount");
                           if (a==null){
                        %>
                        <li >
                            <a href="http://localhost:8080/Assignment/login">Sign in</a>
                        </li>
                        <li>
                            <a href="http://localhost:8080/Assignment/signup">Sign up</a>
                        </li>
                        <%}else{%>
                        
                        <li >
                            <a href="#">Hello <%=a.getUsername()%></a>
                        </li>
                        <li>
                            <a href="http://localhost:8080/Assignment/logout">Log out</a>
                        </li>
                        
                        <%}%>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Header -->
        <header>
            <div class="header-content">
                <div class="header-content-inner">
                    <h1>Become a English professional!</h1>
                    <p>Future of Education Technology.</p>
                    <a href="#" class="btn btn-primary btn-lg">Engage Now</a>
                </div>
            </div>
        </header>


    <!-- Footer -->
    <footer class="page-footer">

        <!-- Contact Us -->
        <div class="contact">
            <div class="container">
                <h2 class="section-heading">Contact Us</h2>
                <p><span class="glyphicon glyphicon-earphone"></span><br> +1(23) 456 7890</p>
                <p><span class="glyphicon glyphicon-envelope"></span><br> info@example.com</p>
            </div>
        </div>

        <!-- Copyright etc -->
        <div class="small-print">
            <div class="container">
                <p>Copyright &copy; Example.com 2015</p>
            </div>
        </div>

    </footer>

    <!-- jQuery -->
    <script src="js/jquery-1.11.3.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Custom Javascript -->
    <script src="js/custom.js"></script>

</body>

</html>
