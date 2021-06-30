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
                        <h1 class="site-title"><a href="index.html" rel="home">Welcome ${sessionScope.user.userName}</a></h1>
                    </div>
                    <nav id="site-navigation" class="main-navigation">
                        <button class="menu-toggle">Menu</button>
                        <a class="skip-link screen-reader-text" href="#content">Skip to content</a>
                        <div class="menu-menu-1-container">
                            <ul id="menu-menu-1" class="menu">
                                <li><a href="MainController">Home</a></li>
                              
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

                        </script>
                    </div>
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main">

                            <form action="AcceptRequestController" method="post">
                                
                                <table>
                                    <h1 style="color:green">${requestScope.SUCCESS}<h1>
                                    <thead>
                                        <tr>
                                            <th>User Name</th>
                                            <th>Date</th>
                                            <th>Image</th>
                                            <th>Name Product</th>
                                            <th>Quantity</th>
                                            <th>Accept</th>
                                           
                                        </tr>
                                    </thead>
                                    <c:forEach items="${requestScope.listRequest}" var="listR">
                                    <tbody>
                                        
                                            <tr>
                                                
                                                <td>${listR.userName}</td>
                                                <td>${listR.date}</td>
                                                <td><img src="images/${listR.imageUrl}" width="100"/></td>
                                                <td>${listR.productName}</td>
                                                <td>${listR.quantity}</td>
                                                <td>
                                                    <h2>  <a href="AcceptRequestController?action=checkStatus&detailID=${listR.borrowDetailID}">OK</a></h2>
                                                </td>
                                            </tr>
                                    
                                    </tbody>
                                    </c:forEach>
                                </table>
                            </form>

                            <!-- .grid -->

                           
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
