/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.elections;

import static com.sleepycat.je.rep.elections.ProposerStatDefinition.PHASE1_HIGHER_PROPOSAL;
import static com.sleepycat.je.rep.elections.ProposerStatDefinition.PHASE1_NO_NON_ZERO_PRIO;
import static com.sleepycat.je.rep.elections.ProposerStatDefinition.PHASE1_NO_QUORUM;
import static com.sleepycat.je.rep.elections.ProposerStatDefinition.PHASE2_HIGHER_PROPOSAL;
import static com.sleepycat.je.rep.elections.ProposerStatDefinition.PHASE2_NO_QUORUM;
import static com.sleepycat.je.rep.elections.ProposerStatDefinition.PROMISE_COUNT;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.QuorumPolicy;
import com.sleepycat.je.rep.elections.Protocol.Accept;
import com.sleepycat.je.rep.elections.Protocol.Promise;
import com.sleepycat.je.rep.elections.Protocol.Value;
import com.sleepycat.je.rep.impl.TextProtocol.MessageExchange;
import com.sleepycat.je.rep.impl.TextProtocol.MessageOp;
import com.sleepycat.je.rep.impl.TextProtocol.ProtocolError;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.ReplicationFormatter;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StatGroup;

/**
 * Plays the role of a Proposer in the consensus algorithm.
 *
 * Note that the Proposer also plays the role of a distinguished learner and
 * informs all other listeners about the acceptance of a proposal.
 */
public abstract class Proposer {

    /* The elections instance that is running this Learner agent. */
    protected final Elections elections;

    /* The statistics from one call of issueProposal. */
    private final StatGroup statistics;
    private final IntStat phase1NoQuorum;
    protected final IntStat phase1NoNonZeroPrio;
    private final IntStat phase1HigherProposal;
    private final IntStat phase2NoQuorum;
    private final IntStat phase2HigherProposal;
    private final IntStat promiseCount;

    protected final Logger logger;
    protected final Formatter formatter;

    /**
     * Initializes a proposer with the set of acceptors identified by the
     * sockets on which they accept proposals.
     */
    public Proposer(Elections elections, NameIdPair nameIdPair) {
        this.elections = elections;

        if (elections.getRepImpl() != null) {
            logger = LoggerUtils.getLogger(getClass());
        } else {
            logger = LoggerUtils.getLoggerFormatterNeeded(getClass());
        }
        formatter = new ReplicationFormatter(nameIdPair);

        statistics  = new StatGroup(ProposerStatDefinition.GROUP_NAME,
                                    ProposerStatDefinition.GROUP_DESC);
        phase1NoQuorum = new IntStat(statistics, PHASE1_NO_QUORUM);
        phase1NoNonZeroPrio = new IntStat(statistics, PHASE1_NO_NON_ZERO_PRIO);
        phase1HigherProposal = new IntStat(statistics, PHASE1_HIGHER_PROPOSAL);
        phase2NoQuorum = new IntStat(statistics, PHASE2_NO_QUORUM);
        phase2HigherProposal = new IntStat(statistics, PHASE2_HIGHER_PROPOSAL);
        promiseCount = new IntStat(statistics, PROMISE_COUNT);
    }

    /**
     * Shut down the proposer and reclaim its resources.
     */
    public void shutDown() {
    }

    /**
     * Returns the current proposer statistics.
     */
    public StatGroup getProposerStats() {
        return statistics;
    }

    /**
     * Predicate to determine whether we have a quorum based upon the quorum
     * policy. Note that the case of two attendees is special-cased when a
     * SIMPLE_MAJORITY is called for, to return success with just one yes vote.
     *
     * @param quorumPolicy the policy to be used for the quorum.
     * @param votes the number of yes votes.
     * @return true if the number of votes satisfies the quorum policy.
     */
    private boolean haveQuorum(QuorumPolicy quorumPolicy, int votes) {
        return votes >=
            elections.getRepNode().getElectionQuorumSize(quorumPolicy);
    }

