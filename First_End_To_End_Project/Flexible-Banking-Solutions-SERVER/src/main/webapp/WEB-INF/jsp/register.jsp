<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/default.css">
    <script src="https://kit.fontawesome.com/44dbd555de.js" crossorigin="anonymous"></script>
    <title>Register</title>
</head>
    <body class="d-flex align-items-center justify-content-center">
        <!-- Card: Registration Form Card -->
            <div class="card registration-form-card col-6 bg-transparent border-0">
                <!-- Card Body -->
                <div class="card-body">
                    <!-- Form Header -->
                        <h1 class="form-header card-title mb-3">
                            <img class="main-image" src="images\Register\RegisterButtonImage.png"></i> Register
                        </h1>
                    <!-- End of Form Header -->

                    <!-- Display Message -->
                    <c:if test="${requestScope.passwordMissMatch != null}">
                        <div class ="alert alert-danger text-center border border-danger">
                            <b>${requestScope.passwordMissMatch}</b>
                        </div>
                    </c:if>
                    <!-- End Of Display Message -->

                    <!-- Display Message -->
                        <c:if test="${requestScope.success != null}">
                            <div class ="alert alert-success text-center border border-success">
                                <b>${requestScope.success}</b>
                            </div>
                        </c:if>
                    <!-- End Of Display Message -->

                    <!-- Registration Form -->
                        <form:form action="/register" class="reg-form" modelAttribute="registerUser">
                            <!-- Row -->
                                <div class="row">
                                    <!--From Group-->
                                    <div class="form-group col">
                                        <form:input type="text" path = "first_name" class="form-control form-control-lg" placeholder="Enter First Name"/>
                                        <form:errors path="first_name" class="text-white bg-danger"/>
                                    </div>
                                    <!--End of From Group-->

                                    <!--From Group-->
                                    <div class="form-group col">
                                        <form:input type="text" path = "last_name" class="form-control form-control-lg" placeholder="Enter Last Name"/>
                                        <form:errors path="last_name" class="text-white bg-danger"/>
                                    </div>
                                    <!--End of From Group-->
                                </div>
                            <!-- End of Row -->

                            <!--From Group-->
                            <div class="form-group col">
                                <form:input type="text" path = "email" class="form-control form-control-lg" placeholder="Enter Email"/>
                                <form:errors path="email" class="text-white bg-danger"/>
                            </div>
                            <!--End of From Group-->

                            <!-- Row -->
                            <div class="row">
                                <!--From Group-->
                                <div class="form-group col">
                                    <form:input type="password" path = "password" class="form-control form-control-lg" placeholder="Enter Password"/>
                                    <form:errors path="password" class="text-white bg-danger"/>
                                </div>
                                <!--End of From Group-->

                                <!--From Group-->
                                <div class="form-group col">
                                    <input type="password" name = "confirm_password" class="form-control form-control-lg" placeholder="Confirm Password"/>
                                    <small class="text-white bg-danger">${confirm_pass}</small>
                                </div>
                                <!--End of From Group-->
                            </div>
                        <!-- End of Row -->

                        <!--From Group-->
                        <div class="form-group col">
                            <button class="btn btn-lg">Register</button>
                        </div>
                        <!--End of From Group-->

                        </form:form>
                    <!-- End of Registration Form -->

                    <!-- Card Text -->
                    <p class="card-text text-white mt-2">
                        Already have an account? <span class="ms-2 text-warning"><a href="/login" class="btn btn-sm text-warning">Sing up</a></span>
                    </p>
                    <!-- Card Text -->

                    <!-- Back Button To Landing Page-->
                        <small class="text-warning">
                            <i class="fa fa-arrow-alt-circle-left"></i> <a href="/" class="btn btn-sm text-warning">Back</a>
                        </small>
                    <!-- End Of Back Button To Landing Page-->
                </div>
                <!-- End of Card Body -->
            </div>
        <!-- Card: Registration Form Card -->
    </body>
</html>