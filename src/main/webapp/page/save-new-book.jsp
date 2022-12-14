<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Page for save a new book</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<jsp:include page="headers/header-for-admin.jsp"/>

<div class="container mt-2">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-6">
            <form action="${pageContext.request.contextPath}/admin/save_new_book" method="post">
                <div class="mb-2">
                    <input class="form-control mr-sm-2" type="text" name="author"
                           placeholder="Input an author"
                           aria-label="Author">
                </div>
                <div class="mb-2">
                    <input class="form-control mr-sm-2" type="text" name="title"
                           placeholder="Input title"
                           aria-label="Title">
                </div>
                <div class="mb-2">
                    <input class="form-control mr-sm-2" type="number" name="year"
                           placeholder="Input year of publishing"
                           aria-label="Year">
                </div>
                <div class="buttons">
                    <button type="submit" class="btn btn-outline-primary"
                            style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: 15px;"
                            value="Enter">Save
                    </button>
                    <button type="reset" class="btn btn-outline-secondary"
                            style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: 15px;"
                            value="Reset">Reset
                    </button>
                    <H4 style="color: red">
                        ${error}
                    </H4>
                </div>
            </form>
        </div>
        <div class="col-3">
        </div>
    </div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
