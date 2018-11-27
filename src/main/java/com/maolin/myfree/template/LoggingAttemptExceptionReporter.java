package com.maolin.myfree.template;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 17:15
 */
class LoggingAttemptExceptionReporter implements AttemptExceptionReporter {
    private final boolean logAsWarn;

    public LoggingAttemptExceptionReporter(boolean logAsWarn) {
        this.logAsWarn = logAsWarn;
    }
}
