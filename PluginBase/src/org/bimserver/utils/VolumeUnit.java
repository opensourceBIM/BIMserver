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

public enum VolumeUnit implements BasicUnit {
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
		public double toCubicCentiMeter(double input) {
			return input * 1000000;
		}
		
		@Override
		protected double toCubicDeciMeter(double input) {
			return input * 1000;
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
		public double toCubicCentiMeter(double input) {
			return input / 1000;
		}
		
		@Override
		public double toCubicMilliMeter(double input) {
			return input;
		}
		
		@Override
		protected double toCubicDeciMeter(double input) {
			return input / 1000000;
		}
		
		@Override
		public double convert(double volume, VolumeUnit modelVolumeUnit) {
			return modelVolumeUnit.toCubicMilliMeter(volume);
		}
	}, CUBIC_CENTI_METER {
		@Override
		public double toCubicMeter(double input) {
			return input / 1000000;
		}
		
		@Override
		public double toCubicCentiMeter(double input) {
			return input;
		}
		
		@Override
		public double toCubicMilliMeter(double input) {
			return input * 1000;
		}
		
		@Override
		protected double toCubicDeciMeter(double input) {
			return input / 1000;
		}
		
		@Override
		public double convert(double volume, VolumeUnit modelVolumeUnit) {
			return modelVolumeUnit.toCubicCentiMeter(volume);
		}
	}, CUBIC_DECI_METER {
		@Override
		public double toCubicMeter(double input) {
			return input / 1000;
		}
		
		@Override
		public double toCubicCentiMeter(double input) {
			return input * 1000;
		}
		
		@Override
		public double toCubicMilliMeter(double input) {
			return input * 1000000;
		}

		@Override
		protected double toCubicDeciMeter(double input) {
			return input;
		}

		@Override
		public double convert(double volume, VolumeUnit modelVolumeUnit) {
			return modelVolumeUnit.toCubicDeciMeter(volume);
		}
	};

	public static VolumeUnit fromPrefix(IfcSIPrefix prefix) {
		switch(prefix) {
		case NULL: 
			return VolumeUnit.CUBIC_METER;
		case MILLI:
			return VolumeUnit.CUBIC_MILLI_METER;
		case CENTI:
			return VolumeUnit.CUBIC_CENTI_METER;
		case DECI:
			return VolumeUnit.CUBIC_DECI_METER;
		default:
			throw new RuntimeException("Unimplemented prefix: " + prefix);
		}
	}

	protected double toCubicDeciMeter(double volume) {
		throw new AbstractMethodError();
	}

	public static VolumeUnit fromPrefix(org.bimserver.models.ifc4.IfcSIPrefix prefix) {
		switch(prefix) {
		case NULL: 
			return VolumeUnit.CUBIC_METER;
		case MILLI:
			return VolumeUnit.CUBIC_MILLI_METER;
		case CENTI:
			return VolumeUnit.CUBIC_CENTI_METER;
		case DECI:
			return VolumeUnit.CUBIC_DECI_METER;
		default:
			throw new RuntimeException("Unimplemented prefix: " + prefix);
		}
	}
	
	public abstract double toCubicMilliMeter(double volume);

	public abstract double toCubicCentiMeter(double volume);

	public abstract double toCubicMeter(double input);

	public abstract double convert(double volume, VolumeUnit modelVolumeUnit);
}