package com.sleepycat.je.rep.utilint;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import com.sleepycat.je.rep.impl.RepParams;

/**
 * Encapsulates the functionality around dealing with HostPort string pairs
 * having the format:
 *
 *  host[:port]
 */

public class HostPortPair {

    static public final String SEPARATOR = ":";

    /**
     * Parses a hostPort pair into the socket it represents.
     * @param hostPortPair
     * @return socket address for this host pair
     *
     * @throws IllegalArgumentException via ReplicatedEnvironment and Monitor
     * ctors.
     */
    public static InetSocketAddress getSocket(String hostPortPair) {
        if ("".equals(hostPortPair)) {
            throw new IllegalArgumentException
                ("Host and port pair was missing");
        }
        int portStartIndex = hostPortPair.indexOf(SEPARATOR);
        String hostName = hostPortPair;
        int port = -1;
        if (portStartIndex < 0) {
            port = Integer.parseInt(RepParams.DEFAULT_PORT.getDefault());
        } else {
            hostName = hostPortPair.substring(0, portStartIndex);
            port =
                Integer.parseInt(hostPortPair.substring(portStartIndex+1));
        }
        return new InetSocketAddress(hostName, port);
    }

    /**
     * Parses hostPort pairs into sockets it represents.
     *
     * @param hostPortPair
     *
     * @return a set of socket addresses for these host pairs
     */
    public static Set<InetSocketAddress> getSockets(String hostPortPairs) {
        Set<InetSocketAddress> helpers = new HashSet<InetSocketAddress>();
        for (StringTokenizer tokenizer = 
             new StringTokenizer(hostPortPairs, ","); 
             tokenizer.hasMoreTokens();) {
            String hostPortPair = tokenizer.nextToken();
            helpers.add(getSocket(hostPortPair));
        }

        return helpers;
    }

    public static String getString(String host, int port) {
        return host + SEPARATOR + port;
    }
}
