package org.bimserver.plugins.deserializers;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.shared.exceptions.ErrorCode;

public enum DeserializerErrorCode implements ErrorCode {
	// Header and schema version
	NO_VALID_IFC_HEADER_FOUND(1), 
	NO_IFC_SCHEMA_VERSION_FOUND(2), 
	UNSUPPORTED_IFC_SCHEMA_VERSION(3),

	// Deserializer issues
	NO_SUITABLE_DESERIALIZER_FOUND(100), 

	// Stream errors
	UNEXPECTED_END_OF_STREAM_WHILE_READING_FIRST_LINE(200), 

	// IFC-ZIP
	IFCZIP_MUST_CONTAIN_EXACTLY_ONE_IFC_FILE(300), 
	IFCZIP_FILE_CONTAINS_TOO_MANY_FILES(301), 
	IFCZIP_CONTAINS_EMPTY_IFC_MODEL(302), 
	IFCZIP_CONTAINS_NO_IFC_FILES(303), 
	
	UNKNOWN_ENTITY(400), 
	NON_EXISTING_ENTITY_TYPE_USED(401), 
	NON_EXISTING_ENTITY_REFERENCED(402), 
	NON_EXISTING_ENUM_LITERAL_USED(403), 
	NO_SEMICOLON_FOUND_IN_RECORD(404), 
	NO_LEFT_PARENTHESIS_FOUND_IN_RECORD(405), 
	NO_RIGHT_PARENTHESIS_FOUND_IN_RECORD(406), 
	DUPLICATE_EXPRESS_ID(407),

	// Invalid literals
	INVALID_GUID(500), 
	INVALID_INTEGER_LITERAL(501), 
	INVALID_LONG_LITERAL(502),
	INVALID_FLOAT_LITERAL(503), 
	INVALID_DOUBLE_LITERAL(504), 
	INVALID_REFERENCE(505), 
	INVALID_DATETIME_LITERAL(506),

	// Expected
	EXPECTED_STRING(600), 
	EXPECTED_RIGHT_PARENTHESIS(601),
	EXPECTED_CHARACTER_BUT_EMPTY_FIELD(602),

	// Unexpected
	UNEXPECTED_ENUM(700), 
	UNEXPECTED_TYPE(701), 
	UNEXPECTED_FIELD(702), 
	UNEXPECTED_AGGREGATION(703), 

	// Common IFC errors
	REFERENCED_OBJECT_CANNOT_BE_STORED_IN_THIS_FIELD(800), 
	IFC_SCHEMA_NOT_SUPPORTED_BY_DESERIALIZER(801), 
	NOT_ENOUGH_FIELDS_FOR_ENTITY(1802), 
	EMPTY_MODEL_CANNOT_BE_CHECKED_IN(803), 
	UNKNOWN_FIELD(804), 
	BYTE_ARRAY_NOT_QUOTED(805), 

	// All sorts of IFC-XML errors, unspecified because serializer/deserializers are deprecated and will be removed at some point
	UNSPECIFIED_IFCXML_ERROR(900), 
	
	// When this happens it is most probably a bug in BIMserver or in the Deserializer, please report
	INTERNAL_BIMSERVER_ERROR(1000), 
	
	// Please report this one as well, means something we did not anticipate happens
	UNIMPLEMENTED_BIMSERVER_FEATURE(1100), 

	// This also means a bug in BIMserver/deserializer
	UNKNOWN_DESERIALIZER_ERROR(1200), 
	
	// String encoding errors
	STRING_ENCODING_UTF32_NOT_SUPPORTED_ON_SYSTEM(1300), 
	STRING_ENCODING_X4_NOT_CLOSED_WITH_X0(1301), 
	STRING_ENCODING_NUMBER_OF_HEX_CHARS_IN_X4_NOT_DIVISIBLE_BY_8(1302), 
	STRING_ENCODING_X2_NOT_CLOSED_WITH_X0(1303), 
	STRING_ENCODING_NUMBER_OF_HEX_CHARS_IN_X2_NOT_DIVISIBLE_BY_4(1304),
	STRING_ENCODING_CHARACTER_DECODING_EXCEPTION(1305), 
	
	IO_EXCEPTION(1400), 
	FILE_NOT_FOUND_EXCEPTION(1401); 

	private int code;
	private static final Map<Integer, DeserializerErrorCode> MAP = new HashMap<>();

	private DeserializerErrorCode(int code) {
		this.code = code;
	}
	
	public static DeserializerErrorCode fromCode(int code) {
		return MAP.get(code);
	}
	
	public int getCode() {
		return code;
	}
	
	static {
		for (DeserializerErrorCode deserializerErrorCode : DeserializerErrorCode.values()) {
			MAP.put(deserializerErrorCode.getCode(), deserializerErrorCode);
		}
	}
}
