   
   $(document).ready(function () {
	   	  alert('Document Ready, hello!'); 
	   
		  $(".navbar-toggle").on("click", function () {
			    $(this).toggleClass("active");
		  });
		  monitorNavbar();
		  $(window).resize(monitorNavbar);
		  
   });
   

   function monitorNavbar() { 
	      if ($(window).width() < 768) {
	   	   $('#greeting').hide();
	   	} else {
	   		$('#greeting').show();
	   	}
    }

   
      