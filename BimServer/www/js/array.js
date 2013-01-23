if ( !Array.prototype.forEach ) {
  Array.prototype.forEach = function(fn, scope) {
    for(var i = 0, len = this.length; i < len; ++i) {
      fn.call(scope, this[i], i, this);
    }
  }
}

if ( !Array.prototype.forEachAndSelf ) {
	  Array.prototype.forEachAndSelf = function(self, fn, scope) {
	    for(var i = 0, len = this.length; i < len; ++i) {
	      fn.call(scope, this[i], i, this);
	    }
	    fn.call(scope, self, i, this);
	  }
	}