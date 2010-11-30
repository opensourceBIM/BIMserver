/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.elections;

import com.sleepycat.je.rep.elections.Protocol.StringValue;
import com.sleepycat.je.rep.elections.Protocol.Value;
import com.sleepycat.je.rep.elections.Protocol.ValueParser;
import com.sleepycat.je.rep.impl.node.NameIdPair;

/**
 * Class represents the identity of a Master as a subclass of a StringValue
 * that can be used during the election protocol.
 */
public class MasterValue extends StringValue {
    private static final String DELIMITER = "$$$";
    private static final String DELIMITER_REGEXP = "\\$\\$\\$";

    private final String hostname;
    private final int port;
    private final NameIdPair nameIdPair;

    public MasterValue(String masterHostname,
                       int masterPort,
                       NameIdPair masterNameIdPair) {
        super(masterHostname + DELIMITER +
              masterPort + DELIMITER +
              masterNameIdPair.getName() + DELIMITER +
              masterNameIdPair.getId());
        this.hostname = masterHostname;
        this.port = masterPort;
        this.nameIdPair = masterNameIdPair;
    }

    public MasterValue(String valueString) {
        super(valueString);
        String[] tokens = valueString.split(DELIMITER_REGEXP);
        hostname = tokens[0];
        port = Integer.parseInt(tokens[1]);
        nameIdPair = new NameIdPair(tokens[2], Integer.parseInt(tokens[3]));
    }

    public String getHostName() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getNodeName() {
        return nameIdPair.getName();
    }

    public NameIdPair getNameId() {
        return nameIdPair;
    }

    /**
     * Returns a parser that can convert a wire format value into a MasterValue
     *
     * @return the value parser
     */
    static public ValueParser getParser() {
        return masterValueParser;
    }

    private static final ValueParser masterValueParser = new ValueParser() {

        public Value parse(String wireFormat) {
            return ((wireFormat == null) || "".equals(wireFormat)) ?
                    null :
                    new MasterValue(wireFormat);
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((hostname == null) ? 0 : hostname.hashCode());
        result = prime * result + nameIdPair.hashCode();
        result = prime * result + port;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof MasterValue)) {
            return false;
        }
        final MasterValue other = (MasterValue) obj;
        if (hostname == null) {
            if (other.hostname != null) {
                return false;
            }
        } else if (!hostname.equals(other.hostname)) {
            return false;
        }
        if (!nameIdPair.equals(other.nameIdPair)) {
            return false;
        }
        if (port != other.port) {
            return false;
        }
        return true;
    }
}
