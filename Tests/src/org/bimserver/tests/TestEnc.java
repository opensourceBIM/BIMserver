package org.bimserver.tests;

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

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import com.google.common.base.Charsets;

public class TestEnc {
	public static void main(String[] args) {
		new TestEnc().start();
	}

	private void start() {
		byte[] key = new byte[16];
		new Random().nextBytes(key);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

		String toEncrypt = "1";
		
		try {
			Cipher encodingCipher = Cipher.getInstance("AES");
			encodingCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encodedBytes = encodingCipher.doFinal(toEncrypt.getBytes(Charsets.UTF_8));
			System.out.println("Encoded size: " + encodedBytes.length);
			String encodedHexString = new String(Hex.encodeHex(encodedBytes));
			
			System.out.println("Encoded hex: " + encodedHexString);
			
			Cipher decodingCipher = Cipher.getInstance("AES");
			decodingCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			ByteBuffer wrap = ByteBuffer.wrap(decodingCipher.doFinal(Hex.decodeHex(encodedHexString.toCharArray())));
			String result = new String(wrap.array(), Charsets.UTF_8);
			
			System.out.println(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
	}
}