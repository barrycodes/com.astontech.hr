<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<%--SIDEBAR HERE--%>

<div class="wrapper">
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id = "main-wrapper" class="col-sm-9">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover ">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>VIN</th>
                    <th>Color</th>
                    <th>Is Purchase</th>
                    <th>Purchase Price</th>
                    <th>Purchase Date</th>
                    <th>Model</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicles}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.year}</td>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.vin}</td>
                        <td>${vehicle.color}</td>
                        <td>${vehicle.isPurchase ? "Yes" : "No"}</td>
                        <td>${vehicle.purchasePrice==null?"":"$"}<fmt:formatNumber type="number" minFractionDigits="2" value="${vehicle.purchasePrice}" /></td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vehicle.purchaseDate}" /></td>
                        <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName} ${vehicle.vehicleModel.vehicleModelName}</td>
                        <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                        <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>
