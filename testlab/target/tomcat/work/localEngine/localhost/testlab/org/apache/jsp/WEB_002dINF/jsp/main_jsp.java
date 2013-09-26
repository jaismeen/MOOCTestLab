package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../assets/ico/favicon.png\">\r\n");
      out.write("\r\n");
      out.write("    <title>Carousel Template for Bootstrap</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <!--  <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("            <link href=\"css/flowchart.css\" rel=\"stylesheet\">\r\n");
      out.write("-->\r\n");
      out.write("\t<link rel='stylesheet' type='text/css' media='screen' href='");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("'/>\r\n");
      out.write("\t\t<link rel='stylesheet' type='text/css' media='screen' href='");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("'/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"../../assets/js/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"../../assets/js/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("   <!--   <link href=\"../../resources/css/carousel.css\" rel=\"stylesheet\">\r\n");
      out.write("    -->\r\n");
      out.write("    \t\t<link rel='stylesheet' type='text/css' media='screen' href='");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("'/>\r\n");
      out.write("    \t\t    <script type='text/javascript' src='");
      if (_jspx_meth_c_005furl_005f7(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("    \t\t<script type='text/javascript' src='");
      if (_jspx_meth_c_005furl_005f8(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("    \t\t    <script src=\"http://raphaeljs.com/raphael.js\"></script>\r\n");
      out.write("    \t\t<script type='text/javascript' src='");
      if (_jspx_meth_c_005furl_005f9(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <!--  <script src=\"../../resources/js/tabs.js\"></script>\r\n");
      out.write("    <script src=\"http://raphaeljs.com/raphael.js\"></script>\r\n");
      out.write("    <script src=\"../../resources/js/flowchart-1.1.3.js\"></script>\r\n");
      out.write("-->\r\n");
      out.write("    <script type='text/javascript'>\r\n");
      out.write("       \r\n");
      out.write("    $(function() {\r\n");
      out.write("    \t\r\n");
      out.write("    \talert(\"in init()\");\r\n");
      out.write("    \t//alert(urlHolder);\r\n");
      out.write("    \t\r\n");
      out.write("\t\t// init\r\n");
      out.write("\t\turlHolder.records = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recordsUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\turlHolder.add = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\turlHolder.edit = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${editUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\turlHolder.del = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deleteUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\talert(\"out init()\");\r\n");
      out.write("    })\r\n");
      out.write("    \r\n");
      out.write("            function createUI(ele)\r\n");
      out.write("{\r\n");
      out.write("    var selElement, element;\r\n");
      out.write("    var selection=document.getElementsByName(\"element\");\r\n");
      out.write("    if (selection[0].checked==true)\r\n");
      out.write("    {\r\n");
      out.write("        selElement=\"Node\"; \r\n");
      out.write("         document.getElementById(\"nodeelements\").style.display='block'; \r\n");
      out.write("         document.getElementById(\"linkelements\").style.display= 'none';\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("    else\r\n");
      out.write("    {\r\n");
      out.write("        selElement=\"Link\";\r\n");
      out.write("        document.getElementById(\"nodeelements\").style.display='none';\r\n");
      out.write("        document.getElementById(\"linkelements\").style.display= 'block';\r\n");
      out.write("    } \r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("       \t\r\n");
      out.write("        </head>\r\n");
      out.write("<!-- NAVBAR\r\n");
      out.write("================================================== -->\r\n");
      out.write("  <body>\r\n");
      out.write("  ");
      out.print(new java.util.Date() );
      out.write("\r\n");
      out.write("      <div class=\"navbar-wrapper\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar navbar-inverse navbar-static-top\">\r\n");
      out.write("          <div class=\"container\">\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("              <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("              </button>\r\n");
      out.write("              <a class=\"navbar-brand\" href=\"#\">Online Test Labs</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"navbar-collapse collapse\">\r\n");
      out.write("              <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("                <li><a href=\"#about\">Lab</a></li>\r\n");
      out.write("                <li><a href=\"#contact\">Practice Sessions</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"main_body\">\r\n");
      out.write("        <div id=\"side_panel\">\r\n");
      out.write("            <div class=\"tabs\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li id=\"tabHeader_1\">Create Element</li>\r\n");
      out.write("                        <li id=\"tabHeader_2\">Delete Element</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"tabscontent\">\r\n");
      out.write("                <div class=\"tabpage\" id=\"tabpage_1\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    \r\n");
      out.write("                    <input type=\"radio\" name=\"element\" onclick=\"createUI()\" value=\"node\" checked=\"checked\">  Node\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    <input type=\"radio\" name=\"element\" onclick=\"createUI()\" value=\"link\">  Link\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                     <div id=\"fg_elements\">\r\n");
      out.write("                     </div>\r\n");
      out.write("                       <div id=\"nodeelements\">\r\n");
      out.write("                   <!-- <<label for=\"createnode\">Create Node</label><br>-->\r\n");
      out.write("                    <label class=\"col-lg-4 control-label\">Name</label>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id = \"nodename\" name=\"nodename\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <label class=\"col-lg-4 control-label\">Content</label>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id = \"content\" name=\"nodecontent\"><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                         \r\n");
      out.write("                            <label class=\"col-lg-4 control-label\">Type</label>\r\n");
      out.write("                            <div class=\"col-lg-6\">\r\n");
      out.write("                            <select id=\"nodetype\" class=\"form-control\">\r\n");
      out.write("                                <option value=\"gnode\">General Node</option>\r\n");
      out.write("                                <option value=\"cnode\">Condition Node</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <button id=\"createNode\" class=\"btn btn-default\" type=\"button\" onclick=\"addNode()\">Create Node</button><br><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <div id=\"linkelements\">\r\n");
      out.write("\r\n");
      out.write("                            <label class=\"col-lg-5 control-label\" for=\"lb_sourcenode\">Source Node</label>\r\n");
      out.write("                            \r\n");
      out.write("                             <div class=\"col-lg-6\">\r\n");
      out.write("                                <select class=\"form-control\" id=\"sourceNode\">\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                            <label class=\"col-lg-5 control-label\" for=\"lb_destinationnode\">Destination Node</label>\r\n");
      out.write("                             <div class=\"col-lg-6\">\r\n");
      out.write("                                <select class=\"form-control\" id=\"destinationNode\">\r\n");
      out.write("                            </select><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <button id=\"createLink\" class=\"btn btn-default\" type=\"button\" onclick=\"addLink()\">Create Link</button><br>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"tabpage\" id=\"tabpage_2\">\r\n");
      out.write("                         <br>\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    \r\n");
      out.write("                  <!--<input type=\"radio\" name=\"element\" onclick=\"createUI()\" value=\"node\" checked=\"checked\">  Node\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    &nbsp\r\n");
      out.write("                    <input type=\"radio\" name=\"element\" onclick=\"createUI()\" value=\"link\">  Link\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                     <div id=\"fg_elements\">\r\n");
      out.write("                     </div>\r\n");
      out.write("                       <div id=\"nodeelements\">\r\n");
      out.write("                    <label class=\"col-lg-4 control-label\">Name</label>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id = \"nodename\" name=\"nodename\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <label class=\"col-lg-4 control-label\">Content</label>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id = \"content\" name=\"nodecontent\"><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                         \r\n");
      out.write("                            <label class=\"col-lg-4 control-label\">Type</label>\r\n");
      out.write("                            <div class=\"col-lg-6\">\r\n");
      out.write("                            <select id=\"nodetype\" class=\"form-control\">\r\n");
      out.write("                                <option value=\"gnode\">General Node</option>\r\n");
      out.write("                                <option value=\"cnode\">Condition Node</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <button id=\"createNode\" class=\"btn btn-default\" type=\"button\" onclick=\"addNode()\">Create Node</button><br><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <div id=\"linkelements\">\r\n");
      out.write("\r\n");
      out.write("                            <label class=\"col-lg-5 control-label\" for=\"lb_sourcenode\">Source Node</label>\r\n");
      out.write("                            \r\n");
      out.write("                             <div class=\"col-lg-6\">\r\n");
      out.write("                                <select class=\"form-control\" id=\"sourceNode\">\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                            <label class=\"col-lg-5 control-label\" for=\"lb_destinationnode\">Destination Node</label>\r\n");
      out.write("                             <div class=\"col-lg-6\">\r\n");
      out.write("                                <select class=\"form-control\" id=\"destinationNode\">\r\n");
      out.write("                            </select><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <button id=\"createLink\" class=\"btn btn-default\" type=\"button\" onclick=\"addLink()\">Create Link</button><br>\r\n");
      out.write("                        </div>-->\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"code_area\">\r\n");
      out.write("                <iframe class=\"codeframe\" style=\"background: #F0F0F0; width: 100%; height: 230px\" src='");
      if (_jspx_meth_c_005furl_005f10(_jspx_page_context))
        return;
      out.write("'></iframe>\r\n");
      out.write("                <br>\r\n");
      out.write("                <br>\r\n");
      out.write("                <button id=\"submit\" stype=\" align: right\" class=\"btn btn-default\" type=\"button\" onclick=\"submitHW()\">Submit</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"canvas\">\r\n");
      out.write("             <h1>Drawing Area</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/jsp/main.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/main/records");
    // /WEB-INF/jsp/main.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setVar("recordsUrl");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/jsp/main.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/main/create");
    // /WEB-INF/jsp/main.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setVar("addUrl");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/jsp/main.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/main/update");
    // /WEB-INF/jsp/main.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setVar("editUrl");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /WEB-INF/jsp/main.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/main/delete");
    // /WEB-INF/jsp/main.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setVar("deleteUrl");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /WEB-INF/jsp/main.jsp(22,61) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/resources/css/bootstrap.css");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /WEB-INF/jsp/main.jsp(23,62) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/resources/css/flowchart.css");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /WEB-INF/jsp/main.jsp(35,66) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/resources/css/carousel.css");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent(null);
    // /WEB-INF/jsp/main.jsp(36,46) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/resources/js/jquery-1.6.4.min.js");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent(null);
    // /WEB-INF/jsp/main.jsp(37,42) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("/resources/js/tabs.js");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f9.setParent(null);
    // /WEB-INF/jsp/main.jsp(39,42) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setValue("/resources/js/flowchart-1.1.3.js");
    int _jspx_eval_c_005furl_005f9 = _jspx_th_c_005furl_005f9.doStartTag();
    if (_jspx_th_c_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f10.setParent(null);
    // /WEB-INF/jsp/main.jsp(243,103) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setValue("/WEB-INF/jsp/samplecode/test.c");
    int _jspx_eval_c_005furl_005f10 = _jspx_th_c_005furl_005f10.doStartTag();
    if (_jspx_th_c_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
    return false;
  }
}
