package org.bimserver.utils;

import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;

public enum VolumeUnit {
	CUBIC_METER {
		@Override
		public double toCubicMeter(double input) {
			return input;
		}

		@Override
		public double toCubicMilliMeter(double input) {
			return input * 1000000000;
		}

		@Override
		public double convert(double volume, VolumeUnit modelVolumeUnit) {
			return modelVolumeUnit.toCubicMeter(volume);
		}
}, CUBIC_MILLI_METER {
		@Override
		public double toCubicMeter(double input) {
			return input / 1000000000;
		}
		
		@Override
		public double toCubicMilliMeter(double input) {
			return input;
		}
		
		@Override
		public double convert(double volume, VolumeUnit modelVolumeUnit) {
			return modelVolumeUnit.toCubicMilliMeter(volume);
		}
	};

	public static VolumeUnit fromPrefix(IfcSIPrefix prefix) {
		switch(prefix) {
		case NULL: 
			return VolumeUnit.CUBIC_METER;
		case MILLI:
			return VolumeUnit.CUBIC_MILLI_METER;
		}
		return null;
	}

	protected double toCubicMilliMeter(double volume) {
		throw new AbstractMethodError();
	}

	public double toCubicMeter(double input) {
		throw new AbstractMethodError();
	}

	public double convert(double volume, VolumeUnit modelVolumeUnit) {
		throw new AbstractMethodError();
	}
}