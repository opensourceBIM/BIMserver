"use strict"

/**
 * Class: BIMSURFER.Server
 * Manages the connection to a BIMServer
 */
BIMSURFER.Server = BIMSURFER.Class({
	CLASS: 'BIMSURFER.Server',
	SYSTEM: null,

	url: null,
	username: null,
	password: null,
	rememberMe: null,
	server: null,
	events:null,
	connectionStatus: null,
	loginStatus: null,
	projects: null,
	serializers: new Array(),


	/**
	 * @constructor
	 * @param {BIMSURFER.Viewer instance} system The viewer instance
	 * @param {string} url The server URL
	 * @param {string} username The server username
	 * @param {String} password The server password
	 * @param {Boolean} [rememberMe] Remember Default = false
	 * @param {Boolean} [autoConnect] Automatically connect to the server? Default = true
	 * @param {Boolean} [autoLogin] Automatically login to the server after auto connecting? Default = true
	 * @param {Function} [autoLoginCallback] Callback function that will be called after auto login
	 */
	__construct: function(system, bimServerApi) {
		this.SYSTEM = system;

		this.events = new BIMSURFER.Events(this);
	},

	/**
	 * Gets project by OID
	 *
	 * @param {Number} oid The OID of the project
	 * @return {BIMSURFER.Project instance} The Project object or null
	 */
	 getProjectByOid: function(oid) {
		for(var i = 0; i < this.projects.length; i++) {
			if(this.projects[i].oid == oid) {
				return this.projects[i];
			}
		}
		return null;
	 }

});