    /**
     * Implements phase 1. It sends our Propose requests to all acceptors and
     * tallies up the results.
     *
     * @param proposal the new unique proposal.
     *
     * @return the results from running Phase1, or null if phase 1 did not get
     * a promise from the majority of acceptors.
     *
     * @throws HigherNumberedProposal
     */
    private Phase1Result phase1(QuorumPolicy quorumPolicy, Proposal proposal)
        throws HigherNumberedProposal {

        LoggerUtils.logMsg(logger, elections.getRepImpl(), formatter,
                           Level.FINE, "Phase 1 proposal: " + proposal);

        /* Broadcast Propose requests. */
        List<Future<MessageExchange>> futures =
            Utils.broadcastMessage
            (elections.getAcceptorSockets(),
             Acceptor.SERVICE_NAME,
             elections.getProtocol().new Propose(proposal),
             elections.getThreadPool());

        Phase1Result result = tallyPhase1Results(proposal, futures);
        if (haveQuorum(quorumPolicy, result.promisories.size())) {
            return result;
        }
        phase1NoQuorum.increment();

        return null;
    }

    /**
     * Tally the results from Phase 1. Terminate the tally if we see any
     * rejection messages which indicate our proposal has been obsoleted by a
     * more recent one. It also tracks the highest numbered proposal and the
     * associated value that was accepted by the Acceptors.
     *
     * @param currentProposal the proposal for this round
     * @param futures the futures resulting from Prepare messages
     *
     * @return results Summarized results from Phase 1
     * @throws HigherNumberedProposal
     */
    private Phase1Result
        tallyPhase1Results(Proposal currentProposal,
                           final List<Future<MessageExchange>> futures)
        throws HigherNumberedProposal {

        final Phase1Result result = new Phase1Result();
        for (final Future<MessageExchange> f : futures) {

            new Utils.WithFutureExceptionHandler () {

                @Override
                protected void processFuture ()
                    throws ExecutionException, InterruptedException {

                    MessageExchange me = f.get();
                    if (me.getResponseMessage() == null) {
                        LoggerUtils.logMsg(logger, elections.getRepImpl(),
                                           formatter, Level.FINE,
                                           "No response from: " + me.target +
                                           " reason: " + me.exception);
                        return;
                    }

                    if (me.getResponseMessage().getOp() ==
                        elections.getProtocol().REJECT) {
                        /*
                         * The acceptor has already received a higher numbered
                         * Prepare request. Abandon this round as an
                         * optimization.
                         */
                        Utils.discardFutures
                            (futures.subList(futures.indexOf(f),
                                             futures.size()));
                        phase1HigherProposal.increment();
                        throw new HigherNumberedProposal(me.target);
                    } else if (me.getResponseMessage().getOp() ==
                            elections.getProtocol().PROMISE) {
                        result.promisories.add(me.target);
                        result.promisoryMessages.add(me);
                        Promise accept = (Promise) me.getResponseMessage();
                        Proposal acceptProposal = accept.getHighestProposal();
                        if ((result.acceptProposal == null) ||
                            ((acceptProposal != null) &&
                             (acceptProposal.compareTo(result.acceptProposal) >
                              0))) {
                            result.acceptProposal = acceptProposal;
                            result.acceptedValue = accept.getAcceptedValue();
                        }
                    } else if (me.getResponseMessage().getOp() ==
                               elections.getProtocol().PROTOCOL_ERROR){
                        ProtocolError protocolError =
                            (ProtocolError) me.getResponseMessage();
                        /* Possible protocol version, group, or config skew. */
                        LoggerUtils.logMsg(logger, elections.getRepImpl(),
                                           formatter, Level.WARNING,
                                           "Election protocol error: " +
                                           protocolError.getMessage());
                        return;
                    } else {
                        throw EnvironmentFailureException.unexpectedState
                            ("Unknown response: " +
                             me.getResponseMessage().getOp());
                    }
                }
            }.execute(logger, elections.getRepImpl(), null);
        }

        if ((result.promisories.size() > 0) &&
            (result.acceptProposal == null)) {
            result.acceptProposal = currentProposal;
        }
        promiseCount.set(result.promisories.size());

        return result;
    }

