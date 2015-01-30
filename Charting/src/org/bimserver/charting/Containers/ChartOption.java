package org.bimserver.charting.Containers;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public class ChartOption {

	public String Title = "Untitled Option";
	public String Description = "Option description.";
	public Object DefaultValue = null;
	private Object Value = null;

	/**
	 * @return the value
	 */
	public Object getValue() {
		return (Value == null) ? DefaultValue : Value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		Value = value;
	}

	/**
	 * Create option to help control and manage a particular chart, including the value to be used.
	 *
	 * @param title
	 * @param description
	 * @param defaultValue
	 * @param value
	 */
	public ChartOption(String title, String description, Object defaultValue, Object value) {
		super();
		Title = title;
		Description = description;
		DefaultValue = defaultValue;
		Value = value;
	}

	/**
	 * Create option to help control and manage a particular chart.
	 *
	 * @param title
	 * @param description
	 * @param defaultValue
	 */
	public ChartOption(String title, String description, Object defaultValue) {
		this(title, description, defaultValue, null);
	}
}
