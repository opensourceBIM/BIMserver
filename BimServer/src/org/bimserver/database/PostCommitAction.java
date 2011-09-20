package org.bimserver.database;

import org.bimserver.shared.exceptions.UserException;

public interface PostCommitAction {
	void execute() throws UserException;
}
