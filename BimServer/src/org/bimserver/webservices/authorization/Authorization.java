package org.bimserver.webservices.authorization;

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
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.DefaultErrorCode;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Authorization {
	private static final Logger LOGGER = LoggerFactory.getLogger(Authorization.class);
	private final GregorianCalendar expires = new GregorianCalendar();
	private long uoid = -1;
	
	// Volatile
	private String username;

	public Authorization(int expires, TimeUnit expiresUnit) {
		this.expires.add(Calendar.SECOND, (int) TimeUnit.SECONDS.convert(expires, expiresUnit));
	}
	
	public Authorization() {
	}

	public GregorianCalendar getExpires() {
		return expires;
	}

	public void canDownload(long roid) throws UserException {
	}

	public void canCheckin(long poid) throws UserException {
	}

	public void canReadExtendedData(long roid) throws UserException {
	}

	public void canWriteExtendedData(long roid) throws UserException {
	}

	protected abstract int getBufferSize();

	protected abstract byte getId();

	public boolean hasRightsOnProjectOrSuperProjectsOrSubProjects(User user, Project project) {
		if (user == null) {
			return false;
		}
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		while (project != null) {
			if (hasRightsOnProjectOrSubProjects(user, project)) {
				return true;
			}
			project = project.getParent();
		}
		return false;
	}

	public boolean hasRightsOnProjectOrSuperProjects(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		if (hasRightsOnProject(user, project)) {
			return true;
		}
		if (project.getParent() != null) {
			if (hasRightsOnProjectOrSuperProjects(user, project.getParent())) {
				return true;
			}
		}
		return false;
	}

	public boolean hasRightsOnProjectOrSubProjects(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		if (hasRightsOnProject(user, project)) {
			return true;
		}
		for (Project subProject : project.getSubProjects()) {
			if (hasRightsOnProjectOrSubProjects(user, subProject)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasRightsOnProject(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		for (User authorizedUser : project.getHasAuthorizedUsers()) {
			if (authorizedUser == user) {
				return true;
			}
		}
		return false;
	}

	protected abstract void getBytes(ByteBuffer buffer);

	public String asHexToken(Key key) {
		try {
			Cipher encodingCipher = Cipher.getInstance("AES");
			encodingCipher.init(Cipher.ENCRYPT_MODE, key);

			ByteBuffer buffer = ByteBuffer.allocate(16 + 1 + 8 + 8 + getBufferSize());
			buffer.position(16);
			buffer.put(getId());
			buffer.putLong(getExpires().getTimeInMillis());
			buffer.putLong(getUoid());
			getBytes(buffer);
			if (buffer.position() != buffer.capacity()) {
				throw new RuntimeException("Buffer's position should be at the end " + buffer.position() + "/" + buffer.capacity());
			}
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			buffer.position(16);
			messageDigest.update(buffer);
			buffer.position(0);
			buffer.put(messageDigest.digest());

			byte[] encodedBytes = encodingCipher.doFinal(buffer.array());
			String encodedHexString = new String(Hex.encodeHex(encodedBytes));
			return encodedHexString;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public static Authorization fromToken(SecretKeySpec key, String token) throws AuthenticationException {
		if (token == null) {
			throw new IllegalArgumentException("Token required");
		}
		try {
			int hashSizeBytes = 16;
			Cipher decodingCipher = Cipher.getInstance("AES");
			decodingCipher.init(Cipher.DECRYPT_MODE, key);
			ByteBuffer buffer = ByteBuffer.wrap(decodingCipher.doFinal(Hex.decodeHex(token.toCharArray())));
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] foundHash = new byte[hashSizeBytes];
			buffer.get(foundHash, 0, hashSizeBytes);
			byte[] hashInput = new byte[buffer.capacity() - hashSizeBytes];
			buffer.get(hashInput);
			buffer.position(hashSizeBytes);
			byte[] calculatedHash = messageDigest.digest(hashInput);
			if (Arrays.equals(foundHash, calculatedHash)) {
				byte type = buffer.get();
				Authorization authorization = null;
				long expires = buffer.getLong();
				long uoid = buffer.getLong();
				switch (type) {
				case ExplicitRightsAuthorization.ID:
					authorization = ExplicitRightsAuthorization.fromBuffer(buffer);
					break;
				case UserAuthorization.ID:
					authorization = UserAuthorization.fromBuffer(buffer);
					break;
				case SystemAuthorization.ID:
					authorization = SystemAuthorization.fromBuffer(buffer);
					break;
				case AnonymousAuthorization.ID:
					authorization = AnonymousAuthorization.fromBuffer(buffer);
					break;
				case AdminAuthorization.ID:
					authorization = AdminAuthorization.fromBuffer(buffer);
					break;
				case SingleProjectAuthorization.ID:
					authorization = SingleProjectAuthorization.fromBuffer(buffer);
					break;
				case RunServiceAuthorization.ID:
					authorization = RunServiceAuthorization.fromBuffer(buffer);
					break;
				case MonitorAuthorization.ID:
					authorization = MonitorAuthorization.fromBuffer(buffer);
					break;
				default:
					throw new AuthenticationException("Unknown authorization type: " + type);
				}
				authorization.setUoid(uoid);
				authorization.setExpires(expires);
				if (authorization.getExpires().getTimeInMillis() < new GregorianCalendar().getTimeInMillis()) {
					throw new AuthenticationException("This token has expired");
				}
				return authorization;
			} else {
				throw new AuthenticationException("Given token is corrupt");
			}
		} catch (GeneralSecurityException e) {
			throw new AuthenticationException("Invalid token", DefaultErrorCode.INVALID_TOKEN);
		} catch (DecoderException e) {
			throw new AuthenticationException(e);
		}
	}

	private void setExpires(long expires) {
		this.expires.setTimeInMillis(expires);
	}

	public long getUoid() {
		return uoid;
	}

	public void setUoid(long uoid) {
		this.uoid = uoid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}