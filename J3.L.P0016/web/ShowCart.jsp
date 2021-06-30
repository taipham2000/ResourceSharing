<%-- 
    Document   : index
    Created on : Jun 9, 2021, 3:39:12 PM
    Author     : phamv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TaiPham Company | Minimalist Free HTML Portfolio by WowThemes.net</title>
        <link rel='stylesheet' href='css/woocommerce-layout.css' type='text/css' media='all'/>
        <link rel='stylesheet' href='css/woocommerce-smallscreen.css' type='text/css' media='only screen and (max-width: 768px)'/>
        <link rel='stylesheet' href='css/woocommerce.css' type='text/css' media='all'/>
        <link rel='stylesheet' href='css/font-awesome.min.css' type='text/css' media='all'/>
        <link rel='stylesheet' href='style.css' type='text/css' media='all'/>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>
        <link rel='stylesheet' href='css/easy-responsive-shortcodes.css' type='text/css' media='all'/>
    </head>
    <body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">
        <div id="page">
            <div class="container">
                <header id="masthead" class="site-header">
                    <div class="site-branding">
                        <c:if test="${sessionScope.user!=null}">
                            <h1 class="site-title"><a href="#" rel="home">Welcome ${sessionScope.user.userName}</a></h1>
                        </c:if>
                        <c:if test="${sessionScope.user==null}">
                            <h1 class="site-title"><a href="#" rel="home">TaiPham Company</a></h1>
                        </c:if>
                    </div>
                    <nav id="site-navigation" class="main-navigation">
                        <button class="menu-toggle">Menu</button>
                        <a class="skip-link screen-reader-text" href="#content">Skip to content</a>
                        <div class="menu-menu-1-container">
                            <ul id="menu-menu-1" class="menu">
                                <li><a href="MainController">Home</a></li>
                                    <c:if test="${sessionScope.user == null}">
                                    <li><a href="MainController?action=Login">Login</a></li>
                                    <li><a href="MainController?action=SignUp">Sign Up</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user != null}">
                                    <li><a href="MainController?action=History">View History</a></li>
                                    <li><a href="MainController?action=Logout">Logout</a></li>
                                    </c:if>

                            </ul>
                        </div>
                    </nav>
                </header>
                <!-- #masthead -->
                <div id="content" class="site-content">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Search Products</h2>
                        <form action="MainController" method="post">
                            <input type="text" name="search" placeholder="Search products...">
                            <input type="submit" name="action" value="search">
                        </form>

                    </div>
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main">

                            <form action="BookingController" method="post">

                                <table>
                                    <h1 style="color:green">${requestScope.SUCCESS}</h1>
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>Image</th>
                                            <th>Name Product</th>
                                            <th>Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.cart}" var="cart">
                                            <tr>
                                                <td><a href="CartController?action=remove&productID=${cart.sanpham.productID}" onclick="return confirm('Are you sure product?')">x</a></td>
                                                <td><img src="images/${cart.sanpham.imageUrl}" width="100"></td>
                                                <td>${cart.sanpham.productName}</td>
                                                <td>${cart.quantities}</td>
                                            </tr>
                                        </c:forEach>
                                    <td>Date Borrow : </td>
                                    <td>
                                     
                                        <select name="year" id="">
                                            <option > Year</option>
                                            <%for (int i = 1990; i <= 2021; i++) {
                                            %>

                                            <option value="<%=i%>"><%=i%></option>

                                            <%
                                                }
                                            %>
                                        </select>
                                     
                                        <select name="month" id="">
                                            <option > Month</option>
                                            <%for (int i = 1; i <= 12; i++) {
                                            %>

                                            <option value="<%=i%>"><%=i%></option>

                                            <%
                                                }
                                            %>
                                        </select>
                                        
                                        <select name="day" id="">
                                            <option > Day</option>
                                            <%for (int i = 1; i <= 31; i++) {
                                            %>

                                            <option value="<%=i%>"><%=i%></option>

                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                    <td><input type="submit" name="action" value="Borrow"></td>
                                    </tbody>
                                </table>
                            </form>

                            <!-- .grid -->

                            <nav class="pagination">
                                <span class="page-numbers current">1</span>
                                <a class="page-numbers" href="#">2</a>
                                <a class="next page-numbers" href="#">Next »</a>
                            </nav>
                            <br/>

                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                </div>
                <!-- #content -->
            </div>
            <!-- .container -->
            <footer id="colophon" class="site-footer">
                <div class="container">
                    <div class="site-info">
                        <h1 style="font-family: 'Herr Von Muellerhoff';color: #ccc;font-weight:300;text-align: center;margin-bottom:0;margin-top:0;line-height:1.4;font-size: 46px;">TaiPham</h1>
                        <a target="blank" href="https://www.wowthemes.net/">&copy; TaiPham - 252b Linh Trung, Thu Duc District</a>
                    </div>
                </div>	
            </footer>
            <a href="#top" class="smoothup" title="Back to top"><span class="genericon genericon-collapse"></span></a>
        </div>
        <!-- #page -->
        <script src='js/jquery.js'></script>
        <script src='js/plugins.js'></script>
        <script src='js/scripts.js'></script>
        <script src='js/masonry.pkgd.min.js'></script>
    </body>
</html>
