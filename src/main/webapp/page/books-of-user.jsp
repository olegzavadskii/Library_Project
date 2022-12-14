<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Books of user</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<jsp:include page="headers/header-for-admin.jsp"/>

<div class="container">
    <div class="row">
        <c:choose>
            <c:when test="${booksOfUser.size()>0}">
                <table class="table table-striped">
                    <caption>${userById.login}'s books</caption>
                    <thead>
                    <tr>
                        <th scope="col">Line number</th>
                        <th scope="col">Book id</th>
                        <th scope="col">Book author</th>
                        <th scope="col">Title of the book</th>
                        <th scope="col">Year of publishing</th>
                        <th scope="col">Date of issue</th>
                        <th scope="col">Return book</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${booksOfUser}" var="book" varStatus="loop">
                        <tr>
                            <th scope="row"> ${loop.count}</th>
                            <td> ${book.id}</td>
                            <td> ${book.author}</td>
                            <td> ${book.title}</td>
                            <td> ${book.year}</td>
                            <td><fmt:formatDate value="${book.dateOfIssue}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <form class="d-flex"
                                      action="${pageContext.request.contextPath}/admin/return_book_from_user"
                                      method="post">
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <input type="hidden" name="userId" value="${userById.id}">
                                    <button type="submit" class="btn btn-info">Return the book
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col"><H4>User doesn't have any books now</H4></th>
                    </tr>
                    </thead>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
