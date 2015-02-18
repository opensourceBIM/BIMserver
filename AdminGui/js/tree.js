function Tree(selector) {
	var o = this;
	
	o.idToNodeMap = {};
	o.rootNode = Object.create(Node.prototype);
	o.rootNode.init(-1);
	o.selectedNode = null;
	o.selectionListeners = [];

	this.add = function(node){
		o.rootNode.add(node);
	};
	
	this.remove = function(node){
		delete o.idToNodeMap[node.id];
	};
	
	this.find = function(id){
		return o.idToNodeMap[id];
	};
	
	this.setSelectedNode = function(selectedNode){
		o.selectedNode = selectedNode;
		o.selectionListeners.forEach(function(listener){
			listener(selectedNode);
		});
	};

	o.rootNode.tree = o;
	o.idToNodeMap[-1] = o.rootNode;
	var ul = $("<ul>");
	ul.addClass("rootnode");
	selector.append(ul);
	o.rootNode.ul = ul;
}

function Node() {};

Node.prototype.init = function(id, title){
	this.id = id;
	this.title = title;
	this.isOpen = false;
	this.parent = null;
	this.children = [];
	this.sort = false;
	this.onLoadListeners;

	this.li = $("<li class=\"treenode\">");
	this.li.attr("nodeid", id);
	this.div = $("<div class=\"treelabel\">");
	this.a = $("<a>" + title + "</a>");
	this.img = $("<div class=\"treeicon\"/>");
	this.img.click(this.toggle.bind(this));
	this.li.append(this.img);
	this.icon = $("<div class=\"treepreicon\">");
	this.li.append(this.icon);
	this.div.append(this.a);
	this.li.append(this.div);
	this.ul = $("<ul>");
	this.ul.hide();
	this.li.append(this.ul);

	this.a.click(this.linkClick.bind(this));
};

Node.prototype.linkClick = function(){
	if (this.onClick != null) {
		this.onClick(this);
		this.toggle();
		this.select();
	}
};

Node.prototype.getOnLoadListeners = function(){
	if (this.onLoadListeners == null) {
		this.onLoadListeners = new EventRegistry();
	}
	return this.onLoadListeners;
};

Node.prototype.add = function(node){
	node.parent = this;
	node.tree = this.tree;
	node.tree.idToNodeMap[node.id] = node;

	if (this.sort) {
		var found = false;
		for (var i=0; i<this.children.length; i++) {
			var diff = node.title.localeCompare(this.children[i].title);
			if (diff < 0) {
				if (i == 0) {
					this.ul.prepend(node.li);
				} else {
					this.ul.children().eq(i-1).after(node.li);
				}
				found = true;
				break;
			}
		}
		if (!found) {
			this.ul.append(node.li);
		}
	} else {
		this.ul.append(node.li);
	}
	// TODO sync order in array with dom nodes order?
	this.children.push(node);
	
	if (this.isOpen) {
		this.img.addClass("treenodeopen");
	} else {
		this.img.addClass("treenodeclosed");
	}
	this.img.css("display: inline");
};

Node.prototype.setIcon = function(icon){
	this.icon.addClass(icon);
};

Node.prototype.onLoad = function(listener){
	this.getOnLoadListeners().register(listener);
	this.img.addClass("treenodeclosed");
};

Node.prototype.click = function(click){
	this.onClick = click;
};

Node.prototype.open = function(){
	var promise = new Promise();
	this.isOpen = true;
	if (this.onLoadListeners != null) {
		this.onLoadListeners.trigger(function(listener){
			promise.chain(listener());
		});
		this.onLoadListeners.clear();
	}
	this.ul.show();
	if (this.children.length > 0) {
		this.img.removeClass("treenodeclosed");
		this.img.addClass("treenodeopen");
	}
	return promise;
};

Node.prototype.close = function(){
	this.isOpen = false;
	this.ul.hide();
	if (this.children.length > 0) {
		this.img.removeClass("treenodeopen");
		this.img.addClass("treenodeclosed");
	}
};

Node.prototype.openRecursive = function(){
	this.open();
	if (this.parent != null) {
		this.parent.openRecursive();
	}
};

Node.prototype.select = function(){
	if (this.tree.selectedNode != null) {
		this.tree.selectedNode.unselect();
	}
	this.tree.setSelectedNode(this);
	this.li.addClass("selected");
};

Node.prototype.unselect = function(){
	this.tree.selectedNode = null;
	this.li.removeClass("selected");
};

Node.prototype.hint = function(hint) {
	this.a.attr("title", hint);
};

Node.prototype.setTitle = function(title){
	this.a.html(title);
};

Node.prototype.hide = function(){
	this.li.hide();
};

Node.prototype.setLoading = function(){
	this.img.removeClass("treenodeopen");
	this.img.removeClass("treenodeclosed");
	this.img.addClass("loading");
};

Node.prototype.doneLoading = function(){
	this.img.removeClass("loading");
	if (this.children.length > 0) {
		if (this.isOpen) {
			this.img.addClass("treenodeopen");
		} else {
			this.img.addClass("treenodeclosed");
		}
	}			
};

Node.prototype.toggle = function(){
	if (this.isOpen) {
		this.close();
	} else {
		this.open();
	}
};

Node.prototype.findFirstParentWithAttr = function(attrName){
	if (this[attrName] != null) {
		return this;
	}
	if (this.parent != null) {
		return this.parent.findFirstParentWithAttr(attrName);
	} else {
		return null;
	}
};

Node.prototype.remove = function(){
	removeA(this.parent.children, this);
	if (this.parent.children.length == 0) {
		this.parent.img.removeClass("treenodeopen");
		this.parent.img.removeClass("treenodeclosed");
	}
	this.tree.remove(this);
	this.li.remove();
};

Node.prototype.listFilterByType = function(type){
	var result = [];
	this.internalListFilterByType(result, type);
	return result;
};

Node.prototype.list = function(){
	var result = [];
	this.internalList(result);
	return result;
};

Node.prototype.internalList = function(result){
	result.push(this);
	this.children.forEach(function(subNode){
		subNode.internalList(result);
	});
};

Node.prototype.internalListFilterByType = function(result, type){
	if (this.type == type) {
		result.push(this);
	}
	this.children.forEach(function(subNode){
		subNode.internalListFilterByType(result, type);
	});
};

Node.prototype.addButton = function(button){
	this.div.after(button);
};