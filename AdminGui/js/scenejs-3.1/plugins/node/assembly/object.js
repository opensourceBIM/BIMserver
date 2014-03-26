(function () {

    SceneJS.Types.addType("assembly/object", {

        construct:function (params) {

            // Find container model
            for (var parent = this.parent; parent; parent = parent.parent) {
                if (parent.type == "assembly/model") {
                    parent._registerObject(this);
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

            if (params.translate) {
                this.translate = node = node.addNode({
                    type:"translate"
                });
            }

            if (params.scale) {
                this.scale = node = node.addNode({
                    type:"scale",
                    x:1,
                    y:1,
                    z:1
                });
            }

            if (params.rotate) {
                this.rotate = node = node.addNode({
                    type:"rotate",
                    x:1,
                    y:1,
                    z:1,
                    angle:0
                });
            }

            if (params.matrix) {
                this.matrix = node = node.addNode({
                    type:"matrix"
                });
            }

            if (params.material) {
                this.material = node = node.addNode({
                    type:"material",
                    color:{ r:1.0, g:0.6, b:0.6 }
                });
            }

            if (params.name) {
                this.name = node = node.addNode({
                    type:"name",
                    name:params.name
                });
            }

            if (params.nodes) {
                node.addNodes(params.nodes);
                params.nodes = [];
            }

            // Set initial attributes
            if (params.translate) {
                this.setTranslate(params.translate);
            }

            if (params.scale) {
                this.setScale(params.scale);
            }

            if (params.rotate) {
                this.setRotate(params.rotate);
            }

            if (params.material) {
                this.setMaterial(params.material);
            }
        },

        /**
         * Sets translation
         * @param translate
         */
        setTranslate:function (translate) {
            if (this.translate) {
                this.translate.setXYZ(translate);
            }
        },

        /**
         * Sets scale
         * @param size
         */
        setScale:function (scale) {
            if (this.scale) {
                this.scale.setXYZ(scale);
            }
        },

        /**
         * Sets rotation
         * @param rotate
         */
        setRotate:function (rotate) {
            if (this.rotate) {
                this.rotate.set(rotate);
            }
        },

        /**
         * Sets material
         * @param material
         */
        setMaterial:function (material) {
            if (this.material) {
                this.material.set(material);
            }
        },

        destruct:function () {
            for (var parent = this.parent; parent; parent = parent.parent) {
                if (parent.type == "assembly/model") {
                    parent._deregisterObject(this);
                }
            }
        }
    });

})();