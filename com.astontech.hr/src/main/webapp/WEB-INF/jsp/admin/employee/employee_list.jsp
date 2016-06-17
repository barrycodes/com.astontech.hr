<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<%--SIDEBAR HERE--%>

<div class="wrapper">
    <%@include file="employee_sidebar.jsp" %>
    <div id = "main-wrapper" class="col-sm-12 col-lg-10">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover ">
                <thead>
                <tr>
                    <%--private Integer id;--%>
                    <%--private Date hireDate;--%>
                    <%--private Date termDate;--%>
                    <%--private Date createDate;--%>
                    <%--private String title;--%>
                    <%--private String firstName;--%>
                    <%--private String middleName;--%>
                    <%--private String lastName;--%>
                    <%--private String displayFirstName;--%>
                    <%--private Character gender;--%>
                    <%--private Date birthDate;--%>
                    <%--private String ssn;--%>

                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>SSN</th>
                    <th>Birth Date</th>
                    <th>Hire Date</th>
                    <th>Term Date</th>
                    <th>Created</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.fullName}</td>
                        <td>${employee.gender}</td>
                        <td>${employee.ssn}</td>
                        <%--<td><fmt:formatDate pattern="yyyy-MM-dd" value="${employee.birthDate}" /></td>--%>
                        <%--<td><fmt:formatDate pattern="yyyy-MM-dd" value="${employee.hireDate}" /></td>--%>
                        <%--<td><fmt:formatDate pattern="yyyy-MM-dd" value="${employee.termDate}" /></td>--%>
                        <%--<td><fmt:formatDate pattern="yyyy-MM-dd" value="${employee.employeeCreateDate}" /></td>--%>
                        <td>${employee.birthDate}</td>
                        <td>${employee.hireDate}</td>
                        <td>${employee.termDate}</td>
                        <td>${employee.employeeCreateDate}</td>
                        <td><a href="/admin/employee/edit/${employee.employeeId}">Edit</a></td>
                        <td><a href="/admin/employee/delete/${employee.employeeId}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>
