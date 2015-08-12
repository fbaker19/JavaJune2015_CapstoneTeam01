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
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">
                    ${post.title} 
                </h3>
            </div>
            <div class="panel-body">
                ${post.content}
            </div>
        </div>

        <div class="input-group col-lg-10 col-lg-offset-1">
            <textarea class="form-control" rows="4" placeholder="Add Your Comment"></textarea>
        </div>
        <br/>
            <div class="input-group col-lg-4 col-lg-offset-1">
                <input type="text" class="form-control" placeholder="Your Name (optional)">
            </div>
        <br/>
            <div class="input-group col-lg-4 col-lg-offset-1">
                <span class="input-group-btn">
                    <button class="btn btn-default" id="add-comment-button" type="button">Add Comment</button>
                </span>
            </div> 
    </div>
    <br/>
</div>


<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>


