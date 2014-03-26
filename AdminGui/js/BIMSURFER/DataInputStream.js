"use strict"

/**
 * Class: BIMSURFER.DataInputStreamReader
 * Class to read binary data from the BIMServer
 */
BIMSURFER.DataInputStreamReader = BIMSURFER.Class({
	CLASS: 'BIMSurfer.DataInputStreamReader',
	SYSTEM: null,

	arrayBuffer: null,
	dataView: null,
	pos: null,

	__construct: function(system, arrayBuffer) {
		this.arrayBuffer = arrayBuffer;
		this.dataView = new DataView(this.arrayBuffer);
		this.pos = 0;
	},

	readUTF8: function() {
		var length = this.dataView.getInt16(this.pos);
		this.pos += 2;
		var view = this.arrayBuffer.slice(this.pos, this.pos + length);
		var result = new StringView(view).toString();
		this.pos += length;
		return result;
	},

	align4: function() {
		// Skips to the next alignment of 4 (source should have done the same!)
		var skip = 4 - (this.pos % 4);
		if(skip > 0 && skip != 4) {
			this.pos += skip;
		}
	},

	readFloat: function() {
		var value = this.dataView.getFloat32(this.pos);
		this.pos += 4;
		return value;
	},

	readInt: function() {
		var value = this.dataView.getInt32(this.pos);
		this.pos += 4;
		return value;
	},

	readByte: function() {
		var value = this.dataView.getInt8(this.pos);
		this.pos += 1;
		return value;
	},

	readLong: function() {
		// We are throwing away the first 4 bytes here...
		var value = this.dataView.getInt32(this.pos + 4);
		this.pos += 8;
		return value;
	},

	readFloatArray: function(length) {
		var result = new Float32Array(this.arrayBuffer, this.pos, length);
		this.pos += length * 4;
		return result;
	}
});