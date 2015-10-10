module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),
        concat: {
            js: {
                files: {
                    "../BimServer/www/js/bimserverapi.js": ["../BimServer/www/js/*.js"]
                },
            }
        },
        uglify: {
            dist: {
                files: {
                    "../BimServer/www/js/bimserverapi.min.js": ["../BimServer/www/js/bimserverapi.js"]
                }
            }
        }
    });

    grunt.loadNpmTasks("grunt-contrib-concat");
    grunt.loadNpmTasks("grunt-contrib-uglify");
    grunt.loadNpmTasks("grunt-css");
    grunt.loadNpmTasks("grunt-contrib-clean");

    grunt.registerTask("default", ["concat", "uglify"]);
};