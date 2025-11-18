<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">

    <div class="container mt-4">

        <h1 class="mb-4">Users</h1>

        <c:choose>
            <c:when test="${not empty users}">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Username</th>
                            <th>Email</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="u" items="${users}" varStatus="st">
                            <tr>
                                <td>${st.index + 1}</td>
                                <td>${u.username}</td>
                                <td>${u.email}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>

            <c:otherwise>
                <div class="alert alert-info">
                    There are no users to display.
                </div>
            </c:otherwise>

        </c:choose>

    </div>

</t:pageTemplate>
