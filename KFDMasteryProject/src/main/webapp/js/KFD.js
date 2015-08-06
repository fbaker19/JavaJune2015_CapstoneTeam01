/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function  fillBlog(postList, status) {
    //clearContactTable();
    var pBlurb = $("#postBlurb");
    var pTitle = $("#postTitle");
    var pFooter = $("#postFooter");
    $.each(postList, function (index, contact)
    {
        pTitle.append($("<tr>")
                .append($("<td>").append($("<a>")
                        .attr({
                            "data-post-id": post.postId,
                            "data-toggle": "modal",
                            "data-target": "#postModal"
                        })
                        .text(post.title))));
        pBlurb.append($("<tr>")
                .append($("<td>").text(post.content)));
        pFooter.append($("<tr>")
                .append($("<td>").text("Comments (" + comments.length + ")")
                        ));
    });
}
