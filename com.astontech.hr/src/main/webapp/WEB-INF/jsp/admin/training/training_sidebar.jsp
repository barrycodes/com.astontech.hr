<div id="sidebar-wrapper" class="col-md-2">
    <div id="sidebar container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <a class="list-group-item" href="/admin/training/curriculum/add">New Curriculum</a>
            </div>
        </div>
        <%--<li><span class="list-group-item" />&nbsp;</li>--%>
        <div class="row">&nbsp;</div>
        <c:choose>
            <c:when test="${curriculums != null}">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <a class="list-group-item" href="/admin/training/list">Curriculums</a>
                    </div>
                </div>
                <c:forEach var="curriculum" items="${curriculums}">
                    <div class="row">
                        <div class="col-md-11 col-md-offset-1 col-sm-12">
                            <a class="list-group-item" href="/admin/training/curriculum/${curriculum.id}">
                                ${curriculum.name}
                            </a>
                        </div>
                    </div>
                    <c:forEach var="section" items="${curriculum.sections}">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-2 col-sm-12">
                                <a class="list-group-item" href="/admin/training/section/${section.id}">
                                    ${section.name}
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>
</div>