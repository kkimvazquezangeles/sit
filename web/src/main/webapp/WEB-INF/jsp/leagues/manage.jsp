<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head> 
    <jsp:include page="../_header.jsp" />
</head>
<body>

<jsp:include page="../_menu.jsp" />

<div class="container">

</div>

<jsp:include page="../_footer.jsp" />

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://builds.handlebarsjs.com.s3.amazonaws.com/handlebars-v1.3.0.js"></script>
<script src="http://builds.emberjs.com/tags/v1.8.1/ember.js"></script>
<script src="http://builds.emberjs.com/tags/v1.0.0-beta.11/ember-data.js"></script>


      <!-- ... Ember.js and other javascript dependencies ... -->
<script src="${pageContext.request.contextPath}/static/application.js"></script>
<script src="${pageContext.request.contextPath}/static/router.js"></script>

<!-- ... additional lines truncated for brevity ... -->
<script src="${pageContext.request.contextPath}/static/models/league.js"></script>
<script src="${pageContext.request.contextPath}/static/controllers/leagues_controller.js"></script>
<script src="${pageContext.request.contextPath}/static/controllers/league_controller.js"></script>

<!-- ... additional views ... -->
<script src="${pageContext.request.contextPath}/static/views/league.js"></script>
</body>
</html>