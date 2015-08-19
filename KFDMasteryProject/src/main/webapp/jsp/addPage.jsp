<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix ="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Sea Legs Nautical Academy</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">


        <!-- Logo -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.jpg">
    </div>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/img/background1.jpg); background-attachment:fixed;"> 
    <input type="hidden" value="${pageContext.request.contextPath}" id="projectRoot"/>
    <div class="container">
        <div class="row" style="padding-top: 20px">
            <img src="${pageContext.request.contextPath}/img/logo.jpg" class="img-rounded"; style="float:left; width:150px;height:150px" />
            <h1 style="text-align: center; padding-top: 30px">Sea Legs Nautical Academy</h1>
        </div>
        <hr/>
        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/aboutUs">About</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/bossDashboard">Dashboard</a></li>
            </ul>    
        </div>

        <div class="panel panel-default">
            <br/>
            <iframe id="form_target" name="form_target" style="display:none"></iframe>
            <form id="my_form" action="uploadImage" target="form_target" method="post" enctype="multipart/form-data" style="width:0px;height:0;overflow:hidden">
                <input name="newImage" class="form-control" type="file" onchange="$('#my_form').submit();
                        this.value = '';">
            </form>
            <div class="panel-header">
                <div class="input-group col-lg-10 col-lg-offset-1">
                    <input type="hidden" id="page-id" value="${page.pageId}"/>
                    <input type="text" class="form-control" id="page-title" value="${page.title}" placeholder="Title"/>
                </div>
            </div>
            <br/>
            <div class="panel-body ">
                <input type="text" class="form-control editor" id="page-content" value ='${page.content}' placeholder="Page Content"/> 
            </div>
            <div class="panel-footer">
                <br/>
                <div class="row">
                    <div class="col-lg-2 col-lg-offset-8">
                        <button type="submit" id="publish-page-button" class="btn btn-default">Publish</button>
                    </div>
                </div><!--row-->
                <br/>
                <div class="row">
                    <div class="col-lg-2 col-lg-offset-8">
                        <button type="submit" id="delete-page-button" class="btn btn-default ">Delete</button>
                        <button type="submit" id="cancel-page-button" class="btn btn-default ">Cancel</button>
                    </div>
                </div><!--row-->

            </div><!--panel footer-->
        </div>
        <br/>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.dev.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.jquery.dev.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/KFD.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce.js"></script>


</body>
</html>
