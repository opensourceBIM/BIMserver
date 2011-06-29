// see http://trac.openlayers.org/ticket/2779
OpenLayers.Handler.Path.prototype.mousedown = function(evt) {
    var geometry = this.line && this.line.geometry;
    var length = geometry ? geometry.components.length: null;
    if (length !== null && length === this.maxVertices) {
        this.removePoint();
        this.finalize();
        return false;
    }
    // ignore double-clicks
    if (this.lastDown && this.lastDown.equals(evt.xy)) {
        return false;
    }
    if(this.lastDown == null) {
        if(this.persist) {
            this.destroyFeature();
        }
        this.createFeature(evt.xy);
    } else if((this.lastUp == null) || !this.lastUp.equals(evt.xy)) {
        this.addPoint(evt.xy);
    }
    this.mouseDown = true;
    this.lastDown = evt.xy;
    this.drawing = true;
    return false;
};
