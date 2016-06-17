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
                    <th>Vehicle Make</th>
                    <th>Vehicle Models</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicleMake" items="${vehicleMakes}">
                    <tr>
                        <td>${vehicleMake.id}</td>
                        <td>${vehicleMake.vehicleMakeName}</td>
                        <td>${vehicleMake.vehicleModels}</td>
                        <td><a href="/admin/vehiclemake/edit/${vehicleMake.id}">Edit</a></td>
                        <td><a href="/admin/vehiclemake/delete/${vehicleMake.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>
