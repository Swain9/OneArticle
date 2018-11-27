package com.maolin.myfree.template;

import com.maolin.myfree.core.Configurable;
import com.maolin.myfree.core.ParserConfiguration;

import java.util.Locale;
import java.util.TimeZone;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 10:00
 */
public class Configuration extends Configurable implements Cloneable, ParserConfiguration {
    public static final Version VERSION_2_3_28 = new Version(2, 3, 28);
    private Version incompatibleImprovements;

    public Configuration(Version incompatibleImprovements) {
        super(incompatibleImprovements);
        this.incompatibleImprovements = incompatibleImprovements;

        createTemplateCache();
        loadBuiltInSharedVariables();
    }

    static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    static TimeZone getDefaultTimeZone() {
        return TimeZone.getDefault();
    }

    static TemplateExceptionHandler getDefaultTemplateExceptionHandler(Version incompatibleImprovements) {
        return TemplateExceptionHandler.DEBUG_HANDLER;
    }

    static boolean getDefaultWrapUncheckedExceptions(Version incompatibleImprovements) {
        return false;
    }

    static AttemptExceptionReporter getDefaultAttemptExceptionReporter(Version incompatibleImprovements) {
        return AttemptExceptionReporter.LOG_ERROR_REPORTER;
    }
    public static ObjectWrapper getDefaultObjectWrapper(Version incompatibleImprovements) {
        if (incompatibleImprovements.intValue() < _TemplateAPI.VERSION_INT_2_3_21) {
            return ObjectWrapper.DEFAULT_WRAPPER;
        } else {
            return new DefaultObjectWrapperBuilder(incompatibleImprovements).build();
        }
    }
}
