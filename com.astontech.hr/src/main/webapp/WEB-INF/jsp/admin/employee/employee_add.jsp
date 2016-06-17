<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(function () {
//        $("#successAlert").delay(7000).fadeOut(2000);
        $("#warningAlert").delay(7000).fadeOut(2000);
    });
</script>

<%--SIDEBAR HERE--%>

<div class="wrapper">
    <%@include file="employee_sidebar.jsp" %>
    <div id = "main-wrapper" class="col-sm-9">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="employeeVo" action="/admin/employee/add" method="post">
                <%--<form:hidden path="personId" />--%>
                <%--<form:hidden path="personVersion" />--%>
                <%--<form:hidden path="personCreateDate" />--%>
                <%--<form:hidden path="employeeId" />--%>
                <%--<form:hidden path="employeeVersion" />--%>
                <%--<form:hidden path="employeeCreateDate" />--%>
                <legend>Add Employee</legend>

                <%--private Integer employeeId;--%>
                <%--private Integer personId;--%>
                <%--private Integer employeeVersion;--%>
                <%--private Integer personVersion;--%>
                <%--private Date employeeCreateDate;--%>
                <%--private Date personCreateDate;--%>
                    <%--private Date hireDate;--%>
                    <%--private Date termDate;--%>
                <%--private String title;--%>
                <%--private String firstName;--%>
                <%--private String middleName;--%>
                <%--private String lastName;--%>
                <%--private String displayFirstName;--%>
                    <%--private Character gender;--%>
                    <%--private Date birthDate;--%>
                    <%--private String ssn;--%>
                <%--private String fullName;--%>
                <div class="form-group">
                    <label for="inputTitle" class="col-lg-3 control-label">Title</label>
                    <div class="col-lg-9">
                        <form:input path="title" type="text" class="form-control" id="inputTitle" placeholder="Title"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputFirstName" class="col-lg-3 control-label">First Name</label>
                    <div class="col-lg-9">
                        <form:input path="firstName" type="text" class="form-control" id="inputFirstName" placeholder="First"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputMiddleName" class="col-lg-3 control-label">Middle Name</label>
                    <div class="col-lg-9">
                        <form:input path="middleName" type="text" class="form-control" id="inputMiddleName" placeholder="Middle"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputLastName" class="col-lg-3 control-label">Last Name</label>
                    <div class="col-lg-9">
                        <form:input path="lastName" type="text" class="form-control" id="inputLastName" placeholder="Last"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDisplayFirstName" class="col-lg-3 control-label">Display First Name</label>
                    <div class="col-lg-9">
                        <form:input path="displayFirstName" type="text" class="form-control" id="inputDisplayFirstName" placeholder="leave blank if none"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGender" class="col-lg-3 control-label">Gender</label>
                    <div class="col-lg-9">
                        <form:select path="gender" cssClass="form-control" id="inputGender">
                            <form:option value=" ">(Select one)</form:option>
                            <form:option value="M">Male</form:option>
                            <form:option value="F">Female</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputBirthDate" class="col-lg-3 control-label">Birth Date</label>
                    <div class="col-lg-9">
                        <form:input path="birthDate" type="date" class="form-control" id="inputBirthDate"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputSsn" class="col-lg-3 control-label">SSN</label>
                    <div class="col-lg-9">
                        <form:input path="ssn" type="text" class="form-control" id="inputSsn" placeholder="SSN"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputHireDate" class="col-lg-3 control-label">Hire Date</label>
                    <div class="col-lg-9">
                        <form:input path="hireDate" type="date" class="form-control" id="inputHireDate"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputTermDate" class="col-lg-3 control-label">Term Date</label>
                    <div class="col-lg-9">
                        <form:input path="termDate" type="date" class="form-control" id="inputTermDate"></form:input>
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
                    <strong>Employee added successfully to the database!</strong>.
                </div>
            </div>
            <div class="${warningAlert==null?'hidden':'warningAlert'}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>Some fields required...</p>
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
