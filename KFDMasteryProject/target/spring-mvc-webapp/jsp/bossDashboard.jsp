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
        <div class="row">
            <div class="panel panel-default  col-md-5">
                <div class="panel-heading">
                    <h3 class="dashboard-blog-title">Pending Blog Posts</h3>
                </div>
                <div class="panel-body" style="max-height: 300px">
                    <table class="table table-striped">
                        <c:forEach var="pendingPost" items="${ppList}">
                            <tr>
                                <td><a href="editPost/${pendingPost.postId}">${pendingPost.title} </a></td>
                            </tr>
                        </c:forEach>
                    </table> 
                </div>
            </div>
            <div class="panel panel-default col-md-5 col-md-offset-1">
                <div class="panel-heading">
                    <h3 class="dashboard-comment-title">Pending Comments</h3>
                </div>
                <div class="panel-body" style="max-height: 300px">
                    <table class="table table-striped">
                        <c:forEach var="pendingComment" items="${pcList}">
                            <tr>
                                <td><a href="editComment/${pendingComment.commentId}">${pendingComment.commentId} </a></td>
                            </tr>
                        </c:forEach>
                    </table> 

                </div>
            </div>
        </div>
        <div class="row">
            <div class="panel panel-default  col-md-5">
                <div class="panel-heading">
                    <h3 class="dashboard-page-title">Static Pages</h3>
                </div>
                <div class="panel-body" style="max-height: 300px">
                    <table class="table table-striped">
                        <c:forEach var="staticPage" items="${spList}">
                            <tr>
                                <td><a href="editPage/${staticPage.pageId}">${staticPage.title} </a></td>
                            </tr>
                        </c:forEach>
                    </table> 


                </div>
            </div>
            <div class="panel panel-default col-md-5 col-md-offset-1">
                <div class="panel-heading">
                    <h3 class="dashboard-category-title">Categories</h3>
                </div>
                <div class="panel-body" style="max-height: 300px">
                    <table class="table table-striped">
                        <c:forEach var="category" items="${catList}">
                            <tr>
                                <td><a href="editPage/${category.categoryId}">${category.categoryName} </a></td>
                            </tr>
                        </c:forEach>
                    </table> 

                </div>
            </div>
        </div>
    </div>    

</body>
</html>
