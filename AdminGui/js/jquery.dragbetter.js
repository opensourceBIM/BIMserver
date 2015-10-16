/*
 * jquery.dragbetter 0.1.3
 *
 * Author: Andrey Mikhaylov aka lolmaus
 * Email: lolmaus@gmail.com
 *
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 *
 * Based on jquery.draghover.js by William Meleyal (william.meleyal@gmail.com): https://gist.github.com/meleyal/3794126.
 *
 * Inspired by jquery.event.dragout by Dan Cork ([Firstname].[Lastname]@kickinteractive.net): https://github.com/dancork/jquery.event.dragout .
 *
 * Thanks to Ian Bytchek for support.
 *
 */

;(function($){

  "use strict";

  $.event.special.dragbetterenter = {

    setup: function() {

      var
        self = this,
        $self = $(self);

      self.dragbetterCollection = [];

      $self.on('dragenter.dragbetterenter', function (event) {

        if (self.dragbetterCollection.length === 0) {
          $self.triggerHandler('dragbetterenter');
        }

        self.dragbetterCollection.push(event.target);
      });

      $self.on('drop.dragbetterenter dragend.dragbetterenter', function () {
        self.dragbetterCollection = [];
        $self.triggerHandler('dragbetterleave');
      });
    },

    teardown: function() {
      $(this).off('.dragbetterenter');
    }

  };

  $.event.special.dragbetterleave = {

    setup: function() {

      if (!this.dragbetterCollection)
        throw "Triggered dragbetterleave without dragbetterenter. Do you listen to dragbetterenter?";

      var
        self = this,
        $self = $(self);


      $self.on('dragleave.dragbetterleave', function (event) {

        // Timeout is needed to ensure that the leave event on the previous element
        // fires AFTER the enter event on the next element.
        setTimeout(function() {

          var currentElementIndex = self.dragbetterCollection.indexOf(event.target);
          if (currentElementIndex > -1)
            self.dragbetterCollection.splice(currentElementIndex, 1);

          if (self.dragbetterCollection.length === 0) {
            $self.triggerHandler('dragbetterleave');
          }
        }, 1);
      });
    },

    teardown: function() {
      $(this).off('.dragbetterleave');
    }

  };

})(window.jQuery);