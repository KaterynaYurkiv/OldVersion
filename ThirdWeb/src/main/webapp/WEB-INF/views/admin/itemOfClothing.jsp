<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/brand">Brand</a></li>
					<li><a href="/admin/toc">Type of clothing</a></li>
					<li><a href="/admin/targeta">Target audience</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/size">Size</a></li>
					<li class="active"><a href="/admin/ioc">Item of clothing</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/customer">Customer</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-2 col-xs-12"></div>
	<div class="col-md-8 col-xs-12">
		<div class="row">
			<div class="col-md-2 col-xs-2"><h4>Item name</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Marking</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Price</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Quantity</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Brand</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Target audience</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Type</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Colors</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Sizes</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Update</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Delete</h4></div>
		</div>
<!-- 		спеціальний тег для роботи з всім що можна прогорнути а точніше з тим що імплементує Iterator<T> -->
<!-- 		items -- це посилання на колекцію, ім'я потрібно  вказувати те яке ви передали в метод addAttribute першим параметром (в BrandController.java)-->
<!-- 		var -- це назва одного елемента колекції доступна лише в середині парного тегу c:forEach -->
			<c:forEach items="${itemsOfClothing}" var="itemOfClothing">
				<div class="row">
<!-- 					тут все так само як на сервлетах -->
					<div class="col-md-2 col-xs-2">${itemOfClothing.name}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.marking}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.price}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.quantity}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.brand.brandName}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.targetAudience.category}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.typeOfClothing.itemType}</div>
					<div class="col-md-1 col-xs-1">
					      <c:forEach items="${itemOfClothing.colors}" var="color">
					               ${color.color}
					      </c:forEach>
                    </div>
                    <div class="col-md-1 col-xs-1">
					      <c:forEach items="${itemOfClothing.sizes}" var="size">
					               ${size.size}
					      </c:forEach>
                    </div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/ioc/update/${itemOfClothing.id}">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/ioc/delete/${itemOfClothing.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>