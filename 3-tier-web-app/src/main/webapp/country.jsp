<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h2>Country Management</h2>
            </div>
            <div class="row">
                <form action="countryController" method="POST">
                    <div class="form-group">
                        <label for="inputName">Country name</label>
                        <input class="form-control" type="input" id="inputName" name="inputName" placeholder="E.g. Brazil" maxlength="30"/>
                    </div>
                    <div class="form-group">
                        <label for="inputAcronym">Acronym</label>
                        <input class="form-control" type="input" id="inputAcronym" name="inputAcronym" placeholder="E.g. BR" maxlength="5"/>
                    </div>
                    <div class="form-group">
                        <label for="inputDigits">Digits</label>
                        <input class="form-control" type="number" id="inputDigits" name="inputDigits" min="2" max="16"/>
                    </div>
                    <input type="submit" value="Create" class="btn btn-primary"/>
                </form>
            </div>
            <div class="row"></div>
            <div class="row">
                <table class="table table-striped table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Acronym</th>
                            <th>Digits</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "country" items="${sessionScope.countryList}">
                            <tr>
                                <td>${country.id}</td>
                                <td>${country.name}</td>
                                <td>${country.acronym}</td>
                                <td>${country.digits}</td>
                            </tr>                            
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
