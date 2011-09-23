package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.comparators.SRevisionIdComparator;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RevisionTableModel extends AbstractTableModel {
	private static final Logger LOGGER = LoggerFactory.getLogger(RevisionTableModel.class);
	private static final long serialVersionUID = -1528523705646440767L;
	private List<SRevision> allRevisions = new ArrayList<SRevision>();
	private final ServiceHolder serviceHolder;

	public RevisionTableModel(ServiceHolder serviceHolder) {
		this.serviceHolder = serviceHolder;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return allRevisions.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SRevision revision = allRevisions.get(row);
		switch (col) {
		case 0:
			return revision.getId();
		case 1:
			return dateFormat.format(revision.getDate());
			// case 2:
			// return revision.getUsername();
		case 3:
			return revision.getComment();
		case 4:
			return revision.getSize();
		}
		return "";
	}

	public void showProject(SProject project) {
		try {
			List<SRevision> revisions = serviceHolder.getService().getAllRevisionsOfProject(project.getOid());
			if (revisions == null) {
				this.allRevisions.clear();
			} else {
				Collections.sort(revisions, new SRevisionIdComparator(true));
				this.allRevisions = revisions;
			}
			update();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Revision";
		case 1:
			return "Date";
		case 2:
			return "Author";
		case 3:
			return "Comment";
		case 4:
			return "Size";
		}
		return "";
	}

	public SRevision getRevision(int selectedRow) {
		return allRevisions.get(selectedRow);
	}

	public void update() {
		for (TableModelListener listener : getTableModelListeners()) {
			listener.tableChanged(new TableModelEvent(this));
		}
	}

	public void showUser(SUser user) {
		try {
			List<SRevision> revisions = serviceHolder.getService().getAllRevisionsByUser(user.getOid());
			if (revisions == null) {
				this.allRevisions.clear();
			} else {
				Collections.sort(revisions, new SRevisionIdComparator(true));
				this.allRevisions = revisions;
			}
			update();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}
}