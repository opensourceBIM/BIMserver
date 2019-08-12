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

import java.util.Arrays;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

public class Matrix {

	public static void main(String[] args) {
		float[] x = new float[16];
		setIdentityM(x, 0);
		translateM(x, 0, 2, 3, 4);
		dump(x);
	}
	
    /** Temporary memory for operations that need temporary matrix data. */
    private final static float[] sTemp = new float[32];
    private final static double[] sTempD = new double[32];

    /**
     * Multiply two 4x4 matrices together and store the result in a third 4x4
     * matrix. In matrix notation: result = lhs x rhs. Due to the way
     * matrix multiplication works, the result matrix will have the same
     * effect as first multiplying by the rhs matrix, then multiplying by
     * the lhs matrix. This is the opposite of what you might expect.
     *
     * The same float array may be passed for result, lhs, and/or rhs. However,
     * the result element values are undefined if the result elements overlap
     * either the lhs or rhs elements.
     *
     * @param result The float array that holds the result.
     * @param resultOffset The offset into the result array where the result is
     *        stored.
     * @param lhs The float array that holds the left-hand-side matrix.
     * @param lhsOffset The offset into the lhs array where the lhs is stored
     * @param rhs The float array that holds the right-hand-side matrix.
     * @param rhsOffset The offset into the rhs array where the rhs is stored.
     *
     * @throws IllegalArgumentException if result, lhs, or rhs are null, or if
     * resultOffset + 16 > result.length or lhsOffset + 16 > lhs.length or
     * rhsOffset + 16 > rhs.length.
     */
    public static void multiplyMM(float[] result, int resultOffset,
            float[] lhs, int lhsOffset, float[] rhs, int rhsOffset) {
    	result[resultOffset + 0] = rhs[0] * lhs[0] + rhs[1] * lhs[4] + rhs[2] * lhs[8] + rhs[3] * lhs[12];
    	result[resultOffset + 1] = rhs[0] * lhs[1] + rhs[1] * lhs[5] + rhs[2] * lhs[9] + rhs[3] * lhs[13];
    	result[resultOffset + 2] = rhs[0] * lhs[2] + rhs[1] * lhs[6] + rhs[2] * lhs[10] + rhs[3] * lhs[14];
    	result[resultOffset + 3] = rhs[0] * lhs[3] + rhs[1] * lhs[7] + rhs[2] * lhs[11] + rhs[3] * lhs[15];

    	result[resultOffset + 4] = rhs[4] * lhs[0] + rhs[5] * lhs[4] + rhs[6] * lhs[8] + rhs[7] * lhs[12];
    	result[resultOffset + 5] = rhs[4] * lhs[1] + rhs[5] * lhs[5] + rhs[6] * lhs[9] + rhs[7] * lhs[13];
    	result[resultOffset + 6] = rhs[4] * lhs[2] + rhs[5] * lhs[6] + rhs[6] * lhs[10] + rhs[7] * lhs[14];
    	result[resultOffset + 7] = rhs[4] * lhs[3] + rhs[5] * lhs[7] + rhs[6] * lhs[11] + rhs[7] * lhs[15];

    	result[resultOffset + 8] = rhs[8] * lhs[0] + rhs[9] * lhs[4] + rhs[10] * lhs[8] + rhs[11] * lhs[12];
    	result[resultOffset + 9] = rhs[8] * lhs[1] + rhs[9] * lhs[5] + rhs[10] * lhs[9] + rhs[11] * lhs[13];
    	result[resultOffset + 10] = rhs[8] * lhs[2] + rhs[9] * lhs[6] + rhs[10] * lhs[10] + rhs[11] * lhs[14];
    	result[resultOffset + 11] = rhs[8] * lhs[3] + rhs[9] * lhs[7] + rhs[10] * lhs[11] + rhs[11] * lhs[15];

    	result[resultOffset + 12] = rhs[12] * lhs[0] + rhs[13] * lhs[4] + rhs[14] * lhs[8] + rhs[15] * lhs[12];
    	result[resultOffset + 13] = rhs[12] * lhs[1] + rhs[13] * lhs[5] + rhs[14] * lhs[9] + rhs[15] * lhs[13];
    	result[resultOffset + 14] = rhs[12] * lhs[2] + rhs[13] * lhs[6] + rhs[14] * lhs[10] + rhs[15] * lhs[14];
    	result[resultOffset + 15] = rhs[12] * lhs[3] + rhs[13] * lhs[7] + rhs[14] * lhs[11] + rhs[15] * lhs[15];
    	
    }

    public static void multiplyMM(double[] result, int resultOffset,
    		double[] lhs, int lhsOffset, double[] rhs, int rhsOffset) {
    	result[resultOffset + 0] = rhs[0] * lhs[0] + rhs[1] * lhs[4] + rhs[2] * lhs[8] + rhs[3] * lhs[12];
    	result[resultOffset + 1] = rhs[0] * lhs[1] + rhs[1] * lhs[5] + rhs[2] * lhs[9] + rhs[3] * lhs[13];
    	result[resultOffset + 2] = rhs[0] * lhs[2] + rhs[1] * lhs[6] + rhs[2] * lhs[10] + rhs[3] * lhs[14];
    	result[resultOffset + 3] = rhs[0] * lhs[3] + rhs[1] * lhs[7] + rhs[2] * lhs[11] + rhs[3] * lhs[15];
    	
    	result[resultOffset + 4] = rhs[4] * lhs[0] + rhs[5] * lhs[4] + rhs[6] * lhs[8] + rhs[7] * lhs[12];
    	result[resultOffset + 5] = rhs[4] * lhs[1] + rhs[5] * lhs[5] + rhs[6] * lhs[9] + rhs[7] * lhs[13];
    	result[resultOffset + 6] = rhs[4] * lhs[2] + rhs[5] * lhs[6] + rhs[6] * lhs[10] + rhs[7] * lhs[14];
    	result[resultOffset + 7] = rhs[4] * lhs[3] + rhs[5] * lhs[7] + rhs[6] * lhs[11] + rhs[7] * lhs[15];
    	
    	result[resultOffset + 8] = rhs[8] * lhs[0] + rhs[9] * lhs[4] + rhs[10] * lhs[8] + rhs[11] * lhs[12];
    	result[resultOffset + 9] = rhs[8] * lhs[1] + rhs[9] * lhs[5] + rhs[10] * lhs[9] + rhs[11] * lhs[13];
    	result[resultOffset + 10] = rhs[8] * lhs[2] + rhs[9] * lhs[6] + rhs[10] * lhs[10] + rhs[11] * lhs[14];
    	result[resultOffset + 11] = rhs[8] * lhs[3] + rhs[9] * lhs[7] + rhs[10] * lhs[11] + rhs[11] * lhs[15];
    	
    	result[resultOffset + 12] = rhs[12] * lhs[0] + rhs[13] * lhs[4] + rhs[14] * lhs[8] + rhs[15] * lhs[12];
    	result[resultOffset + 13] = rhs[12] * lhs[1] + rhs[13] * lhs[5] + rhs[14] * lhs[9] + rhs[15] * lhs[13];
    	result[resultOffset + 14] = rhs[12] * lhs[2] + rhs[13] * lhs[6] + rhs[14] * lhs[10] + rhs[15] * lhs[14];
    	result[resultOffset + 15] = rhs[12] * lhs[3] + rhs[13] * lhs[7] + rhs[14] * lhs[11] + rhs[15] * lhs[15];
    	
    }

