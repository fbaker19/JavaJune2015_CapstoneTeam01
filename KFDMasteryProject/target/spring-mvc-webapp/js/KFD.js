/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $("#save-post-button").on("click", function (e) {
        console.log("GOT HERE FIRST");
        //e.preventDefault();
        $.ajax({
            type: "POST",
            url: "savePost",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = "bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });

$("#edit-post").on("click", function (e) {
        console.log("GOT HERE FIRST");
        var element = $(event.relatedTarget);
        var postId = element.data("post-id");
        //e.preventDefault();
        $.ajax({
            type: "GET",
            url: "addPost/" + postId,
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val(),
                postId: $("#post-id").val()
            }),
            
        }).success(function (post) {
            window.location = "../bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });

$("#publish-post-button").on("click", function (e) {
        console.log("GOT HERE FIRST");
        //e.preventDefault();
        $.ajax({
            type: "POST",
            url: "publishPost",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                expDate: $("#exp-date").val(),
                title: $("#post-title").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = "../bossDashboard";
            console.log("GOT HERE");

        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);

        });
    });

});
    