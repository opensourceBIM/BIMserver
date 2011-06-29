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
 * @fileoverview This is a simple unit testing library used to test the
 * sample utilities
 *
 *
 */
o3djs.provide('o3djs.test');

/**
 * A unit testing library
 */
o3djs.test = o3djs.test || {};

/**
  * Class of errors thrown by assertions
  * @param {string} message The assertion message.
  * @this o3djs.test.AssertionError
  */
o3djs.test.AssertionError = function(message) {
  this.message = message;

  /**
    * Returns the error message.
    * @return {String} The error message.
    */
  this.toString = function() {
    return message;
  };
};

/**
  * Runs all the tests found in the given suite. Every function with a
  * name beginning with 'test' is considered to be a test.
  * @param {!Object} suite The object containing the test suite.
  * @param {!Object} opt_reporter An optional object to which the results
  *    of the test run are reported.
  * @return {boolean} Whether all the tests passed.
  */
o3djs.test.runTests = function(suite, opt_reporter) {
  try {
    opt_reporter = opt_reporter || o3djs.test.documentReporter;

    var passCount = 0;
    var failCount = 0;
    for (var propertyName in suite) {
      if (propertyName.substring(0, 4) !== 'test')
        continue;

      if (typeof(suite[propertyName]) !== 'function')
        continue;

      try {
        suite[propertyName]();
      } catch (e) {
        ++failCount;
        opt_reporter.reportFail(propertyName, String(e));
        continue;
      }

      ++passCount;
      opt_reporter.reportPass(propertyName);
    }

    opt_reporter.reportSummary(passCount, failCount);
    return failCount == 0;
  }
  catch (e) {
    return false;
  }
};

/**
  * Converts a value to the string representation used in assertion messages.
  * @private
  * @param {*} value The value to convert.
  * @param {number} opt_depth The depth of references to follow for nested
  *     objects. Defaults to 3.
  * @return {string} The string representation.
  */
o3djs.test.valueToString_ = function(value, opt_depth) {
  if (opt_depth === undefined) {
     opt_depth = 3;
  }
  var string;
  if (typeof(value) === 'object') {
    if (value !== null) {
      if (opt_depth === 0) {
        string = '?';
      } else {
        if (o3djs.base.isArray(value)) {
          var valueAsArray = /** @type {!Array.<*>} */ (value);
          string = '[';
          var separator = '';
          for (var i = 0; i < valueAsArray.length; ++i) {
            string += separator +
                o3djs.test.valueToString_(valueAsArray[i], opt_depth - 1);
            separator = ', ';
          }
          string += ']';
        } else {
          var valueAsObject = /** @type {!Object} */ (value);
          string = '{';
          var separator = '';
          for (var propertyName in valueAsObject) {
            if (typeof(valueAsObject[propertyName]) !== 'function') {
              string += separator + propertyName + ': ' +
                  o3djs.test.valueToString_(valueAsObject[propertyName],
                                            opt_depth - 1);
              separator = ', ';
            }
          }
          string += '}';
        }
      }
    } else {
      string = "null";
    }
  } else if (typeof(value) === 'string') {
    string = '"' + value + '"';
  } else {
    string = String(value);
  }
  return string;
};

/**
  * Asserts that a value is true from within a test
  * @param {boolean} value The value to test.
  */
o3djs.test.assertTrue = function(value) {
  if (!value) {
    throw new o3djs.test.AssertionError(
        'assertTrue failed for ' +
            o3djs.test.valueToString_(value));
  }
};

/**
  * Asserts that a value is false from within a test
  * @param {boolean} value The value to test.
  */
o3djs.test.assertFalse = function(value) {
  if (value) {
    throw new o3djs.test.AssertionError(
        'assertFalse failed for ' +
            o3djs.test.valueToString_(value));
  }
};

/**
  * Asserts that a value is null from within a test
  * @param {*} value The value to test.
  */
o3djs.test.assertNull = function(value) {
  if (value !== null) {
    throw new o3djs.test.AssertionError(
        'assertNull failed for ' +
            o3djs.test.valueToString_(value));
  }
};

/**
  * Asserts that an expected value is equal to an actual value.
  * @param {*} expected The expected value.
  * @param {*} actual The actual value.
  */
o3djs.test.assertEquals = function(expected, actual) {
  if (expected !== actual) {
    throw new o3djs.test.AssertionError(
        'assertEquals failed: expected ' +
            o3djs.test.valueToString_(expected) + ' but got ' +
            o3djs.test.valueToString_(actual));
  }
};

