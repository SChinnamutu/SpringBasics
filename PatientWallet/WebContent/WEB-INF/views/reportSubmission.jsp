<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="comman_header.jsp" %>
<head>
		<title>Save Report Status</title>
</head>
<body>
<div id="global">
        <h5>Details:</h5>
        Product Name: ${iReport.name}<br/>
        <%-- Description: ${iReport.description}<br/> --%>
        <p>${iReport.status}</p>
       <%--  <ol>
        <c:forEach items="${product.images}" var="image">
            <li>${image.originalFilename}
            <img width="100" src="<c:url value="/image/"/>${image.originalFilename}"/>
            </li>
        </c:forEach>
        </ol> --%>
</div>
</body>
</html>