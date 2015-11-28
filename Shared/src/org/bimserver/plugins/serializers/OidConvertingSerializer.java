package org.bimserver.plugins.serializers;

import java.util.Map;

public interface OidConvertingSerializer {

	Map<Long, Integer> getOidToEid();
}
