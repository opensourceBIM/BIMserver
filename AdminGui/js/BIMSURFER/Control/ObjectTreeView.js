BIMSURFER.Control.ObjectTreeView = BIMSURFER.Class(BIMSURFER.Control,
{
	CLASS: "BIMSURFER.Control.ObjectTreeView",
	showCheckboxes: true,

	projectHtml: null,

	__construct: function(div) {
		if(typeof div == 'string') {
			this.div = jQuery(document).find('div#' + div)[0] || null;
		} else if(jQuery(div).is('div')) {
			this.div = div;
		}

		this.events = new BIMSURFER.Events(this);

		//this.projectHtml = '<li id="{ID}"
	},

	redraw: function()
	{
		jQuery(this.div).empty();
		jQuery(this.DOMelement).remove();
		var classIdPrefix = this.CLASS.replace(/\./g,"-");
		this.DOMelement = jQuery('<ul />').addClass(classIdPrefix);
		if(this.active)
		{
			jQuery(this.div).append(this.DOMelement);

			var relationships = this.SYSTEM.scene.data.relationships;
			var showCheckboxes = this.showCheckboxes;

			function drawRelationships(objects, relationship) {
				if(objects == null || objects.length == 0) {
					return null;
				}

				var div = jQuery('<div />');
				jQuery('<span />').text(relationship).appendTo(div);
				var list = jQuery('<ul />').appendTo(div);

				for(var i = 0; i < objects.length; i++) {
					jQuery(list).append(drawObject(objects[i]));
				}
				return div;
			}

			function drawObject(object) {
				var li = jQuery('<li />');
				var div = jQuery('<div />').appendTo(li);
				if(showCheckboxes) {
					jQuery('<span />').append(jQuery('<input />').attr('type', 'checkbox').attr('checked', 'checked')).appendTo(div);
				}
				jQuery('<span />').text(object.name).appendTo(div);
				jQuery('<span />').text('(' + object.type + ')');

				jQuery(li).append(drawRelationships(object.decomposedBy, 'Decomposed by'));
				jQuery(li).append(drawRelationships(object.definedBy, 'Defined by'));
				jQuery(li).append(drawRelationships(object.contains, 'Contains'));
				return li;
			}

			function drawProject(project) {
				var projLi = jQuery('<li />').attr('id', classIdPrefix + '-project-' + project.id).addClass( + '-project');
				jQuery('<div />').appendTo(projLi)
					.append(jQuery('<span />').addClass(classIdPrefix + '-project-name').text(project.name))
					.append(jQuery('<span />').addClass(classIdPrefix + '-project-type').text('(' + project.type + ')'));

				jQuery(projLi).append(drawRelationships(project.decomposedBy, 'Decomposed by'));
				jQuery(projLi).append(drawRelationships(project.definedBy, 'Defined by'));
				jQuery(projLi).append(drawRelationships(project.contains, 'Contains'));

				return projLi;
			}

			for(var i = 0; i < this.SYSTEM.scene.data.relationships.length; i++) {
				var project = this.SYSTEM.scene.data.relationships[i];

				jQuery(this.DOMelement).append(drawProject(project));

/*

		ifcRelationships = function(type, rel, indent) {
			var html, obj, _i, _len;
			if ((rel != null) && rel.length > 0) {
				indent = Math.min(indent + 1, 6);
				html = "<ul class='controls-tree'>";
				html += "<div class='controls-tree-heading'><hr><h4>" + type + "</h4></div>";
				for (_i = 0, _len = rel.length; _i < _len; _i++) {
					obj = rel[_i];
					html += ifcObjectDescription(obj, indent);
				}
				return html += "</ul>";
			} else {
				return "";
			}
		};
ifcObjectDescription = function(obj, indent) {
			return "<li class='controls-tree-rel' id='" + obj.id + "'><div class='controls-tree-item'><span class='indent-" + String(indent) + "'/>"
					+ "<input type='checkbox' checked='checked'> " + obj.name + "<span class='controls-tree-postfix'>(" + obj.type + ")</span></div>"
					+ (ifcDefinedBy(obj.decomposedBy, indent)) + (ifcDefinedBy(obj.definedBy, indent)) + (ifcContains(obj.contains, indent)) + "</li>";
		};
		ifcProject = function(obj) {
			return "<li class='controls-tree-root' id='" + obj.id + "'><div class='controls-tree-item'>" + obj.name + "<span class='controls-tree-postfix'>(" + obj.type
					+ ")</span></div>" + (ifcDefinedBy(obj.decomposedBy, 0)) + (ifcDefinedBy(obj.definedBy, 0)) + (ifcContains(obj.contains, 0)) + "</li>";
		};
*/




			}
		}
		return this;
	}
});