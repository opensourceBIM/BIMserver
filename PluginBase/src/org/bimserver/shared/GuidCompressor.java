package org.bimserver.shared;

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

import java.util.UUID;

/**
 * This class is a service class providing methods to generation and conversion between compressed 
 * and uncompressed string representations of GUIDs according to the algorithms used by the 
 * Industry Foundation Classes (IFC). The algorithm is based on an implementation in c as follows: 
 * originally proposed by Jim Forester<br>
 * implemented previously by Jeremy Tammik using hex-encoding<br>
 * Peter Muigg, June 1998<br>
 * Janos Maros, July 2000<br>
 * This class is provided as-is with no warranty.<br>
 * <br>
 * The class GuidCompressor is part of the OPEN IFC JAVA TOOLBOX package. Copyright:
 * CCPL BY-NC-SA 3.0 (cc) 2008 Eike Tauscher, Jan Tulke <br>
 * <br>
 * The OPEN IFC JAVA TOOLBOX package itself (except this class) is licensed under <br>
 * <a rel="license"
 * href="http://creativecommons.org/licenses/by-nc-sa/3.0/de/">Creative Commons
 * Attribution-Non-Commercial- Share Alike 3.0 Germany</a>.<br>
 * Please visit <a
 * href="http://www.openifctools.com">http://www.openifctools.com</a> for more
 * information.<br>
 * 
 * @author Jan Tulke
 * @version 1.0 - 24.07.2009
 *
 */
public class GuidCompressor {

	static char[] cConversionTable = new char[]{'0','1','2','3','4','5','6','7','8','9',
												'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
												'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
												'_','$'};

	/**
	 * Generates a new GUID and returns a compressed string representation as used for IfcGloballyUniqueId
	 * @return String with a length of 22 characters
	 */
	public static String getNewIfcGloballyUniqueId(){
		Guid guid = getGuidFromUncompressedString(UUID.randomUUID().toString());		
		String shortString = getCompressedStringFromGuid(guid);
		return shortString;
	}
	
	/**
	 * Converts an uncompressed String representation in an Guid-object 
	 * @param uncompressedGuidString the uncompressed String representation of a GUID
	 * @return an Guid-object
	 */
	public static Guid getGuidFromUncompressedString(String uncompressedGuidString){
		String[] parts = uncompressedGuidString.split("-");
		Guid guid = new Guid();
		guid.Data1 = Long.parseLong(parts[0], 16);
		guid.Data2 = Integer.parseInt(parts[1],16);
		guid.Data3 = Integer.parseInt(parts[2], 16);
		
		String temp;
		
		temp = parts[3];
		guid.Data4[0] = (char) Integer.parseInt(temp.substring(0, 2), 16);
		guid.Data4[1] = (char) Integer.parseInt(temp.substring(2, 4), 16);
		 
		temp = parts[4];
		guid.Data4[2] = (char) Integer.parseInt(temp.substring(0, 2), 16);
		guid.Data4[3] = (char) Integer.parseInt(temp.substring(2, 4), 16);
		guid.Data4[4] = (char) Integer.parseInt(temp.substring(4, 6), 16);
		guid.Data4[5] = (char) Integer.parseInt(temp.substring(6, 8), 16);
		guid.Data4[6] = (char) Integer.parseInt(temp.substring(8, 10), 16);
		guid.Data4[7] = (char) Integer.parseInt(temp.substring(10, 12), 16);
		
		return guid;
	}
	
	/**
	 * Converts a Guid-object into a compressed string representation of a GUID
	 * @param guid the Guid-object
	 * @return String with a length of 22 characters
	 */
	public static String getCompressedStringFromGuid(Guid guid)
	{
	    long[] num = new long[6];
	    char[][] str = new char[6][5];
	    int i,j,n;
	    String result = new String();

	    //
	    // Creation of six 32 Bit integers from the components of the GUID structure
	    //
	    num[0] = (long)(guid.Data1 / 16777216);                                                //    16. byte  (pGuid->Data1 / 16777216) is the same as (pGuid->Data1 >> 24)
	    num[1] = (long)(guid.Data1 % 16777216);                                                // 15-13. bytes (pGuid->Data1 % 16777216) is the same as (pGuid->Data1 & 0xFFFFFF)
	    num[2] = (long)(guid.Data2 * 256 + guid.Data3 / 256);                                  // 12-10. bytes
	    num[3] = (long)((guid.Data3 % 256) * 65536 + guid.Data4[0] * 256 + guid.Data4[1]);     // 09-07. bytes
	    num[4] = (long)(guid.Data4[2] * 65536 + guid.Data4[3] * 256 + guid.Data4[4]);          // 06-04. bytes
	    num[5] = (long)(guid.Data4[5] * 65536 + guid.Data4[6] * 256 + guid.Data4[7]);          // 03-01. bytes
	    //
	    // Conversion of the numbers into a system using a base of 64
	    //
	    n = 3;
	    for (i = 0; i < 6; i++) {
	        if (!cv_to_64 (num[i], str[i], n)) {
	            return null;
	        }
		    for(j = 0; j<str[i].length; j++)
		    	if(str[i][j]!= '\0') result += str[i][j];
	        
	        n = 5;
	    }
	    return result;
	}

