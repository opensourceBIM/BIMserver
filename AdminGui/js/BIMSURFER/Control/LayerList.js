BIMSURFER.Control.LayerList = BIMSURFER.Class(BIMSURFER.Control,
{
	CLASS: "BIMSURFER.Control.LayerList",
	showCheckboxes: true,
	autoDraw: true,

	redraw: function()
	{
		jQuery(this.div).empty();
		jQuery(this.DOMelement).remove();
		var controlClass = this.CLASS.replace(/\./g,"-");
		this.DOMelement = jQuery('<ul />').addClass(controlClass);
		if(this.active)
		{
			jQuery(this.div).append(this.DOMelement);

			for(var i = 0; i < this.SYSTEM.loadedProjects.length; i++) {
				var project = this.SYSTEM.loadedProjects[i];
				var projectLi = jQuery('<li />').addClass(controlClass + '-Project');
				jQuery('<span />').addClass(controlClass + '-Project-Title').text(project.name).appendTo(projectLi);
				var projectUl = jQuery('<ul />').addClass(controlClass + '-Revisions').appendTo(projectLi);

				for(var x = 0; x < project.loadedRevisions.length; x++) {
					var revision = project.loadedRevisions[x];
					var revisionLi = jQuery('<li />').addClass(controlClass + '-Revision');
					if(project.loadedRevisions.length > 1) {
						jQuery('<span />').addClass(controlClass + '-Revision-Title').text(revision.comment).appendTo(revisionLi);
					}
					var revisionUl = jQuery('<ul />').addClass(controlClass + '-ifcTypes').appendTo(revisionLi);

					for(var y = 0; y < revision.ifcTypes.length; y++) {
						var ifcType = revision.ifcTypes[y];
						var typeLi = jQuery('<li />').addClass(controlClass + '-ifcType');
						var label = jQuery('<label />').addClass(controlClass + '-ifcType-Label').appendTo(typeLi);

						if(this.showCheckboxes) {
							var _this = this;
							var checkbox = jQuery('<input />')
													.attr('type', 'checkbox')
													.attr('name', controlClass + '-' + project.oid + '-' + revision.oid + '-' + ifcType)
													.addClass(controlClass + '-ifcType-Checkbox')
													.data('ifcType', ifcType)
													.data('revision', revision)
													.change(function() {
															if(jQuery(this).is(':checked')) {
																_this.SYSTEM.showType(jQuery(this).data('ifcType'), jQuery(this).data('revision'));
															} else {
																_this.SYSTEM.hideType(jQuery(this).data('ifcType'), jQuery(this).data('revision'));
															}
													});
							jQuery('<span />').addClass(controlClass + '-ifcType-checkboxContainer').append(checkbox).appendTo(label);
							if(revision.visibleTypes.indexOf(ifcType.toLowerCase()) > -1) {
								jQuery(checkbox).attr('checked', 'checked');
							}
						}

						jQuery('<span />').addClass(controlClass + '-ifcType-Name').text(ifcType).appendTo(label);
						jQuery(typeLi).appendTo(revisionUl);
					}
					jQuery(revisionLi).appendTo(projectUl);
				}

				jQuery(projectLi).appendTo(this.DOMelement);
			}
		}
		return this;
	},
	initEvents: function() {
		if(!this.SYSTEM) { return; }

		if(this.active) {
			var _this = this;
			this.SYSTEM.events.register('revisionSceneLoaded', function() {
				if(_this.autoDraw) { _this.redraw(); }
			});

			this.SYSTEM.events.register('tagMaskUpdated', function() {
				if(_this.autoDraw) { _this.redraw(); }
			});
		}
	}
});