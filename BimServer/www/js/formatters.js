function formatDate(date) {
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

function formatDateTimeWithSeconds(date) {
	return date.getDate().toString().lpad("0", 2) + "-" + (date.getMonth() + 1).toString().lpad("0", 2) + "-" + date.getFullYear() + " " + date.getHours().toString().lpad("0", 2) + ":" + date.getMinutes().toString().lpad("0", 2) + ":" + date.getSeconds().toString().lpad("0", 2);
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