/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.impl;

import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.impl.node.NameIdPair;

/**
 * Defines the protocol used in support of group membership.
 *
 * API to Master
 *   ENSURE_NODE -> ENSURE_OK | FAIL
 *   REMOVE_MEMBER -> OK | FAIL
 *
 * Monitor to Master
 *   GROUP_REQ -> GROUP
 */
public class RepGroupProtocol extends TextProtocol {

    public static final String VERSION = "2";

    public static enum FailReason {
        DEFAULT, MEMBER_NOT_FOUND, IS_MASTER;
    }

    /* The messages defined by this class. */

    public final MessageOp ENSURE_NODE =
        new MessageOp("ENREQ", EnsureNode.class);
    public final MessageOp ENSURE_OK =
        new MessageOp("ENRESP", EnsureOK.class);
    public final MessageOp REMOVE_MEMBER =
        new MessageOp("RMREQ", RemoveMember.class);
    public final MessageOp GROUP_REQ =
        new MessageOp("GREQ", GroupRequest.class);
    public final MessageOp GROUP_RESP =
        new MessageOp("GRESP", GroupResponse.class);
    public final MessageOp RGFAIL_RESP =
        new MessageOp("GRFAIL", Fail.class);


    public RepGroupProtocol(String groupName,
                            NameIdPair nameIdPair,
                            RepImpl repImpl) {

        super(VERSION, groupName, nameIdPair, repImpl);

        this.initializeMessageOps(new MessageOp[] {
                ENSURE_NODE,
                ENSURE_OK,
                REMOVE_MEMBER,
                GROUP_REQ,
                GROUP_RESP,
                RGFAIL_RESP
        });

        setTimeouts(repImpl,
                    RepParams.REP_GROUP_OPEN_TIMEOUT,
                    RepParams.REP_GROUP_READ_TIMEOUT);
    }

    public class RemoveMember extends RequestMessage {
        final String nodeName;

        public RemoveMember(String memberName) {
            this.nodeName = memberName;
        }

        public RemoveMember(String requestLine, String[] tokens)
            throws InvalidMessageException {

            super(requestLine, tokens);
            nodeName = nextPayloadToken();
        }

        @Override
        public MessageOp getOp() {
            return REMOVE_MEMBER;
        }

        @Override
        protected String getMessagePrefix() {
            return messagePrefixNocheck;
        }

        public String wireFormat() {
           return  wireFormatPrefix() + SEPARATOR + nodeName;
        }

        public String getNodeName() {
            return nodeName;
        }
    }

    public class GroupRequest extends RequestMessage {

        public GroupRequest() {
        }

        public GroupRequest(String line, String[] tokens)
            throws InvalidMessageException {
            super(line, tokens);
        }

        @Override
        public MessageOp getOp() {
           return GROUP_REQ;
        }

        @Override
        protected String getMessagePrefix() {
            return messagePrefixNocheck;
        }

        public String wireFormat() {
           return wireFormatPrefix();
        }
    }

    public class EnsureNode extends RequestMessage {
        final RepNodeImpl node;

        public EnsureNode(RepNodeImpl node) {
            assert(node.getType() == NodeType.MONITOR);
            this.node = node;
        }

        public EnsureNode(String line, String[] tokens)
            throws InvalidMessageException {

            super(line, tokens);
            node = RepGroupImpl.hexDeserializeNode(nextPayloadToken());
        }

        public RepNodeImpl getNode() {
            return node;
        }

        @Override
        public MessageOp getOp() {
            return ENSURE_NODE;
        }

        @Override
        protected String getMessagePrefix() {
            return messagePrefixNocheck;
        }

        public String wireFormat() {
            return wireFormatPrefix() + SEPARATOR +
                   RepGroupImpl.serializeHex(node);
        }
    }

    public class EnsureOK extends OK {
        private final NameIdPair nameIdPair;

        public EnsureOK(NameIdPair nameIdPair) {
            super();
            this.nameIdPair = nameIdPair;
        }

        public EnsureOK(String line, String[] tokens)
            throws InvalidMessageException {
            super(line, tokens);
            nameIdPair = new NameIdPair(nextPayloadToken(),
                                        Integer.parseInt(nextPayloadToken()));
        }

        public NameIdPair getNameIdPair() {
            return nameIdPair;
        }

        @Override
        public MessageOp getOp() {
            return ENSURE_OK;
        }

        @Override
        public String wireFormat() {
            return wireFormatPrefix() + SEPARATOR +
                   nameIdPair.getName() + SEPARATOR +
                   Integer.toString(nameIdPair.getId());
        }
    }

    public class GroupResponse extends ResponseMessage {
        final RepGroupImpl group;

        public GroupResponse(RepGroupImpl group) {
            this.group = group;
        }

        public GroupResponse(String line, String[] tokens)
            throws InvalidMessageException {

            super(line, tokens);
            group = RepGroupImpl.deserializeHex
                (tokens, getCurrentTokenPosition()); 
        }

        public RepGroupImpl getGroup() {
            return group;
        }

        @Override
        public MessageOp getOp() {
            return GROUP_RESP;
        }

        @Override
        protected String getMessagePrefix() {
            return messagePrefixNocheck;
        }

        public String wireFormat() {
            return wireFormatPrefix() + SEPARATOR + group.serializeHex();
        }
    }

    /**
     * Extends the class Fail, adding a reason code to distinguish amongst
     * different types of failures.
     */
    public class Fail extends TextProtocol.Fail {
        final FailReason reason;

        public Fail(FailReason reason, String message) {
            super(message);
            this.reason = reason;
        }

        public Fail(String line, String[] tokens)
            throws InvalidMessageException {

            super(line, tokens);
            reason = FailReason.valueOf(nextPayloadToken());
        }

        @Override
        public String wireFormat() {
            return super.wireFormat() + SEPARATOR + reason.toString();
        }

        public FailReason getReason() {
            return reason;
        }
    }
}