    /**
     * Runs Phase 2 for the proposal and value.
     *
     * @param proposal the proposal resulting from Phase1
     * @param phase2Value the value that we would like to be chosen.
     * @param promisories from Phase1
     * @return a summary of the result or null if proposal was not accepted
     * @throws HigherNumberedProposal
     */
    private Phase2Result phase2(QuorumPolicy quorumPolicy,
                                Proposal proposal,
                                Value phase2Value,
                                Set<InetSocketAddress> promisories)
        throws HigherNumberedProposal {

        LoggerUtils.logMsg
            (logger, elections.getRepImpl(), formatter, Level.FINE,
             "Phase 2 proposal: " + proposal + " Value: " + phase2Value);

        /* Broadcast Accept requests to promisories. */
        final Accept accept =
            elections.getProtocol().new Accept(proposal, phase2Value);
        List<Future<MessageExchange>> futures =
            Utils.broadcastMessage(promisories, Acceptor.SERVICE_NAME,
                                   accept, elections.getThreadPool());
        Phase2Result result = tallyPhase2Results(quorumPolicy, futures);

        if (haveQuorum(quorumPolicy, result.accepts.size())) {
            return result;
        }

        phase2NoQuorum.increment();
        return null;
    }

    /**
     * Tallies the results from Phase 2.
     *
     * @param futures
     * @return the Phase2Result
     * @throws HigherNumberedProposal if a higher numbered proposal was
     *         encountered
     */
    private Phase2Result
        tallyPhase2Results(final QuorumPolicy quorumPolicy,
                           final List<Future<MessageExchange>> futures)
        throws HigherNumberedProposal {

        final Phase2Result result = new Phase2Result();
        try {
            for (final Future<MessageExchange> f : futures) {
                new Utils.WithFutureExceptionHandler() {

                    @Override
                    protected void processFuture()
                        throws ExecutionException, InterruptedException {

                        MessageExchange me = f.get();
                        final ResponseMessage responseMessage =
                            me.getResponseMessage();
                        if (responseMessage == null) {
                            LoggerUtils.logMsg(logger, elections.getRepImpl(),
                                               formatter, Level.WARNING,
                                               "No response from: " +
                                               me.target + " reason: " +
                                               me.exception);
                            return;
                        }

                        final Protocol protocol = elections.getProtocol();
                        final MessageOp op = responseMessage.getOp();
                        if (op == protocol.REJECT) {
                            Utils.discardFutures
                                (futures.subList(futures.indexOf(f),
                                                 futures.size()));
                            phase2HigherProposal.increment();
                            throw new HigherNumberedProposal(me.target);
                        } else if (op == protocol.ACCEPTED) {
                            result.accepts.add(me.target);
                            if (haveQuorum(quorumPolicy,
                                           result.accepts.size())) {
                                Utils.discardFutures
                                    (futures.subList(futures.indexOf(f),
                                                     futures.size()));
                                throw new HaveQuorum();
                            }
                        } else if (op == protocol.PROTOCOL_ERROR) {
                            final Protocol.ProtocolError errorMessage =
                                (Protocol.ProtocolError)responseMessage;
                            throw EnvironmentFailureException.unexpectedState
                                ("Protcol error:" + errorMessage.getMessage());
                        } else {
                            throw EnvironmentFailureException.unexpectedState
                                ("Unknown response: " + op);
                        }
                    }
                }.execute(logger, elections.getRepImpl(), null);
            }
        } catch (HaveQuorum hq) {
            /* Terminated phase2 early from an early quorum. */
        }
        return result;
    }

    /**
     * Selects the value to be used during Phase2, which if it succeeds will
     * become the "chosen value".
     *
     * @param exchanges the message exchanges from Phase 1
     *
     * @return the candidate value for Phase2, or null, if no suitable value
     * was found during phase 1
     */
    protected abstract Value choosePhase2Value(Set<MessageExchange> exchanges);

    /**
     * Creates the next unique Proposal to be used
     *
     * @return the Proposal
     */
    protected abstract Proposal nextProposal();

