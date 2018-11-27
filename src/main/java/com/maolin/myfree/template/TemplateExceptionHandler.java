package com.maolin.myfree.template;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 16:45
 */
public interface TemplateExceptionHandler {

    TemplateExceptionHandler DEBUG_HANDLER = new TemplateExceptionHandler() {
        public void handleTemplateException(TemplateException te, Environment env, Writer out)
                throws TemplateException {
            if (!env.isInAttemptBlock()) {
                PrintWriter pw = (out instanceof PrintWriter) ? (PrintWriter) out : new PrintWriter(out);
                pw.print("FreeMarker template error (DEBUG mode; use RETHROW in production!):\n");
                te.printStackTrace(pw, false, true, true);

                pw.flush();  // To commit the HTTP response
            }
            throw te;
        }
    };
    TemplateExceptionHandler RETHROW_HANDLER = new TemplateExceptionHandler() {
        public void handleTemplateException(TemplateException te, Environment env, Writer out)
                throws TemplateException {
            throw te;
        }
    };
}
