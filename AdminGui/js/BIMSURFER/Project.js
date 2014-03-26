"use strict"

/**
 * Class: BIMSURFER.Project
 * Projects loads all information about the BIMServer projects
 */
BIMSURFER.Project = BIMSURFER.Class({
	CLASS: 'BIMSURFER.Project',
	SYSTEM: null,

	events: null,
	server: null,

	/**
	 * This construct will load all the revision information of the server.
	 *
	 * @constructor
	 * @param {BIMSURFER.Viewer instance} system The viewer instance
	 * @param {Object} serverProject An object with all the project properties
	 * @param {BIMSURFER.Server instance} server The server instance
	 */
	__construct: function(system, serverProject, server) {
		this.SYSTEM = system;

		if(!BIMSURFER.Util.isset(server.CLASS) || server.CLASS !== 'BIMSURFER.Server') {
			console.error('BIMSURFER.Project: No server given');
			return
		}
		this.server = server;

		var _this = this;
		this.server.server.call("Bimsie1ServiceInterface", "getAllRevisionsOfProject", {
			poid : serverProject.oid
		}, function(revisions) {
			_this.revisions = new Array();
			for(var i = 0; i < revisions.length; i++) {
				if(revisions[i].hasGeometry) {
					_this.revisions.push(new BIMSURFER.ProjectRevision(_this.SYSTEM, _this, revisions[i]));
				}
			}
			if(!BIMSURFER.Util.isset(serverProject.lastRevisionId) || _this.revisions.length == 0) {
				console.error('BIMSURFER.Project: Project has no revisions');
				return;
			}
			this.loadedRevisions = new Array();
			
			delete serverProject.revisions;
			jQuery.extend(this, serverProject);
			
			this.events = new BIMSURFER.Events(this);
		});
	},

	/**
	 * Loads the scene of a revision
	 *
	 * @param {BIMSURFER.ProjectRevision instance} [revision] The revision (Default = last revision)
	 * @param {Boolean} [autoShow] Automatically load and show the geometries (Default = false)
	 */
	loadScene: function(revision, autoShow) {
		if(this.scene != null) {
			return;
		}

		var _this = this;
		var autoShowFunction = function(revision) {
			if(!autoShow) {
				return;
			}
			var revisionSceneLoaded = function() {
				_this.events.unregister('revisionSceneLoaded', revisionSceneLoaded);
				var scene = this.scene;
				if(scene == null)
				{
					console.error('Could not load project revision scene');
					return;
				}
				if(this.SYSTEM.loadScene(this)) {
					var toLoad = [];
					for(var i = 0; i < this.ifcTypes.length; i++) {
						if(BIMSURFER.Constants.defaultTypes.indexOf(this.ifcTypes[i]) != -1) {
							toLoad.push(this.ifcTypes[i]);
						}
					}
					if (toLoad.length > 0) {
						this.SYSTEM.loadQueue.push({revision: this, types: toLoad});
					}
					this.SYSTEM.loadGeometry();
				}
			}
			_this.events.register('revisionSceneLoaded', revisionSceneLoaded);
		}

		if(typeof revision == 'object' && revision != null) {
			if(this.revisions.indexOf(revision) > -1) {
				autoShowFunction(revision);
				revision.loadScene();
			} else {
				console.error('BIMSURFER.Project.looad: This revision ID does not exist in this project');
				return;
			}
		} else {
			if(!BIMSURFER.Util.isset(revision)) {
				revision = this.lastRevisionId;
			}
			var revisionFound = false;
			for(var i = 0; i < this.revisions.length; i++) {
				if(this.revisions[i].oid == revision) {
					revisionFound = true;
					autoShowFunction(this.revisions[i]);
					this.revisions[i].loadScene();
					break;
				}
			}
			if(!revisionFound) {
				console.error('BIMSURFER.Project.looad: This revision ID does not exist in this project');
				return;
			}
		}

	}
});