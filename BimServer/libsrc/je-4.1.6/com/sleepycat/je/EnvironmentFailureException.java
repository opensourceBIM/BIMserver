/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;

@SuppressWarnings("deprecation")
/**
 * Indicates that a failure has occurred that could impact the {@code
 * Environment} as a whole.  For failures that impact only the current
 * operation and/or transaction, see {@link OperationFailureException}).  For
 * an overview of all exceptions thrown by JE, see {@link DatabaseException}.
 *
 * <p>Depending on the nature of the failure, this exception may indicate that
 * {@link Environment#close} must be called. The application should catch
 * {@code EnvironmentFailureException} and then call {@link
 * Environment#isValid}.  If {@code false} is returned, all {@code Environment}
 * handles (instances) must be closed and re-opened in order to run recovery
 * and continue operating.  If {@code true} is returned, the {@code
 * Environment} can continue operating without being closed and re-opened.
 * Also note that {@link Environment#isValid} may be called at any time, not
 * just during exception handling.</p>
 *
 * <p>The use of the {@link Environment#isValid} method allows JE to determine
 * dynamically whether the failure requires recovery or not, and allows for
 * this determination to change in future releases.  Over time, internal
 * improvements to error handling may allow more error conditions to be handled
 * without invalidating the {@code Environment}.</p>
 *
 * <p>(Although this exception class extends {@link RunRecoveryException}, it
 * does not always indicate that recovery is necessary, as described above.
 * {@code RunRecoveryException} has been deprecated and {@code
 * EnvironmentFailureException} should be used instead.)</p>
 *
 * <p>If an {@code EnvironmentFailureException} consistently occurs soon after
 * opening the Environment, this may indicate a persistent problem.  It may
 * indicate a system problem or a persistent storage problem.  In this case,
 * human intervention is normally required and restoring from a backup may be
 * necessary.</p>
 *
 * <p>Note that subclasses of {@code EnvironmentFailureException} indicate how
 * to handle the exception in more specific ways.</p>
 * <ul>
 * <li>If {@code Thread.interrupt} is called for a thread performing JE
 * operations, a {@link ThreadInterruptedException} is thrown.  Since
 * interrupting a thread is intentional, it does not indicate a persistent
 * problem and human intervention is not normally required.
 * </li>
 * <li>If an {@code IOException} occurs while writing to the JE log, a
 * {@link LogWriteException} is thrown.  Although an {@code IOException} can
 * occur for different reasons, it is a hint that the disk may be full and
 * applications may wish to attempt recovery after making more disk space
 * available.
 * </li>
 * <li>For replicated environments, see the subclasses of {@code
 * EnvironmentFailureException} in the {@link com.sleepycat.je.rep} package for
 * more information.  Such exceptions may require special handling.
 * </li>
 * </ul>
 *
 * <p>If {@link Environment#close} is not called after an {@code
 * EnvironmentFailureException} invalidates the {@code Environment}, all
 * subsequent method calls for the {@code Environment} will throw the same
 * exception.  This provides more than one opportunity to catch and handle the
 * specific exception subclass that caused the failure.</p>
 */
public class EnvironmentFailureException extends RunRecoveryException {

    private static final long serialVersionUID = 1;

    private boolean alreadyThrown;
    private EnvironmentFailureReason reason;

    /**
     * Only used by makeJavaErrorWrapper.
     */
    private EnvironmentFailureException(String msg) {
        super(msg);
    }

    /**
     * Only used by unexpectedState and unexpectedException.
     */
    private EnvironmentFailureException(EnvironmentFailureReason reason,
                                        String message,
                                        Throwable cause) {
        this(null /*envImpl*/, reason, message, cause);
    }

