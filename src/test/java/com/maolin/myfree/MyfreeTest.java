package com.maolin.myfree;

import com.maolin.entity.Product;
import com.maolin.myfree.cache.StringTemplateLoader;
import com.maolin.myfree.template.Configuration;
import com.maolin.myfree.template.TemplateExceptionHandler;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-26 10:03
 */
public class MyfreeTest {

    @Test
    public void test5() throws IOException, TemplateException {
        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> root = new HashMap<>();
        root.put("user", "Big Joe");

        Map<String, Object> latest = new HashMap<>();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        Product product = getLatestProductFromDatabaseOrSomething();
        root.put("product", product);

        String content = "${user}\n" +
                "!{latestProduct}\n" +
                "${latestProduct.url}\n" +
                "${latestProduct.name}\n" +
                "${product}\n" +
                "${product.name}\n" +
                "${product.url}\n" +
                "${product.price}\n" +
                "${product.created}";

        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("script", content);
        cfg.setTemplateLoader(stringTemplateLoader);

        Template temp = cfg.getTemplate("script");

        StringWriter writer = new StringWriter();
        temp.process(root, writer);

        System.out.println(writer.toString());
    }
    private Product getLatestProductFromDatabaseOrSomething() {
        Product product = new Product();
        product.setUrl("http://www.baidu.com");
        product.setName("百度");
        product.setPrice(-100);
        product.setCreated(LocalDateTime.now());
        return product;
    }

}
