var SizePrefixes = ' KMGTPEZYXWVU';
function GetHumanSize(size) {
  if(size <= 0) return '0';
  var t2 = Math.min(Math.round(Math.log(size)/Math.log(1024)), 12);
  return (Math.round(size * 100 / Math.pow(1024, t2)) / 100) +
    SizePrefixes.charAt(t2).replace(' ', '') + 'B';
}

function formatDate(date) {
	if (date == null) {
		return "No date";
	}
	return date.getDate().toString().lpad("0", 2) + "-" + (date.getMonth() + 1).toString().lpad("0", 2) + "-" + date.getFullYear();
}

function formatTime(date) {
	return date.getHours().toString().lpad("0", 2) + ":" + date.getMinutes().toString().lpad("0", 2);
}

function formatTimeObject(date) {
	return ("" + date.hour).lpad("0", 2) + ":" + ("" + date.minute).lpad("0", 2);
}

function formatDateTime(date) {
	return date.getDate().toString().lpad("0", 2) + "-" + (date.getMonth() + 1).toString().lpad("0", 2) + "-" + date.getFullYear() + " " + date.getHours().toString().lpad("0", 2) + ":" + date.getMinutes().toString().lpad("0", 2);
}

function formatDateTimeShortest(date) {
	var now = new Date();
	if (now.getDay() == date.getDay() && now.getMonth() == date.getMonth() && now.getYear() == date.getYear()) {
		// Same day
		return formatTime(date);
	} else {
		return formatDateTime(date);
	}
}

function formatDateTimeWithSeconds(date) {
	return date.getDate().toString().lpad("0", 2) + "-" + (date.getMonth() + 1).toString().lpad("0", 2) + "-" + date.getFullYear() + " " + date.getHours().toString().lpad("0", 2) + ":" + date.getMinutes().toString().lpad("0", 2) + ":" + date.getSeconds().toString().lpad("0", 2);
}

function formatDuration(ms, showSeconds) {
	var s = Math.round(ms / 1000);
	if (s < 60) {
		if (showSeconds && s > 0) {
			var r = Math.round(s);
			if (r == 1) {
				return "1 second";
			} else {
				return r + " " + "seconds";
			}
		} else {
			return "1 second";
		}
	} else if (s < 60 * 60) {
		var r = Math.round(s / 60);
		if (r == 1) {
			return "one minute";
		} else {
			return r + " " + "minutes";
		}
	} else if (s < 60 * 60 * 24) {
		var r = Math.round(s / 3600); 
		if (r == 1) {
			return "one hour";
		} else {
			return r + " " + "hours";
		}
	} else {
		var r = Math.round(s / (3600 * 24));
		if (r == 1) {
			return "1 day";
		} else {
			return r + " " + "days";
		}
	}
}

function formatTimeSpan(ms, showSeconds) {
	var s = Math.round(ms / 1000);
	if (s < 60) {
		if (showSeconds && s > 0) {
			var r = Math.round(s);
			if (r == 1) {
				return "1 second ago";
			} else {
				return r + " " + "seconds ago";
			}
		} else {
			return "just now";
		}
	} else if (s < 60 * 60) {
		var r = Math.round(s / 60);
		if (r == 1) {
			return "one minute ago";
		} else {
			return r + " " + "minutes ago";
		}
	} else if (s < 60 * 60 * 24) {
		var r = Math.round(s / 3600); 
		if (r == 1) {
			return "one hour ago";
		} else {
			return r + " " + "hours ago";
		}
	} else {
		var r = Math.round(s / (3600 * 24));
		if (r == 1) {
			return "1 day ago";
		} else {
			return r + " " + "days ago";
		}
	}
}