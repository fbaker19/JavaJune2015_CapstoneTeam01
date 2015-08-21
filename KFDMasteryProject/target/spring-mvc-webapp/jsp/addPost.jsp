<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix ="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

                    <div class="col-lg-5">
                        <div class="input-group">
                            <!--                            <input type="text" class="form-control" aria-label="..." placeholder="Add New Category"/>-->
                            <div class="input-group-btn">
                                <div class ="form-group">
                                    <select id="category-id" class="form-control" name="category" data-select-category="${post.categoryId}">
                                            <option value="" selected="selected">--Select Category--</option>
                                            <c:forEach var="listCategory" items="${catList}">
                                                <option value="${listCategory.categoryId}" >${listCategory.categoryName}</option>
                                            </c:forEach>
                                    </select>
                                </div> 
                            </div><!-- /btn-group -->
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                    <div class="col-lg-2 col-lg-offset-5">
                        <button type="submit" id="save-post-button" class="btn btn-default">Save</button>
                       
                       <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <button type="submit" id="publish-post-button" class="btn btn-default">Publish</button>
                      </sec:authorize>
                        </div>

                </div><!--row-->
                <br/>

                <div class="row">
                    <div class="col-lg-8">
                        <form class="form-inline">
                             
                            <input type="text" id="hashtag1" class="form-control" placeholder="Add Hash Tag" value="${post.hashtag1}"/>
                            <input type="text" id="hashtag2" class="form-control" placeholder="Add Hash Tag" value="${post.hashtag2}"/>
                            <input type="text" id="hashtag3" class="form-control" placeholder="Add Hash Tag" value="${post.hashtag3}"/>
                             
<!--                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Add Tag</button>
                            </span>-->
                        </form><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                    <div class="col-lg-2 col-lg-offset-2">
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
    <script src="${pageContext.request.contextPath}/js/categorySelector.js"></script>

</body>
</html>
