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
        <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
        
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
                                    <c:choose>
                                        <c:when test="${sessionScope.user.roleID eq 1}">
                                        <li><a href="MainController?action=ViewRequest">View Order</a></li>
                                        </c:when>

                                    <c:otherwise>
                                        <li><a href="ShowCart.jsp">Cart</a></li>
                                        
                                        </c:otherwise>
                                    </c:choose>
                                    <c:if test="${sessionScope.user == null}">
                                    <li><a href="MainController?action=Login">Login</a></li>
                                    <li><a href="MainController?action=SignUp">Sign Up</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user != null}">
                                    <li><a href="MainController?action=Logout">Logout</a></li>
                                    </c:if>
                                <li><a href="#">Category</a>
                                    <ul class="sub-menu">
                                        <c:forEach items="${requestScope.ListCategory}" var="listC">

                                            <li><option value="${listC.categoryID}"  selected>${listC.categoryName}</option></li>

                                </c:forEach>
                            </ul>
                            <%--ul class="sub-menu">
                                <li><a href="portfolio-item.html">Portfolio Item</a></li>
                                
                            </ul--%>
                            </li>
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
                            <div class="grid portfoliogrid">

                                <c:forEach items="${requestScope.ListProduct}" var="listP">
                                    <article class="hentry">

                                        <header class="entry-header">
                                            <div class="entry-thumbnail">
                                                <a href="portfolio-item.html"><img src="images/${listP.imageUrl}" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="p1"/></a>
                                            </div>
                                            <h2 class="entry-title"><a href="#" rel="bookmark">${listP.productName}</a></h2>
                                            <a class='portfoliotype' href='#'>${listP.quantity} pieces</a>
                                            <a class='portfoliotype' href='#'>${listP.description}</a>
                                            <c:choose>
                                                <c:when test="${sessionScope.user.roleID eq 1}">
                                                  
                                                </c:when>
                                                <c:otherwise>
                                                    <a class='portfoliotype' href='CartController?action=buy&productID=${listP.productID}'>Borrow</a>
                                                </c:otherwise>
                                            </c:choose>

                                        </header>

                                    </article>
                                </c:forEach>

                            </div>

                            <!-- .grid -->
                            
                            <nav class="pagination">
                                <c:forEach begin="1" end="${endP}" var="i">
                                    <a class="page-numbers" href="ProductController?index=${i}">${i}</a>
                                </c:forEach>
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
                        <h1 style="font-family: 'Herr Von Muellerhoff';color: #ccc;font-weight:300;text-align: center;margin-bottom:0;margin-top:0;line-height:1.4;font-size: 46px;">Tai Pham</h1>
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
