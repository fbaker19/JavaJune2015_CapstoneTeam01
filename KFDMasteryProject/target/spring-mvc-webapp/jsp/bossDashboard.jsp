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
                <li role="presentation"><a href="${pageContext.request.contextPath}/#">About</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/#">Contact Us</a></li>
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/bossDashboard">Dashboard</a></li>
            </ul>    
        </div>
        <div class="row">
           
            <div class="panel panel-default  col-md-5">
                
                <div class="panel-heading">
                    <h3 class="dashboard-blog-title">Pending Blog Posts</h3>
<<<<<<< HEAD
=======

>>>>>>> 72b9054319e9e9266961b4a5e329be7bdd7b6fd9
                </div>
               
                
                <div class="panel-body" style="max-height: 300px">
                    <table class="table table-striped">
                        <c:forEach var="pendingPost" items="${ppList}">
                            <tr>
                                <td><a href="addPost/${pendingPost.postId}">${pendingPost.title} </a></td>
                            </tr>
                        </c:forEach>
                    </table> 
                </div>
                <div class="panel-footer">
                    <ul>
                        <li class="btn btn-default col-md-offset-8">
                            <a href="addPost">Add New Post</a>
                        </li>
                    </ul> 
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
                                <td><a data-toggle="modal" href="#editCommentModal" data-comment-id="${pendingComment.commentId}">${pendingComment.commentId} </a></td>
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
                <div class="panel-footer">
                    <ul>
                        <li class="btn btn-default col-md-offset-8">
                            <a href="addPage">Add New Page</a>
                        </li>
                    </ul>
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

    <!-- Modal -->
    <div class="modal fade" id="editCommentModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    
                    <h4 class="modal-title">
                        
                        <table class="table table"></table>
                        <tr>
                            <td><label id="comment-id"></label></td>, 
                            <td><label id="comment-create-date"></label></td>,
                            <td><label id="comment-commenter"></label></td>
                        </tr>
                    </h4>
                </div>
                <div class="modal-body">
                    <p id="comment-comment"></p>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="publish-comment-button" class="btn btn-default">Publish</button>
                    <button type="submit" id="delete-comment-button" class="btn btn-default">Delete</bu
                    tton>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>   
                
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/KFD.js"></script>
    <script src="${pageContext.request.contextPath}/js/tinymce.js"></script>

</body>
</html>
