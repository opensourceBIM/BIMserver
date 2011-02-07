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
 * Per-client list of counters/timers.
 * @constructor
 */
o3d.CounterManager = function() {
  /**
   * Map from counter type to list of counters in this client.
   * @private
   * @type {!Object}
   */
  this.counterMap_ = {};
};

/**
 * Contains the time of the last call to tick, so we know the amount to pass
 * into advanceCounters_
 * lastUpdated is initialized on the first call to tick().
 * @type {Date}
 */
o3d.CounterManager.prototype.lastUpdated = null;

/**
 * @param {string} type Which counter_type_ to advance.
 * @param {number} amount Amount to advance counters.
 */
o3d.CounterManager.prototype.advanceCounters = function(type, amount) {
  var counterArrayRef = this.counterMap_[type];
  if (!counterArrayRef)
    return;
  var length = counterArrayRef.length;
  var counterArray = [];
  for (var i = 0; i < length; i++) {
    counterArray[i] = counterArrayRef[i];
  }
  for (var i = 0; i < length; ++i) {
    if (counterArray[i].running) {
      counterArray[i].advance(amount);
    }
  }
};

/**
 * Static method to increments all global counters. RenderFrameCounter should
 * not get updated here.
 */
o3d.CounterManager.prototype.tick = function() {
  this.advanceCounters("TickCounter", 1.0);
  var now = new Date();
  var deltaSeconds = 0;
  if (this.lastUpdated != null) {
    deltaSeconds = (now - this.lastUpdated) / 1000.0;
  }
  this.lastUpdated = now;
  this.advanceCounters("SecondCounter", deltaSeconds);
};

/**
 * Updates RenderFrameCounter objects by 1.0, similarly to TickCounter.
 * As opposed to tick(), this should only be when the canvas is rendered, so
 * any canvases which are not automatically rendererd may not advance this.
 */
o3d.CounterManager.prototype.advanceRenderFrameCounters = function() {
  this.advanceCounters("RenderFrameCounter", 1.0);
};

/**
 * Register a counter, using its className to decide which type of counter.
 * @param {!o3d.Counter} counter Instance of some sub-type of o3d.Counter
 */
o3d.CounterManager.prototype.registerCounter = function(counter) {
  var type = counter.counter_type_;
  var arr = this.counterMap_[type];
  if (!arr) {
    arr = this.counterMap_[type] = [];
  }
  arr.push(counter);
};

/**
 * Unregister a counter previously registered by registerCounter.
 * @param {!o3d.Counter} counter Instance of some sub-type of o3d.Counter
 */
o3d.CounterManager.prototype.unregisterCounter = function(counter) {
  var type = counter.counter_type_;
  var arr = this.counterMap_[type];
  if (arr) {
    o3d.removeFromArray(arr, counter);
  }
};

/**
 * A Counter counts seconds, ticks or render frames depending on the type of
 * counter. You can set where it starts counting from and where it stops
 * counting at, whether or not it is running or paused and how it loops or does
 * not loop. You can also give it callbacks to call at specific count values.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.Counter = function() {
  o3d.ParamObject.call(this);

  /**
   * Last called callback in the forward direction (start_count > end_count)
   * @type {number}
   * @private
   */
  this.next_callback_ = -1;

  /**
   * Last called callback in the backward direction (start_count < end_count)
   * @type {number}
   * @private
   */
  this.prev_callback_ = -1;

  /**
   * Keeps track of last count in case this.count_ is bound to another param.
   * @type {number}
   * @private
   */
  this.old_count_ = 0;

  /**
   * Keeps track of last end_count to prevent double-firing of callbacks if
   * start_count is the same.
   * @type {number}
   * @private
   */
  this.last_call_callbacks_end_count_ = 0;

  /**
   * List of callbacks for this counter, in sorted order.
   * There can only be one callback per timer value.
   * @type {Array.<o3d.Counter.CallbackInfo>}
   * @private
   */
  this.callbacks_ = [];

  /**
   * Pointer to CounterManager which owns this counter, so it can be added
   * to the list of counters by setting this.running = true.
   * @type {o3d.CounterManager}
   */
  this.counter_manager_ = null;

  /**
   * Cached copy of this.getParam('running')
   * @type {o3d.ParamBoolean}
   * @private
   */
  this.running_param_ = this.createParam("running", "ParamBoolean");

  /**
   * Cached copy of this.getParam('count')
   * @type {o3d.ParamFloat}
   * @private
   */
  this.count_param_ = this.createParam("count", "ParamFloat");

  this.multiplier = 1.0;

  this.forward = true;

  this.countMode = o3d.Counter.CONTINUOUS;

  // this.running must be set in the sub class due to how o3d.inherit works.
};
o3d.inherit('Counter', 'ParamObject');

