/*
 * Copyright (C) 2010  TNO
 *
 * This file is part of BIMServer Viewer
 *
 * BIMServer Viewer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BIMServer Viewer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BIMServer Viewer.  If not, see <http://www.gnu.org/licenses/>.
 */

Ext.namespace('BIMServer', 'BIMServer.Viewer');

BIMServer.Viewer = function() {
    // private space
    var map;
    var vector;
    var draw;

    // public space
    return {
        create: function(options) {
            Ext.QuickTips.init();
            this.formid = options.formid;
            map = new OpenLayers.Map(null, {controls: []});
            vector = this.createVectorLayer();
            this.createWindow(options.title, options.width, options.height);
            this.initForm();
        },
        createVectorLayer: function() {
            return new OpenLayers.Layer.Vector("Sketch", {
                displayInLayerSwitcher: false,
                eventListeners: {
                    sketchstarted: function(evt) {
                       // make sure there is only 1 feature at a time
                       vector.destroyFeatures();
                    },
                    featureadded: this.setFormValues,
                    scope: this
                }
            });
        },
        createMapToolbar: function() {
            return [
                new GeoExt.Action({
                    control: new OpenLayers.Control.ZoomBox(),
                    icon: 'js/mapimg/magnifier_zoom_in.png',
                    map: map,
                    toggleGroup: "draw",
                    allowDepress: false,
                    pressed: true,
                    tooltip: {title: 'Zoom in', text: 'Zoom in by clicking in the map or drawing a box'}
                }),
                new GeoExt.Action({
                    control: new OpenLayers.Control.ZoomBox({out: true}),
                    icon: 'js/mapimg/magnifier_zoom_out.png',
                    map: map,
                    toggleGroup: "draw",
                    allowDepress: false,
                    pressed: false,
                    tooltip: {title: 'Zoom out', text: 'Zoom out by clicking in the map or drawing a box'}
                }),
                new GeoExt.Action({
                    control: new OpenLayers.Control.DragPan(),
                    icon: 'js/mapimg/pan.png',
                    map: map,
                    toggleGroup: "draw",
                    allowDepress: false,
                    pressed: false,
                    tooltip: {title: 'Pan map', text: 'Pan map by dragging'}
                }),
                new GeoExt.Action({
                    control: draw = new OpenLayers.Control.DrawFeature(vector, OpenLayers.Handler.Path,
                        {
                            handlerOptions: {maxVertices: 2}
                        }
                    ),
                    icon: 'js/mapimg/line_red.png',
                    map: map,
                    toggleGroup: "draw",
                    allowDepress: false,
                    pressed: false,
                    tooltip: {title: 'Draw line', text: 'Draw a line to determine the direction angle and the x and y coordinates'}
                })
            ];
        },
        createWindow: function(title, width, height) {
            var items = [{
                map: map,
                xtype: "gx_mappanel",
                width: width,
                height: height,
                layers: [
                    new OpenLayers.Layer.OSM(),
                    vector
                ],
                tbar: this.createMapToolbar(),
                zoom: 2,
                split: true
            }];
            return new Ext.Window({title: title, items: items, width: width, height: height}).show();
        },
        changeX: function(evt) {
            var form = document.forms[this.formid];
            var x = parseFloat(evt.target.value);
            var line = vector.features[0];
            if (line) {
                var proj = new OpenLayers.Projection(form.elements["epsg"].value);
                line.geometry.transform(map.getProjectionObject(), proj);
                var width = line.geometry.components[1].x-line.geometry.components[0].x;
                line.geometry.components[0].x = x;
                line.geometry.components[1].x = x+width;
                // transform back
                line.geometry.transform(proj, map.getProjectionObject());
                // redraw
                vector.drawFeature(line);
            } else {
                this.createFeature();
            }
        },
        allValuesComplete: function() {
            var form = document.forms[this.formid];
            return (form.elements["directionAngle"].value !== undefined &&
                form.elements["x"].value !== undefined &&
                form.elements["y"].value !== undefined);
        },
        changeY: function(evt) {
            var form = document.forms[this.formid];
            var y = parseFloat(evt.target.value);
            var line = vector.features[0];
            if (line) {
                var proj = new OpenLayers.Projection(form.elements["epsg"].value);
                line.geometry.transform(map.getProjectionObject(), proj);
                var height = line.geometry.components[1].y-line.geometry.components[0].y;
                line.geometry.components[0].y = y;
                line.geometry.components[1].y = y+height;
                // transform back
                line.geometry.transform(proj, map.getProjectionObject());
                // redraw
                vector.drawFeature(line);
            } else {
                this.createFeature();
            }
        },
        createFeature: function() {
            if (this.allValuesComplete() === true) {
                var form = document.forms[this.formid];
                var start = new OpenLayers.Geometry.Point(form.elements["x"].value,
                    form.elements["y"].value);
                var proj = new OpenLayers.Projection(form.elements["epsg"].value);
                start = start.transform(proj, map.getProjectionObject());
                var angle = parseInt(form.elements["directionAngle"].value);
                var width = map.getExtent().getWidth()/18;
                var height;
                if (angle > 0 && angle < 180) {
                    height = width*Math.tan(((-angle+90)*Math.PI)/180);
                } else {
                    width = -width;
                    height = width*Math.tan(((-angle+270)*Math.PI)/180);
                }
                var end = new OpenLayers.Geometry.Point(start.x+width, start.y+height);
                var line = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.LineString([start, end]));
                vector.addFeatures(line, {silent: true});
            }
        },
        changeRadius: function(evt) {
            var angle = parseInt(evt.target.value);
            var line = vector.features[0];
            if (line) {
                var start = line.geometry.components[0];
                // take a width of 1/10 of the map
                var width = map.getExtent().getWidth()/18;
                var height;
                if (angle >= 0 && angle < 180) {
                    height = width*Math.tan(((-angle+90)*Math.PI)/180);
                } else {
                    width = -width;
                    height = width*Math.tan(((-angle+270)*Math.PI)/180);
                }
                var end = line.geometry.components[1];
                end.x = start.x+width;
                end.y = start.y+height;
                vector.drawFeature(line);
            } else {
                this.createFeature();
            }
        },
        changeProjection: function(evt) {
            var form = document.forms[this.formid];
            var toProjection = new OpenLayers.Projection(evt.target.value);
            var line = vector.features[0];
            if (line) {
                var startPoint = line.geometry.components[0].clone();
                startPoint = startPoint.transform(map.getProjectionObject(), toProjection);
                form.elements["x"].value = startPoint.x;
                form.elements["y"].value = startPoint.y;
            }
        },
        initForm: function() {
            var form = document.forms[this.formid];
            var changeX = OpenLayers.Function.bind(this.changeX, this);
            form.elements["x"].addEventListener('change', changeX, false);
            var changeY = OpenLayers.Function.bind(this.changeY, this);
            form.elements["y"].addEventListener('change', changeY, false);
            var changeRadius = OpenLayers.Function.bind(this.changeRadius, this);
            form.elements["directionAngle"].addEventListener('change', changeRadius, false);
            var changeProjection = OpenLayers.Function.bind(this.changeProjection, this);
            form.elements["epsg"].addEventListener('change', changeProjection, false);
        },
        calculateAngle: function(geometry) {
            var points = geometry.getVertices();
            var width = points[1].x-points[0].x;
            var height = points[1].y-points[0].y;
            var angle;
            if (width >= 0) {
                angle = 90-(Math.atan(height/width)*(180/Math.PI));
            } else {
                angle = 270-Math.atan(height/width)*(180/Math.PI);
            }
            return Math.round(angle);
        },
        setFormValues: function(evt) {
            var geometry = evt.feature.geometry;
            var form = document.forms[this.formid];
            var toProjection = new OpenLayers.Projection(form.elements["epsg"].value);
            geometry = geometry.clone().transform(map.getProjectionObject(), toProjection);
            var points = geometry.getVertices();
            var x = points[0].x;
            var y = points[0].y;
            if (form.elements["epsg"].value == "EPSG:900913")
            {
            	form.elements["x"].value = x.toFixed(2);
            	form.elements["y"].value = y.toFixed(2);
            }
            else
            {
            	form.elements["x"].value = x.toFixed(8);
            	form.elements["y"].value = y.toFixed(8);
            }
            form.elements["directionAngle"].value = this.calculateAngle(geometry);
        },
        getMap: function() {
            return map;
        }
    }
}();

Ext.onReady(function() {
//    BIMServer.Viewer.create({formid: 'newproject'});
});