    /**
     * For internal use only.
     * @hidden
     */
    public EnvironmentFailureException(EnvironmentImpl envImpl,
                                       EnvironmentFailureReason reason) {
        this(envImpl, reason, null /*message*/, null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     */
    public EnvironmentFailureException(EnvironmentImpl envImpl,
                                       EnvironmentFailureReason reason,
                                       Throwable cause) {
        this(envImpl, reason, null /*message*/, cause);
    }

    /**
     * For internal use only.
     * @hidden
     */
    public EnvironmentFailureException(EnvironmentImpl envImpl,
                                       EnvironmentFailureReason reason,
                                       String message) {
        this(envImpl, reason, message, null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     */
    public EnvironmentFailureException(EnvironmentImpl envImpl,
                                       EnvironmentFailureReason reason,
                                       String message,
                                       Throwable cause) {
        super(makeMsg(envImpl, reason, message, cause), cause);
        if (reason.invalidatesEnvironment()) {
            assert envImpl != null;
            envImpl.invalidate(this);
        }
        this.reason = reason;
    }

    private static String makeMsg(EnvironmentImpl envImpl,
                                  EnvironmentFailureReason reason,
                                  String message,
                                  Throwable cause) {
        StringBuilder s = new StringBuilder(300);
        if (envImpl != null) {
            s.append(envImpl.getName()).append(" ");
        }

        if (message != null) {
            s.append(message);
            s.append(' ');
        } else if (cause != null) {
            s.append(cause.toString());
            s.append(' ');
        }
        assert reason != null;
        s.append(reason);

        /*
         * Use the current environment status for reporting in the exception
         * message.  This is more information than simply whether this
         * exception caused an invalidate, since previous exceptions may have
         * occurred.
         */
        if (reason.invalidatesEnvironment() ||
            (envImpl != null && !envImpl.isValid())) {
            s.append(" Environment is invalid and must be closed.");
        }
        return s.toString();
    }

    /**
     * For internal use only.
     * @hidden
     * Only for use by wrapSelf methods.
     */
    protected EnvironmentFailureException(String message,
                                          EnvironmentFailureException cause) {
        super(message, cause);
        assert cause != null;
        reason = cause.reason; 
    }

    /**
     * For internal use only.
     * @hidden
     * Must be overridden by every concrete subclass to return an instance of
     * its own class, constructed with the given msg and this exception as
     * parameters, e.g.: return new MyClass(msg, this);
     */
    public EnvironmentFailureException wrapSelf(String msg) {
        assert EnvironmentFailureException.class == this.getClass() :
               "Missing overriding " + this.getClass().getName() +
               ".wrapSelf() method";
        return new EnvironmentFailureException(msg, this);
    }

    /**
     * For internal use only.
     * @hidden
     * Remember that this was already thrown. That way, if we re-throw it
     * because another handle uses the environment after the fatal throw, the
     * message is more clear.
     */
    public void setAlreadyThrown(boolean alreadyThrown) {
        this.alreadyThrown = alreadyThrown;
    }

    @Override
    public String getMessage() {

        /*
         * Don't allocate memory after a Java Error occurs.  Note that for
         * a Java Error, addErrorMessage is never called, so super.getMessage
         * will not allocate memory either.
         */
        if (reason == EnvironmentFailureReason.JAVA_ERROR || !alreadyThrown) {
            return super.getMessage();
        }

        return "Environment invalid because of previous exception: " +
               super.getMessage();
    }

    /**
     * For internal use only.
     * @hidden
     */
    public EnvironmentFailureReason getReason() {
        return reason;
    }

    /**
     * For internal use only.
     * @hidden
     *
     * May ONLY be used for EnviromentImpl.SAVED_EFE.
     */
    public static EnvironmentFailureException makeJavaErrorWrapper() {
        EnvironmentFailureException e = new EnvironmentFailureException
            (EnvironmentFailureReason.JAVA_ERROR.toString());
        e.reason = EnvironmentFailureReason.JAVA_ERROR;
        return e;
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Promotes the given cause exception and message to an
     * EnvironmentFailureException.
     *
     * If the cause is not an EnvironmentFailureException, wraps the cause
     * exception in an EnvironmentFailureException along with the message.  If
     * the cause is an EnvironmentFailureException, adds the message to it.
     *
     * @return the resulting EnvironmentFailureException.
     */
    public static EnvironmentFailureException
        promote(EnvironmentImpl envImpl,
                EnvironmentFailureReason reason,
                String message,
                Throwable cause) {
        if (cause instanceof EnvironmentFailureException) {
            EnvironmentFailureException e =
                (EnvironmentFailureException) cause;
            e.addErrorMessage(message);
            return e;
        }

        return new EnvironmentFailureException
            (envImpl, reason, message, cause);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that an unexpected exception was caught
     * internally.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment should *not* be invalidated.
     */
    public static EnvironmentFailureException
        unexpectedException(Exception cause) {
        return new EnvironmentFailureException
            (EnvironmentFailureReason.UNEXPECTED_EXCEPTION,
             null /*message*/, cause);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that an unexpected exception was caught
     * internally.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment *should* be invalidated.
     */
    public static EnvironmentFailureException
        unexpectedException(EnvironmentImpl envImpl, Exception cause) {
        return new EnvironmentFailureException
            (envImpl, EnvironmentFailureReason.UNEXPECTED_EXCEPTION_FATAL,
             null /*message*/, cause);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that an unexpected exception was caught
     * internally.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment should *not* be invalidated.
     */
    public static EnvironmentFailureException
        unexpectedException(String message, Exception cause) {
        return new EnvironmentFailureException
            (EnvironmentFailureReason.UNEXPECTED_EXCEPTION, message,
             cause);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that an unexpected exception was caught
     * internally.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment *should* be invalidated.
     */
    public static EnvironmentFailureException
        unexpectedException(EnvironmentImpl envImpl,
                            String message,
                            Exception cause) {
        return new EnvironmentFailureException
            (envImpl, EnvironmentFailureReason.UNEXPECTED_EXCEPTION_FATAL,
             message, cause);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that unexpected internal state was
     * detected.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment should *not* be invalidated.
     */
    public static EnvironmentFailureException unexpectedState() {
        return new EnvironmentFailureException
            (EnvironmentFailureReason.UNEXPECTED_STATE,
             null /*message*/, null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that unexpected internal state was
     * detected.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment *should* be invalidated.
     */
    public static EnvironmentFailureException
        unexpectedState(EnvironmentImpl envImpl) {
        return new EnvironmentFailureException
            (envImpl, EnvironmentFailureReason.UNEXPECTED_STATE_FATAL,
             null /*message*/, null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that unexpected internal state was
     * detected.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment should *not* be invalidated.
     */
    public static EnvironmentFailureException unexpectedState(String message) {
        return new EnvironmentFailureException
            (EnvironmentFailureReason.UNEXPECTED_STATE, message,
             null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     *
     * Creates an exception indicating that unexpected internal state was
     * detected.  Used in place of an assert, when an exception is preferred.
     * Used when the Environment *should* be invalidated.
     */
    public static EnvironmentFailureException
        unexpectedState(EnvironmentImpl envImpl, String message) {
        return new EnvironmentFailureException
            (envImpl, EnvironmentFailureReason.UNEXPECTED_STATE_FATAL,
             message, null /*cause*/);
    }
}
