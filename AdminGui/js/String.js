if (typeof String.prototype.startsWith != 'function') {
	String.prototype.startsWith = function(str) {
		return this.indexOf(str) == 0;
	};
}

if (typeof String.prototype.firstUpper != 'function') {
	String.prototype.firstUpper = function() {
		return this.substring(0, 1).toUpperCase() + this.substring(1);
	};
}

if (typeof String.prototype.endsWith != 'function') {
	String.prototype.endsWith = function(str) {
		return this.lastIndexOf(str) == this.length - str.length;
	};
}

if (typeof String.prototype.trim !== 'function') {
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, '');
	};
}

if (typeof String.prototype.lpad != 'function') {
	String.prototype.lpad = function(padString, length) {
		var str = this;
		while (str.length < length) {
			str = padString + str;
		}
		return str;
	};
}

if (typeof String.prototype.rpad != 'function') {
	String.prototype.rpad = function(padString, length) {
		var str = this;
		while (str.length < length) {
			str = str + padString;
		}
		return str;
	};
}

if (typeof String.prototype.contains != 'function') {
	String.prototype.contains = function(needle) {
		return this.indexOf(needle) != -1;
	};
}