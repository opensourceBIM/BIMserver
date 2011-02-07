package org.bimserver.database.actions;

import org.bimserver.shared.UserException;

public interface PostCommitAction {
	void execute() throws UserException;
}
