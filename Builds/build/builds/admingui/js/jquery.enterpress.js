(function( $ ){
  $.fn.enterpress = function(callback) {
	  this.keypress(function(event){
		  if (event.which == 13) {
			  callback.call(this);
			  event.preventDefault();
		  }
	  });
  };
})( jQuery );