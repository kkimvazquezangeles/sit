<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="_header.jsp"/>
  </head>
  <body>

    <jsp:include page="_menu.jsp"/>

    <div class="container">
      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Welcome to your training!</h1>
        <p>You're learning SpringMVC 4 and the ways to configure it, so, you must use you actual acknowledge about Spring.</p>
      </div>
    </div> <!-- /container -->
    
    <div class="container">
        <h2>Exercises</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/leagues">League</a></li>
        </ul>
    </div>

    <jsp:include page="_footer.jsp"/>
    
  </body>
</html>