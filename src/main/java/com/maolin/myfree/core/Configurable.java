package com.maolin.myfree.core;

import com.maolin.myfree.template.AttemptExceptionReporter;
import com.maolin.myfree.template.Configuration;
import com.maolin.myfree.template.ObjectWrapper;
import com.maolin.myfree.template.TemplateExceptionHandler;
import com.maolin.myfree.template.Version;
import com.maolin.myfree.template._TemplateAPI;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 10:01
 */
public class Configurable {
    private Configurable parent;
    private Properties properties;
    private Locale locale;
    public static final String LOCALE_KEY = "locale";
    private TimeZone timeZone;
    public static final String TIME_ZONE_KEY = "time_zone";
    private TimeZone sqlDataAndTimeTimeZone;
    public static final String SQL_DATE_AND_TIME_TIME_ZONE_KEY = "sql_date_and_time_time_zone";
    private String numberFormat;
    public static final String NUMBER_FORMAT_KEY = "number_format";
    private String timeFormat;
    public static final String TIME_FORMAT_KEY = "time_format";
    private String dateFormat;
    public static final String DATE_FORMAT_KEY = "date_format";
    private String dateTimeFormat;
    public static final String DATETIME_FORMAT_KEY = "datetime_format";
    private Integer classicCompatible;
    public static final String CLASSIC_COMPATIBLE_KEY = "classic_compatible";
    private TemplateExceptionHandler templateExceptionHandler;
    public static final String TEMPLATE_EXCEPTION_HANDLER_KEY = "template_exception_handler";
    private Boolean wrapUncheckedExceptions;
    private AttemptExceptionReporter attemptExceptionReporter;
    private ArithmeticEngine arithmeticEngine;
    public static final String ARITHMETIC_ENGINE_KEY = "arithmetic_engine";
    private ObjectWrapper objectWrapper;

    protected Configurable(Version incompatibleImprovements) {

        parent = null;
        properties = new Properties();

        locale = _TemplateAPI.getDefaultLocale();
        properties.setProperty(LOCALE_KEY, locale.toString());

        timeZone = _TemplateAPI.getDefaultTimeZone();
        properties.setProperty(TIME_ZONE_KEY, timeZone.getID());

        sqlDataAndTimeTimeZone = null;
        properties.setProperty(SQL_DATE_AND_TIME_TIME_ZONE_KEY, String.valueOf(sqlDataAndTimeTimeZone));

        numberFormat = "number";
        properties.setProperty(NUMBER_FORMAT_KEY, numberFormat);

        timeFormat = "";
        properties.setProperty(TIME_FORMAT_KEY, timeFormat);

        dateFormat = "";
        properties.setProperty(DATE_FORMAT_KEY, dateFormat);

        dateTimeFormat = "";
        properties.setProperty(DATETIME_FORMAT_KEY, dateTimeFormat);

        classicCompatible = Integer.valueOf(0);
        properties.setProperty(CLASSIC_COMPATIBLE_KEY, classicCompatible.toString());

        templateExceptionHandler = _TemplateAPI.getDefaultTemplateExceptionHandler(incompatibleImprovements);
        properties.setProperty(TEMPLATE_EXCEPTION_HANDLER_KEY, templateExceptionHandler.getClass().getName());

        wrapUncheckedExceptions = _TemplateAPI.getDefaultWrapUncheckedExceptions(incompatibleImprovements);

        attemptExceptionReporter = _TemplateAPI.getDefaultAttemptExceptionReporter(incompatibleImprovements);

        arithmeticEngine = ArithmeticEngine.BIGDECIMAL_ENGINE;
        properties.setProperty(ARITHMETIC_ENGINE_KEY, arithmeticEngine.getClass().getName());

        objectWrapper = Configuration.getDefaultObjectWrapper(incompatibleImprovements);
        // bug: setProperty missing

        autoFlush = Boolean.TRUE;
        properties.setProperty(AUTO_FLUSH_KEY, autoFlush.toString());

        newBuiltinClassResolver = TemplateClassResolver.UNRESTRICTED_RESOLVER;
        properties.setProperty(NEW_BUILTIN_CLASS_RESOLVER_KEY, newBuiltinClassResolver.getClass().getName());

        showErrorTips = Boolean.TRUE;
        properties.setProperty(SHOW_ERROR_TIPS_KEY, showErrorTips.toString());

        apiBuiltinEnabled = Boolean.FALSE;
        properties.setProperty(API_BUILTIN_ENABLED_KEY, apiBuiltinEnabled.toString());

        logTemplateExceptions = Boolean.valueOf(
                _TemplateAPI.getDefaultLogTemplateExceptions(incompatibleImprovements));
        properties.setProperty(LOG_TEMPLATE_EXCEPTIONS_KEY, logTemplateExceptions.toString());

        // outputEncoding and urlEscapingCharset defaults to null,
        // which means "not specified"

        setBooleanFormat(C_TRUE_FALSE);

        customAttributes = new HashMap();

        customDateFormats = Collections.emptyMap();
        customNumberFormats = Collections.emptyMap();

        lazyImports = false;
        lazyAutoImportsSet = true;

        initAutoImportsMap();
        initAutoIncludesList();
    }
    public void setTemplateExceptionHandler(TemplateExceptionHandler templateExceptionHandler) {
        NullArgumentException.check("templateExceptionHandler", templateExceptionHandler);
        this.templateExceptionHandler = templateExceptionHandler;
        properties.setProperty(TEMPLATE_EXCEPTION_HANDLER_KEY, templateExceptionHandler.getClass().getName());
    }
}
