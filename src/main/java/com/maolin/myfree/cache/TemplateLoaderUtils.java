package com.maolin.myfree.cache;

import com.maolin.myfree.template.Configuration;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-27 10:14
 */
final class TemplateLoaderUtils {
    private TemplateLoaderUtils() {
        // Not meant to be instantiated
    }

    public static String getClassNameForToString(TemplateLoader templateLoader) {
        final Class tlClass = templateLoader.getClass();
        final Package tlPackage = tlClass.getPackage();
        return tlPackage == Configuration.class.getPackage() || tlPackage == TemplateLoader.class.getPackage()
                ? tlClass.getSimpleName() : tlClass.getName();
    }
}
