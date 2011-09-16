package org.bimserver.database.actions;

import org.bimserver.shared.exceptions.UserException;

public interface PostCommitAction {
	void execute() throws UserException;
}
