/*
 * Copyright 2010, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/**
 * An Event object contains information describing a JavaScript event; it's used
 * as an argument to event handlers triggered by the plugin.
 * @constructor
 */
o3d.Event = function() {
  o3d.ObjectBase.call(this);
};
o3d.inherit('Event', 'ObjectBase');


/**
 * @type {number}
 */
o3d.Event.Type = goog.typedef;

/**
 * String identifiers for JavaScript events.
 *  type
 *  invalid
 *  click
 *  dblclick
 *  mousedown
 *  mousemove
 *  mouseup
 *  wheel
 *  keydown
 *  keypress
 *  keyup
 *  resize
 */
o3d.Event.TYPE_INVALID = 0;
o3d.Event.TYPE_CLICK = 1;
o3d.Event.TYPE_DBLCLICK = 2;
o3d.Event.TYPE_MOUSEDOWN = 3;
o3d.Event.TYPE_MOUSEMOVE = 4;
o3d.Event.TYPE_MOUSEUP = 5;
o3d.Event.TYPE_WHEEL = 6;
o3d.Event.TYPE_KEYDOWN = 7;
o3d.Event.TYPE_KEYPRESS = 8;
o3d.Event.TYPE_KEYUP = 9;
o3d.Event.TYPE_RESIZE = 10;

/**
 * The type of event this object represents.
 * @type {o3d.Event.Type}
 */
o3d.Event.prototype.type = o3d.Event.TYPE_INVALID;


/**
 * @type {number}
 */
o3d.Event.Button = goog.typedef;

/**
 * Constants used to identify mouse buttons.
 */
o3d.Event.BUTTON_LEFT = 0;
o3d.Event.BUTTON_MIDDLE = 1;
o3d.Event.BUTTON_RIGHT = 2;
o3d.Event.BUTTON_4 = 3;
o3d.Event.BUTTON_5 = 4;



/**
 * Which mouse button caused the event, in the case of mousedown, mouseup,
 * click, and dblclick events.  This uses the values in enum Button.
 */
o3d.Event.prototype.button = o3d.Event.BUTTON_LEFT;



/**
 * Whether the ctrl key was pressed at the time of the event.
 * @type {boolean}
 */
o3d.Event.prototype.ctrl_key = false;



/**
 * Whether the alt [option, on OSX] key was pressed at the time of the event.
 * @type {boolean}
 */
o3d.Event.prototype.alt_key = false;



/**
 * Whether the shift key was pressed at the time of the event.
 * @type {boolean}
 */
o3d.Event.prototype.shift_key = false;



/**
 * Whether the meta [command, on OSX] key was pressed at the time of the event.
 * @type {boolean}
 */
o3d.Event.prototype.meta_key = false;



/**
 * The key code of the key pressed or released.
 * @type {number}
 */
o3d.Event.prototype.key_code = 0;



/**
 * The character created by a keypress event.
 * @type {number}
 */
o3d.Event.prototype.char_code = 0;



/**
 * The x-coordinate in pixels from the left side of the plugin or fullscreen
 * display region.
 * @type {number}
 */
o3d.Event.prototype.x = 0;



/**
 * The y-coordinate in pixels from the top of the plugin or fullscreen
 * display region.
 * @type {number}
 */
o3d.Event.prototype.y = 0;



/**
 * The x-coordinate in pixels from the left side of the screen.
 * @type {number}
 */
o3d.Event.prototype.screenX = 0;



/**
 * The y-coordinate in pixels from the top of the screen.
 * @type {number}
 */
o3d.Event.prototype.screenY = 0;



/**
 * The horizontal scroll offset for wheel events, in arbitrary units.
 * Positive values mean right; negative mean left.
 * @type {number}
 */
o3d.Event.prototype.deltaX = 0;



/**
 * The vertical scroll offset for wheel events, in arbitrary units.
 * Positive values mean up or away from the user; negative mean down or toward
 * the user.
 * @type {number}
 */
o3d.Event.prototype.deltaY = 0;



/**
 * The width in pixels of the plugin or fullscreen display region as a result
 * of this event.
 * @type {number}
 */
o3d.Event.prototype.width = 0;



/**
 * The height in pixels of the plugin or fullscreen display region as a result
 * of this event.
 * @type {number}
 */
o3d.Event.prototype.height = 0;



/**
 * Whether we're currently displaying in fullscreen mode.
 * @type {boolean}
 */
o3d.Event.prototype.fullscreen = false;



/**
 * An Event that gets sent to the render callback.
 * @constructor
 */
o3d.RenderEvent = function() {
  o3d.Event.call(this);
};
o3d.inherit('RenderEvent', 'Event');


/**
 * Time in seconds since the last time the client rendered.
 * @type {number}
 */
o3d.RenderEvent.prototype.elapsedTime = 0;


/**
 * An Event that gets sent to the render callback.
 * @constructor
 */
o3d.TickEvent = function() {
  o3d.Event.call(this);
};
o3d.inherit('RenderEvent', 'Event');


/**
 * Time in seconds since the last time the client rendered.
 * @type {number}
 */
o3d.TickEvent.prototype.elapsedTime = 0;

