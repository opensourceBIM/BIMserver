package org.bimserver.charting;

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

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.bimserver.charting.Charts.Chart;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.plugins.serializers.EmfSerializer;

public abstract class ChartEmfSerializer extends EmfSerializer {

	protected Chart chart = null;
	protected ArrayList<LinkedHashMap<String, Object>> rawData = null;
	protected String title = null;
	protected ArrayList<ChartOption> options = new ArrayList<>();

	public ChartEmfSerializer() {
		super();
	}

	/**
	 * @param title
	 */
	public ChartEmfSerializer(String title) {
		super();
		this.title = title;
	}

	/**
	 * @param title
	 * @param options
	 */
	public ChartEmfSerializer(String title, ArrayList<ChartOption> options) {
		super();
		this.title = title;
		this.options = options;
	}

	public void integrateSettings() {
		if (chart != null) {
			if (title != null)
				chart.Title = title;
			if (options != null)
				for (ChartOption option : options)
					chart.setOption(option.Title, option.getValue());
		}
	}

	public void addOption(String title, Object value) {
		if (options == null)
			options = new ArrayList<>();
		options.add(new ChartOption(title, null, null, value));
	}

	public boolean hasOption(String optionTitle) {
		if (options != null)
			for (ChartOption option : options)
				if (option.Title.equals(optionTitle))
					return true;
		return false;
	}

	public Object getOptionValue(String optionTitle) {
		if (options != null)
			for (ChartOption option : options)
				if (option.Title.equals(optionTitle))
					return option.getValue();
		return null;
	}

	@Override
	public void reset() {
		if (rawData != null)
			rawData.clear();
		setMode(Mode.BODY);
	}
}