	/**
	 * Conversion of an integer into a number with base 64
	 * using the table cConversionTable
	 * 
	 * @param number
	 * @param code 
	 * @param len
	 * @return true if no error occurred
	 */
	private static boolean cv_to_64(long number, char[] code, int len )
	{
	    long   act;
	    int    iDigit, nDigits;
	    char[] result = new char[5];

	    if (len > 5)
	        return false;

	    act = number;
	    nDigits = len - 1;

	    for (iDigit = 0; iDigit < nDigits; iDigit++) {
	        result[nDigits - iDigit - 1] = cConversionTable[(int) (act % 64)];
	        act /= 64;
	    }
	    result[len - 1] = '\0';
	    
	    if (act != 0)
	        return false;

	    for(int i = 0; i<result.length; i++)
	    	code[i] = result[i];
	    
	    return true;
	}

	/**
	 * Calculate a numberer from the code
	 * @param res
	 * @param str
	 * @return true if no error occurred
	 */
	private static boolean cv_from_64(long[] res, char[] str )
	{
	    int len, i, j, index;

	    for(len = 1; len<5; len++)
	    	if(str[len]=='\0') break;

	    res[0]=0;

	    for (i = 0; i < len; i++) {
	        index = -1;
	        for (j = 0; j < 64; j++) {
	            if (cConversionTable[j] == str[i]) {
	               index = j;
	               break;
	            }
	        }
	        if (index == -1)
	            return false;
	        res[0] = res[0] * 64 + index;
	    }
	    return true;
	}
		
	/**
	 * Reconstructs a Guid-object form an compressed String representation of a GUID
	 * 
	 * @param string compressed String representation of a GUID, 22 character long
	 * @param guid contains the reconstructed Guid as a result of this method 
	 * @return true if no error occurred
	 */
	public static boolean getGuidFromCompressedString(String string, Guid guid) throws InvalidGuidException
	{
	    char[][] str = new char[6][5];
	    int len, i, j, m;
	    long[][] num = new long[6][1];

	    len = string.length();
	    if (len != 22)
	       throw new InvalidGuidException(string, "Length must be 22 (is: " + string.length() + ")");

	    j = 0;
	    m = 2;

	    for (i = 0; i < 6; i++) {
	    	for(int k = 0; k<m; k++){
	    		str[i][k] = string.charAt(j+k);
	    	}
	    	str[i][m]= '\0';
	    	j = j + m;
	    	m = 4;
	    }
	    for (i = 0; i < 6; i++) {
	        if (!cv_from_64 (num[i], str[i])) {
	        	 throw new InvalidGuidException(string);
	        }
	    }

	    guid.Data1= (long) (num[0][0] * 16777216 + num[1][0]);              // 16-13. bytes
	    guid.Data2= (int) (num[2][0] / 256);                                // 12-11. bytes
	    guid.Data3= (int) ((num[2][0] % 256) * 256 + num[3][0] / 65536);    // 10-09. bytes

	    guid.Data4[0] = (char) ((num[3][0] / 256) % 256);                   //    08. byte
	    guid.Data4[1] = (char) (num[3][0] % 256);                           //    07. byte
	    guid.Data4[2] = (char) (num[4][0] / 65536);                         //    06. byte
	    guid.Data4[3] = (char) ((num[4][0] / 256) % 256);                   //    05. byte
	    guid.Data4[4] = (char) (num[4][0] % 256);                           //    04. byte
	    guid.Data4[5] = (char) (num[5][0] / 65536);                         //    03. byte
	    guid.Data4[6] = (char) ((num[5][0] / 256) % 256);                   //    02. byte
	    guid.Data4[7] = (char) (num[5][0] % 256);                           //    01. byte

	    return true;
	}

	/**
	 * Converts a Guid-object into a uncompressed String representation of a GUID
	 * 
	 * @param guid the Guid-object to be converted
	 * @return the uncompressed String representation of a GUID
	 */
	public static String getUncompressedStringFromGuid(Guid guid){
		String result = new String();
		result += String.format("%1$08x", guid.Data1); 
		result += "-";
		result += String.format("%1$04x", guid.Data2); 
		result += "-";
		result += String.format("%1$04x", guid.Data3); 
		result += "-";
		result += String.format("%1$02x%2$02x", (int)guid.Data4[0], (int)guid.Data4[1]); 
		result += "-";
		result += String.format("%1$02x%2$02x%3$02x%4$02x%5$02x%6$02x", (int)guid.Data4[2], (int)guid.Data4[3], (int)guid.Data4[4], (int)guid.Data4[5], (int)guid.Data4[6], (int)guid.Data4[7]); 
		return result;
	}

	/**
	 * Converts an uncompressed String representation of a GUID into a compressed one
	 * @param uncompressedString the String representation which gets compressed
	 * @return the compressed String representation with a length of 22 characters
	 */
	public static String compressGuidString(String uncompressedString){
		Guid guid = getGuidFromUncompressedString(uncompressedString);
		return getCompressedStringFromGuid(guid);
	}
	
	/**
	 * Converts a compressed String representation of a GUID into an uncompressed one
	 * @param compressedString the String representation which gets uncompressed
	 * @return the uncompressed String representation
	 * @throws InvalidGuidException 
	 */
	public static String uncompressGuidString(String compressedString) throws InvalidGuidException{
		Guid guid = new Guid();
		getGuidFromCompressedString(compressedString, guid);
		return getUncompressedStringFromGuid(guid);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(GuidCompressor.uncompressGuidString("1_MvLDs9r0eAPqtR3GOY9_"));
			Guid guid = new Guid();
			System.out.println(getGuidFromCompressedString("HG0002Hfz0199_80KQ2900", guid));
			UUID uuid = guid.test();
			System.out.println(uuid);
		} catch (InvalidGuidException e) {
			e.printStackTrace();
		}
	}
}
