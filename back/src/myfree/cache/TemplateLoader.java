package com.maolin.myfree.cache;

import java.io.IOException;
import java.io.Reader;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-27 10:10
 */
public interface TemplateLoader {
    public Object findTemplateSource(String name) throws IOException;

    public long getLastModified(Object templateSource);

    public Reader getReader(Object templateSource, String encoding) throws IOException;

    public void closeTemplateSource(Object templateSource) throws IOException;
}
