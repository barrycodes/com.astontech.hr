<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<script>
    $(function () {
        $("#successAlert").delay(7000).fadeOut(2000);
        $("#warningAlert").delay(7000).fadeOut(2000);
    });
</script>

<%--SIDEBAR HERE--%>

<div class="wrapper">
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id = "main-wrapper" class="col-sm-9">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVo" action="/admin/vehicle/add" method="post">
                <legend>New Vehicle</legend>
                <div class="form-group">
                    <label for="inputYear" class="col-lg-3 control-label">Year</label>
                    <div class="col-lg-9">
                        <form:input path="year" type="number" class="form-control" id="inputYear" placeholder="Year"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputLicensePlate" class="col-lg-3 control-label">License Plate</label>
                    <div class="col-lg-9">
                        <form:input path="licensePlate" type="text" class="form-control" id="inputLicensePlate" placeholder="License Plate"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputVin" class="col-lg-3 control-label">VIN</label>
                    <div class="col-lg-9">
                        <form:input path="vin" type="text" class="form-control" id="inputVin" placeholder="VIN"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputColor" class="col-lg-3 control-label">Color</label>
                    <div class="col-lg-9">
                        <form:input path="color" type="text" class="form-control" id="inputColor" placeholder="Color"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputIsPurchase" class="col-lg-3 control-label">Is Purchase?</label>
                    <div class="col-lg-9">
                        <form:select path="isPurchase" cssClass="form-control" id="inputIsPurchase">
                            <form:option value="0">No</form:option>
                            <form:option value="1">Yes</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPurchasePrice" class="col-lg-3 control-label">Color</label>
                    <div class="col-lg-9">
                        <form:input path="purchasePrice" type="number" class="form-control" id="inputPurchasePrice" placeholder="Price"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPurchaseDate" class="col-lg-3 control-label">Purchase Date</label>
                    <div class="col-lg-9">
                        <form:input path="purchaseDate" type="date" class="form-control" id="inputPurchaseDate"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputVehicleModel" class="col-lg-3 control-label">Vehicle Model</label>
                    <div class="col-lg-9">
                        <select class="form-control" id="inputVehicleModel" name="vehicleModel">
                            <option name="vehicleModel" value="0">--Select Model--</option>
                            <c:forEach var="vehicleModel" items="${vehicleModels}">
                                <option name="vehicleModel" value="${vehicleModel.id}">
                                    ${vehicleModel.vehicleMake.vehicleMakeName} ${vehicleModel.vehicleModelName}
                                </option>
                            </c:forEach>
                        </select>
                        <%--<form:select path="vehicleModel" class="form-control" id="inputVehicleModel" name="vehicleModel">--%>
                            <%--<form:option value="0" name="vehicleModel">--Select Model--</form:option>--%>
                        <%--</form:select>--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-9 col-lg-offset-3">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                    </div>
                </div>
            </form:form>
        </div>
        <div class="col-sm-4">
            <%--ALERTS--%>
            <div class="${successAlert==null?'hidden':'successAlert'}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Vehicle added successfully to the database!</strong>.
                </div>
            </div>
            <div class="${warningAlert==null?'hidden':'warningAlert'}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>Model field required. Please choose a Vehicle Model.</p>
                </div>
            </div>
            <div class="${errorAlert==null?'hidden':'errorAlert'}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>
