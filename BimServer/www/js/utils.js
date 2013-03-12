function formatAccessMethod(accessMethod) {
	if (accessMethod == "INTERNAL") {
		return "Internal";
	} else if (accessMethod == "JSON") {
		return "JSON";
	} else if (accessMethod == "WEB_INTERFACE") {
		return "Web Interface";
	} else {
		return accessMethod;
	}
}

function formatUserType(type) {
	if (type == "SYSTEM") {
		return "System";
	} else if (type == "ADMIN") {
		return "Administrator";
	} else if (type == "USER") {
		return "User";
	} else if (type == "READ_ONLY") {
		return "Read only";
	}
}

function formatTrigger(trigger) {
	if (trigger == "NEW_REVISION") {
		return "New revision";
	} else if (trigger == "NEW_EXTENDED_DATA") {
		return "New extended data";
	} else if (trigger == "NEW_PROJECT") {
		return "New project";
	}
}