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
            <h3 style="text-align: center; padding-top: 30px">Life on the High Seas Blog</h3>
        </div>
        <hr/>
        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li role="presentation"  class="active"><a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/#">About</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/#">Contact Us</a></li>
            </ul>    
        </div>
        <c:forEach var="post" items="${pList}">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a href="viewPost/${post.postId}">${post.title} </a>
                    </h3>
                </div>
<<<<<<< HEAD
                <div class="panel-body">
=======
<<<<<<< HEAD
                <div class="panel-body">
=======
                <div class="panel-body ">
>>>>>>> 0e5808a3f244517da6ceb0591f16a5615026a7bb
>>>>>>> cd4a854a98a0b6ae536e416f3d310ab5290f1263
                    ${post.blurb}
                </div>
                <div class="panel-footer">Comments ()</div>
            </div>
            <br/>
        </c:forEach>
    </div>


<<<<<<< HEAD
<!-- Placed at the end of the document so the pages load faster --><!--.editor can be placed in multiple divs, can be ".woodchuck"-->
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
=======
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
    <script type="text/javascript">
        tinymce.init({
            selector: ".editor", theme: "modern",
            plugins: [
                "advlist autolink lists link image charmap print preview anchor",
                "searchreplace visualblocks code fullscreen",
                "insertdatetime media table contextmenu paste jbimages"
            ],
            toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image jbimages",
            relative_urls: false,
        });
    </script>
>>>>>>> c304a175da2a9c261b095a8f64b937f1be32a5fc
</body>
</html>


