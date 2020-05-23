<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colrolib Templates">
        <meta name="author" content="Colrolib">
        <meta name="keywords" content="Colrolib Templates">

        <!-- Title Page-->
        <title>Search Questions</title>


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
                                <a class="tab-list__link" href="#tab1" data-toggle="tab">Questions (Leave filter blank if you don't wanna search by it)</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab1">
                                <form method="POST" action="searchQuestion">
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Question ID:</label>
                                                <input class="input--style-1" type="number" name="questionid" placeholder="Question ID">
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Question:</label>
                                                <input class="input--style-1" type="text" name="question" placeholder="Question">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Option 1:</label>
                                                <input class="input--style-1" type="text" name="option1" placeholder="Option 1">
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Option 2:</label>
                                                <input class="input--style-1" type="text" name="option2" placeholder="Option 2">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Option 3:</label>
                                                <input class="input--style-1" type="text" name="option3" placeholder="Option 3">
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Correct answer:</label>
                                                <input class="input--style-1" type="text" name="correct" placeholder="Correct Answer">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="p-t-5">
                                        <label class="checkbox-container m-r-45">Match Case
                                            <input type="checkbox" name="first-class">
                                            <span class="checkmark"></span>
                                        </label>

                                    </div>
                                    <button class="btn-submit" type="submit">search</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/datepicker/moment.min.js"></script>
        <script src="vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="js/global.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->
