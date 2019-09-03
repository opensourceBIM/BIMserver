package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;

public enum AreaUnit implements BasicUnit {
	SQUARED_METER {
		@Override
		public double toSquaredMeters(double input) {
			return input;
		}
		
		@Override
		public double toSquaredCentiMeters(double area) {
			return area * 10000;
		}

		@Override
		public double toSquaredMilliMeters(double area) {
			return area * 1000000;
		}

		@Override
		public double convert(double area, AreaUnit modelAreaUnit) {
			return modelAreaUnit.toSquaredMeters(area);
		}
	},
	SQUARED_MILLI_METER {
		@Override
		public double toSquaredMeters(double input) {
			return input / 1000000;
		}

		@Override
		public double toSquaredCentiMeters(double area) {
			return area / 100;
		}

		@Override
		public double toSquaredMilliMeters(double area) {
			return area;
		}
		
		@Override
		public double convert(double area, AreaUnit modelAreaUnit) {
			return modelAreaUnit.toSquaredMilliMeters(area);
		}
	},
	SQUARED_CENTI_METER {
		@Override
		public double toSquaredMeters(double input) {
			return input / 10000;
		}
		
		@Override
		public double toSquaredCentiMeters(double area) {
			return area;
		}
		
		@Override
		public double toSquaredMilliMeters(double area) {
			return area * 100;
		}
		
		@Override
		public double convert(double area, AreaUnit modelAreaUnit) {
			return modelAreaUnit.toSquaredCentiMeters(area);
		}
	};

	public static AreaUnit fromPrefix(IfcSIPrefix prefix) {
		switch (prefix) {
		case NULL:
			return AreaUnit.SQUARED_METER;
		case MILLI:
			return AreaUnit.SQUARED_MILLI_METER;
		case CENTI:
			return AreaUnit.SQUARED_CENTI_METER;
		default:
			throw new RuntimeException("Unimplemented prefix: " + prefix);
		}
	}

	public static AreaUnit fromPrefix(org.bimserver.models.ifc4.IfcSIPrefix prefix) {
		switch (prefix) {
		case NULL:
			return AreaUnit.SQUARED_METER;
		case MILLI:
			return AreaUnit.SQUARED_MILLI_METER;
		case CENTI:
			return AreaUnit.SQUARED_CENTI_METER;
		default:
			throw new RuntimeException("Unimplemented prefix: " + prefix);
		}
	}
	
	public abstract double toSquaredMilliMeters(double area);

	public abstract double toSquaredCentiMeters(double area);
	
	public abstract double toSquaredMeters(double input);

	public abstract double convert(double area, AreaUnit modelAreaUnit);
}