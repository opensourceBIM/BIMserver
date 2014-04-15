function ReadUTF8(asyncStream, callback) {
	this.state = 0;
	this.length = -1;

	this.process = function(){
		if (this.state == 0) {
			if (asyncStream.available() >= 2) {
				length = asyncStream.dataView.getInt16(asyncStream.pos);
				asyncStream.pos += 2;
				this.state = 1;
			}
		}
		if (this.state == 1) {
			if (asyncStream.available() >= length) {
				var view = asyncStream.arrayBuffer.slice(asyncStream.pos, asyncStream.pos + length);
				var result = new StringView(view).toString();
				asyncStream.pos += length;
				asyncStream.pop();
				if (callback(result) == false) {
					console.log("error");
				}
				return true;
			}
		}
	};
}

function ReadByte(asyncStream, callback) {
	this.process = function(){
		if (asyncStream.available() > 0) {
			var value = asyncStream.dataView.getInt8(asyncStream.pos);
			asyncStream.pos += 1;
			asyncStream.pop();
			if (callback(value) == false) {
				console.log("error");
			}
			return true;
		}
	};
}

function ReadFloatArray(asyncStream, length, callback) {
	this.process = function(){
		asyncStream.align4();
		if (asyncStream.available() >= 4 * length) {
			var result = new Float32Array(asyncStream.arrayBuffer, asyncStream.pos, length);
			asyncStream.pos += length * 4;
			asyncStream.pop();
			if (callback(result) == false) {
				console.log("error");
			}
			return true;
		}
	};
}

function ReadIntArray(asyncStream, length, callback) {
	this.process = function(){
		asyncStream.align4();
		if (asyncStream.available() >= 4 * length) {
			var result = new Int32Array(asyncStream.arrayBuffer, asyncStream.pos, length);
			asyncStream.pos += length * 4;
			asyncStream.pop();
			if (callback(result) == false) {
				console.log("error");
			}
			return true;
		}
	};
}

function ReadInt(asyncStream, callback) {
	this.process = function(){
		if (asyncStream.available() >= 4) {
			var value = asyncStream.dataView.getInt32(asyncStream.pos);
			asyncStream.pos += 4;
			asyncStream.pop();
			if (callback(value) == false) {
				console.log("error");
			}
			return true;
		}
	};
}

function ReadFloats(asyncStream, length, callback) {
	this.process = function(){
		if (asyncStream.available() >= 4 * length) {
			var results = [];
			for (var i=0; i<length; i++) {
				var value = asyncStream.dataView.getFloat32(asyncStream.pos);
				asyncStream.pos += 4;
				results.push(value);
			}
			asyncStream.pop();
			if (callback(results) == false) {
				console.log("error");
			}
			return true;
		}
	};
}

function ReadLong(asyncStream, callback) {
	this.process = function(){
		if (asyncStream.available() >= 4) {
			// We are throwing away the first 4 bytes here...
			var value = asyncStream.dataView.getInt32(asyncStream.pos + 4);
			asyncStream.pos += 8;
			asyncStream.pop();
			if (callback(value) == false) {
				console.log("error");
			}
			return true;
		}
	};
}

function AsyncStream() {
	var othis = this;
	
	othis.arrayBuffer = null;
	othis.dataView = null;
	othis.pos = 4;
	
	othis.todolist = [];
	othis.data = [];
	othis.totalReceived = 0;
	othis.lastTotalReceived = -1;
	othis.stoppedOnMax = false;

	othis.pop = function(){
		othis.todolist.splice(0, 1);
	};
	
	othis.available = function(){
		return othis.arrayBuffer.byteLength - othis.pos;
	};
	
	othis.addReadUTF8 = function(callback){
		othis.todolist.push(new ReadUTF8(othis, callback));
	};
	
	othis.addReadByte = function(callback){
		othis.todolist.push(new ReadByte(othis, callback));
	};
	
	othis.addReadFloatArray = function(length, callback){
		if (length == 0) {
			callback();
		} else {
			othis.todolist.push(new ReadFloatArray(othis, length, callback));
		}
	};

	othis.addReadIntArray = function(length, callback){
		if (length == 0) {
			callback();
		} else {
			othis.todolist.push(new ReadIntArray(othis, length, callback));
		}
	};

	othis.addReadFloats = function(length, callback){
		if (length == 0) {
			callback();
		} else {
			othis.todolist.push(new ReadFloats(othis, length, callback));
		}
	};
	
	othis.addReadInt = function(callback){
		othis.todolist.push(new ReadInt(othis, callback));
	};
	
	othis.addReadLong = function(callback){
		othis.todolist.push(new ReadLong(othis, callback));
	};
	
	othis.align4 = function() {
		// Skips to the next alignment of 4 (source should have done the same!)
		var skip = 4 - (othis.pos % 4);
		if(skip > 0 && skip != 4) {
			othis.pos += skip;
		}
	};
	
	othis.process = function(max){
		var c = 0;
		if (othis.totalReceived == othis.lastTotalReceived && !othis.stoppedOnMax) {
			return;
		}
		othis.lastTotalReceived = othis.totalReceived;
		othis.stoppedOnMax = false;
		while (othis.todolist.length > 0 && othis.data.length > 0) {
			var todoitem = othis.todolist[0];
			var data = othis.data[0];

			othis.arrayBuffer = data;
			othis.dataView = new DataView(othis.arrayBuffer);
			
			var processDone = todoitem.process();
			
			if (data.byteLength == othis.pos) {
				othis.data.splice(0, 1);
				othis.pos = 4;
			}
			if (!processDone) {
				break;
			}
			c++;
			if (c > max) {
				othis.stoppedOnMax = true;
				break;
			}
		}
	};
	
	othis.newData = function(data) {
		othis.data.push(data);
		othis.totalReceived += (data.byteLength - 4);
	};
}