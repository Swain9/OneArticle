package com.maolin.dom4j;

import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.QNameCache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2021-04-29 13:39
 */

public class QNameNoCache extends QNameCache {
    public QNameNoCache() {}

    public List<QName> getQNames() {
        throw new RuntimeException("Not implemented.");
    }

    public QName get(String name) {
        return createQName(name);
    }

    public QName get(String name, Namespace namespace) {
        if (name == null) {
            name = "";
        }

        return createQName(name, namespace);
    }

    public QName get(String localName, Namespace namespace, String qName) {
        if (localName == null) {
            localName = "";
        }

        return createQName(localName, namespace, qName);
    }

    public QName get(String qualifiedName, String uri) {
        int index = qualifiedName.indexOf(':');

        if (index < 0) {
            return get(qualifiedName, Namespace.get(uri));
        } else if (index == 0) {
            throw new IllegalArgumentException("Qualified name cannot start with ':'.");
        } else {
            String name = qualifiedName.substring(index + 1);
            String prefix = qualifiedName.substring(0, index);
            return get(name, Namespace.get(prefix, uri));
        }
    }

    public QName intern(QName qname) {
        return qname;
    }

    protected Map<String, QName> getNamespaceCache(Namespace namespace) {
        if (namespace == Namespace.NO_NAMESPACE) {
            return noNamespaceCache;
        } else {
            return namespaceCache.computeIfAbsent(namespace, (ns) -> new HashMap<>());
        }
    }

    protected Map<String, QName> createMap() {
        throw new RuntimeException("Not implemented.");
    }

    protected QName createQName(String name) {
        return new QName(name);
    }

    protected QName createQName(String name, Namespace namespace) {
        return new QName(name, namespace);
    }

    protected QName createQName(String name, Namespace namespace, String qualifiedName) {
        return new QName(name, namespace, qualifiedName);
    }
}
