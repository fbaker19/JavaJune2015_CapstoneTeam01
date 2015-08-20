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
    <div class="container">
        <div class="row col-md-offset-11">
            <a data-toggle="modal" href="#myModal">Sign In</a>
            <!-- Logo -->
            <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.jpg" >
        </div>
    </div>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/img/background1.jpg); background-attachment:fixed;"> 
    <input type="hidden" value="${pageContext.request.contextPath}" id="projectRoot"/>
                
    <div class="container">
        <div class="row" style="padding-top: 20px">
            <img src="${pageContext.request.contextPath}/img/logo.jpg" class="img-rounded"; style="float:left; width:150px;height:150px" />
            <h1 style="text-align: center; padding-top: 30px">Sea Legs Nautical Academy</h1>
        </div>
        <br/>
        <div class="row">
        <div class="fb-like" data-href="https://www.facebook.com/thesoftwareguild" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
        <div id="fb-root"></div>
        
        <a href="https://twitter.com/softwareguild" class="twitter-follow-button" data-show-count="false" data-size="large">Follow @sealegs</a>
        </div>
        <hr/>

        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation"  class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/aboutUs">About</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
            </ul>    
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Latest Blog Post: ${currentPost.title}</h3>
                <p style="font-size:70%"><i>${currentPost.createDate}</i></p>
            </div>
            <div class="panel-body">
                ${currentPost.content}
            </div>
        </div>
        <br/><br/>
        <div class="panel panel-default col-md-5">
            <div class="panel-heading">
                <h3 class="panel-title">${page1.title}</h3>
            </div>
            <div class="panel-body">
                ${page1.content}
            </div>
        </div>
        <div class="panel panel-default col-md-6 col-md-offset-1">
            <div class="panel-heading">
                <h3 class="panel-title">${page2.title}</h3>
            </div>
            <div class="panel-body">
                ${page2.content}
            </div>
        </div>


    </div>
</div>
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/bossDashboard" method="POST">
                    <div class="form-group">
                        <label for="login-user-name" class="col-md-4 control-label">User Name</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="login-user-name" placeholder="User Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="login-password" class="col-md-4 control-label">Password</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="login-password" placeholder="Password"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="login-button" class="btn btn-default">Sign In</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.dev.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.jquery.dev.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/KFD.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce.js"></script>
<script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
<script>!function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
                if (!d.getElementById(id)) {
                    js = d.createElement(s);
                    js.id = id;
                    js.src = p + '://platform.twitter.com/widgets.js';
                    fjs.parentNode.insertBefore(js, fjs);
                }
            }(document, 'script', 'twitter-wjs');</script>
</body>
</html>


