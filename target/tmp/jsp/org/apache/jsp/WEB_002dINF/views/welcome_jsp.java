/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2018-04-11 17:10:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("jar:file:/C:/Users/Kevin/.m2/repository/org/springframework/spring-webmvc/4.2.0.RELEASE/spring-webmvc-4.2.0.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1438302982000L));
    _jspx_dependants.put("jar:file:/C:/Users/Kevin/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153381482000L));
    _jspx_dependants.put("file:/C:/Users/Kevin/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1509281832297L));
    _jspx_dependants.put("jar:file:/C:/Users/Kevin/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153381482000L));
    _jspx_dependants.put("file:/C:/Users/Kevin/.m2/repository/org/springframework/spring-webmvc/4.2.0.RELEASE/spring-webmvc-4.2.0.RELEASE.jar", Long.valueOf(1509281827019L));
    _jspx_dependants.put("jar:file:/C:/Users/Kevin/.m2/repository/org/springframework/spring-webmvc/4.2.0.RELEASE/spring-webmvc-4.2.0.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1438302982000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fform_0026_005fcommandName;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fcssClass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005ferrors_0026_005fpath_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005fform_0026_005fcommandName = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fcssClass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005ferrors_0026_005fpath_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fform_005fform_0026_005fcommandName.release();
    _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fcssClass_005fnobody.release();
    _005fjspx_005ftagPool_005fform_005ferrors_0026_005fpath_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("<meta name=\"description\" content=\"\">\n");
      out.write("<meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("<title>Homepage</title>\n");
      out.write("\n");
      out.write("<!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/custom.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/mediaplayer.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("<form id=\"logoutForm\" method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout\">\n");
      out.write("\t<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"col-lg-4\">\n");
      out.write("\t\t\t<div id=\"logbox\">\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "mediaplayer.jsp", out, false);
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div class=\"col-lg-5\">\n");
      out.write("\t\t\t<div id=\"logbox\">\n");
      out.write("\t\t\t\t<div class=\"col-lg-6\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Button trigger modal -->\n");
      out.write("\t\t\t\t\t<!-- <button class=\"btn btn-primary btn-lg\" data-toggle=\"modal\"\n");
      out.write("\t\t\t\t\t\tdata-target=\"#myModal\">New Post</button>-->\n");
      out.write("\t\t\t\t\t<input type=\"text\" data-target=\"#myModal\" data-toggle=\"modal\"\n");
      out.write("\t\t\t\t\t\tclass=\"form-control1\" placeholder=\"New Post\" />\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t");
      //  form:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fform_005fform_0026_005fcommandName.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_form_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_form_005fform_005f0.setParent(null);
      // /WEB-INF/views/welcome.jsp(69,4) name = commandName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_form_005fform_005f0.setCommandName("postTextForm");
      int[] _jspx_push_body_count_form_005fform_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_form_005fform_005f0 = _jspx_th_form_005fform_005f0.doStartTag();
        if (_jspx_eval_form_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("\t\t\t\t\t<!-- Modal -->\n");
            out.write("\t\t\t\t\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\"\n");
            out.write("\t\t\t\t\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
            out.write("\t\t\t\t\t\t<div class=\"modal-dialog\">\n");
            out.write("\t\t\t\t\t\t\t<div class=\"modal-content\">\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"modal-header\">\n");
            out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\taria-hidden=\"true\">&times;</button>\n");
            out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">New post</h4>\n");
            out.write("\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"modal-body\">\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"content\" class=\"col-sm-2 control-label\">Content:</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-10\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t");
            if (_jspx_meth_form_005finput_005f0(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
              return;
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_005ferrors_005f0 = (org.springframework.web.servlet.tags.form.ErrorsTag) _005fjspx_005ftagPool_005fform_005ferrors_0026_005fpath_005fnobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_005ferrors_005f0.setPageContext(_jspx_page_context);
            _jspx_th_form_005ferrors_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
            // /WEB-INF/views/welcome.jsp(85,11) name = path type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_form_005ferrors_005f0.setPath("content");
            int[] _jspx_push_body_count_form_005ferrors_005f0 = new int[] { 0 };
            try {
              int _jspx_eval_form_005ferrors_005f0 = _jspx_th_form_005ferrors_005f0.doStartTag();
              if (_jspx_th_form_005ferrors_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (java.lang.Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_005ferrors_005f0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_005ferrors_005f0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_005ferrors_005f0.doFinally();
              _005fjspx_005ftagPool_005fform_005ferrors_0026_005fpath_005fnobody.reuse(_jspx_th_form_005ferrors_005f0);
            }
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"modal-footer\">\n");
            out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\tdata-dismiss=\"modal\">Close</button>\n");
            out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary\" value=\"Save\" />\n");
            out.write("\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t");
            int evalDoAfterBody = _jspx_th_form_005fform_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_form_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_form_005fform_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_form_005fform_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_form_005fform_005f0.doFinally();
        _005fjspx_005ftagPool_005fform_005fform_0026_005fcommandName.reuse(_jspx_th_form_005fform_005f0);
      }
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"col-lg-6\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" data-target=\"#myModal1\" data-toggle=\"modal\"\n");
      out.write("\t\t\t\t\t\tclass=\"form-control1\" placeholder=\"New Track\" />\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<form enctype=\"multipart/form-data\" method=\"post\"\n");
      out.write("\t\t\t\t\taction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/track?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('=');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t<!-- Modal -->\n");
      out.write("\t\t\t\t\t<div class=\"modal fade\" id=\"myModal1\" tabindex=\"-1\" role=\"dialog\"\n");
      out.write("\t\t\t\t\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-dialog\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\taria-hidden=\"true\">&times;</button>\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">New track</h4>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"title\" class=\"col-sm-2 control-label\">Artist:</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"artist\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"title\" class=\"col-sm-2 control-label\">Title:</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"track\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"title\" class=\"col-sm-2 control-label\">Genre:</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select name=\"genre\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Techno\">Techno</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Tech House\">Tech House</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"House\">House</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Trance\">Trance</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"title\" class=\"col-sm-2 control-label\">File:</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"file\" name=\"file\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdata-dismiss=\"modal\">Close</button>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary\" value=\"Save\" />\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t<br></br> <br></br>\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "post.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-md-3\">\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /container -->\n");
      out.write("</body>\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/bootstrap.min.js\"></script>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<!-- Media player script -->\n");
      out.write("<script>jQuery(function ($) {\n");
      out.write("    'use strict'\n");
      out.write("    var supportsAudio = !!document.createElement('audio').canPlayType;\n");
      out.write("    if (supportsAudio) {\n");
      out.write("        var index = 0,\n");
      out.write("            playing = false,\n");
      out.write("            mediaPath = 'https://s3.eu-west-1.amazonaws.com/sounddrop-track-bucket/',\n");
      out.write("            extension = '',\n");
      out.write("            tracks = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracks}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(",\n");
      out.write("            buildPlaylist = $.each(tracks, function(key, value) {\n");
      out.write("                var trackNumber = value.track,\n");
      out.write("                    trackName = value.name,\n");
      out.write("                    trackArtist = value.artist;\n");
      out.write("                if (trackNumber.toString().length === 1) {\n");
      out.write("                    trackNumber = '0' + trackNumber;\n");
      out.write("                } else {\n");
      out.write("                    trackNumber = '' + trackNumber;\n");
      out.write("                }\n");
      out.write("                $('#plList').append('<li><div class=\"plItem\"><div class=\"plNum\">' + trackNumber +  '</div><div class=\"plTitle\">' + trackArtist +'    -    ' + trackName + '</div></div></li>');\n");
      out.write("            }),\n");
      out.write("            trackCount = tracks.length,\n");
      out.write("            npAction = $('#npAction'),\n");
      out.write("            npTitle = $('#npTitle'),\n");
      out.write("            audio = $('#audio1').bind('play', function () {\n");
      out.write("                playing = true;\n");
      out.write("                npAction.text('Now Playing...');\n");
      out.write("            }).bind('pause', function () {\n");
      out.write("                playing = false;\n");
      out.write("                npAction.text('Paused...');\n");
      out.write("            }).bind('ended', function () {\n");
      out.write("                npAction.text('Paused...');\n");
      out.write("                if ((index + 1) < trackCount) {\n");
      out.write("                    index++;\n");
      out.write("                    loadTrack(index);\n");
      out.write("                    audio.play();\n");
      out.write("                } else {\n");
      out.write("                    audio.pause();\n");
      out.write("                    index = 0;\n");
      out.write("                    loadTrack(index);\n");
      out.write("                }\n");
      out.write("            }).get(0),\n");
      out.write("            btnPrev = $('#btnPrev').click(function () {\n");
      out.write("                if ((index - 1) > -1) {\n");
      out.write("                    index--;\n");
      out.write("                    loadTrack(index);\n");
      out.write("                    if (playing) {\n");
      out.write("                        audio.play();\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    audio.pause();\n");
      out.write("                    index = 0;\n");
      out.write("                    loadTrack(index);\n");
      out.write("                }\n");
      out.write("            }),\n");
      out.write("            btnNext = $('#btnNext').click(function () {\n");
      out.write("                if ((index + 1) < trackCount) {\n");
      out.write("                    index++;\n");
      out.write("                    loadTrack(index);\n");
      out.write("                    if (playing) {\n");
      out.write("                        audio.play();\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    audio.pause();\n");
      out.write("                    index = 0;\n");
      out.write("                    loadTrack(index);\n");
      out.write("                }\n");
      out.write("            }),\n");
      out.write("            li = $('#plList li').click(function () {\n");
      out.write("                var id = parseInt($(this).index());\n");
      out.write("                if (id !== index) {\n");
      out.write("                    playTrack(id);\n");
      out.write("                }\n");
      out.write("            }),\n");
      out.write("            loadTrack = function (id) {\n");
      out.write("                $('.plSel').removeClass('plSel');\n");
      out.write("                $('#plList li:eq(' + id + ')').addClass('plSel');\n");
      out.write("                npTitle.text(tracks[id].name);\n");
      out.write("                index = id;\n");
      out.write("                audio.src = mediaPath + tracks[id].file;\n");
      out.write("            },\n");
      out.write("            playTrack = function (id) {\n");
      out.write("                loadTrack(id);\n");
      out.write("                audio.play();\n");
      out.write("            };\n");
      out.write("        extension = audio.canPlayType('audio/mpeg') ? '.mp3' : audio.canPlayType('audio/wav') ? '.wav' : '';\n");
      out.write("        loadTrack(index);\n");
      out.write("    }\n");
      out.write("});\n");
      out.write("\n");
      out.write("//initialize plyr\n");
      out.write("plyr.setup($('#audio1'), {});</script>\t\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/views/welcome.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("contextPath");
    // /WEB-INF/views/welcome.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/welcome.jsp(5,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f0 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fcssClass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/welcome.jsp(84,11) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f0.setPath("content");
    // /WEB-INF/views/welcome.jsp(84,11) name = cssClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f0.setCssClass("form-control");
    int[] _jspx_push_body_count_form_005finput_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f0 = _jspx_th_form_005finput_005f0.doStartTag();
      if (_jspx_th_form_005finput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fcssClass_005fnobody.reuse(_jspx_th_form_005finput_005f0);
    }
    return false;
  }
}
