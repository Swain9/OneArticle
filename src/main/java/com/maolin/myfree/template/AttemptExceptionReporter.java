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
public interface AttemptExceptionReporter {
    AttemptExceptionReporter LOG_ERROR_REPORTER = new LoggingAttemptExceptionReporter(false);
}
