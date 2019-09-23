<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">        
    </head>
    <body>        
        <div class="container">
            <h1 class="text-center" style="margin-top: 30px">Welcome To Masimo Vending Machine</h1>
            <hr style="margin-bottom: 30px">
            <div class="col-sm-9">
                <div class="row">
                    <h3 class="text-center">Add Coins</h3> 
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/addCoin/quarter" class="btn btn-primary">Add Quarter</a>
                        <a href="${pageContext.request.contextPath}/addCoin/dime" class="btn btn-primary">Add Dime</a>
                        <a href="${pageContext.request.contextPath}/addCoin/nickel" class="btn btn-primary">Add Nickel</a>
                    </div>
                    <p>
                    <form>
                        <div class="form-group">
                            <input class="form-control" id="balance" type="text" value="Total Ammount: $ ${balance}" disabled>
                        </div>
                    </form>
                    <hr>
                </div>
                </div>
            <!-- Vending Machine Items -->
            <div id="itemColumn" class="col-sm-9">
            <h3 class="text-center">Please Choose Item</h3>

   	<div class="text-center">             
         <c:forEach var="item" items="${items}"> 
 		<div class="col-sm-4">
 		<div class="panel">
          	<div >
            		<h4 class="my-0 font-weight-normal">${item.id}</h4>
          	</div>
          	<div >
            		<h2 >${item.name}</h2>
            		<ul class="list-unstyled mt-3 mb-4">
              		<li>Price : $ ${item.price}</li>
              		<li>Remaining Quantity: ${item.quantity}</li>
              		<li>.</li>
              		<li><a href="${pageContext.request.contextPath}/makeSelection/${item.id}" class="btn btn-primary">Select Item</a></li>
            		</ul>       
            		
          	</div>
		</div>
		</div>
		</c:forEach>
       </div>   
        
        <h3 style="display:inline">Selected Item: <c:if test="${selectedItem != 0}">${selectedItem}</c:if> </h3>
            </div>
            <!-- FORMS -->
            <div class="col-sm-9">

                <div class="row">
                    <h3 class="text-center">Alerts</h3>
                    <form>
                        <div class="form-group">
                            <input value="${alert}" class="form-control" disabled></input>
                        </div>
                        <div class="form-group">
                            
                        </div>
                    </form>
                    <a href="purchaseItem" class="btn btn-primary btn-block">Purchase Selected Item</a>
                    <hr>
                </div>
                <div class="row" style="margin-bottom: 30px">
                    <h3 class="text-center">Returned Coins</h3>
                    <form>
                        <div class="form-group">
                            <textarea id="changeMsg" class="form-control" row="2" disabled><c:if test="${returnedCoins != null}">Quarters: ${returnedCoins.quarters}, Dimes: ${returnedCoins.dimes}, Nickels: ${returnedCoins.nickels} </c:if></textarea>
                        </div>
                    </form>
                    <a class="btn btn-primary btn-block" href="coinsReturn">Return Coins</a>
                </div>
            </div>
        </div>      
        
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/home.js"></script>
        
    </body>
</html>

