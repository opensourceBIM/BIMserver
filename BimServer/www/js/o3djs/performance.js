/*
 * Copyright 2009, Google Inc.
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
 * @fileoverview This file contains a utility that helps adjust rendering
 * quality [or any other setting, really] based on rendering performance.
 *
 */

o3djs.provide('o3djs.performance');

/**
 * A Module to help with adjusting performance.
 * @namespace
 */
o3djs.performance = o3djs.performance || {};

/**
 * Creates a utility that monitors performance [in terms of FPS] and helps to
 * adjust the rendered scene accordingly.
 * @param {number} targetFPSMin the minimum acceptable frame rate; if we're
 * under this, try to decrease quality to improve performance.
 * @param {number} targetFPSMax if we're over this, try to increase quality.
 * @param {!function(): void} increaseQuality a function to increase
 *     quality because we're rendering at high-enough FPS to afford it.
 * @param {!function(): void} decreaseQuality a function to decrease
 *     quality to try to raise our rendering speed.
 * @param {!o3djs.performance.PerformanceMonitor.Options} opt_options Options.
 * @return {!o3djs.performance.PerformanceMonitor} The created
 *     PerformanceMonitor.
 */
o3djs.performance.createPerformanceMonitor = function(
    targetFPSMin, targetFPSMax, increaseQuality, decreaseQuality, opt_options) {
  return new o3djs.performance.PerformanceMonitor(targetFPSMin, targetFPSMax,
      increaseQuality, decreaseQuality, opt_options);
};

/**
 * A class that monitors performance [in terms of FPS] and helps to adjust the
 * rendered scene accordingly.
 * @constructor
 * @param {number} targetFPSMin the minimum acceptable frame rate; if we're
 * under this, try to decrease quality to improve performance.
 * @param {number} targetFPSMax if we're over this, try to increase quality.
 * @param {function(): void} increaseQuality a function to increase
 *     quality/lower FPS.
 * @param {function(): void} decreaseQuality a function to decrease
 *     quality/raise FPS.
 * @param {!o3djs.performance.PerformanceMonitor.Options} opt_options Options.
 */
o3djs.performance.PerformanceMonitor = function(
    targetFPSMin, targetFPSMax, increaseQuality, decreaseQuality, opt_options) {
  opt_options = opt_options || {};

  /**
   * A function to increase quality/lower FPS.
   * @type {function(): void}
   */
  this.increaseQuality = increaseQuality;

  /**
   * A function to decrease quality/raise FPS.
   * @type {function(): void}
   */
  this.decreaseQuality = decreaseQuality;

  /**
   * The mean time taken per frame so far, in seconds.  This is only valid once
   * we've collected at least minSamples samples.
   * @type {number}
   */
  this.meanFrameTime = 0;

  /**
   * The number of samples we've collected so far, when that number is less than
   * or equal to this.damping.  After that point, we no longer update
   * this.sampleCount, so it will clip at this.damping.
   *
   * @type {number}
   */
  this.sampleCount = 0;

  /**
   * The minimum number of samples to collect before trying to adjust quality.
   *
   * @type {number}
   */
  this.minSamples = opt_options.opt_minSamples || 60;

  /**
   * A number that controls the rate at which the effects of any given sample
   * fade away.  Higher is slower, but also means that each individual sample
   * counts for less at its most-influential.  Damping defaults to 120; anywhere
   * between 60 and 600 are probably reasonable values, depending on your needs,
   * but the number must be no less than minSamples.
   *
   * @type {number}
   */
  this.damping = opt_options.opt_damping || 120;

  /**
   * The minimum number of samples to take in between adjustments, to cut down
   * on overshoot.  It defaults to 2 * minSamples.
   *
   * @type {number}
   */
  this.delayCycles = opt_options.opt_delayCycles || 2 * this.minSamples;

  this.targetFrameTimeMax_ = 1 / targetFPSMin;
  this.targetFrameTimeMin_ = 1 / targetFPSMax;
  this.scaleInput_ = 1 / this.minSamples;
  this.scaleMean_ = 1;
  this.delayCyclesLeft_ = 0;
  if (this.damping < this.minSamples) {
    throw Error('Damping must be at least minSamples.');
  }
};

/**
 * Options for the PerformanceMonitor.
 *
 * opt_minSamples is the minimum number of samples to take before making any
 * performance adjustments.
 * opt_damping is a number that controls the rate at which the effects of any
 * given sample fade away.  Higher is slower, but also means that each
 * individual sample counts for less at its most-influential.  Damping
 * defaults to 120; anywhere between 60 and 600 are probably reasonable values,
 * depending on your needs, but the number must be no less than minSamples.
 * opt_delayCycles is the minimum number of samples to take in between
 * adjustments, to cut down on overshoot.  It defaults to 2 * opt_minSamples.
 *
 * @type {{
 *   opt_minSamples: number,
 *   opt_damping: number,
 *   opt_delayCycles: number
 * }}
 */
o3djs.performance.PerformanceMonitor.Options = goog.typedef;

/**
 * Call this once per frame with the elapsed time since the last call, and it
 * will attempt to adjust your rendering quality as needed.
 *
 * @param {number} seconds the elapsed time since the last frame was rendered,
 * in seconds.
 */
o3djs.performance.PerformanceMonitor.prototype.onRender = function(seconds) {
  var test = true;
  if (this.sampleCount < this.damping) {
    if (this.sampleCount >= this.minSamples) {
      this.scaleInput_ = 1 / (this.sampleCount + 1);
      this.scaleMean_ = this.sampleCount * this.scaleInput_;
    } else {
      test = false;
    }
    this.sampleCount += 1;
  }
  this.meanFrameTime = this.meanFrameTime * this.scaleMean_ +
      seconds * this.scaleInput_;
  if (this.delayCyclesLeft_ > 0) {
    this.delayCyclesLeft_ -= 1;
  } else if (test) {
    if (this.meanFrameTime < this.targetFrameTimeMin_) {
      this.increaseQuality();
      this.delayCyclesLeft_ = this.delayCycles;
    } else if (this.meanFrameTime > this.targetFrameTimeMax_) {
      this.decreaseQuality();
      this.delayCyclesLeft_ = this.delayCycles;
    }
  }
};


