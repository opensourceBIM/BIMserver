if(typeof SceneJS != 'object')
{
	console.error('SceneJS: SceneJS is not loaded!');
}

SceneJS.FX = {};

SceneJS.FX.Tween = {};

SceneJS.FX.TweenSpline = (function() {
	var TweenSpline, _dt, _intervalID, _r, _tick, _tweens;
	TweenSpline = (function() {

		function TweenSpline(lookAtNode, play) {
			this._target = lookAtNode;
			this._sequence = [];
			this._timeline = [];
			this._play = play != null ? play : true;
			this._t = 0.0;
		}

		TweenSpline.prototype.tick = function(dt) {
			if (this._play)
				return this._t += dt;
		};

		TweenSpline.prototype.start = function(lookAt) {
			this._sequence = [ lookAt != null ? lookAt : {
				eye : this._target.get('eye'),
				look : this._target.get('look'),
				up : this._target.get('up')
			} ];
			this._timeline = [ 0.0 ];
			return this._t = 0.0;
		};

		TweenSpline.prototype.push = function(lookAt, dt) {
			var dt_prime;
			if (this._sequence.length === 0)
				this._t = 0.0;
			dt_prime = dt != null ? dt : 5000;
			if (this._timeline.length === 0)
				dt_prime = 0.0;
			this._timeline.push(this.totalTime() + dt_prime);
			return this._sequence.push(lookAt);
		};

		TweenSpline.prototype.sequence = function(lookAts, dt) {
			var dt_prime, lookAt, _i, _len;
			if (this._sequence.length === 0)
				this._t = 0.0;
			for (_i = 0, _len = lookAts.length; _i < _len; _i++) {
				lookAt = lookAts[_i];
				dt_prime = dt != null ? dt : 800; // speedfactor of
				// playing sequences
				if (this._timeline.length === 0)
					dt_prime = 0.0;
				this._timeline.push(this.totalTime() + dt_prime);
				this._sequence.push(lookAt);
			}
			return null;
		};

		TweenSpline.prototype.pause = function() {
			return this._play = false;
		};

		TweenSpline.prototype.play = function() {
			return this._play = true;
		};

		TweenSpline.prototype.totalTime = function() {
			if (this._timeline.length > 0) {
				return this._timeline[this._timeline.length - 1];
			}
			return 0;
		};

		TweenSpline.prototype.update = function() {
			var dt, i;
			if (this._sequence.length === 0)
				return false;
			if (!this._play)
				return true;
			if (this._t >= this.totalTime() || this._sequence.length === 1) {
				this._target.set(this._sequence[this._sequence.length - 1]);
				return false;
			}
			i = 0;
			while (this._timeline[i] <= this._t) {
				++i;
			}
			dt = this._timeline[i] - this._timeline[i - 1];
			_this.lerpLookAtNode(this._target, (this._t - this._timeline[i - 1]) / dt, this._sequence[i - 1], this._sequence[i]);
			return true;
		};

		return TweenSpline;

	})();
	_tweens = [];
	_intervalID = null;
	_dt = 0;
	_tick = function() {
		var tween, _i, _len;
		for (_i = 0, _len = _tweens.length; _i < _len; _i++) {
			tween = _tweens[_i];
			tween.tick(_dt);
		}
		return null;
	};
	_r = function(lookAtNode, interval) {
		var tween;
		_dt = interval || 50;
		if (_intervalID !== null)
			clearInterval(_intervalID);
		_intervalID = setInterval(_tick, _dt);
		tween = new TweenSpline(lookAtNode);
		_tweens.push(tween);
		return tween;
	};
	_r.update = function() {
		var i, tween, _results;
		i = 0;
		_results = [];
		while (i < _tweens.length) {
			tween = _tweens[i];
			if (!tween.update()) {
				_results.push(_tweens.splice(i, 1));
			} else {
				_results.push(i += 1);
			}
		}
		return _results;
	};
	return _r;
})();

SceneJS.FX.idle = function() {
	SceneJS.FX.TweenSpline.update();
	return null;
};