package com.maolin.myfree.template;

import java.util.Locale;
import java.util.TimeZone;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 16:47
 */
public class _TemplateAPI {

    public static Locale getDefaultLocale() {
        return Configuration.getDefaultLocale();
    }

    public static TimeZone getDefaultTimeZone() {
        return Configuration.getDefaultTimeZone();
    }
    public static TemplateExceptionHandler getDefaultTemplateExceptionHandler(
            Version incompatibleImprovements) {
        return Configuration.getDefaultTemplateExceptionHandler(incompatibleImprovements);
    }
    public static boolean getDefaultWrapUncheckedExceptions(Version incompatibleImprovements) {
        return Configuration.getDefaultWrapUncheckedExceptions(incompatibleImprovements);
    }
    public static AttemptExceptionReporter getDefaultAttemptExceptionReporter(
            Version incompatibleImprovements) {
        return Configuration.getDefaultAttemptExceptionReporter(incompatibleImprovements);
    }
}
