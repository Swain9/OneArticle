package com.maolin.test.jackson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maolin.test.fastjson.model.Site;
import com.maolin.test.fastjson.model.SiteNetworkAccess;
import com.maolin.test.fastjson.model.SiteNetworkAccesses;
import com.maolin.test.fastjson.model.Sites;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-01-03 23:17
 */
public class TypeTest {

    @Test
    public void testType() {
        Sites sites = new Sites();
        List<Site> list = new ArrayList<Site>();
        Site site = new Site();
        site.setSiteId("1");
        SiteNetworkAccesses siteNetworkAccesses = new SiteNetworkAccesses();
        List<SiteNetworkAccess> siteNetworkAccessList = new ArrayList<SiteNetworkAccess>();
        SiteNetworkAccess siteNetworkAccess = new SiteNetworkAccess();
        siteNetworkAccess.setSiteNetworkAccessId("110");
        siteNetworkAccessList.add(siteNetworkAccess);
        siteNetworkAccesses.setSiteNetworkAccess(siteNetworkAccessList);
        site.setSiteNetworkAccesses(siteNetworkAccesses);
        list.add(site);
        sites.setSite(list);

        String s = JSON.toJSONString(sites);
        System.out.println(s);
        //Sites json = jsonToObject2(s);
        Sites json = JSON.parseObject(s, new com.alibaba.fastjson.TypeReference<Sites>() {
        });

        System.out.println(json);
    }

    public <T> T jsonToObject(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            T value = mapper.readValue(json, new TypeReference<T>() {

            });
            return value;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T jsonToObject2(String json) {
        T t = JSON.parseObject(json, new com.alibaba.fastjson.TypeReference<T>() {
        });
        return t;
    }

}