    public static float[] multiplyV(float[] transformationMatrix, float[] coordinates) {
		if (coordinates.length == 3) {
			float[] result = new float[4];
			Matrix.multiplyMV(result, 0, transformationMatrix, 0, new float[]{coordinates[0], coordinates[1], coordinates[2], 0}, 0);
			return new float[]{result[0], result[1], result[2]};
		} else if (coordinates.length == 4) {
			float[] result = new float[4];
			Matrix.multiplyMV(result, 0, transformationMatrix, 0, new float[]{coordinates[0], coordinates[1], coordinates[2], coordinates[3]}, 0);
			return result;
		}
		return null;
	}

    public static double[] multiplyV(double[] transformationMatrix, double[] coordinates) {
    	if (coordinates.length == 3) {
    		double[] result = new double[4];
    		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[]{coordinates[0], coordinates[1], coordinates[2], 0}, 0);
    		return new double[]{result[0], result[1], result[2]};
    	} else if (coordinates.length == 4) {
    		double[] result = new double[4];
    		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[]{coordinates[0], coordinates[1], coordinates[2], coordinates[3]}, 0);
    		return result;
    	}
    	return null;
    }
    
    /**
     * Multiply a 4 element vector by a 4x4 matrix and store the result in a 4
     * element column vector. In matrix notation: result = lhs x rhs
     *
     * The same float array may be passed for resultVec, lhsMat, and/or rhsVec.
     * However, the resultVec element values are undefined if the resultVec
     * elements overlap either the lhsMat or rhsVec elements.
     *
     * @param resultVec The float array that holds the result vector.
     * @param resultVecOffset The offset into the result array where the result
     *        vector is stored.
     * @param lhsMat The float array that holds the left-hand-side matrix.
     * @param lhsMatOffset The offset into the lhs array where the lhs is stored
     * @param rhsVec The float array that holds the right-hand-side vector.
     * @param rhsVecOffset The offset into the rhs vector where the rhs vector
     *        is stored.
     *
     * @throws IllegalArgumentException if resultVec, lhsMat,
     * or rhsVec are null, or if resultVecOffset + 4 > resultVec.length
     * or lhsMatOffset + 16 > lhsMat.length or
     * rhsVecOffset + 4 > rhsVec.length.
     */
    public static void multiplyMV(float[] resultVec, int resultVecOffset, float[] lhsMat, int lhsMatOffset, float[] rhsVec, int rhsVecOffset) {
    	resultVec[resultVecOffset + 0] = lhsMat[lhsMatOffset + 0] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 4] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 8] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 12] * rhsVec[rhsVecOffset + 3];
    	resultVec[resultVecOffset + 1] = lhsMat[lhsMatOffset + 1] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 5] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 9] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 13] * rhsVec[rhsVecOffset + 3];
    	resultVec[resultVecOffset + 2] = lhsMat[lhsMatOffset + 2] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 6] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 10] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 14] * rhsVec[rhsVecOffset + 3];
    	resultVec[resultVecOffset + 3] = lhsMat[lhsMatOffset + 3] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 7] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 11] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 15] * rhsVec[rhsVecOffset + 3];
    }

    public static void multiplyMV(float[] resultVec, int resultVecOffset, double[] lhsMat, int lhsMatOffset, double[] rhsVec, int rhsVecOffset) {
    	resultVec[resultVecOffset + 0] = (float) (lhsMat[lhsMatOffset + 0] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 4] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 8] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 12] * rhsVec[rhsVecOffset + 3]);
    	resultVec[resultVecOffset + 1] = (float) (lhsMat[lhsMatOffset + 1] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 5] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 9] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 13] * rhsVec[rhsVecOffset + 3]);
    	resultVec[resultVecOffset + 2] = (float) (lhsMat[lhsMatOffset + 2] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 6] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 10] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 14] * rhsVec[rhsVecOffset + 3]);
    	resultVec[resultVecOffset + 3] = (float) (lhsMat[lhsMatOffset + 3] * rhsVec[rhsVecOffset + 0] + lhsMat[lhsMatOffset + 7] * rhsVec[rhsVecOffset + 1] + lhsMat[lhsMatOffset + 11] * rhsVec[rhsVecOffset + 2] + lhsMat[lhsMatOffset + 15] * rhsVec[rhsVecOffset + 3]);
    }

    public static void multiplyMV(float[] resultVec, int resultVecOffset, double[] lhsMat, int lhsMatOffset, float[] rhsVec, int rhsVecOffset) {
    	resultVec[resultVecOffset + 0] = (float) (lhsMat[0] * rhsVec[0] + lhsMat[4] * rhsVec[1] + lhsMat[8] * rhsVec[2] + lhsMat[12] * rhsVec[3]);
    	resultVec[resultVecOffset + 1] = (float) (lhsMat[1] * rhsVec[0] + lhsMat[5] * rhsVec[1] + lhsMat[9] * rhsVec[2] + lhsMat[13] * rhsVec[3]);
    	resultVec[resultVecOffset + 2] = (float) (lhsMat[2] * rhsVec[0] + lhsMat[6] * rhsVec[1] + lhsMat[10] * rhsVec[2] + lhsMat[14] * rhsVec[3]);
    	resultVec[resultVecOffset + 3] = (float) (lhsMat[3] * rhsVec[0] + lhsMat[7] * rhsVec[1] + lhsMat[11] * rhsVec[2] + lhsMat[15] * rhsVec[3]);
    }

    public static void multiplyMV(double[] resultVec, int resultVecOffset, double[] lhsMat, int lhsMatOffset, double[] rhsVec, int rhsVecOffset) {
    	resultVec[resultVecOffset + 0] = lhsMat[0] * rhsVec[0] + lhsMat[4] * rhsVec[1] + lhsMat[8] * rhsVec[2] + lhsMat[12] * rhsVec[3];
    	resultVec[resultVecOffset + 1] = lhsMat[1] * rhsVec[0] + lhsMat[5] * rhsVec[1] + lhsMat[9] * rhsVec[2] + lhsMat[13] * rhsVec[3];
    	resultVec[resultVecOffset + 2] = lhsMat[2] * rhsVec[0] + lhsMat[6] * rhsVec[1] + lhsMat[10] * rhsVec[2] + lhsMat[14] * rhsVec[3];
    	resultVec[resultVecOffset + 3] = lhsMat[3] * rhsVec[0] + lhsMat[7] * rhsVec[1] + lhsMat[11] * rhsVec[2] + lhsMat[15] * rhsVec[3];
    }

    /**
     * Transposes a 4 x 4 matrix.
     *
     * @param mTrans the array that holds the output inverted matrix
     * @param mTransOffset an offset into mInv where the inverted matrix is
     *        stored.
     * @param m the input array
     * @param mOffset an offset into m where the matrix is stored.
     */
    public static void transposeM(float[] mTrans, int mTransOffset, float[] m,
            int mOffset) {
        for (int i = 0; i < 4; i++) {
            int mBase = i * 4 + mOffset;
            mTrans[i + mTransOffset] = m[mBase];
            mTrans[i + 4 + mTransOffset] = m[mBase + 1];
            mTrans[i + 8 + mTransOffset] = m[mBase + 2];
            mTrans[i + 12 + mTransOffset] = m[mBase + 3];
        }
    }

    public static void transposeM(double[] mTrans, int mTransOffset, double[] m,
    		int mOffset) {
    	for (int i = 0; i < 4; i++) {
    		int mBase = i * 4 + mOffset;
    		mTrans[i + mTransOffset] = m[mBase];
    		mTrans[i + 4 + mTransOffset] = m[mBase + 1];
    		mTrans[i + 8 + mTransOffset] = m[mBase + 2];
    		mTrans[i + 12 + mTransOffset] = m[mBase + 3];
    	}
    }

    /**
     * Inverts a 4 x 4 matrix.
     *
     * @param mInv the array that holds the output inverted matrix
     * @param mInvOffset an offset into mInv where the inverted matrix is
     *        stored.
     * @param m the input array
     * @param mOffset an offset into m where the matrix is stored.
     * @return true if the matrix could be inverted, false if it could not.
     */
    public static boolean invertM(float[] mInv, int mInvOffset, float[] m,
            int mOffset) {
        // Invert a 4 x 4 matrix using Cramer's Rule

        // transpose matrix
        final float src0  = m[mOffset +  0];
        final float src4  = m[mOffset +  1];
        final float src8  = m[mOffset +  2];
        final float src12 = m[mOffset +  3];

        final float src1  = m[mOffset +  4];
        final float src5  = m[mOffset +  5];
        final float src9  = m[mOffset +  6];
        final float src13 = m[mOffset +  7];

        final float src2  = m[mOffset +  8];
        final float src6  = m[mOffset +  9];
        final float src10 = m[mOffset + 10];
        final float src14 = m[mOffset + 11];

        final float src3  = m[mOffset + 12];
        final float src7  = m[mOffset + 13];
        final float src11 = m[mOffset + 14];
        final float src15 = m[mOffset + 15];

        // calculate pairs for first 8 elements (cofactors)
        final float atmp0  = src10 * src15;
        final float atmp1  = src11 * src14;
        final float atmp2  = src9  * src15;
        final float atmp3  = src11 * src13;
        final float atmp4  = src9  * src14;
        final float atmp5  = src10 * src13;
        final float atmp6  = src8  * src15;
        final float atmp7  = src11 * src12;
        final float atmp8  = src8  * src14;
        final float atmp9  = src10 * src12;
        final float atmp10 = src8  * src13;
        final float atmp11 = src9  * src12;

        // calculate first 8 elements (cofactors)
        final float dst0  = (atmp0 * src5 + atmp3 * src6 + atmp4  * src7)
                          - (atmp1 * src5 + atmp2 * src6 + atmp5  * src7);
        final float dst1  = (atmp1 * src4 + atmp6 * src6 + atmp9  * src7)
                          - (atmp0 * src4 + atmp7 * src6 + atmp8  * src7);
        final float dst2  = (atmp2 * src4 + atmp7 * src5 + atmp10 * src7)
                          - (atmp3 * src4 + atmp6 * src5 + atmp11 * src7);
        final float dst3  = (atmp5 * src4 + atmp8 * src5 + atmp11 * src6)
                          - (atmp4 * src4 + atmp9 * src5 + atmp10 * src6);
        final float dst4  = (atmp1 * src1 + atmp2 * src2 + atmp5  * src3)
                          - (atmp0 * src1 + atmp3 * src2 + atmp4  * src3);
        final float dst5  = (atmp0 * src0 + atmp7 * src2 + atmp8  * src3)
                          - (atmp1 * src0 + atmp6 * src2 + atmp9  * src3);
        final float dst6  = (atmp3 * src0 + atmp6 * src1 + atmp11 * src3)
                          - (atmp2 * src0 + atmp7 * src1 + atmp10 * src3);
        final float dst7  = (atmp4 * src0 + atmp9 * src1 + atmp10 * src2)
                          - (atmp5 * src0 + atmp8 * src1 + atmp11 * src2);

        // calculate pairs for second 8 elements (cofactors)
        final float btmp0  = src2 * src7;
        final float btmp1  = src3 * src6;
        final float btmp2  = src1 * src7;
        final float btmp3  = src3 * src5;
        final float btmp4  = src1 * src6;
        final float btmp5  = src2 * src5;
        final float btmp6  = src0 * src7;
        final float btmp7  = src3 * src4;
        final float btmp8  = src0 * src6;
        final float btmp9  = src2 * src4;
        final float btmp10 = src0 * src5;
        final float btmp11 = src1 * src4;

        // calculate second 8 elements (cofactors)
        final float dst8  = (btmp0  * src13 + btmp3  * src14 + btmp4  * src15)
                          - (btmp1  * src13 + btmp2  * src14 + btmp5  * src15);
        final float dst9  = (btmp1  * src12 + btmp6  * src14 + btmp9  * src15)
                          - (btmp0  * src12 + btmp7  * src14 + btmp8  * src15);
        final float dst10 = (btmp2  * src12 + btmp7  * src13 + btmp10 * src15)
                          - (btmp3  * src12 + btmp6  * src13 + btmp11 * src15);
        final float dst11 = (btmp5  * src12 + btmp8  * src13 + btmp11 * src14)
                          - (btmp4  * src12 + btmp9  * src13 + btmp10 * src14);
        final float dst12 = (btmp2  * src10 + btmp5  * src11 + btmp1  * src9 )
                          - (btmp4  * src11 + btmp0  * src9  + btmp3  * src10);
        final float dst13 = (btmp8  * src11 + btmp0  * src8  + btmp7  * src10)
                          - (btmp6  * src10 + btmp9  * src11 + btmp1  * src8 );
        final float dst14 = (btmp6  * src9  + btmp11 * src11 + btmp3  * src8 )
                          - (btmp10 * src11 + btmp2  * src8  + btmp7  * src9 );
        final float dst15 = (btmp10 * src10 + btmp4  * src8  + btmp9  * src9 )
                          - (btmp8  * src9  + btmp11 * src10 + btmp5  * src8 );

        // calculate determinant
        final float det =
                src0 * dst0 + src1 * dst1 + src2 * dst2 + src3 * dst3;

        if (det == 0.0f) {
            return false;
        }

        // calculate matrix inverse
        final float invdet = 1.0f / det;
        mInv[     mInvOffset] = dst0  * invdet;
        mInv[ 1 + mInvOffset] = dst1  * invdet;
        mInv[ 2 + mInvOffset] = dst2  * invdet;
        mInv[ 3 + mInvOffset] = dst3  * invdet;

        mInv[ 4 + mInvOffset] = dst4  * invdet;
        mInv[ 5 + mInvOffset] = dst5  * invdet;
        mInv[ 6 + mInvOffset] = dst6  * invdet;
        mInv[ 7 + mInvOffset] = dst7  * invdet;

        mInv[ 8 + mInvOffset] = dst8  * invdet;
        mInv[ 9 + mInvOffset] = dst9  * invdet;
        mInv[10 + mInvOffset] = dst10 * invdet;
        mInv[11 + mInvOffset] = dst11 * invdet;

        mInv[12 + mInvOffset] = dst12 * invdet;
        mInv[13 + mInvOffset] = dst13 * invdet;
        mInv[14 + mInvOffset] = dst14 * invdet;
        mInv[15 + mInvOffset] = dst15 * invdet;

        return true;
    }
    public static boolean invertM(double[] mInv, int mInvOffset, double[] m,
    		int mOffset) {
    	// Invert a 4 x 4 matrix using Cramer's Rule
    	
    	// transpose matrix
    	final double src0  = m[mOffset +  0];
    	final double src4  = m[mOffset +  1];
    	final double src8  = m[mOffset +  2];
    	final double src12 = m[mOffset +  3];
    	
    	final double src1  = m[mOffset +  4];
    	final double src5  = m[mOffset +  5];
    	final double src9  = m[mOffset +  6];
    	final double src13 = m[mOffset +  7];
    	
    	final double src2  = m[mOffset +  8];
    	final double src6  = m[mOffset +  9];
    	final double src10 = m[mOffset + 10];
    	final double src14 = m[mOffset + 11];
    	
    	final double src3  = m[mOffset + 12];
    	final double src7  = m[mOffset + 13];
    	final double src11 = m[mOffset + 14];
    	final double src15 = m[mOffset + 15];
    	
    	// calculate pairs for first 8 elements (cofactors)
    	final double atmp0  = src10 * src15;
    	final double atmp1  = src11 * src14;
    	final double atmp2  = src9  * src15;
    	final double atmp3  = src11 * src13;
    	final double atmp4  = src9  * src14;
    	final double atmp5  = src10 * src13;
    	final double atmp6  = src8  * src15;
    	final double atmp7  = src11 * src12;
    	final double atmp8  = src8  * src14;
    	final double atmp9  = src10 * src12;
    	final double atmp10 = src8  * src13;
    	final double atmp11 = src9  * src12;
    	
    	// calculate first 8 elements (cofactors)
    	final double dst0  = (atmp0 * src5 + atmp3 * src6 + atmp4  * src7)
    			- (atmp1 * src5 + atmp2 * src6 + atmp5  * src7);
    	final double dst1  = (atmp1 * src4 + atmp6 * src6 + atmp9  * src7)
    			- (atmp0 * src4 + atmp7 * src6 + atmp8  * src7);
    	final double dst2  = (atmp2 * src4 + atmp7 * src5 + atmp10 * src7)
    			- (atmp3 * src4 + atmp6 * src5 + atmp11 * src7);
    	final double dst3  = (atmp5 * src4 + atmp8 * src5 + atmp11 * src6)
    			- (atmp4 * src4 + atmp9 * src5 + atmp10 * src6);
    	final double dst4  = (atmp1 * src1 + atmp2 * src2 + atmp5  * src3)
    			- (atmp0 * src1 + atmp3 * src2 + atmp4  * src3);
    	final double dst5  = (atmp0 * src0 + atmp7 * src2 + atmp8  * src3)
    			- (atmp1 * src0 + atmp6 * src2 + atmp9  * src3);
    	final double dst6  = (atmp3 * src0 + atmp6 * src1 + atmp11 * src3)
    			- (atmp2 * src0 + atmp7 * src1 + atmp10 * src3);
    	final double dst7  = (atmp4 * src0 + atmp9 * src1 + atmp10 * src2)
    			- (atmp5 * src0 + atmp8 * src1 + atmp11 * src2);
    	
    	// calculate pairs for second 8 elements (cofactors)
    	final double btmp0  = src2 * src7;
    	final double btmp1  = src3 * src6;
    	final double btmp2  = src1 * src7;
    	final double btmp3  = src3 * src5;
    	final double btmp4  = src1 * src6;
    	final double btmp5  = src2 * src5;
    	final double btmp6  = src0 * src7;
    	final double btmp7  = src3 * src4;
    	final double btmp8  = src0 * src6;
    	final double btmp9  = src2 * src4;
    	final double btmp10 = src0 * src5;
    	final double btmp11 = src1 * src4;
    	
    	// calculate second 8 elements (cofactors)
    	final double dst8  = (btmp0  * src13 + btmp3  * src14 + btmp4  * src15)
    			- (btmp1  * src13 + btmp2  * src14 + btmp5  * src15);
    	final double dst9  = (btmp1  * src12 + btmp6  * src14 + btmp9  * src15)
    			- (btmp0  * src12 + btmp7  * src14 + btmp8  * src15);
    	final double dst10 = (btmp2  * src12 + btmp7  * src13 + btmp10 * src15)
    			- (btmp3  * src12 + btmp6  * src13 + btmp11 * src15);
    	final double dst11 = (btmp5  * src12 + btmp8  * src13 + btmp11 * src14)
    			- (btmp4  * src12 + btmp9  * src13 + btmp10 * src14);
    	final double dst12 = (btmp2  * src10 + btmp5  * src11 + btmp1  * src9 )
    			- (btmp4  * src11 + btmp0  * src9  + btmp3  * src10);
    	final double dst13 = (btmp8  * src11 + btmp0  * src8  + btmp7  * src10)
    			- (btmp6  * src10 + btmp9  * src11 + btmp1  * src8 );
    	final double dst14 = (btmp6  * src9  + btmp11 * src11 + btmp3  * src8 )
    			- (btmp10 * src11 + btmp2  * src8  + btmp7  * src9 );
    	final double dst15 = (btmp10 * src10 + btmp4  * src8  + btmp9  * src9 )
    			- (btmp8  * src9  + btmp11 * src10 + btmp5  * src8 );
    	
    	// calculate determinant
    	final double det =
    			src0 * dst0 + src1 * dst1 + src2 * dst2 + src3 * dst3;
    	
    	if (det == 0.0f) {
    		return false;
    	}
    	
    	// calculate matrix inverse
    	final double invdet = 1.0f / det;
    	mInv[     mInvOffset] = dst0  * invdet;
    	mInv[ 1 + mInvOffset] = dst1  * invdet;
    	mInv[ 2 + mInvOffset] = dst2  * invdet;
    	mInv[ 3 + mInvOffset] = dst3  * invdet;
    	
    	mInv[ 4 + mInvOffset] = dst4  * invdet;
    	mInv[ 5 + mInvOffset] = dst5  * invdet;
    	mInv[ 6 + mInvOffset] = dst6  * invdet;
    	mInv[ 7 + mInvOffset] = dst7  * invdet;
    	
    	mInv[ 8 + mInvOffset] = dst8  * invdet;
    	mInv[ 9 + mInvOffset] = dst9  * invdet;
    	mInv[10 + mInvOffset] = dst10 * invdet;
    	mInv[11 + mInvOffset] = dst11 * invdet;
    	
    	mInv[12 + mInvOffset] = dst12 * invdet;
    	mInv[13 + mInvOffset] = dst13 * invdet;
    	mInv[14 + mInvOffset] = dst14 * invdet;
    	mInv[15 + mInvOffset] = dst15 * invdet;
    	
    	return true;
    }

    /**
     * Computes an orthographic projection matrix.
     *
     * @param m returns the result
     * @param mOffset
     * @param left
     * @param right
     * @param bottom
     * @param top
     * @param near
     * @param far
     */
    public static void orthoM(float[] m, int mOffset,
        float left, float right, float bottom, float top,
        float near, float far) {
        if (left == right) {
            throw new IllegalArgumentException("left == right");
        }
        if (bottom == top) {
            throw new IllegalArgumentException("bottom == top");
        }
        if (near == far) {
            throw new IllegalArgumentException("near == far");
        }

        final float r_width  = 1.0f / (right - left);
        final float r_height = 1.0f / (top - bottom);
        final float r_depth  = 1.0f / (far - near);
        final float x =  2.0f * (r_width);
        final float y =  2.0f * (r_height);
        final float z = -2.0f * (r_depth);
        final float tx = -(right + left) * r_width;
        final float ty = -(top + bottom) * r_height;
        final float tz = -(far + near) * r_depth;
        m[mOffset + 0] = x;
        m[mOffset + 5] = y;
        m[mOffset +10] = z;
        m[mOffset +12] = tx;
        m[mOffset +13] = ty;
        m[mOffset +14] = tz;
        m[mOffset +15] = 1.0f;
        m[mOffset + 1] = 0.0f;
        m[mOffset + 2] = 0.0f;
        m[mOffset + 3] = 0.0f;
        m[mOffset + 4] = 0.0f;
        m[mOffset + 6] = 0.0f;
        m[mOffset + 7] = 0.0f;
        m[mOffset + 8] = 0.0f;
        m[mOffset + 9] = 0.0f;
        m[mOffset + 11] = 0.0f;
    }


    /**
     * Define a projection matrix in terms of six clip planes
     * @param m the float array that holds the perspective matrix
     * @param offset the offset into float array m where the perspective
     * matrix data is written
     * @param left
     * @param right
     * @param bottom
     * @param top
     * @param near
     * @param far
     */
    public static void frustumM(float[] m, int offset,
            float left, float right, float bottom, float top,
            float near, float far) {
        if (left == right) {
            throw new IllegalArgumentException("left == right");
        }
        if (top == bottom) {
            throw new IllegalArgumentException("top == bottom");
        }
        if (near == far) {
            throw new IllegalArgumentException("near == far");
        }
        if (near <= 0.0f) {
            throw new IllegalArgumentException("near <= 0.0f");
        }
        if (far <= 0.0f) {
            throw new IllegalArgumentException("far <= 0.0f");
        }
        final float r_width  = 1.0f / (right - left);
        final float r_height = 1.0f / (top - bottom);
        final float r_depth  = 1.0f / (near - far);
        final float x = 2.0f * (near * r_width);
        final float y = 2.0f * (near * r_height);
        final float A = (right + left) * r_width;
        final float B = (top + bottom) * r_height;
        final float C = (far + near) * r_depth;
        final float D = 2.0f * (far * near * r_depth);
        m[offset + 0] = x;
        m[offset + 5] = y;
        m[offset + 8] = A;
        m[offset +  9] = B;
        m[offset + 10] = C;
        m[offset + 14] = D;
        m[offset + 11] = -1.0f;
        m[offset +  1] = 0.0f;
        m[offset +  2] = 0.0f;
        m[offset +  3] = 0.0f;
        m[offset +  4] = 0.0f;
        m[offset +  6] = 0.0f;
        m[offset +  7] = 0.0f;
        m[offset + 12] = 0.0f;
        m[offset + 13] = 0.0f;
        m[offset + 15] = 0.0f;
    }

    /**
     * Define a projection matrix in terms of a field of view angle, an
     * aspect ratio, and z clip planes
     * @param m the float array that holds the perspective matrix
     * @param offset the offset into float array m where the perspective
     * matrix data is written
     * @param fovy field of view in y direction, in degrees
     * @param aspect width to height aspect ratio of the viewport
     * @param zNear
     * @param zFar
     */
    public static void perspectiveM(float[] m, int offset,
          float fovy, float aspect, float zNear, float zFar) {
        float f = 1.0f / (float) Math.tan(fovy * (Math.PI / 360.0));
        float rangeReciprocal = 1.0f / (zNear - zFar);

        m[offset + 0] = f / aspect;
        m[offset + 1] = 0.0f;
        m[offset + 2] = 0.0f;
        m[offset + 3] = 0.0f;

        m[offset + 4] = 0.0f;
        m[offset + 5] = f;
        m[offset + 6] = 0.0f;
        m[offset + 7] = 0.0f;

        m[offset + 8] = 0.0f;
        m[offset + 9] = 0.0f;
        m[offset + 10] = (zFar + zNear) * rangeReciprocal;
        m[offset + 11] = -1.0f;

        m[offset + 12] = 0.0f;
        m[offset + 13] = 0.0f;
        m[offset + 14] = 2.0f * zFar * zNear * rangeReciprocal;
        m[offset + 15] = 0.0f;
    }

    /**
     * Computes the length of a vector
     *
     * @param x x coordinate of a vector
     * @param y y coordinate of a vector
     * @param z z coordinate of a vector
     * @return the length of a vector
     */
    public static float length(float x, float y, float z) {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public static double length(double x, double y, double z) {
    	return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Sets matrix m to the identity matrix.
     * @param sm returns the result
     * @param smOffset index into sm where the result matrix starts
     */
    public static void setIdentityM(float[] sm, int smOffset) {
        for (int i=0 ; i<16 ; i++) {
            sm[smOffset + i] = 0;
        }
        for(int i = 0; i < 16; i += 5) {
            sm[smOffset + i] = 1.0f;
        }
    }

    /**
     * Sets matrix m to the identity matrix.
     * @param sm returns the result
     * @param smOffset index into sm where the result matrix starts
     */
    public static void setIdentityM(double[] sm, int smOffset) {
    	for (int i=0 ; i<16 ; i++) {
    		sm[smOffset + i] = 0;
    	}
    	for(int i = 0; i < 16; i += 5) {
    		sm[smOffset + i] = 1.0;
    	}
    }

    /**
     * Scales matrix  m by x, y, and z, putting the result in sm
     * @param sm returns the result
     * @param smOffset index into sm where the result matrix starts
     * @param m source matrix
     * @param mOffset index into m where the source matrix starts
     * @param x scale factor x
     * @param y scale factor y
     * @param z scale factor z
     */
    public static void scaleM(float[] sm, int smOffset,
            float[] m, int mOffset,
            float x, float y, float z) {
        for (int i=0 ; i<4 ; i++) {
            int smi = smOffset + i;
            int mi = mOffset + i;
            sm[     smi] = m[     mi] * x;
            sm[ 4 + smi] = m[ 4 + mi] * y;
            sm[ 8 + smi] = m[ 8 + mi] * z;
            sm[12 + smi] = m[12 + mi];
        }
    }
    
    public static void scaleM(double[] m, int mOffset,
    		double x, double y, double z) {
    	for (int i=0 ; i<4 ; i++) {
    		int mi = mOffset + i;
    		m[     mi] *= x;
    		m[ 4 + mi] *= y;
    		m[ 8 + mi] *= z;
    	}
    }

    /**
     * Scales matrix m in place by sx, sy, and sz
     * @param m matrix to scale
     * @param mOffset index into m where the matrix starts
     * @param x scale factor x
     * @param y scale factor y
     * @param z scale factor z
     */
    public static void scaleM(float[] m, int mOffset,
            float x, float y, float z) {
        for (int i=0 ; i<4 ; i++) {
            int mi = mOffset + i;
            m[     mi] *= x;
            m[ 4 + mi] *= y;
            m[ 8 + mi] *= z;
        }
    }

    public static void scaleM(double[] m, int mOffset,
    		float x, float y, float z) {
    	for (int i=0 ; i<4 ; i++) {
    		int mi = mOffset + i;
    		m[     mi] *= x;
    		m[ 4 + mi] *= y;
    		m[ 8 + mi] *= z;
    	}
    }

    /**
     * Translates matrix m by x, y, and z, putting the result in tm
     * @param tm returns the result
     * @param tmOffset index into sm where the result matrix starts
     * @param m source matrix
     * @param mOffset index into m where the source matrix starts
     * @param x translation factor x
     * @param y translation factor y
     * @param z translation factor z
     */
    public static void translateM(float[] tm, int tmOffset,
            float[] m, int mOffset,
            float x, float y, float z) {
        for (int i=0 ; i<12 ; i++) {
            tm[tmOffset + i] = m[mOffset + i];
        }
        for (int i=0 ; i<4 ; i++) {
            int tmi = tmOffset + i;
            int mi = mOffset + i;
            tm[12 + tmi] = m[mi] * x + m[4 + mi] * y + m[8 + mi] * z +
                m[12 + mi];
        }
    }
    
    public static void translateM(double[] tm, int tmOffset,
    		double[] m, int mOffset,
    		double x, double y, double z) {
        for (int i=0 ; i<12 ; i++) {
            tm[tmOffset + i] = m[mOffset + i];
        }
        for (int i=0 ; i<4 ; i++) {
            int tmi = tmOffset + i;
            int mi = mOffset + i;
            tm[12 + tmi] = m[mi] * x + m[4 + mi] * y + m[8 + mi] * z +
                m[12 + mi];
        }
    }

    /**
     * Translates matrix m by x, y, and z in place.
     * @param m matrix
     * @param mOffset index into m where the matrix starts
     * @param x translation factor x
     * @param y translation factor y
     * @param z translation factor z
     */
    public static void translateM(
            float[] m, int mOffset,
            float x, float y, float z) {
        for (int i=0 ; i<4 ; i++) {
            int mi = mOffset + i;
            m[12 + mi] += m[mi] * x + m[4 + mi] * y + m[8 + mi] * z;
        }
    }

    /**
     * Translates matrix m by x, y, and z in place.
     * @param m matrix
     * @param mOffset index into m where the matrix starts
     * @param x translation factor x
     * @param y translation factor y
     * @param z translation factor z
     */
    public static void translateM(
    		double[] m, int mOffset,
    		double x, double y, double z) {
    	for (int i=0 ; i<4 ; i++) {
    		int mi = mOffset + i;
    		m[12 + mi] += m[mi] * x + m[4 + mi] * y + m[8 + mi] * z;
    	}
    }
    
    /**
     * Rotates matrix m by angle a (in degrees) around the axis (x, y, z)
     * @param rm returns the result
     * @param rmOffset index into rm where the result matrix starts
     * @param m source matrix
     * @param mOffset index into m where the source matrix starts
     * @param a angle to rotate in degrees
     * @param x scale factor x
     * @param y scale factor y
     * @param z scale factor z
     */
    public static void rotateM(float[] rm, int rmOffset,
            float[] m, int mOffset,
            float a, float x, float y, float z) {
        synchronized(sTemp) {
            setRotateM(sTemp, 0, a, x, y, z);
            multiplyMM(rm, rmOffset, m, mOffset, sTemp, 0);
        }
    }

    public static void rotateM(double[] rm, int rmOffset,
    		double[] m, int mOffset,
    		double a, double x, double y, double z) {
    	synchronized(sTempD) {
    		setRotateM(sTempD, 0, a, x, y, z);
    		multiplyMM(rm, rmOffset, m, mOffset, sTempD, 0);
    	}
    }

    /**
     * Rotates matrix m in place by angle a (in degrees)
     * around the axis (x, y, z)
     * @param m source matrix
     * @param mOffset index into m where the matrix starts
     * @param a angle to rotate in degrees
     * @param x scale factor x
     * @param y scale factor y
     * @param z scale factor z
     */
    public static void rotateM(float[] m, int mOffset,
            float a, float x, float y, float z) {
        synchronized(sTemp) {
            setRotateM(sTemp, 0, a, x, y, z);
            multiplyMM(sTemp, 16, m, mOffset, sTemp, 0);
            System.arraycopy(sTemp, 16, m, mOffset, 16);
        }
    }

    public static void rotateM(double[] m, int mOffset,
    		double a, double x, double y, double z) {
    	synchronized(sTempD) {
    		setRotateM(sTempD, 0, a, x, y, z);
    		multiplyMM(sTempD, 16, m, mOffset, sTempD, 0);
    		System.arraycopy(sTempD, 16, m, mOffset, 16);
    	}
    }

    /**
     * Rotates matrix m by angle a (in degrees) around the axis (x, y, z)
     * @param rm returns the result
     * @param rmOffset index into rm where the result matrix starts
     * @param a angle to rotate in degrees
     * @param x scale factor x
     * @param y scale factor y
     * @param z scale factor z
     */
    public static void setRotateM(float[] rm, int rmOffset,
            float a, float x, float y, float z) {
        rm[rmOffset + 3] = 0;
        rm[rmOffset + 7] = 0;
        rm[rmOffset + 11]= 0;
        rm[rmOffset + 12]= 0;
        rm[rmOffset + 13]= 0;
        rm[rmOffset + 14]= 0;
        rm[rmOffset + 15]= 1;
        a *= (float) (Math.PI / 180.0f);
        float s = (float) Math.sin(a);
        float c = (float) Math.cos(a);
        if (1.0f == x && 0.0f == y && 0.0f == z) {
            rm[rmOffset + 5] = c;   rm[rmOffset + 10]= c;
            rm[rmOffset + 6] = s;   rm[rmOffset + 9] = -s;
            rm[rmOffset + 1] = 0;   rm[rmOffset + 2] = 0;
            rm[rmOffset + 4] = 0;   rm[rmOffset + 8] = 0;
            rm[rmOffset + 0] = 1;
        } else if (0.0f == x && 1.0f == y && 0.0f == z) {
            rm[rmOffset + 0] = c;   rm[rmOffset + 10]= c;
            rm[rmOffset + 8] = s;   rm[rmOffset + 2] = -s;
            rm[rmOffset + 1] = 0;   rm[rmOffset + 4] = 0;
            rm[rmOffset + 6] = 0;   rm[rmOffset + 9] = 0;
            rm[rmOffset + 5] = 1;
        } else if (0.0f == x && 0.0f == y && 1.0f == z) {
            rm[rmOffset + 0] = c;   rm[rmOffset + 5] = c;
            rm[rmOffset + 1] = s;   rm[rmOffset + 4] = -s;
            rm[rmOffset + 2] = 0;   rm[rmOffset + 6] = 0;
            rm[rmOffset + 8] = 0;   rm[rmOffset + 9] = 0;
            rm[rmOffset + 10]= 1;
        } else {
            float len = length(x, y, z);
            if (1.0f != len) {
                float recipLen = 1.0f / len;
                x *= recipLen;
                y *= recipLen;
                z *= recipLen;
            }
            float nc = 1.0f - c;
            float xy = x * y;
            float yz = y * z;
            float zx = z * x;
            float xs = x * s;
            float ys = y * s;
            float zs = z * s;
            rm[rmOffset +  0] = x*x*nc +  c;
            rm[rmOffset +  4] =  xy*nc - zs;
            rm[rmOffset +  8] =  zx*nc + ys;
            rm[rmOffset +  1] =  xy*nc + zs;
            rm[rmOffset +  5] = y*y*nc +  c;
            rm[rmOffset +  9] =  yz*nc - xs;
            rm[rmOffset +  2] =  zx*nc - ys;
            rm[rmOffset +  6] =  yz*nc + xs;
            rm[rmOffset + 10] = z*z*nc +  c;
        }
    }

    public static void setRotateM(double[] rm, int rmOffset,
    		double a, double x, double y, double z) {
        rm[rmOffset + 3] = 0;
        rm[rmOffset + 7] = 0;
        rm[rmOffset + 11]= 0;
        rm[rmOffset + 12]= 0;
        rm[rmOffset + 13]= 0;
        rm[rmOffset + 14]= 0;
        rm[rmOffset + 15]= 1;
        a *= (double) (Math.PI / 180.0f);
        double s = (float) Math.sin(a);
        double c = (float) Math.cos(a);
        if (1.0f == x && 0.0f == y && 0.0f == z) {
            rm[rmOffset + 5] = c;   rm[rmOffset + 10]= c;
            rm[rmOffset + 6] = s;   rm[rmOffset + 9] = -s;
            rm[rmOffset + 1] = 0;   rm[rmOffset + 2] = 0;
            rm[rmOffset + 4] = 0;   rm[rmOffset + 8] = 0;
            rm[rmOffset + 0] = 1;
        } else if (0.0f == x && 1.0f == y && 0.0f == z) {
            rm[rmOffset + 0] = c;   rm[rmOffset + 10]= c;
            rm[rmOffset + 8] = s;   rm[rmOffset + 2] = -s;
            rm[rmOffset + 1] = 0;   rm[rmOffset + 4] = 0;
            rm[rmOffset + 6] = 0;   rm[rmOffset + 9] = 0;
            rm[rmOffset + 5] = 1;
        } else if (0.0f == x && 0.0f == y && 1.0f == z) {
            rm[rmOffset + 0] = c;   rm[rmOffset + 5] = c;
            rm[rmOffset + 1] = s;   rm[rmOffset + 4] = -s;
            rm[rmOffset + 2] = 0;   rm[rmOffset + 6] = 0;
            rm[rmOffset + 8] = 0;   rm[rmOffset + 9] = 0;
            rm[rmOffset + 10]= 1;
        } else {
        	double len = length(x, y, z);
            if (1.0f != len) {
            	double recipLen = 1.0f / len;
                x *= recipLen;
                y *= recipLen;
                z *= recipLen;
            }
            double nc = 1.0f - c;
            double xy = x * y;
            double yz = y * z;
            double zx = z * x;
            double xs = x * s;
            double ys = y * s;
            double zs = z * s;
            rm[rmOffset +  0] = x*x*nc +  c;
            rm[rmOffset +  4] =  xy*nc - zs;
            rm[rmOffset +  8] =  zx*nc + ys;
            rm[rmOffset +  1] =  xy*nc + zs;
            rm[rmOffset +  5] = y*y*nc +  c;
            rm[rmOffset +  9] =  yz*nc - xs;
            rm[rmOffset +  2] =  zx*nc - ys;
            rm[rmOffset +  6] =  yz*nc + xs;
            rm[rmOffset + 10] = z*z*nc +  c;
        }
    }

    
    /**
     * Converts Euler angles to a rotation matrix
     * @param rm returns the result
     * @param rmOffset index into rm where the result matrix starts
     * @param x angle of rotation, in degrees
     * @param y angle of rotation, in degrees
     * @param z angle of rotation, in degrees
     */
    public static void setRotateEulerM(float[] rm, int rmOffset,
            float x, float y, float z) {
        x *= (float) (Math.PI / 180.0f);
        y *= (float) (Math.PI / 180.0f);
        z *= (float) (Math.PI / 180.0f);
        float cx = (float) Math.cos(x);
        float sx = (float) Math.sin(x);
        float cy = (float) Math.cos(y);
        float sy = (float) Math.sin(y);
        float cz = (float) Math.cos(z);
        float sz = (float) Math.sin(z);
        float cxsy = cx * sy;
        float sxsy = sx * sy;

        rm[rmOffset + 0]  =   cy * cz;
        rm[rmOffset + 1]  =  -cy * sz;
        rm[rmOffset + 2]  =   sy;
        rm[rmOffset + 3]  =  0.0f;

        rm[rmOffset + 4]  =  cxsy * cz + cx * sz;
        rm[rmOffset + 5]  = -cxsy * sz + cx * cz;
        rm[rmOffset + 6]  =  -sx * cy;
        rm[rmOffset + 7]  =  0.0f;

        rm[rmOffset + 8]  = -sxsy * cz + sx * sz;
        rm[rmOffset + 9]  =  sxsy * sz + sx * cz;
        rm[rmOffset + 10] =  cx * cy;
        rm[rmOffset + 11] =  0.0f;

        rm[rmOffset + 12] =  0.0f;
        rm[rmOffset + 13] =  0.0f;
        rm[rmOffset + 14] =  0.0f;
        rm[rmOffset + 15] =  1.0f;
    }

    /**
     * Define a viewing transformation in terms of an eye point, a center of
     * view, and an up vector.
     *
     * @param rm returns the result
     * @param rmOffset index into rm where the result matrix starts
     * @param eyeX eye point X
     * @param eyeY eye point Y
     * @param eyeZ eye point Z
     * @param centerX center of view X
     * @param centerY center of view Y
     * @param centerZ center of view Z
     * @param upX up vector X
     * @param upY up vector Y
     * @param upZ up vector Z
     */
    public static void setLookAtM(float[] rm, int rmOffset,
            float eyeX, float eyeY, float eyeZ,
            float centerX, float centerY, float centerZ, float upX, float upY,
            float upZ) {

        // See the OpenGL GLUT documentation for gluLookAt for a description
        // of the algorithm. We implement it in a straightforward way:

        float fx = centerX - eyeX;
        float fy = centerY - eyeY;
        float fz = centerZ - eyeZ;

        // Normalize f
        float rlf = 1.0f / Matrix.length(fx, fy, fz);
        fx *= rlf;
        fy *= rlf;
        fz *= rlf;

        // compute s = f x up (x means "cross product")
        float sx = fy * upZ - fz * upY;
        float sy = fz * upX - fx * upZ;
        float sz = fx * upY - fy * upX;

        // and normalize s
        float rls = 1.0f / Matrix.length(sx, sy, sz);
        sx *= rls;
        sy *= rls;
        sz *= rls;

        // compute u = s x f
        float ux = sy * fz - sz * fy;
        float uy = sz * fx - sx * fz;
        float uz = sx * fy - sy * fx;

        rm[rmOffset + 0] = sx;
        rm[rmOffset + 1] = ux;
        rm[rmOffset + 2] = -fx;
        rm[rmOffset + 3] = 0.0f;

        rm[rmOffset + 4] = sy;
        rm[rmOffset + 5] = uy;
        rm[rmOffset + 6] = -fy;
        rm[rmOffset + 7] = 0.0f;

        rm[rmOffset + 8] = sz;
        rm[rmOffset + 9] = uz;
        rm[rmOffset + 10] = -fz;
        rm[rmOffset + 11] = 0.0f;

        rm[rmOffset + 12] = 0.0f;
        rm[rmOffset + 13] = 0.0f;
        rm[rmOffset + 14] = 0.0f;
        rm[rmOffset + 15] = 1.0f;

        translateM(rm, rmOffset, -eyeX, -eyeY, -eyeZ);
    }

	public static void dump(float[] result) {
		for (int c=0; c<4; c++) {
			for (int r=0; r<4; r++) {
				System.out.print(result[r * 4 + c] + (r == 3 ? "" : ", "));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void copy(float[] mModelMatrix, float[] mModelMatrix2) {
		System.arraycopy(mModelMatrix, 0, mModelMatrix2, 0, mModelMatrix.length);
	}

	public static void copy(double[] mModelMatrix, double[] mModelMatrix2) {
		System.arraycopy(mModelMatrix, 0, mModelMatrix2, 0, mModelMatrix.length);
	}

	public static float[] changeOrientation(float[] input) {
		float[] result = new float[16];
		result[0] = input[0];
		result[1] = input[4];
		result[2] = input[8];
		result[3] = input[12];
		result[4] = input[1];
		result[5] = input[5];
		result[6] = input[9];
		result[7] = input[13];
		result[8] = input[2];
		result[9] = input[6];
		result[10] = input[10];
		result[11] = input[14];
		result[12] = input[3];
		result[13] = input[7];
		result[14] = input[11];
		result[15] = input[15];
		return result;
	}

	public static double[] changeOrientation(double[] input) {
		double[] result = new double[16];
		result[0] = input[0];
		result[1] = input[4];
		result[2] = input[8];
		result[3] = input[12];
		result[4] = input[1];
		result[5] = input[5];
		result[6] = input[9];
		result[7] = input[13];
		result[8] = input[2];
		result[9] = input[6];
		result[10] = input[10];
		result[11] = input[14];
		result[12] = input[3];
		result[13] = input[7];
		result[14] = input[11];
		result[15] = input[15];
		return result;
	}

	public static void dump(String message, double[] matrix) {
		System.out.println(message);
		dump(matrix);
	}
	
	public static void dump(double[] matrix) {
		for (int c=0; c<4; c++) {
			for (int r=0; r<4; r++) {
				System.out.print(matrix[r * 4 + c] + (r == 3 ? "" : ", "));
			}
			System.out.println();
		}
	}

	public static void dumpIfNotId(double[] matrix) {
		if (!Arrays.equals(matrix, identity())) {
			dump(matrix);
		}
	}
	
	public static double[] identity() {
		double matrix[] = new double[16];
		setIdentityM(matrix, 0);
		return matrix;
	}
	
	public static float[] identityF() {
		float matrix[] = new float[16];
		setIdentityM(matrix, 0);
		return matrix;
	}

	public static boolean isIdentity(double[] other) {
		double[] identity = identity();
		return Arrays.equals(identity, other);
	}
}