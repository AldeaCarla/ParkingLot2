<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Add Car">

    <div class="container mt-4">
        <h1>Add Car</h1>

        <form class="needs-validation" novalidate
              method="POST"
              action="${pageContext.request.contextPath}/AddCar">

            <!-- License plate -->
            <div class="mb-3">
                <label for="license_plate" class="form-label">License plate</label>
                <input type="text" class="form-control"
                       id="license_plate" name="license_plate" required>
                <div class="invalid-feedback">
                    Please enter a license plate.
                </div>
            </div>

            <!-- Parking spot -->
            <div class="mb-3">
                <label for="parking_spot" class="form-label">Parking spot</label>
                <input type="text" class="form-control"
                       id="parking_spot" name="parking_spot" required>
                <div class="invalid-feedback">
                    Please enter a parking spot.
                </div>
            </div>

            <!-- Owner -->
            <div class="mb-3">
                <label for="owner_id" class="form-label">Owner</label>
                <select class="form-select" id="owner_id" name="owner_id" required>
                    <option value="">Choose...</option>

                    <%
                        java.util.List<com.parking.parkinglot.common.UsersDto> users =
                                (java.util.List<com.parking.parkinglot.common.UsersDto>) request.getAttribute("users");

                        if (users != null) {
                            for (com.parking.parkinglot.common.UsersDto u : users) {
                    %>
                    <option value="<%= u.getId() %>">
                        <%= u.getUsername() %> - <%= u.getEmail() %>
                    </option>
                    <%      }
                    }
                    %>

                </select>
                <div class="invalid-feedback">
                    Please select an owner.
                </div>
            </div>

            <button class="btn btn-primary btn-lg" type="submit">Save</button>
        </form>
    </div>

</t:pageTemplate>
