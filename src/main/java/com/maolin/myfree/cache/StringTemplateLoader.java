package com.maolin.myfree.cache;

import com.maolin.myfree.template.utility.StringUtil;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-27 10:11
 */
public class StringTemplateLoader implements TemplateLoader {
    private final Map<String, StringTemplateSource> templates = new HashMap<>();
    public void putTemplate(String name, String templateContent) {
        putTemplate(name, templateContent, System.currentTimeMillis());
    }
    public void putTemplate(String name, String templateContent, long lastModified) {
        templates.put(name, new StringTemplateSource(name, templateContent, lastModified));
    }
    public boolean removeTemplate(String name) {
        return templates.remove(name) != null;
    }
    @Override
    public Object findTemplateSource(String name) throws IOException {
        return templates.get(name);
    }

    @Override
    public long getLastModified(Object templateSource) {
        return ((StringTemplateSource) templateSource).lastModified;
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        return new StringReader(((StringTemplateSource) templateSource).templateContent);
    }

    @Override
    public void closeTemplateSource(Object templateSource) throws IOException {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TemplateLoaderUtils.getClassNameForToString(this));
        sb.append("(Map { ");
        int cnt = 0;
        for (String name : templates.keySet()) {
            cnt++;
            if (cnt != 1) {
                sb.append(", ");
            }
            if (cnt > 10) {
                sb.append("...");
                break;
            }
            sb.append(StringUtil.jQuote(name));
            sb.append("=...");
        }
        if (cnt != 0) {
            sb.append(' ');
        }
        sb.append("})");
        return sb.toString();
    }

    private static class StringTemplateSource {
        private final String name;
        private final String templateContent;
        private final long lastModified;

        StringTemplateSource(String name, String templateContent, long lastModified) {
            if (name == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (templateContent == null) {
                throw new IllegalArgumentException("source == null");
            }
            if (lastModified < -1L) {
                throw new IllegalArgumentException("lastModified < -1L");
            }
            this.name = name;
            this.templateContent = templateContent;
            this.lastModified = lastModified;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            StringTemplateSource other = (StringTemplateSource) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }


        @Override
        public String toString() {
            return name;
        }

    }
}
