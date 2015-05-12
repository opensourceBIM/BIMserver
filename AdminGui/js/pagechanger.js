function PageChanger(navElement, mainContainer) {
	var othis = this;
	othis.current = null;
	
	this.changePage = function(linkElement, page, constructorFunction, callback) {
		if (othis.current != null) {
			if (othis.current.close != null) {
				othis.current.close();
			}
		}
		navElement.find("li").removeClass("active");
		linkElement.addClass("active");
		mainContainer.load(page, function(response, status, xhr) {
			if (status == "error") {
				console.log(msg, xhr.status, xhr.statusText);
			} else {
				othis.current = constructorFunction.call(this);
				othis.current.show();
				if (callback != null) {
					callback.call(othis.current);
				}
			}
		});
	};
}

function TabChanger(navElement, mainContainer) {
	var othis = this;
	othis.current = null;
	othis.currentContentElement = null;
	
	this.changeTab = function(linkElement, page, contentElement, constructorFunction, callback) {
		if (othis.currentContentElement != null && contentElement != null && othis.currentContentElement.get(0) == contentElement.get(0)) {
			othis.current = constructorFunction.call(contentElement);
			return;
		}
		if (othis.current != null) {
			if (othis.current.close != null) {
				othis.current.close();
			}
		}
		navElement.find("li").removeClass("active");
		mainContainer.find("> div").hide();
		linkElement.addClass("active");
		if (page != null) {
			contentElement.load(page, function(response, status, xhr) {
				if (status == "error") {
					console.log(response, xhr.status, xhr.statusText);
				} else {
					othis.current = constructorFunction.call(this);
					contentElement.show();
					if (callback != null) {
						callback.call(othis.current);
					}
				}
			});
		} else {
			othis.current = constructorFunction.call(contentElement);
			contentElement.show();
		}
		othis.currentContentElement = contentElement;
	};
}

function TabChanger2(navElement, mainContainer) {
	var othis = this;
	othis.current = null;
	othis.currentContentElement = null;
	
	this.changeTab = function(linkElement, page, contentElement, constructorFunction, callback) {
		if (othis.currentContentElement != null && contentElement != null && othis.currentContentElement.get(0) == contentElement.get(0)) {
			othis.current = constructorFunction.call(contentElement);
			if (callback != null) {
				callback.call(othis.current);
			}
			return;
		}
		if (othis.current != null) {
			if (othis.current.close != null) {
				othis.current.close();
			}
		}
		linkElement.parent().find("label").removeClass("active");
		linkElement.addClass("active");
		mainContainer.find("> div").hide();
		if (page != null) {
			if (typeof page == "string") {
				contentElement.load(page, function(response, status, xhr) {
					if (status == "error") {
						console.log(response, xhr.status, xhr.statusText);
					} else {
						othis.current = constructorFunction.call(this);
						contentElement.show();
						if (callback != null) {
							callback.call(othis.current);
						}
					}
				});
			} else {
				othis.current = page;
				contentElement.append(page);
				contentElement.show();
				if (callback != null) {
					callback.call(othis.current);
				}
			}
		} else {
			othis.current = constructorFunction.call(contentElement);
			if (callback != null) {
				callback.call(othis.current);
			}
			contentElement.show();
		}
		othis.currentContentElement = contentElement;
	};
}