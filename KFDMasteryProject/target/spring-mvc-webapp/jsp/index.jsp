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
<body style="background-image:url(img/background1.jpg)">

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
                <h3 class="panel-title">Latest Blog Entry</h3>
            </div>
            <div class="panel-body">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac enim cursus augue aliquet convallis nec sed velit. Ut vulputate venenatis massa, vel tincidunt elit vehicula sit amet. Donec tincidunt accumsan maximus. Aliquam convallis rhoncus augue eget suscipit. Ut elementum ante a erat efficitur posuere. Curabitur ut posuere dolor, at placerat risus. Vivamus quis tincidunt purus. Sed imperdiet quis neque non tristique.

                Nulla ut nisi urna. Nulla consequat fringilla efficitur. Vestibulum quis diam faucibus, condimentum est a, vestibulum augue. Mauris luctus tempus mollis. Cras eu sodales sem, a congue diam. Vestibulum vehicula blandit neque at ornare. Aenean suscipit augue quis mi consectetur, eget lobortis metus eleifend. Ut consectetur luctus urna, a lacinia urna tincidunt nec. Vestibulum pretium pharetra augue, sit amet malesuada felis sodales in.

                Integer et ipsum et purus aliquam tristique. Aliquam sed mauris imperdiet, fermentum nisi ac, consectetur justo. Nam non nisl sed nulla sollicitudin pellentesque placerat at turpis. Morbi facilisis metus eget mattis accumsan. Donec tristique efficitur egestas. In hac habitasse platea dictumst. Cras ac lorem sem. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque rhoncus ex nec mi faucibus pretium. Phasellus quis vehicula augue. Vivamus bibendum, arcu a laoreet dictum, odio dolor malesuada neque, a faucibus enim ligula at lacus. Cras quam libero, maximus et lacinia ac, feugiat sit amet metus.

                Aliquam interdum, dolor non finibus convallis, tortor risus maximus risus, non dictum nulla ex et sem. Sed nec congue nulla. Integer sit amet mi in augue aliquam scelerisque. Sed posuere ligula vel nulla venenatis, sit amet pretium sapien aliquet. Nullam ut lacus volutpat, viverra odio ut, porta justo. Nulla lacinia mauris ligula, varius porta augue molestie sit amet. Ut sem urna, malesuada at est eget, consequat rutrum nisl. Maecenas sit amet nunc vehicula, ultricies elit ac, pulvinar ex. Pellentesque iaculis purus quis est feugiat, a feugiat diam feugiat. Duis eget tristique augue, vitae porttitor metus. Nulla id dignissim leo, ut faucibus nisl.
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




    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>


