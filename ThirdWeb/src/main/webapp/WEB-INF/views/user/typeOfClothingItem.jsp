<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Type of clothing: ${typeOfClothing.itemType}</h2>
<c:forEach items="${itemsOfClothing}" var="itemOfClothing">
	<div>${itemOfClothing.brand.brandName} ${itemOfClothing.name} costs ${itemOfClothing.price} $</div>
</c:forEach>
<c:if test="${empty itemsOfClothing}">
	<h3>There are no clothes of this type</h3>
</c:if>