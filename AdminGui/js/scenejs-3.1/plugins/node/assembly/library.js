(function () {

    SceneJS.Types.addType("assembly/library", {

        construct:function (params) {

            // Find container model
            for (var parent = this.parent; parent; parent = parent.parent) {
                if (parent.type == "assembly/model") {
                    parent._registerLibrary(this);
                    this._model = parent;
                    break;
                }
            }

            // Model is mandatory
            if (!this._model) {
                throw "no model found";
            }


            // Create child nodes

            var node = this;

            if (params.nodes) {
                node.addNodes(params.nodes);
                params.nodes = [];
            }

            this._assets = {};
        },

        setVisible:function (visible) {
        },

        setSelected:function (selected) {
        },

        destruct: function() {
            for (var parent = this.parent; parent; parent = parent.parent) {
                if (parent.type == "assembly/model") {
                    parent._deregisterLibrary(this);
                }
            }
        }


    });


})();