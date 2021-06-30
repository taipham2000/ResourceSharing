package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en-US\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>TaiPham Company | Minimalist Free HTML Portfolio by WowThemes.net</title>\n");
      out.write("        <link rel='stylesheet' href='css/woocommerce-layout.css' type='text/css' media='all'/>\n");
      out.write("        <link rel='stylesheet' href='css/woocommerce-smallscreen.css' type='text/css' media='only screen and (max-width: 768px)'/>\n");
      out.write("        <link rel='stylesheet' href='css/woocommerce.css' type='text/css' media='all'/>\n");
      out.write("        <link rel='stylesheet' href='css/font-awesome.min.css' type='text/css' media='all'/>\n");
      out.write("        <link rel='stylesheet' href='style.css' type='text/css' media='all'/>\n");
      out.write("        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>\n");
      out.write("        <link rel='stylesheet' href='css/easy-responsive-shortcodes.css' type='text/css' media='all'/>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"home page page-template page-template-template-portfolio page-template-template-portfolio-php\">\n");
      out.write("        <div id=\"page\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <header id=\"masthead\" class=\"site-header\">\n");
      out.write("                    <div class=\"site-branding\">\n");
      out.write("                        <h1 class=\"site-title\"><a href=\"index.html\" rel=\"home\">TaiPham Company</a></h1>\n");
      out.write("                    </div>\n");
      out.write("                    <nav id=\"site-navigation\" class=\"main-navigation\">\n");
      out.write("                        <button class=\"menu-toggle\">Menu</button>\n");
      out.write("                        <a class=\"skip-link screen-reader-text\" href=\"#content\">Skip to content</a>\n");
      out.write("                        <div class=\"menu-menu-1-container\">\n");
      out.write("                            <ul id=\"menu-menu-1\" class=\"menu\">\n");
      out.write("                                <li><a href=\"MainController\">Home</a></li>\n");
      out.write("                                <li><a href=\"about.html\">About</a></li>\n");
      out.write("                                <li><a href=\"MainController?action=Login\">Login</a></li>\n");
      out.write("                                <li><a href=\"blog.html\">Blog</a></li>\n");
      out.write("                                <li><a href=\"elements.html\">Elements</a></li>\n");
      out.write("                                <li><a href=\"#\">Pages</a>\n");
      out.write("                                    <ul class=\"sub-menu\">\n");
      out.write("                                        <li><a href=\"portfolio-item.html\">Portfolio Item</a></li>\n");
      out.write("                                        <li><a href=\"blog-single.html\">Blog Article</a></li>\n");
      out.write("                                        <li><a href=\"shop-single.html\">Shop Item</a></li>\n");
      out.write("                                        <li><a href=\"portfolio-category.html\">Portfolio Category</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </header>\n");
      out.write("                <!-- #masthead -->\n");
      out.write("                <div id=\"content\" class=\"site-content\">\n");
      out.write("                    <div class=\"single-sidebar\">\n");
      out.write("                        <h2 class=\"sidebar-title\">Search Products</h2>\n");
      out.write("                        <form action=\"MainController\" method=\"post\">\n");
      out.write("                            <input type=\"text\" name=\"search\" placeholder=\"Search products...\">\n");
      out.write("                            <input type=\"submit\" name=\"action\" value=\"search\">\n");
      out.write("                        </form>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"primary\" class=\"content-area column full\">\n");
      out.write("                        <main id=\"main\" class=\"site-main\">\n");
      out.write("                            <form>\n");
      out.write("                                <table>\n");
      out.write("                                    <thead>\n");
      out.write("                                    <td>ProductID</td>\n");
      out.write("                                    <input type=\"text\" name=\"productID\">\n");
      out.write("                                    </thead>\n");
      out.write("                                </table>\n");
      out.write("                            </form>\n");
      out.write("                        </main>\n");
      out.write("                        <!-- #main -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- #primary -->\n");
      out.write("                </div>\n");
      out.write("                <!-- #content -->\n");
      out.write("            </div>\n");
      out.write("            <!-- .container -->\n");
      out.write("            <footer id=\"colophon\" class=\"site-footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"site-info\">\n");
      out.write("                        <h1 style=\"font-family: 'Herr Von Muellerhoff';color: #ccc;font-weight:300;text-align: center;margin-bottom:0;margin-top:0;line-height:1.4;font-size: 46px;\">Moschino</h1>\n");
      out.write("                        <a target=\"blank\" href=\"https://www.wowthemes.net/\">&copy; Moschino - Free HTML Template by WowThemes.net</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\t\n");
      out.write("            </footer>\n");
      out.write("            <a href=\"#top\" class=\"smoothup\" title=\"Back to top\"><span class=\"genericon genericon-collapse\"></span></a>\n");
      out.write("        </div>\n");
      out.write("        <!-- #page -->\n");
      out.write("        <script src='js/jquery.js'></script>\n");
      out.write("        <script src='js/plugins.js'></script>\n");
      out.write("        <script src='js/scripts.js'></script>\n");
      out.write("        <script src='js/masonry.pkgd.min.js'></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