/**
 * Controls the direction of the counter. If false, Counter.callCallbacks_
 * will be called with start_count > end_count.
 * @default true
 * @type {boolean}
 */
o3d.ParamObject.setUpO3DParam_(o3d.Counter, "forward", "ParamBoolean");

/**
 * The start value for this counter.
 * @default 0
 * @type {number}
 */
o3d.ParamObject.setUpO3DParam_(o3d.Counter, "start", "ParamFloat");

/**
 * The end value for this counter.
 * @default 0
 * @type {number}
 */
o3d.ParamObject.setUpO3DParam_(o3d.Counter, "end", "ParamFloat");

/**
 * Can be used to switch the direction of the counter or control what happens
 * when end_count is reached.
 * @see o3d.Counter.CONTINUOUS
 * @see o3d.Counter.ONCE
 * @see o3d.Counter.CYCLE
 * @see o3d.Counter.OSCILLATE
 * @default o3d.Counter.CONTINUOUS
 * @type {o3d.Counter.CountMode}
 */
o3d.ParamObject.setUpO3DParam_(o3d.Counter, "countMode", "ParamInteger");

/**
 * The time multiplier for this counter.
 * @default 1
 * @type {number}
 */
o3d.ParamObject.setUpO3DParam_(o3d.Counter, "multiplier", "ParamFloat");

/**
 * Whether or not this counter is running.
 * Special setter to allow destroying a stopped Counter without leaking mem.
 * Defaults to true in SecondCounter, TickCounter and RenderFrameCounter.
 * @default false
 * @type {boolean}
 */
o3d.Counter.prototype.__defineSetter__("running",
    function(newRunning) {
      var oldRunning = this.running_param_.value;
      if (this.counter_manager_ && oldRunning != newRunning) {
        if (newRunning == false) {
          this.counter_manager_.unregisterCounter(this);
        } else {
          this.counter_manager_.registerCounter(this);
        }
      }
      this.running_param_.value = newRunning;
    }
);
o3d.Counter.prototype.__defineGetter__("running",
    function() {
      return this.running_param_.value;
    }
);

/**
 * The current count for this counter. The setter is equivalent to calling
 * setCount(value)
 * @default 0
 * @type {number}
 */
o3d.Counter.prototype.__defineSetter__("count",
    function(value) {
      this.setCount(value);
    }
);
o3d.Counter.prototype.__defineGetter__("count",
    function() {
      return this.count_param_.value;
    }
);

o3d.Counter.prototype.__defineSetter__("gl",
    function(new_gl) {
      var old_running = this.running;
      this.running = false;
      this.gl_ = new_gl;
      if (this.gl_ && this.gl_.client) {
        this.counter_manager_ = this.gl_.client.counter_manager_;
      }
      this.running = old_running;
    }
);

o3d.Counter.prototype.__defineGetter__("gl",
    function() {
      return this.gl_;
    }
);

/**
 * @type {number}
 */
o3d.Counter.CountMode = goog.typedef;

/**
 * Continiuously goes up, ignoring the value of end_count. This is the default.
 * @type {o3d.Counter.CountMode}
 */
o3d.Counter.CONTINUOUS = 0;
/**
 * Sets running=false when end is reached and stops.
 * @type {o3d.Counter.CountMode}
 */
o3d.Counter.ONCE = 1;
/**
 * Resets count to start_count whenever end is reached.
 * @type {o3d.Counter.CountMode}
 */
o3d.Counter.CYCLE = 2;
/**
 * Switches direction whenever end or start is reached.
 * @type {o3d.Counter.CountMode}
 * @see direction
 */
o3d.Counter.OSCILLATE = 3;

/**
 * The counter type is used by o3d.CounterManager to decide which array to
 * put the counter in, and how much to call advanceAmount by during each call
 * to o3d.CounterManager.tick() or advanceRenderFrameCounters().
 * "Counter" means that it will only be advanced manually.
 * @type {string}
 */
o3d.Counter.prototype.counter_type_ = "Counter";

