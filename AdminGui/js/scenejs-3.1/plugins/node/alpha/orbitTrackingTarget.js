/**
 *
 */

SceneJS.Types.addType("alpha/orbitTrackingTarget", {

    construct:function (params) {
        this._camera = null;
    },


    setEnabled:function (enabled) {
        if (!this._camera && enabled) {
            this.log("error", "No parent 'orbitTracking' node - ignoring enable");
            return;
        }
        if (enabled) {
            this._camera._activeTargetId = this.id;
        } else {
            if (this._camera._activeTargetId == this.id) {
                this._camera._activeTargetId = null;
            }
        }
    },

    preCompile:function () {
        this._camera = this.findParentByType("alpha/orbitTracking");
        if (!this._camera) {
            this.log("error", "Mandatory parent 'orbitTracking' node not found");
        }
        this.on("rendered", function (data) {
            if (this._camera._activeTargetId == this.id) {
                //this._camera.
            }
        });
    },

    destruct:function () {
        if (this._camera._activeTargetId == this.id) {
            this._camera._activeTargetId = null;
        }
    }
});