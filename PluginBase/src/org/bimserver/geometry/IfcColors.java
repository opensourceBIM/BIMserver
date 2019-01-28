package org.bimserver.geometry;

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

public class IfcColors {
	public static float[] getDefaultColor(String type) {
		type = type.toUpperCase();
		switch (type) {
			case "IFCROOF": return new float[]{0.837255f, 0.203922f, 0.270588f, 1.0f};
			case "IFCSLAB": return new float[]{0.637255f, 0.603922f, 0.670588f, 1.0f};
			case "IFCWALL": return new float[]{0.537255f, 0.337255f, 0.237255f, 1.0f};
			case "IFCWALLSTANDARDCASE": return new float[]{0.537255f, 0.337255f, 0.237255f, 1.0f};
			case "IFCDOOR": return new float[]{0.637255f, 0.603922f, 0.670588f, 1.0f};
			case "IFCWINDOW": return new float[]{0.137255f, 0.403922f, 0.870588f, 0.5f};
			case "IFCOPENINGELEMENT": return new float[]{0.137255f, 0.403922f, 0.870588f, 0f};
			case "IFCRAILING": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCOLUMN": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCBEAM": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCFURNISHINGELEMENT": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCCURTAINWALL": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCSTAIR": return new float[]{0.637255f, 0.603922f, 0.670588f, 1.0f};
			case "IFCSTAIRFLIGHT": return new float[]{0.637255f, 0.603922f, 0.670588f, 1.0f};
			case "IFCBUILDINGELEMENTPROXY": return new float[]{0.5f, 0.5f, 0.5f, 1.0f};
			case "IFCFLOWSEGMENT": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCFLOWFITTING": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCFLOWTERMINAL": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCPROY": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCSITE": return new float[]{0.137255f, 0.403922f, 0.870588f, 1.0f};
			case "IFCLIGHTFIXTURE": return new float[]{0.8470588235f, 0.8470588235f, 0.870588f, 1.0f};
			case "IFCDUCTSEGMENT": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCDISTRIBUTIONFLOWELEMENT": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCDUCTFITTING": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCPLATE": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCAIRTERMINAL": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCMEMBER": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCCOVERING": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCTRANSPORTELEMENT": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCFLOWCONTROLLER": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCRAMP": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCFURNITURE": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCFOOTING": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCSYSTEMFURNITUREELEMENT": return new float[]{0.8470588235f, 0.427450980392f, 0f, 1.0f};
			case "IFCSPACE": return new float[]{0.137255f, 0.303922f, 0.570588f, 0.5f};
			case "IFCBUILDINGELEMENTPART": return new float[]{1f, 0.5f, 0.5f, 1.0f};
		}
		return new float[]{0.8470588235f, 0.427450980392f, 0f, 1f};
	}
}