/**
 * Resets the counter back to the start or end time depending on the forward
 * setting and also resets the Callback state.
 * Note: Reset does not change the running state of the counter.
 */
o3d.Counter.prototype.reset = function() {
  this.setCount(this.forward ? this.start : this.end);
};

/**
 * Sets the current count value for this counter as well as the resetting the
 * state of the callbacks.
 * @param {number} count The current value of the counter
 */
o3d.Counter.prototype.setCount = function(value) {
  this.count_param_.value = value;
  this.old_count_ = value;
  this.next_callback_ = -1;
  this.prev_callback_ = -1;
};


/**
 * Advances the counter the given amount. The actual amount advanced depends on
 * the forward and multiplier settings. The formula is
 * new_count = count + advance_amount * multiplier * (forward ? 1.0 : -1.0);
 *
 * Any callbacks that fall in the range between the counter's current count and
 * the amount advanced will be called. This function is normally called
 * automatically by the client if the counter is set to running = true. but you
 * can call it manually.
 *
 * @param {number} advance_amount Amount to advance count.
 */
o3d.Counter.prototype.advance = function(advance_amount) {
  var queue = [];
  var old_count = this.count_param_.value;

  // Update the count.
  if (this.count_param_.inputConnection) {
    this.callCallbacks_(this.old_count_, old_count, queue);
  } else {
    var direction = this.forward;
    var start_count = this.start;
    var end_count = this.end;
    var multiplier = this.multiplier;
    var delta = (direction ? advance_amount : -advance_amount) * multiplier;
    var period = end_count - start_count;

    var mode = this.countMode;
    if (period >= 0.0) {
      // end > start
      var new_count = old_count + delta;
      if (delta >= 0.0) {
        switch (mode) {
          case o3d.Counter.ONCE: {
            if (new_count >= end_count) {
              new_count = end_count;
              this.running = false;
            }
            break;
          }
          case o3d.Counter.CYCLE: {
            while (new_count >= end_count) {
              this.callCallbacks_(old_count, end_count, queue);
              if (period == 0.0) {
                break;
              }
              old_count = start_count;
              new_count -= period;
            }
            break;
          }
          case o3d.Counter.OSCILLATE: {
            while (delta > 0.0) {
              new_count = old_count + delta;
              if (new_count < end_count) {
                break;
              }
              this.callCallbacks_(old_count, end_count, queue);
              direction = !direction;
              var amount = end_count - old_count;
              delta -= amount;
              old_count = end_count;
              new_count = end_count;
              if (delta <= 0.0 || period == 0.0) {
                break;
              }
              new_count -= delta;
              if (new_count > start_count) {
                break;
              }
              this.callCallbacks_(old_count, start_count, queue);
              direction = !direction;
              amount = old_count - start_count;
              delta -= amount;
              old_count = start_count;
              new_count = start_count;
            }
            this.forward = direction;
            break;
          }
          case o3d.Counter.CONTINUOUS:
          default:
            break;
        }
        this.callCallbacks_(old_count, new_count, queue);
        this.count_param_.value = new_count;
      } else if (delta < 0.0) {
        switch (mode) {
          case o3d.Counter.ONCE: {
            if (new_count <= start_count) {
              new_count = start_count;
              this.running = false ;
            }
            break;
          }
          case o3d.Counter.CYCLE: {
            while (new_count <= start_count) {
              this.callCallbacks_(old_count, start_count, queue);
              if (period == 0.0) {
                break;
              }
              old_count = end_count;
              new_count += period;
            }
            break;
          }
          case o3d.Counter.OSCILLATE: {
            while (delta < 0.0) {
              new_count = old_count + delta;
              if (new_count > start_count) {
                break;
              }
              this.callCallbacks_(old_count, start_count, queue);
              direction = !direction;
              var amount = old_count - start_count;
              delta += amount;
              old_count = start_count;
              new_count = start_count;
              if (delta >= 0.0 || period == 0.0) {
                break;
              }
              new_count -= delta;
              if (new_count < end_count) {
                break;
              }
              this.callCallbacks_(old_count, end_count, queue);
              direction = !direction;
              amount = end_count - old_count;
              delta += amount;
              old_count = end_count;
              new_count = end_count;
            }
            this.forward = direction;
            break;
          }
          case o3d.Counter.CONTINUOUS:
          default:
            break;
        }
        this.callCallbacks_(old_count, new_count, queue);
        this.count_param_.value = new_count;
      }
    } else if (period < 0.0) {
      // start > end
      period = -period;
      var new_count = old_count - delta;
      if (delta > 0.0) {
        switch (mode) {
          case o3d.Counter.ONCE: {
            if (new_count <= end_count) {
              new_count = end_count;
              this.running = false;
            }
            break;
          }
          case o3d.Counter.CYCLE: {
            while (new_count <= end_count) {
              this.callCallbacks_(old_count, end_count, queue);
              old_count = start_count;
              new_count += period;
            }
            break;
          }
          case o3d.Counter.OSCILLATE: {
            while (delta > 0.0) {
              new_count = old_count - delta;
              if (new_count > end_count) {
                break;
              }
              this.callCallbacks_(old_count, end_count, queue);
              direction = !direction;
              var amount = old_count - end_count;
              delta -= amount;
              old_count = end_count;
              new_count = end_count;
              if (delta <= 0.0) {
                break;
              }
              new_count += delta;
              if (new_count < start_count) {
                break;
              }
              this.callCallbacks_(old_count, start_count, queue);
              direction = !direction;
              amount = start_count - old_count;
              delta -= amount;
              old_count = start_count;
              new_count = start_count;
            }
            this.forward = direction;
            break;
          }
          case o3d.Counter.CONTINUOUS:
          default:
            break;
        }
        this.callCallbacks_(old_count, new_count, queue);
        this.count_param_.value = new_count;
      } else if (delta < 0.0) {
        switch (mode) {
          case o3d.Counter.ONCE: {
            if (new_count >= start_count) {
              new_count = start_count;
              this.running = false;
            }
            break;
          }
          case o3d.Counter.CYCLE: {
            while (new_count >= start_count) {
              this.callCallbacks_(old_count, start_count, queue);
              old_count = end_count;
              new_count -= period;
            }
            break;
          }
          case o3d.Counter.OSCILLATE: {
            while (delta < 0.0) {
              new_count = old_count - delta;
              if (new_count < start_count) {
                break;
              }
              this.callCallbacks_(old_count, start_count, queue);
              direction = !direction;
              var amount = start_count - old_count;
              delta += amount;
              old_count = start_count;
              new_count = start_count;
              if (delta >= 0.0) {
                break;
              }
              new_count += delta;
              if (new_count > end_count) {
                break;
              }
              this.callCallbacks_(old_count, end_count, queue);
              direction = !direction;
              amount = old_count - end_count;
              delta += amount;
              old_count = end_count;
              new_count = end_count;
            }
            this.forward = direction;
            break;
          }
          case o3d.Counter.CONTINUOUS:
          default:
            break;
        }
        this.callCallbacks_(old_count, new_count, queue);
        this.count_param_.value = new_count;
      }
    }
  }
  this.old_count_ = old_count;
  for (var i = 0; i < queue.length; i++) {
    queue[i]();
  }
};

