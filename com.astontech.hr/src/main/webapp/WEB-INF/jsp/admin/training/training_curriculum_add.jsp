<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(function () {
        $("#successAlert").delay(7000).fadeOut(2000);
        $("#warningAlert").delay(7000).fadeOut(2000);
    });
</script>

<%--SIDEBAR HERE--%>

<div class="wrapper">
    <%@include file="training_sidebar.jsp" %>
    <div id = "main-wrapper" class="col-sm-9">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="curriculum" action="/admin/training/curriculum/add" method="post">
                <legend>New Curriculum</legend>
                <div class="form-group">
                    <label for="inputName" class="col-lg-3 control-label">Curriculum</label>
                    <div class="col-lg-9">
                        <form:input path="name" type="text" class="form-control" id="inputName" placeholder="Name"></form:input>
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
                    <strong>Curriculum added successfully to the database!</strong>.
                </div>
            </div>
            <div class="${warningAlert==null?'hidden':'warningAlert'}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>Name field required. Please enter a Curriculum Name.</p>
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

<%@include file="../../includes/footer.jsp" %>
