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
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/employeeDash">Employee Dashboard</a></li>
            </ul>    
        </div>

        <div class="panel panel-default">
            <br/>
            <div class="panel-header">
                <div class="input-group col-lg-10 col-lg-offset-1">
                    <input type="hidden" id="post-id" value="${post.postId}"/>
                    
                    
                    <input type="text" class="form-control" id="post-title" value="${post.title}" placeholder="Title"/>
                </div>
            </div>
            <br/>
            <div class="panel-body ">
                <input type="text" class="form-control editor" id="post-content" value ='${post.content}' placeholder="Blog Content"/> 
            </div>
            <div class="panel-footer">
                   <div class="input-group col-lg-5">
                       Expiration Date (optional)
                    <input type="date" class="form-control" id="exp-date" value="${post.expDate}" >
                   </div>
                <br/>
                <div class="row">

                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" class="form-control" aria-label="..." placeholder="Add New Category"/>
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Category<span class="caret"></span></button>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li><a href="#">Add Category</a></li>
                                    <li><a href="#">Events</a></li>
                                    <li><a href="#">Good Times</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                    <div class="col-lg-2 col-lg-offset-4">
                        <button type="submit" id="save-post-button" class="btn btn-default">Save</button>
                   
                    </div>

                </div><!--row-->
                <br/>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Add New Tag"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Add Tag</button>
                            </span>
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                    <div class="col-lg-2 col-lg-offset-4">
                        <button type="submit" id="delete-post-button" class="btn btn-default ">Delete</button>
                        <button type="submit" id="cancel-post-button" class="btn btn-default ">Cancel</button>
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
