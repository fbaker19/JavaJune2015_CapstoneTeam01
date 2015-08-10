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
<body style="background-image:url(${pageContext.request.contextPath}/img/background1.jpg)"> 

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
                <li role="presentation"><a href="${pageContext.request.contextPath}/#">About</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/#">Contact Us</a></li>
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/bossDashboard">Dashboard</a></li>
            </ul>    
        </div>

        <div class="panel panel-default">
            <div class="panel-body editor">

            </div>
            <div class="panel-footer">
                <div class="row">
                    
                    
                    <div class="col-lg-2 col-lg-offset-9">
                    <button type="submit" id="publish-add-button" class="btn btn-default btn-block">Publish</button>
                    <button type="submit" id="save-add-button" class="btn btn-default btn-block">Save</button>
                    </div>

                </div><!--row-->
                <br/>
                <div class="row">
                    
                      <div class="col-lg-2 col-lg-offset-9">
                    <button type="submit" id="delete-add-button" class="btn btn-default btn-block">Delete</button>
                    <button type="submit" id="cancel-add-button" class="btn btn-default btn-block">Cancel</button>
                    </div>

                   
                </div><!--row-->
            </div><!--panel footer-->
        </div>
        <br/>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
    <script type="text/javascript">
        tinymce.init({
            selector: ".editor", theme: "modern",
            plugins: [
                "advlist autolink link image lists charmap print preview hr anchor pagebreak",
                "searchreplace wordcount visualblocks visualchars insertdatetime media nonbreaking",
                "table contextmenu directionality emoticons paste textcolor responsivefilemanager"
            ],
            toolbar1: "undo redo | bold italic underline | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | styleselect",
            toolbar2: "| responsivefilemanager | link unlink anchor | image media | forecolor backcolor  | print preview code ",
            image_advtab: true,
            external_filemanager_path: "${pageContext.request.contextPath}/filemanager/",
            filemanager_title: "Responsive Filemanager",
            external_plugins: {"filemanager": "${pageContext.request.contextPath}/filemanager/plugin.min.js"}
        });
    </script>
</body>
</html>
