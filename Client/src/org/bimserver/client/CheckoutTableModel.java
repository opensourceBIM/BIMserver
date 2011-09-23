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
import java.util.Comparator;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutTableModel extends AbstractTableModel {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutTableModel.class);
	private static final long serialVersionUID = 7508217629889014900L;

	private List<SCheckout> allCheckouts = new ArrayList<SCheckout>();
	private final ServiceHolder serviceHolder;

	public CheckoutTableModel(ServiceHolder serviceHolder) {
		this.serviceHolder = serviceHolder;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return allCheckouts.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SCheckout checkout = allCheckouts.get(row);
		switch (col) {
		case 0:
			return checkout.getRevisionId();
		case 1:
			return dateFormat.format(checkout.getDate());
//		case 2:
//			return checkout.getUsername();
		}
		return "";
	}

	public void showProject(SProject project) {
		try {
			List<SCheckout> checkouts = serviceHolder.getService().getAllCheckoutsOfProject(project.getOid());
			if (checkouts == null) {
				this.allCheckouts.clear();
			} else {
				Collections.sort(checkouts, new Comparator<SCheckout>(){
					@Override
					public int compare(SCheckout o1, SCheckout o2) {
						return (int)(o1.getDate().getTime() - o2.getDate().getTime());
					}});
				this.allCheckouts = checkouts;
			}
			update();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0: return "Revision";
		case 1: return "Date";
		case 2: return "Author";
		}
		return "";
	}

	public SCheckout getCheckout(int selectedRow) {
		return allCheckouts.get(selectedRow);
	}

	public void update() {
		for (TableModelListener listener : getTableModelListeners()) {
			listener.tableChanged(new TableModelEvent(this));
		}
	}

	public void showUser(SUser user) {
		try {
			List<SCheckout> checkouts = serviceHolder.getService().getAllCheckoutsByUser(user.getOid());
			if (checkouts == null) {
				this.allCheckouts.clear();
			} else {
				Collections.sort(checkouts, new Comparator<SCheckout>(){
					@Override
					public int compare(SCheckout o1, SCheckout o2) {
						return (int)(o1.getDate().getTime() - o2.getDate().getTime());
					}});
				this.allCheckouts = checkouts;
			}
			update();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}
}