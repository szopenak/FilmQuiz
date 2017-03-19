   
   $(document).ready(function () {
	   
		  $(".navbar-toggle").on("click", function () {
			    $(this).toggleClass("active");
		  });
		  monitorNavbar();
		  $(window).resize(monitorNavbar);

		  $( "#hint ").click(function() {
			  var url = window.location.href + "/hint/?key=" + $("#question-image").attr('src');
			  $.ajax({ 
		            url: url
		        }).then(function(data) {
		          $("#hint-message").text((data));
		        });
			 });
		  
		  $( ".question>button").click(function() {
			  disableAnswers();
			  var pic = $("#question-image").attr('src');
			  var buttonId = $(this).attr('id');
			  var url = window.location.href + "/result/?key=" +pic;
			  $.ajax({ 
		            url: url
		        }).then(function(data) {
		        	
		        	if ($("#"+buttonId).text() != data) {
		        		$("#"+buttonId).css('background-color', 'red');
		        		$("#"+buttonId).css('color', 'white');
		        		
		        		$(".question>button").each(function () {
		        			if($(this).text() == data) {
		        				$(this).css('background-color', 'green');
		        				$(this).css('color', 'white');
		        			}
		        		});
		        		
		        		
		        	} else {
		        		$("#"+buttonId).css('background-color', 'green');
		        		$("#"+buttonId).css('color', 'white');
		        		}
		        });
			 
			 });
		  
		  $( "#next").click(function() {
			  var url = window.location.href + "/next";
			  $.ajax({ 
		            url: url,
		            type : "GET",
		            dataType: "json"
		        }).then(function(data) {
		        	$("#question-image").attr("src",data.url);
		        	$( ".question>button" ).each( function( index, el ) {
		        	    $( el ).text(  decodeURIComponent(escape(data.responses[index])) );
		        	    enableAnswers();
		        	});
		        });
			  monitorPhoto();
			 });
		  	 
		 
		  
   });
   

   function monitorNavbar() { 
	      if ($(window).width() < 768) {
	   	   $('#greeting').hide();
	   	$("#question-image").css('max-height','300px');
	   	  
	   	} else {
	   		$('#greeting').show();
	   		$("#question-image").css('max-height','400px');	
	   	}
    }
   
   function disableAnswers() {
	   $( ".question>button").each( function( index, el ) {
   	    $( el ).attr("disabled", true);
   	});
   }
   function enableAnswers() {
	   $( ".question>button").each( function( index, el ) {
   	    $( el ).attr("disabled", false);
   	    $( el ).css('background-color', "");
   	    $( el ).css('color', '');
   	});
   }
   


   


   
      