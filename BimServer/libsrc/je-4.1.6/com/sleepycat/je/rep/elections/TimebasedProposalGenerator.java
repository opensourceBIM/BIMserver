/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.elections;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.elections.Proposer.Proposal;
import com.sleepycat.je.rep.elections.Proposer.ProposalParser;

/**
 * Generates a unique sequence of ascending proposal numbers that is unique
 * across all machines.
 *
 * Each proposal number is built as the catenation of the following components:
 *
 * ms time (8 bytes) | IP address  (16 bytes) | locally unique Id (4 bytes)
 *
 * The ms time supplies the increasing number and the IP address a number
 * unique across machines.
 */
public class TimebasedProposalGenerator {

    /*
     * A number that is unique for all instances of the TimeBasedGenerator on
     * this machine.
     */
    private final int locallyUniqueId;
    static int uniqueIdGenerator = 1;

    /*
     * Tracks the time (in ms) used to generate the previous proposal
     * preventing the creation of duplicate proposals.
     */
    private long prevProposalTime = System.currentTimeMillis();

    /* The hex representation of the IP address. */
    private String machineId;

    /* Width of each field in the Proposal number in hex characters. */
    final static int TIME_WIDTH = 16;

    /* Allow for 16 byte ipv6 addresses. */
    final static int ADDRESS_WIDTH =32;
    final static int UID_WIDTH = 8;

    /**
     * Creates an instance with an application-specified locally (machine wide)
     * unique id, e.g. a port number, or a combination of a pid and some other
     * number.
     *
     * @param locallyUniqueId the machine wide unique id
     */
    TimebasedProposalGenerator(int locallyUniqueId) {
        this.locallyUniqueId = locallyUniqueId;

        try {
            byte[] localAddress =
                java.net.InetAddress.getLocalHost().getAddress();

            if (java.net.InetAddress.getLocalHost().isLoopbackAddress()) {
                /* Linux platforms return a loopback address, examine the
                 * interfaces individually for a suitable address.
                 */
                localAddress = null;
                try {
                    for (Enumeration<NetworkInterface> interfaces =
                        NetworkInterface.getNetworkInterfaces();
                        interfaces.hasMoreElements();) {
                        for (Enumeration<InetAddress> addresses =
                            interfaces.nextElement().getInetAddresses();
                            addresses.hasMoreElements();) {
                            InetAddress ia = addresses.nextElement();
                            if (! (ia.isLoopbackAddress() ||
                                   ia.isAnyLocalAddress() ||
                                   ia.isMulticastAddress())) {
                                /* Found one, any one of these will do. */
                                localAddress = ia.getAddress();
                                break;
                            }
                        }
                    }
                } catch (SocketException e) {
                    // Could not get the network interfaces, give up
                }
                if (localAddress == null) {
                    throw EnvironmentFailureException.unexpectedState
                        ("java.net.InetAddress.getLocalHost() returned" +
                         " loopback address: " +
                         java.net.InetAddress.getLocalHost() +
                         " and no suitable adddress associated " +
                         " with network interfaces.");
                }
            }
            machineId = "";
            for (byte b : localAddress) {
                machineId = machineId + String.format("%02x", b);
            }
            String pad ="000000000000000000000000000000";
            machineId =
                pad.substring(0,ADDRESS_WIDTH-machineId.length()) + machineId;
        } catch (UnknownHostException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    /**
     * Constructor defaulting the unique id so it's merely unique within the
     * process.
     */
    public TimebasedProposalGenerator() {
        this(uniqueIdGenerator++);
    }

    /**
     * Returns the next Proposal greater than all previous proposals returned
     * on this machine.
     *
     * @return the next unique proposal
     */
    public synchronized Proposal nextProposal() {
        long proposalTime = System.currentTimeMillis();
        if (proposalTime <= prevProposalTime) {
            /* Proposals are moving faster than the clock. */
            proposalTime = ++prevProposalTime;
        }
        prevProposalTime = proposalTime;
        return new StringProposal(String.format("%016x%s%08x", proposalTime,
                                                machineId, locallyUniqueId));
    }

    /**
     * Returns the parser used to convert wire representations into Proposal
     * instances.
     *
     * @return a ProposalParser
     */
    public static ProposalParser getParser() {
        return StringProposal.getParser();
    }

    /**
     * Implements the Proposal interface for a string based proposal. The
     * string is a hex representation of the Proposal.
     */
    private static class StringProposal implements Proposal {
        private final String proposal;

        /* The canonical proposal parser. */
        private static ProposalParser theParser = new ProposalParser() {
                public Proposal parse(String wireFormat) {
                    return ((wireFormat == null) || ("".equals(wireFormat))) ?
                        null :
                        new StringProposal(wireFormat);
                }
            };

        StringProposal(String proposal) {
            assert (proposal != null);
            this.proposal = proposal;
        }

        public String wireFormat() {
            return proposal;
        }

        public int compareTo(Proposal otherProposal) {
            return this.proposal.compareTo
                (((StringProposal) otherProposal).proposal);
        }

        @Override
        public String toString() {
            return "Proposal(" +
                proposal.substring(0, TIME_WIDTH) +
                ":" +
                proposal.substring(TIME_WIDTH, TIME_WIDTH + ADDRESS_WIDTH) +
                ":" + proposal.substring(TIME_WIDTH + ADDRESS_WIDTH) +
                ")";
        }

        private static ProposalParser getParser() {
            return theParser;
        }

        @Override
        public int hashCode() {
            return ((proposal == null) ? 0 : proposal.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof StringProposal)) {
                return false;
            }
            final StringProposal other = (StringProposal) obj;
            if (proposal == null) {
                if (other.proposal != null) {
                    return false;
                }
            } else if (!proposal.equals(other.proposal)) {
                return false;
            }
            return true;
        }
    }
}
