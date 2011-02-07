package org.bimserver.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class Hashers {
	private static final Logger LOGGER = LoggerFactory.getLogger(Hashers.class);
	
	public static String getSha256Hash(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			return new String(Hex.encodeHex(digest.digest(password.getBytes(Charsets.UTF_8))));
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("", e);
		}
		return null;
	}
}