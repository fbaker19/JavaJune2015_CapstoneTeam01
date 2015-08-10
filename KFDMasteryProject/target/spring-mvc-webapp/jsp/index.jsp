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
        <div class="row col-lg-offset-11">
            <a data-toggle="modal" href="#myModal" >Sign In</a>


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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/#">About</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/#">Contact Us</a></li>
                </ul>    
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${currentPost.title}</h3>
                </div>
                <div class="panel-body">
                    ${currentPost.content}
                </div>
            </div>

            <div class="panel panel-default col-md-6">
                <div class="panel-heading">
                    <h3 class="panel-title">Schedule of Events</h3>
                </div>
                <div class="panel-body">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac enim cursus augue aliquet convallis nec sed velit. Ut vulputate venenatis massa, vel tincidunt elit vehicula sit amet. Donec tincidunt accumsan maximus. Aliquam convallis rhoncus augue eget suscipit. Ut elementum ante a erat efficitur posuere. Curabitur ut posuere dolor, at placerat risus. Vivamus quis tincidunt purus. Sed imperdiet quis neque non tristique.

                    Nulla ut nisi urna. Nulla consequat fringilla efficitur. Vestibulum quis diam faucibus, condimentum est a, vestibulum augue. Mauris luctus tempus mollis. Cras eu sodales sem, a congue diam. Vestibulum vehicula blandit neque at ornare. Aenean suscipit augue quis mi consectetur, eget lobortis metus eleifend. Ut consectetur luctus urna, a lacinia urna tincidunt nec. Vestibulum pretium pharetra augue, sit amet malesuada felis sodales in.

                </div>
            </div>
            <div class="panel panel-default col-md-6">
                <div class="panel-heading">
                    <h3 class="panel-title">Upcoming Events</h3>
                </div>
                <div class="panel-body">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac enim cursus augue aliquet convallis nec sed velit. Ut vulputate venenatis massa, vel tincidunt elit vehicula sit amet. Donec tincidunt accumsan maximus. Aliquam convallis rhoncus augue eget suscipit. Ut elementum ante a erat efficitur posuere. Curabitur ut posuere dolor, at placerat risus. Vivamus quis tincidunt purus. Sed imperdiet quis neque non tristique.

                    Nulla ut nisi urna. Nulla consequat fringilla efficitur. Vestibulum quis diam faucibus, condimentum est a, vestibulum augue. Mauris luctus tempus mollis. Cras eu sodales sem, a congue diam. Vestibulum vehicula blandit neque at ornare. Aenean suscipit augue quis mi consectetur, eget lobortis metus eleifend. Ut consectetur luctus urna, a lacinia urna tincidunt nec. Vestibulum pretium pharetra augue, sit amet malesuada felis sodales in.

                </div>
            </div>


        </div>
</div>
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="signIn" method="POST">
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
                            <button type="submit" id="login-button" class="btn btn-default" onclick="window.open("${pageContext.request.contextPath}/jsp/bossDashboard", "_blank";)">Sign In</button>
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

</body>
</html>


