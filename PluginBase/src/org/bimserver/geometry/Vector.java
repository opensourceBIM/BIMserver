package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

public class Vector {
    // dot product (3D) which allows vector operations in arguments
    public static float dot(float[] u,float[] v) {
        return ((u[X] * v[X]) + (u[Y] * v[Y]) + (u[Z] * v[Z]));
    }
    public static double dot(double[] u,double[] v) {
    	return ((u[X] * v[X]) + (u[Y] * v[Y]) + (u[Z] * v[Z]));
    }
    public static float[] minus(float[] u, float[] v){
        return new float[]{u[X]-v[X],u[Y]-v[Y],u[Z]-v[Z]};
    }
    public static float[] addition(float[] u, float[] v){
        return new float[]{u[X]+v[X],u[Y]+v[Y],u[Z]+v[Z]};
    }
    public static double[] addition(double[] u, double[] v){
    	return new double[]{u[X]+v[X],u[Y]+v[Y],u[Z]+v[Z]};
    }
    public static void addition(double[] output, double[] u, double[] v){
    	output[X] = u[X]+v[X];
    	output[Y] = u[Y]+v[Y];
    	output[Z] = u[Z]+v[Z];
    }
    public static double[] subtract(double[] u, double[] v){
    	return new double[]{u[X]-v[X],u[Y]-v[Y],u[Z]-v[Z], 1};
    }
    public static float[] subtract(float[] u, float[] v){
    	return new float[]{u[X]-v[X],u[Y]-v[Y],u[Z]-v[Z], 1};
    }
    //scalar product
    public static float[] scalarProduct(float r, float[] u){
        return new float[]{u[X]*r,u[Y]*r,u[Z]*r};
    }
    //scalar product
    public static float[] scalarProduct2(float r, float[] u){
    	return new float[]{u[X]*r,u[Y]*r};
    }
    //scalar product
    public static double[] scalarProduct(double r, double[] u){
    	return new double[]{u[X]*r,u[Y]*r,u[Z]*r};
    }
    // (cross product)
    public static float[] crossProduct(float[] u, float[] v){
        return new float[]{(u[Y]*v[Z]) - (u[Z]*v[Y]),(u[Z]*v[X]) - (u[X]*v[Z]),(u[X]*v[Y]) - (u[Y]*v[X])};
    }

    // (cross product)
    public static double[] crossProduct(double[] u, double[] v){
        return new double[]{(u[Y]*v[Z]) - (u[Z]*v[Y]),(u[Z]*v[X]) - (u[X]*v[Z]),(u[X]*v[Y]) - (u[Y]*v[X])};
    }

    //mangnatude or length
    public static float length(float[] u){
        return (float) Math.abs(Math.sqrt((u[X] *u[X]) + (u[Y] *u[Y]) + (u[Z] *u[Z])));
    }
    public static double length(double[] u){
    	return (double) Math.abs(Math.sqrt((u[X] *u[X]) + (u[Y] *u[Y]) + (u[Z] *u[Z])));
    }
 
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;

    public static void normalize4(float[] vector) {
    	float a = vector[0];
    	float b = vector[1];
    	float c = vector[2];
    	float d = vector[3];
    	float len = a*a + b*b + c*c + d*d;
    	if (len > 0) {
    		len = (float) (1 / Math.sqrt(len));
    	}
    	vector[0] = a * len;
    	vector[0] = b * len;
    	vector[0] = c * len;
    	vector[0] = d * len;
    	
    }
    
    public static void normalize(float[] rayDir) {
		float l = length(rayDir);
		rayDir[0] = rayDir[0] / l;
		rayDir[1] = rayDir[1] / l;
		rayDir[2] = rayDir[2] / l;
	}
	public static void normalize(double[] rayDir) {
		double l = length(rayDir);
		if (l == 0) {
			return;
		}
		rayDir[0] = rayDir[0] / l;
		rayDir[1] = rayDir[1] / l;
		rayDir[2] = rayDir[2] / l;
	}

	public static void dump(float[] v) {
		System.out.println(v[0] + ", " + v[1] + ", " + v[2] + (v.length == 4 ? (", " + v[3]) : ""));
	}

	public static void dump(float[] v, int start) {
		System.out.println(v[start * 4 + 0] + ", " + v[start * 4 + 1] + ", " + v[start * 4 + 2] + ", " + v[start * 4 + 3]);
	}

	public static void dump(String pre, float[] v) {
		System.out.println(pre + ": " + v[0] + ", " + v[1] + ", " + v[2] + (v.length == 4 ? (", " + v[3]) : ""));
	}
	
	public static float getArea(float[][] triangle) {
		float[] ab = minus(triangle[1], triangle[0]);
		float[] ac = minus(triangle[2], triangle[0]);
		float[] cross = crossProduct(ab, ac);
		return (float) (0.5f * Math.sqrt(cross[0] * cross[0] + cross[1] * cross[1] + cross[2] * cross[2]));
	}
	
	public static void main(String[] args) {
		float[][] triangle = new float[3][3];
		triangle[0][0] = -5;
		triangle[0][1] = 0;
		triangle[0][2] = 0;
		triangle[1][0] = 1;
		triangle[1][1] = 0;
		triangle[1][2] = 0;
		triangle[2][0] = 0;
		triangle[2][1] = 1;
		triangle[2][2] = 0;
		
		System.out.println(getArea(triangle));
	}
	public static void dump(String message, double[] inputVertex) {
		System.out.println(message);
		for (int i=0; i<inputVertex.length; i++) {
			System.out.print(inputVertex[i]);
			if (i != inputVertex.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	public static float[] copy(float[] currentStartPosition) {
		float[] result = new float[currentStartPosition.length];
		for (int i=0; i<currentStartPosition.length; i++) {
			result[i] = currentStartPosition[i];
		}
		return result;
	}

	public static float[] invert(float[] normal) {
		return new float[] {-normal[0], -normal[1], -normal[2]};
	}
}