/**
 * @param {number} start_count  Starts exactly at this count.
 * @param {number} end_count  Calls callbacks up to but not including this.
 * @private
 */
o3d.Counter.prototype.callCallbacks_ = function(start_count, end_count, queue) {
  if (end_count > start_count) {
    // Going forward.
    // If next_callback is not valid, find the first possible callback.
    if (this.next_callback_ < 0 ||
        start_count != this.last_call_callbacks_end_count_) {
      this.next_callback_ = 0;
      while (this.next_callback_ != this.callbacks_.length &&
             this.callbacks_[this.next_callback_].count < start_count) {
        ++this.next_callback_;
      }
    }

    // add callbacks until we get to some callback past end_count.
    while (this.next_callback_ < this.callbacks_.length) {
      if (this.callbacks_[this.next_callback_].count > end_count) {
        break;
      }
      queue.push(this.callbacks_[this.next_callback_].callback);
      ++this.next_callback_;
    }
    this.prev_callback_ = -1;
    this.last_call_callbacks_end_count_ = end_count;
  } else if (end_count < start_count) {
    // Going backward.
    // If prev_callback is not valid, find the first possible callback.
    if (this.prev_callback_ < 0 ||
        start_count != this.last_call_callbacks_end_count_) {
      this.prev_callback_ = this.callbacks_.length - 1;
      while (this.prev_callback_ >= 0 &&
             this.callbacks_[this.prev_callback_].count > start_count) {
        --this.prev_callback_;
      }
    }

    // add callbacks until we get to some callback past end_count.
    while (this.prev_callback_ >= 0) {
      if (this.callbacks_[this.prev_callback_].count < end_count) {
        break;
      }
      queue.push(this.callbacks_[this.prev_callback_].callback);
      --this.prev_callback_;
    }

    this.next_callback_ = -1;
    this.last_call_callbacks_end_count_ = end_count;
  }
};

