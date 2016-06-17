<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<%--SIDEBAR HERE--%>

<script>
    $(function() {
        // attach an onclick event handler to the remove buttons
        $("button.remove-button").click(function () {
            // log name button, and contents of associated text box
            console.log(this.name);

            var inputToClear = $('#' + this.name);
            console.log(inputToClear.val());

            // clear the value/contents of the textbox
            inputToClear.val('');

            // submit the form
            $('#vehicleMakeEditVo').submit();
        });
    });
</script>

<div class="wrapper">
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id = "main-wrapper" class="col-sm-9">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page" />
            <form:form cssClass="form-horizontal" modelAttribute="vehicleMakeEditVo" action="/admin/vehiclemake/update" method="post">
                <form:hidden path="personid               <form:hidden path="version" />

                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="inputVehicleMakeName"></label>
                        <div class="col-sm-8">
                            <form:input path="vehicleMakeName" id="inidleMakeName" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr />
                    </div>
                </div>

                <c:forEach items="${vehicleMakeEditVo.vehicleModels}" var="vehicleModel">
                    <form:hidden path="vehicleModels[${idx}].id" />
     id       <form:hidden path="vehicleModels[${idx}].version" />
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="${idx}">Vehicle Model</label>
                            <div class="col-sm-7">
                                <div class="input-group">
                                    <form:input path="vehicleModels[${idx}].vehicleModelName" id="${idx}" cssClass="form-control" />
                                    <span class="input-group-btn">
                                        <button name="${idx}" class="btn btn-default remove-button" type="button">Remove</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="idx" value="${idx+1}" scope="page" />
                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="inputNewVehicleModel">Add New Vehicle Model</label>
                        <div class="col-sm-7">

                            <input type="text" class="form-control" id="inputNewVehicleModel" name="inputNewVehicleModel" />

                        </div>
                    </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>

            </form:form>

        </div>
        <div class="col-sm-4">

            <%--ALERTS--%>
            <div class="${successAlert==null?'hidden':'successAlert'}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Edit successful!</strong>
                </div>
            </div>
            <div class="${warningAlert==null?'hidden':'warningAlert'}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Warning!</h4>
                    <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
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
