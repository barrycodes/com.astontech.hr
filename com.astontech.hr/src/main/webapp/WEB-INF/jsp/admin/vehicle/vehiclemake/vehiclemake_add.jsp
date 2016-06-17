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
            <form:form cssClass="form-horizontal" modelAttribute="vehicleMakeVo" action="/admin/vehiclemake/add" method="post">
                <legend>New Vehicle Make</legend>
                <div class="form-group">
                    <label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleMake" type="text" class="form-control" id="inputNewVehicleMake" placeholder="Vehicle Make"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewVehicleModels" class="col-lg-2 control-label">Models</label>
                    <div class="col-lg-10">
                        <form:textarea path="newVehicleModels" rows="3" class="form-control" id="inputNewVehicleModels"></form:textarea>
                        <span class="help-block">Enter each new Model on a new line.</span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
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
                    <strong>Vehicle Make added successfully to the database!</strong>.
                </div>
            </div>
            <div class="${warningAlert==null?'hidden':'warningAlert'}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>Vehicle Make field required. Please enter a Vehicle Make and any associated Vehicle Models separated by a new line.</p>
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