/**
 * Adds a callback for a given count value. Only one callback can be added to a
 * specific count value. If another callback is added with the same count value
 * the previous callback for that value will be replaced. Note: A callback at
 * start will only get called when counting backward, a callback at end will
 * only get called counting forward.
 * @param {number} count Count at which to call callback.
 * @param {function()} callback Callback to call at given count.
 */
o3d.Counter.prototype.addCallback = function(count, callback) {
  this.next_callback_ = -1;
  this.prev_callback_ = -1;
  var end = this.callbacks_.length;
  var iter = 0;
  while (iter != end) {
    var current = this.callbacks_[iter];
    if (current.count == count) {
      // Did the o3d plugin overwrite existing callbacks here?
      current.callback = callback;
      return;
    } else if (current.count > count) {
      break;
    }
    ++iter;
  }
  var rest = this.callbacks_.splice(iter, this.callbacks_.length - iter);
  this.callbacks_.push(new o3d.Counter.CallbackInfo(count, callback));
  this.callbacks_.push.apply(this.callbacks_, rest);
};

/**
 * Removes a callback for a given count value.
 * @param {number} count Count to remove callback for.
 * @return {boolean} true if there was a callback for that count, false if
 *     there was not a callback for that count.
 */
o3d.Counter.prototype.removeCallback = function(count) {
  var end = this.callbacks_.length;
  for (var iter = 0; iter != end; ++iter) {
    if (this.callbacks_[iter].count == count) {
      this.next_callback_ = -1;
      this.prev_callback_ = -1;
      this.callbacks_.splice(iter, 1);
      return true;
    }
  }
  return false;
};

/**
 * Removes all the callbacks on this counter.
 * Does not affect running state: set running=false to allow this counter to be
 * garbage collected.
 */
o3d.Counter.prototype.removeAllCallbacks = function() {
  this.callbacks_ = [];
  this.next_callback_ = -1;
  this.prev_callback_ = -1;
};

/**
 * Class to hold onto the state of a callback function at a specific count.
 * @constructor
 * @param {number} count  Count at which this callback will get called.
 * @param {function()} callback  Function to call when count is reached.
 */
o3d.Counter.CallbackInfo = function(count, callback) {
  /**
   * Count at which this callback will get called.
   * @type {number}
   */
  this.count = count;

  /**
   * Function to call when count is reached.
   * @type {function()}
   */
  this.callback = callback;

  /**
   * Prevents recursion of the same callback, in case it decides to advance
   * the counter.
   * @type {boolean}
   * @private
   */
  this.called_ = false;
};

/**
 * Run this callback without the possibility for recursion.
 */
o3d.Counter.CallbackInfo.prototype.run = function() {
  if (!this.called_) {
    this.called_ = true;
    this.callback();
    this.called_ = false;
  }
};

/**
 * Counter to count seconds. Logic is implemented in CounterManager.tick()
 * @constructor
 * @extends {o3d.Counter}
 */
o3d.SecondCounter = function() {
  o3d.Counter.call(this);
  this.running = true;
};

o3d.inherit("SecondCounter", "Counter");

o3d.SecondCounter.prototype.counter_type_ = "SecondCounter";

/**
 * Counter to count frames. Logic is implemented in
 * CounterManager.advanceRenderFrameCounters()
 * @constructor
 * @extends {o3d.Counter}
 */
o3d.RenderFrameCounter = function() {
  o3d.Counter.call(this);
  this.running = true;
};

o3d.inherit("RenderFrameCounter", "Counter");

o3d.RenderFrameCounter.prototype.counter_type_ = "RenderFrameCounter";

/**
 * Counter to count ticks. Logic is implemented in CounterManager.tick()
 * @constructor
 * @extends {o3d.Counter}
 */
o3d.TickCounter = function() {
  o3d.Counter.call(this);
  this.running = true;
};

o3d.inherit("TickCounter", "Counter");

o3d.TickCounter.prototype.counter_type_ = "TickCounter";
