(function () {

    SceneJS.Types.addType("assembly/model", {

        construct:function (params) {

            // Create child nodes

            var node = this;

            if (params.nodes) {
                node.addNodes(params.nodes);
                params.nodes = [];
            }

            this._objects = {};
            this._libraries = {};
        },

        setVisible: function(visible) {
        },

        setSelected: function(selected) {
        },

        _registerLibrary:function (library) {
            this._libraries[library.getId()] = library;
        },

        _deregisterLibrary:function (library) {
            delete this._libraries[library.getId()];
        },

        _registerObject:function (object) {
            this._objects[object.getId()] = object;
        },

        _deregisterObject:function (object) {
            delete this._objects[object.getId()];
        }
    });


})();