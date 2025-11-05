<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Cars">
    <div class="container mt-4">
        <h1 class="mb-4">Cars Overview</h1>

        <h5 class="text-muted">Free parking spots: ${numberOfFreeParkingSpots}</h5>

        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">License Plate: B-123-XYZ</h5>
                        <p class="card-text">Spot: 12</p>
                        <p class="card-text"><small>Owner: John Doe</small></p>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">License Plate: AG-456-TTT</h5>
                        <p class="card-text">Spot: 7</p>
                        <p class="card-text"><small>Owner: Maria Popescu</small></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>
