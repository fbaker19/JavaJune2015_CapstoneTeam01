/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function clearEditErrorMsg() {
    $('#editValidationErrors').empty();
}

function clearAddErrorMsg() {
    $('#validationErrors').empty();
    
}
var projectRoot = $("#projectRoot").val();
$(document).ready(function () {


    // BOSS DASHBOARD
    $("#save-post-button").unbind("click");
    $("#save-post-button").click(function (e) {
        console.log("GOT HERE SAVE FIRST");
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
                userId: $("#post-user-id").val(),
                hashtag1: $("#hashtag1").val(),
                hashtag2: $("#hashtag2").val(),
                hashtag3: $("#hashtag3").val(),
                categoryId: $("#category-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });


    $("#add-category-button").unbind("click");
    $("#add-category-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/addCategory",
            data: JSON.stringify({
                categoryName: $("#category-name").val()

            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        }).success(function (post) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $("#publish-post-button").unbind("click");
    $("#publish-post-button").click(function (e) {
        console.log("GOT HERE PUBLISH FIRST");
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
                userId: $("#post-user-id").val(),
                hashtag1: $("#hashtag1").val(),
                hashtag2: $("#hashtag2").val(),
                hashtag3: $("#hashtag3").val(),
                categoryId: $("#category-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $("#delete-post-button").unbind("click");
    $("#delete-post-button").click(function (e) {
        console.log("GOT HERE DELETE FIRST");
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

        }
        ;

    });

    $("#cancel-post-button").unbind("click");
    $("#cancel-post-button").click(function (e) {
        e.preventDefault();
        window.location = projectRoot + "/bossDashboard";
    });

    $("#add-comment-button").unbind("click");
    $("#add-comment-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/addComment",
            data: JSON.stringify({
                comment: $("#add-comment").val(),
                commenter: $("#commenter").val(),
                postId: $("#post-id").val(),
                published: 0,
                pending: 1,
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            $("#commentModal").modal();
            $("#add-comment").val("");
            $("#commenter").val("");
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });


    $("#save-page-button").unbind("click");
    $("#save-page-button").click(function (e) {
        console.log("GOT HERE SAVE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/savePage",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                title: $("#page-title").val(),
                pageId: $("#page-id").val(),
                date: $("#page-date").val(),
                published: 0,
                userId: $("#page-user-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $("#publish-page-button").unbind("click");
    $("#publish-page-button").click(function (e) {
        console.log("GOT HERE PUBLISH FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/publishPage",
            data: JSON.stringify({
                content: tinyMCE.activeEditor.getContent(),
                title: $("#page-title").val(),
                pageId: $("#page-id").val(),
                date: $("#page-date").val(),
                published: 1,
                userId: $("#page-user-id").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $("#delete-page-button").unbind("click");
    $("#delete-page-button").click(function (e) {
        console.log("GOT HERE DELETE FIRST");
        var pageId = $("#page-id").val();//element.data("post-id");
        var answer = confirm("Do you really want to delete this page?");
        if (answer === true) {
            $.ajax({
                type: "DELETE",
                url: projectRoot + "/deletePage/" + pageId,
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

        }
        ;

    });

    $("#cancel-page-button").unbind("click");
    $("#cancel-page-button").click(function (e) {
        e.preventDefault();
        window.location = projectRoot + "/bossDashboard";
    });

    $("#add-comment-button").unbind("click");
    $("#add-comment-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/addComment",
            data: JSON.stringify({
                comment: $("#add-comment").val(),
                commenter: $("#commenter").val(),
                postId: $("#post-id").val(),
                published: 0,
                pending: 1,
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            $("#commentModal").modal();
            $("#add-comment").val("");
            $("#commenter").val("");
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });



    $("#editCommentModal").on("show.bs.modal", function (event) {
        var element = $(event.relatedTarget);
        var commentId = element.data("comment-id");
        var modal = $(this);

        $.ajax({
            type: "GET",
            url: projectRoot + "/comment/" + commentId
        }).success(function (comment) {
            modal.find("#post-id").val(comment.postId);
            modal.find("#comment-id").text(comment.commentId);
            modal.find("#comment-create-date").text(comment.createDate);
            modal.find("#comment-commenter").text(comment.commenter);
            modal.find("#comment-comment").text(comment.comment);
        });
    });

    $("#delete-comment-button").unbind("click");
    $("#delete-comment-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        var commentId = $("#comment-id").text();//element.data("post-id");
        var answer = confirm("Do you really want to delete this comment?");
        if (answer === true) {
            $.ajax({
                type: "DELETE",
                url: projectRoot + "/deleteComment/" + commentId,
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
        }
        ;
    });

    $("#publish-comment-button").unbind("click");
    $("#publish-comment-button").click(function (e) {
        console.log("GOT HERE FIRST");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: projectRoot + "/publishComment",
            data: JSON.stringify({
                commentId: $("#comment-id").text(),
                comment: $("#comment-comment").text(),
                postId: $("#post-id").val(),
                createDate: $("#comment-create-date").text(),
                commenter: $("#commenter").text(),
                published: 1,
                pending: 0
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status) {
            window.location = projectRoot + "/bossDashboard";
            console.log("GOT HERE");

        }).error(function (data, jqXHR, textStatus, errorThrown) {
            clearAddErrorMsg();
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });



});
