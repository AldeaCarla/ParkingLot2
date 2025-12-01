<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <div class="container mt-4">
    <h1 class="mb-4">Cars</h1>

    <a class="btn btn-primary btn-lg"
       href="${pageContext.request.contextPath}/AddCar">
        Add Car
    </a>

    <div class="cpntainer text-center">
        <c:forEach var="car" items="${cars}">
            <div class="row">
                <div class="col">
                    ${car.licensPlate}
                </div>
                <div class="col">
                    ${car.paringSpot}
                </div>
                <div class="col">
                    ${car.ownerName}
                </div>
            </div>
        </c:forEach>
    </div>
    <h5>Free parking spots:${numbreOfFreeParkingSpots}</h5>
</t:pageTemplate>
