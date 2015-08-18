/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var projectRoot = $("#projectRoot").val();
$(document).ready(function () {
 
    // BOSS DASHBOARD
$("#save-post-button").unbind("click");
    $("#save-post-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/savePost",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val(),
                postId: $("#post-id").val(),
                blurb: $("#post-blurb").val(),
                createDate: $("#post-create-date").val(),
                lastModifiedDate: $("#post-last-modified-date").val(),
                published: 0,
                pending: 1,
                lastModifiedUserId: $("#post-last-modified-user-id").val(),
                userId: $("#post-user-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });
    
$("#edit-post").unbind("click");
$("#edit-post").click(function (e) {
        console.log("GOT HERE FIRST");
        var element = $(event.relatedTarget);
        var postId = element.data("post-id");
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: projectRoot + "/addPost/" + postId,
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val(),
                postId: $("#post-id").val()
            }),
            
        }).success(function (post) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });
    
$("#publish-post-button").unbind("click");
$("#publish-post-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/publishPost",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val(),
                postId: $("#post-id").val(),
                blurb: $("#post-blurb").val(),
                createDate: $("#post-create-date").val(),
                lastModifiedDate: $("#post-last-modified-date").val(),
                published: 1,
                pending: 0,
                lastModifiedUserId: $("#post-last-modified-user-id").val(),
                userId: $("#post-user-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });
    
$("#delete-post-button").unbind("click");
$("#delete-post-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        var postId = $("#post-id").val();//element.data("post-id");
        var answer = confirm("Do you really want to delete this blog post?");
    if (answer === true) {
        $.ajax({
            type: "DELETE",
            url: projectRoot + "/deletePost/" + postId,
         
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    
        };

        });

$("#cancel-post-button").unbind("click");
$("#cancel-post-button").click( function (e){
    e.preventDefault();
    window.location = projectRoot + "/bossDashboard";
});




//EMPLOYEE DASHBOARD EMPLOYEE DASHBOARD EMPLOYEE DASHBOARD EMPLOYEE DASHBOARD EMPLOYEE DASHBOARD EMPLOYEE DASHBOARD

$("#save-post-button").unbind("click");
    $("#save-post-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/savePost",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val(),
                postId: $("#post-id").val(),
                blurb: $("#post-blurb").val(),
                createDate: $("#post-create-date").val(),
                lastModifiedDate: $("#post-last-modified-date").val(),
               // published: 0,
                pending: 1,
                lastModifiedUserId: $("#post-last-modified-user-id").val(),
                userId: $("#post-user-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/employeeDash";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });
    
$("#edit-post").unbind("click");
$("#edit-post").click(function (e) {
        console.log("GOT HERE FIRST");
        var element = $(event.relatedTarget);
        var postId = element.data("post-id");
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: projectRoot + "/addPostEmp/" + postId,
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val(),
                postId: $("#post-id").val()
            }),
            
        }).success(function (post) {
            window.location = projectRoot + "/employeeDash";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });
$("#delete-post-button").unbind("click");
$("#delete-post-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        var postId = $("#post-id").val();//element.data("post-id");
        var answer = confirm("Do you really want to delete this blog post?");
    if (answer === true) {
        $.ajax({
            type: "DELETE",
            url: projectRoot + "/deletePost/" + postId,
         
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/employeeDash";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    
        };

        });

$("#cancel-post-button").unbind("click");
$("#cancel-post-button").click( function (e){
    e.preventDefault();
    window.location = projectRoot + "/employeeDash";
});


});    