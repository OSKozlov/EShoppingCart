<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping Cart items ...</title>
</head>
<body>

	<form action='addToShoppingCart' method='post'>
		<input type='hidden' name='action' value='add'> Name: <input
			type='text' name='item'> <input type='submit' value='Add'>
	</form>

	<p>
		<c:choose>

			<c:when test="${not empty items}">
				<ul>
					<c:forEach items="${items}" var="item">
						<li><a href='removeFromShoppingCart?item=${item}'>${item}</a></li>
					</c:forEach>
				</ul>
			</c:when>

			<c:otherwise>
                No items...
            </c:otherwise>

		</c:choose>
	</p>

</body>
</html>
