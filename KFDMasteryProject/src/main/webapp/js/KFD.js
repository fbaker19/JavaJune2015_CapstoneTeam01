/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    $("#save-post-button").on("click", function (e){
        console.log("GOT HERE FIRST");
        //e.preventDefault();
        $.ajax({
            type: "POST",
            url: "savePost",
            data: JSON.stringify({
                content: $("#mceu_45").val()
            }),
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }//,
            //dataType: "json"
        }).success(function (data, status){
            $("#mceu_45").val("");
            window.location = "bossDashboard";
            console.log("GOT HERE");
                    
        }).error(function(jqXHR,  textStatus,  errorThrown ){
            console.log(jqXHR);
                        console.log(textStatus);

            console.log(errorThrown);

        });
    });
    
    });
    