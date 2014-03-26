/**
 * Custom node which captures images of the scene canvas
 *
 * Usage example:
 *
 * someNode.addNode({
 *      type: "canvas/capture",
 *
 *      // Optional image format, "jpeg" (default), "png" or "bmp"
 *      format: "jpeg",
 *
 *      // Optional image result size, defaults to current size of canvas at time of capture
 *      width: 300,
 *      height: 400
 * });
 *
 *  scene.getNode("myCanvasCapture",
 *      function (myCanvasCapture) {
 *
 *         // Subscribe to captured image
 *         myCanvasCapture.on("image",
 *             function (data) {
 *                 var src = data.src;       // Data URL
 *                 var width = data.width;   // Width of image
 *                 var height = data.height; // Height of image
 *             });
 *
 *        // Do capture
 *        myCanvasCapture.capture({
 *
 *             // Optional dimensions of desired image, falls back on node config,
  *             // or if not specified there, the current size of canvas
 *             width: 500,
 *             height: 400,
 *
 *             // Optional format - falls back on node config,
 *             // or if not specified there, "jpeg"
 *             format: "jpeg"
 *        });
 */
require([

    // This prefix routes to the 3rd-party libs directory containing resources used by plugins
    "scenejsPluginDeps/canvas2image"
],
    function () {

        SceneJS.Types.addType("canvas/capture", {

            construct:function (params) {
                this._format = params.format ? supportedFormat(params.format) : "jpeg";
                this._width = params.width;
                this._height = params.height;
            },

            capture:function (params) {

                params = params || {};

                var scene = this.getScene();
                scene.renderFrame({ force:true }); // HACK - need to fix need for this in SceneJS
                var canvas = scene.getCanvas();

                var width = params.width || this._width || canvas.width;
                var height = params.height || this._height || canvas.height;

                var image;

                var format = params.format ? this._supportedFormat(params.format) : this._format;

                switch (format) {
                    case "jpeg":
                        image = Canvas2Image.saveAsJPEG(canvas, true, width, height);
                        break;

                    case "png":
                        image = Canvas2Image.saveAsPNG(canvas, true, width, height);
                        break;

                    case "bmp":
                        image = Canvas2Image.saveAsBMP(canvas, true, width, height);
                        break;

                    default:
                        this.log("error", "format unsupported: " + format);
                        return;
                }

                this.publish("image", {
                    src:image.src,
                    format:format,
                    width:width,
                    height:height
                });
            },

            _supportedFormat:function (format) {
                if (format != "jpeg" && format != "png" && format != "bmp") {
                    this.log("error", "unsupported format for canvas/capture node: " + format
                        + " - supported types are 'jpeg', 'bmp' and 'png' - falling back on 'jpeg'");
                    return "jpeg";
                }
                return format;
            }
        });

    });