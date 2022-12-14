<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Main page</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="headers/header-for-admin.jsp"/>
</sec:authorize>

<sec:authorize access="hasRole('USER')">
    <jsp:include page="headers/header-for-user.jsp"/>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <jsp:include page="headers/header-for-anonymous.jsp"/>
</sec:authorize>

<div class="container">
    <div class="row">
        <c:choose>
            <c:when test="${books.size()>0}">
                <table class="table table-striped">
                    <caption>All books in the library</caption>
                    <thead>
                    <tr>
                        <th scope="col">Line number</th>
                        <th scope="col">Book author</th>
                        <th scope="col">Title of the book</th>
                        <th scope="col">Year of publishing</th>
                        <th scope="col">Count of available books</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="book" varStatus="loop">
                        <tr>
                            <th scope="row"> ${loop.count}</th>
                            <td><a href="${pageContext.request.contextPath}/authors/${book.author}"
                                   class="link-primary">${book.author}</a></td>
                            <td> ${book.title}</td>
                            <td> ${book.year}</td>
                            <td> ${book.count}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${totalPages>1}">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <c:forEach begin="0" end="${totalPages-1}" var="page">
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/?page=${page}">${page+1}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </nav>
                </c:if>
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col"><H4>There aren't any books</H4></th>
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
