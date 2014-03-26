function Tree(selector) {
	var o = this;
	
	o.idToNodeMap = {};
	o.rootNode = new Node(-1);
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

function Node(id, title) {
	var o = this;
	o.id = id;
	o.title = title;
	o.isOpen = false;
	o.parent = null;
	o.children = [];

	this.add = function(node){
		node.parent = o;
		if (!o.children.length > 0) {
			o.img.addClass("treenodeclosed");
		}
		o.children.push(node);
		o.img.show();
		node.tree = o.tree;
		node.tree.idToNodeMap[node.id] = node;
		o.ul.append(node.li);
	};
	
	this.click = function(click){
		o.onClick = click;
	};
	
	this.open = function(){
		o.isOpen = true;
		o.ul.show();
		if (o.children.length > 0) {
			o.img.removeClass("treenodeclosed");
			o.img.addClass("treenodeopen");
		}
	};
	
	this.close = function(){
		o.isOpen = false;
		o.ul.hide();
		if (o.children.length > 0) {
			o.img.removeClass("treenodeopen");
			o.img.addClass("treenodeclosed");
		}
	};

	this.openRecursive = function(){
		o.open();
		if (o.parent != null) {
			o.parent.openRecursive();
		}
	};
	
	this.select = function(){
		if (o.tree.selectedNode != null) {
			o.tree.selectedNode.unselect();
		}
		o.tree.setSelectedNode(o);
		o.li.addClass("selected");
	};

	this.unselect = function(){
		o.tree.selectedNode = null;
		o.li.removeClass("selected");
	};
	
	this.hint = function(hint) {
		o.a.attr("title", hint);
	};
	
	this.setTitle = function(title){
		o.a.html(title);
	};
	
	this.hide = function(){
		o.li.hide();
	};
	
	this.setLoading = function(){
		o.img.addClass("loading");
	};
	
	this.doneLoading = function(){
		o.img.removeClass("loading");
	};
	
	this.toggle = function(){
		if (o.isOpen) {
			o.close();
		} else {
			o.open();
		}
	};

	this.findFirstParentWithAttr = function(attrName){
		if (o[attrName] != null) {
			return o;
		}
		if (o.parent != null) {
			return o.parent.findFirstParentWithAttr(attrName);
		} else {
			return null;
		}
	};

	this.remove = function(){
		removeA(o.parent.children, o);
		if (o.parent.children.length == 0) {
			o.parent.img.removeClass("treenodeopen");
			o.parent.img.removeClass("treenodeclosed");
		}
		o.tree.remove(o);
		o.li.remove();
	};
	
	this.addButton = function(button){
		o.div.after(button);
	};
	
	o.li = $("<li class=\"treenode\">");
	o.li.attr("nodeid", id);
	o.div = $("<div class=\"treelabel\">");
	o.a = $("<a>" + title + "</a>");
	o.img = $("<div class=\"treeicon\"/>");
	o.img.click(o.toggle);
	o.li.append(o.img);
	o.div.append(o.a);
	o.li.append(o.div);
	o.ul = $("<ul>");
	o.ul.hide();
	o.li.append(o.ul);

	o.a.click(function(){
		if (o.onClick != null) {
			o.onClick(o);
			o.toggle();
			o.select();
		}
	});
}