    /**
     * Runs an election using the consensus algorithm. An election can be used
     * either to determine an existing consensus value, or to force an election
     * if the current value is not suitable.
     *
     * @param quorumPolicy the policy used to determine whether we have a
     * quorum.
     *
     * @param retryPredicate the interface which determines whether a retry
     * should be attempted.
     *
     * @return the WinningProposal encapsulating the proposal and chosen value
     *
     * @throws MaxRetriesException when a winning proposal could not be
     * established.
     * @throws InterruptedException
     */
    public WinningProposal issueProposal(QuorumPolicy quorumPolicy,
                                         RetryPredicate retryPredicate)
        throws MaxRetriesException, InterruptedException {

        statistics.clear();

        while (retryPredicate.retry()) {
            try {
                final Proposal proposal = nextProposal();
                final Phase1Result result1 = phase1(quorumPolicy, proposal);
                if (result1 == null) {
                    continue;
                }

                final Value phase2Value =
                    choosePhase2Value(result1.promisoryMessages);
                if (phase2Value == null) {
                    continue;
                }

                final Phase2Result result2 =
                    phase2(quorumPolicy, proposal, phase2Value,
                           result1.promisories);
                if (result2 == null) {
                    continue;
                }

                LoggerUtils.logMsg(logger, elections.getRepImpl(),
                                   formatter, Level.INFO,
                                   "Winning proposal: " + proposal +
                                   " Value: " + phase2Value);
                return new WinningProposal(proposal, phase2Value, statistics);
            } catch (HigherNumberedProposal eip) {
                continue;
            }
        }
        throw new MaxRetriesException(statistics);
    }

    /* Local classes */

    /**
     * Summarizes Phase 1 results
     */
    private static class Phase1Result {

        /*
         * Subset of acceptors who have promised not to accept lower numbered
         * proposals.
         */
        Set<InetSocketAddress> promisories = new HashSet<InetSocketAddress>();
        Set<MessageExchange> promisoryMessages =
            new HashSet<Protocol.MessageExchange>();

        /*
         * The highest accepted proposal that was received from the
         * promisories.  It can be null.
         */
        Proposal acceptProposal;

        /*
         * The value associated with the proposal. It's non-null if
         * acceptProposal is not null.
         */
        @SuppressWarnings("unused")
        Value acceptedValue;
    }

    /**
     * Summarizes Phase 2 results.
     */
    private static class Phase2Result {

        /* Subset of promisories who accepted the current proposal. */
        Set<InetSocketAddress> accepts = new HashSet<InetSocketAddress>();
    }

    /**
     * Summarizes the results of the election
     */
    public static class WinningProposal {
        final Proposal proposal;
        final Value chosenValue;
        final StatGroup proposerStats;

        WinningProposal(Proposal proposal,
                        Value value,
                        StatGroup proposerStats) {
            this.proposal = proposal;
            this.chosenValue = value;
            this.proposerStats = proposerStats;
        }
    }

    /**
     * Exception to indicate that a more recent election is in progress.
     */
    @SuppressWarnings("serial")
    private static class HigherNumberedProposal extends RuntimeException {
        /* The acceptor that had a more recent proposal. */
        final InetSocketAddress acceptor;
        HigherNumberedProposal(InetSocketAddress acceptor) {
            this.acceptor = acceptor;
        }

        @Override
        public String getMessage() {
            return "More recent proposal at: " + acceptor.getHostName();
        }
    }

    /**
     * Exception thrown when a Proposal issue fails because the retry limit has
     * been exceeded.
     */
    @SuppressWarnings("serial")
    public static class MaxRetriesException extends Exception {
        final StatGroup proposerStats;

        MaxRetriesException(StatGroup proposerStats) {
            this.proposerStats = proposerStats;
        }
    }

    /**
     * Exception to indicate we have an early Quorum.
     */
    @SuppressWarnings("serial")
    private static class HaveQuorum extends RuntimeException {
        HaveQuorum() {}
    }

    /**
     * The Interface defining a Proposal.
     */
    public interface Proposal extends Comparable<Proposal> {

        /**
         * The string representation of the proposal. It must not contain
         * the Protocol.SEPARATOR character.
         *
         * @return the String representation of theProposal
         */
        String wireFormat();
    }

    public interface ProposalParser {

        /**
         * Converts the wire format back into a Proposal
         *
         * @param wireFormat String representation of a Proposal
         *
         * @return the de-serialized Proposal
         */
        abstract Proposal parse(String wireFormat);
    }

    /**
     * Interface to determine whether the Proposer should be retry with a new
     * Proposal or abandon the effort.
     */
    public interface RetryPredicate {
        boolean retry() throws InterruptedException;
        int retries();
    }
}
