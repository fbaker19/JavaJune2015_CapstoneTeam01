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
            <h3 style="text-align: center; padding-top: 30px">Life on the High Seas Blog</h3>
        </div>
        <hr/>
        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/aboutUs">About</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
            </ul>     
        </div>
        <div class="panel panel-default">
            <input type="hidden" id="post-id" value="${post.postId}"/>
            <input type="hidden" id="category-id" value="${category.categoryId}"/>
            <div class="panel-heading">
                <h3 class="panel-title">
                    ${post.title}
                </h3>
                <a href="${pageContext.request.contextPath}/displayCatPage/${category.categoryId}">${category.categoryName}</a>
            </div>
            <div class="panel-body">
                ${post.content} 
            </div>
        </div>
            <div class="row">
                <div style='float:left;padding:5px 5px 5px 0; col' class="col-lg-offset-1"> <a expr:share_url='data:post.url' href='http://www.facebook.com/sharer.php' name='fb_share' type='box_count'>Share</a></div>
<div style='float:left;padding:5px 5px 5px 0;'><a href="https://twitter.com/share" class="twitter-share-button col-lg-offset-2">Tweet</a>
</div>
             </div>
                
                 <br/>

        <div class="input-group col-lg-10 col-lg-offset-1">
            <textarea class="form-control" rows="4" id="add-comment" placeholder="Add Your Comment"></textarea>
        </div>
        <br/>
        <div class="input-group col-lg-4 col-lg-offset-1">
            <input type="text" class="form-control" id="commenter"  placeholder="Your Name (optional)">
        </div>
        <br/>
        <button class="btn btn-default col-lg-offset-1" id="add-comment-button" type="submit" >Add Comment</button>
        <br/>
        <br/>
            <c:forEach var="comment" items="${comments}">
                <div class="well">
                    <p>${comment.commenter}</p>
                    <p><i>${comment.createDate}</i></p>
                    ${comment.comment}
                </div>
                <br/>
            </c:forEach>
    </div>
    <br/>


    <!-- Modal -->
    <div class="modal fade" id="commentModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">

                <div class="modal-body">
                    <h3>Thank you for your comment!</h3>
                    <p>
                        Your comment has been submitted for approval.
                    </p>
                    <p>
                        Check back in a few days to see your comment up on our blog!
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
<script src='http://static.ak.fbcdn.net/connect.php/js/FB.Share' type='text/javascript'></script>
    <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>

</body>
</html>


