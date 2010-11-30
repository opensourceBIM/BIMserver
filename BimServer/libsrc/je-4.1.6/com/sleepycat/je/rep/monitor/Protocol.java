/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.monitor;

import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.impl.TextProtocol;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.monitor.GroupChangeEvent.GroupChangeType;
import com.sleepycat.je.rep.monitor.LeaveGroupEvent.LeaveReason;

/**
 * @hidden
 * For internal use only.
 *
 * Defines the protocol used by the Monitor to keep informed about group
 * changes, and a node joins/leaves the group. The Master uses the protocol to 
 * inform all Monitors about group change and node join/leave change.
 *
 * GCHG -> no response expected from the monitor.
 * JoinGroup -> no response expected from the monitor.
 * LeaveGroup -> no response expected from the monitor.
 */
public class Protocol extends TextProtocol {

    static public final String VERSION = "1.0";

    /* The messages defined by this class. */
    public final MessageOp GROUP_CHANGE_REQ =
        new MessageOp("GCHG", GroupChange.class);

    public final MessageOp JOIN_GROUP_REQ =
        new MessageOp("JG", JoinGroup.class);

    public final MessageOp LEAVE_GROUP_REQ =
        new MessageOp("LG", LeaveGroup.class);

    public Protocol(String groupName, NameIdPair nameIdPair, RepImpl repImpl) {
        super(VERSION, groupName, nameIdPair, repImpl);

        initializeMessageOps(new MessageOp[] { 
            GROUP_CHANGE_REQ, 
            JOIN_GROUP_REQ, 
            LEAVE_GROUP_REQ 
        });

        setTimeouts(repImpl,
                    RepParams.MONITOR_OPEN_TIMEOUT,
                    RepParams.MONITOR_READ_TIMEOUT);
    }

    private abstract class ChangeEvent extends RequestMessage {
        /* Name of node which this change event happens on. */
        private final String nodeName;

        public ChangeEvent(String nodeName) {
            this.nodeName = nodeName;
        }

        public ChangeEvent(String line, String[] tokens) 
            throws InvalidMessageException {

            super(line, tokens);
            nodeName = nextPayloadToken();
        }

        public String getNodeName() {
            return nodeName;
        }

        @Override
        protected String getMessagePrefix() {
            return messagePrefixNocheck;
        }

        public String wireFormat() {
            return wireFormatPrefix() + SEPARATOR + nodeName + SEPARATOR;
        }
    }

    public class GroupChange extends ChangeEvent {
        private final RepGroupImpl group;
        /* Represents it's a ADD or REMOVE change event. */
        private final GroupChangeType opType;

        public GroupChange(RepGroupImpl group, 
                           String nodeName, 
                           GroupChangeType opType) {
            super(nodeName);
            this.group = group;
            this.opType = opType;
        }

        public GroupChange(String line, String[] tokens)
            throws InvalidMessageException {

            super(line, tokens);
            opType = GroupChangeType.valueOf(nextPayloadToken());
            group = RepGroupImpl.deserializeHex
                (tokens, getCurrentTokenPosition());
        }

        public RepGroupImpl getGroup() {
            return group;
        }

        public GroupChangeType getOpType() {
            return opType;
        }

        @Override
        public MessageOp getOp() {
            return GROUP_CHANGE_REQ;
        }

        public String wireFormat() {
            return super.wireFormat() + 
                   opType.toString() + SEPARATOR +
                   group.serializeHex();
        }
    }

    private abstract class MemberEvent extends ChangeEvent {
        private final String masterName;
        private final long joinTime;

        public MemberEvent(String nodeName, String masterName, long joinTime) {
            super(nodeName);
            this.masterName = masterName;
            this.joinTime = joinTime;
        }

        public MemberEvent(String line, String[] tokens)
            throws InvalidMessageException {

            super(line, tokens);
            masterName = nextPayloadToken();
            joinTime = Long.parseLong(nextPayloadToken());
        }

        public long getJoinTime() {
            return joinTime;
        }

        public String getMasterName() {
            return masterName;
        }

        public String wireFormat() {
            return super.wireFormat() + 
                   masterName + SEPARATOR +
                   Long.toString(joinTime); 
        }
    }

    /* Represents the event that a node joins the group. */
    public class JoinGroup extends MemberEvent {
        public JoinGroup(String nodeName, String masterName, long joinTime) {
            super(nodeName, masterName, joinTime);
        }

        public JoinGroup(String line, String[] tokens) 
            throws InvalidMessageException {

            super(line, tokens);
        }

        @Override
        public MessageOp getOp() {
            return JOIN_GROUP_REQ;
        }
    }

    /* Represents the event that a node leaves the group. */
    public class LeaveGroup extends MemberEvent {
        private final LeaveReason leaveReason;
        private final long leaveTime;

        public LeaveGroup(String nodeName,
                          String masterName, 
                          LeaveReason leaveReason, 
                          long joinTime, 
                          long leaveTime) {
            super(nodeName, masterName, joinTime);
            this.leaveReason = leaveReason;
            this.leaveTime = leaveTime;
        }

        public LeaveGroup(String line, String[] tokens)
            throws InvalidMessageException {

            super(line, tokens);
            leaveReason = LeaveReason.valueOf(nextPayloadToken());
            leaveTime = Long.parseLong(nextPayloadToken());
        }

        public LeaveReason getLeaveReason() {
            return leaveReason;
        }

        public long getLeaveTime() {
            return leaveTime;
        }

        @Override
        public MessageOp getOp() {
            return LEAVE_GROUP_REQ;
        }

        public String wireFormat() {
            return super.wireFormat() + SEPARATOR + 
                   leaveReason.toString() + SEPARATOR + 
                   Long.toString(leaveTime);
        }
    }
}
