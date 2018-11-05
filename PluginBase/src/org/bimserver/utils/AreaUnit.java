package org.bimserver.utils;

import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;

public enum AreaUnit {
	SQUARED_METER {
		@Override
		public double toSquaredMeters(double input) {
			return input;
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
		public double toSquaredMilliMeters(double area) {
			return area;
		}
		
		@Override
		public double convert(double area, AreaUnit modelAreaUnit) {
			return modelAreaUnit.toSquaredMilliMeters(area);
		}
	};

	public static AreaUnit fromPrefix(IfcSIPrefix prefix) {
		switch (prefix) {
		case NULL:
			return AreaUnit.SQUARED_METER;
		case MILLI:
			return AreaUnit.SQUARED_MILLI_METER;
		}
		return null;
	}

	protected double toSquaredMilliMeters(double area) {
		throw new AbstractMethodError();
	}

	public double toSquaredMeters(double input) {
		throw new AbstractMethodError();
	}

	public double convert(double area, AreaUnit modelAreaUnit) {
		throw new AbstractMethodError();
	}
}