/**
  * Asserts that an expected value is close to an actual value
  * within a tolerance of 0.001.
  * @param {number} expected The expected value.
  * @param {number} actual The actual value.
  */
o3djs.test.assertClose = function(expected, actual) {
  if (actual < expected - 0.001 || actual > expected + 0.001) {
    throw new o3djs.test.AssertionError(
        'assertClose failed: expected ' +
            o3djs.test.valueToString_(expected) + ' but got ' +
            o3djs.test.valueToString_(actual));
  }
};

/**
  * Determines whether the elements of a pair of arrays are equal.
  * @private
  * @param {!Array.<*>} expected The expected array.
  * @param {!Array.<*>} actual The actual array.
  * @return {boolean} Whether the arrays are equal.
  */
o3djs.test.compareArrays_ = function(expected, actual) {
  if (expected.length !== actual.length) {
    return false;
  }
  for (var i = 0; i != expected.length; ++i) {
    if (o3djs.base.isArray(expected[i]) && o3djs.base.isArray(actual[i])) {
      var expectedAsArray = /** @type {!Array.<*>} */ (expected[i]);
      var actualAsArray = /** @type {!Array.<*>} */ (actual[i]);
      if (!o3djs.test.compareArrays_(expectedAsArray, actualAsArray)) {
        return false;
      }
    } else if (expected[i] !== actual[i]) {
      return false;
    }
  }
  return true;
};

/**
  * Asserts that an expected array is equal to an actual array.
  * @param {!Array.<*>} expected The expected array.
  * @param {!Array.<*>} actual The actual array.
  */
o3djs.test.assertArrayEquals = function(expected, actual) {
  if (!o3djs.base.isArray(expected)) {
    throw new o3djs.test.AssertionError(
        'assertArrayEquals failed: expected value ' +
            o3djs.test.valueToString_(expected) +
            ' is not an array');
  }
  if (!o3djs.base.isArray(actual)) {
    throw new o3djs.test.AssertionError(
        'assertArrayEquals failed: actual value ' +
            o3djs.test.valueToString_(actual) +
            ' is not an array');
  }
  if (!o3djs.test.compareArrays_(expected, actual)) {
    throw new o3djs.test.AssertionError(
        'assertArrayEquals failed: expected ' +
            o3djs.test.valueToString_(expected) + ' but got ' +
            o3djs.test.valueToString_(actual));
  }
};

/**
 * Creates a DOM paragraph object for the given text and color.
 * @private
 * @param {string} text The text of the message.
 * @param {string} opt_color The optional color of the message.
 * @return {!Element} A DOM paragraph object.
 */
o3djs.test.createReportParagraph_ = function(text, opt_color) {
  var textNode = document.createTextNode(text);
  var paragraph = document.createElement('p');
  paragraph.appendChild(textNode);
  if (opt_color !== undefined) {
    paragraph.style.color = opt_color;
  }
  return paragraph;
};

/**
 * A reporter that reports messages to the document (i.e. the DOM).
 * @type {!Object}
 */
o3djs.test.documentReporter = {
  /**
   * A Report div.
   * @private
   * @this {Object}
   */
  getReportDiv_: function() {
    if (!this.reportDiv_) {
      this.reportDiv_ = document.createElement('div');
      document.body.appendChild(this.reportDiv_);
    }
    return this.reportDiv_;
  },
  /**
   * Reports a test passed.
   * @param {string} testName The name of the test.
   * @this {Object}
   */
  reportPass: function(testName) {
    var paragraph = o3djs.test.createReportParagraph_(
        testName + ' : PASS', 'green');
    this.getReportDiv_().appendChild(paragraph);
  },
  /**
   * Reports a test failed.
   * @param {string} testName The name of the test.
   */
  reportFail: function(testName, message) {
    var paragraph = o3djs.test.createReportParagraph_(
        testName + ' : FAIL : ' + message, 'red');
    var reportDiv = this.getReportDiv_();
    reportDiv.insertBefore(paragraph,
                           reportDiv.firstChild);
  },
  /**
   * Reports a test summary.
   * @param {number} passCount The number of tests that passed.
   * @param {number} failCount The number of tests that failed.
   * @this {Object}
   */
  reportSummary: function(passCount, failCount) {
    var paragraph = o3djs.test.createReportParagraph_(
        passCount + ' passed, ' + failCount + ' failed', 'blue');
    var reportDiv = this.getReportDiv_();
    reportDiv.insertBefore(paragraph,
                           reportDiv.firstChild);
  }
};
