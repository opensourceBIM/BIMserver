(function () {

    SceneJS.Types.addType("utils/reload", {

        construct:function (params) {

            var id = this.id + ".root";
            this.addNode({
                id:id
            });

            var self = this;

            setInterval(function () {

                self.getScene().getNode(id,
                    function (root) {
                        root.destroy();
                        load(params.url,
                            function (json) {
                                self.addNode({
                                    id:id,
                                    nodes:[
                                        JSON.parse(json)
                                    ]
                                });

                            },
                            function (error) {
                                self.log("Load error: " + error);
                            });
                    });
            }, params.interval || 5000);
        }
    });

    function load(url, ok, error) {
        var xhr = new XMLHttpRequest();
        xhr.addEventListener('load',
            function (event) {
                if (event.target.response) {
                    ok(event.target.response);
                } else {
                    error('Invalid file [' + url + ']');
                }
            }, false);
        xhr.addEventListener('error',
            function () {
                error('Couldn\'t load URL [' + url + ']');
            }, false);
        xhr.open('GET', url, true);
        xhr.send(null);
    }

})();

