package com.maolin.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.maolin.test.fastjson.model.Site;
import com.maolin.test.fastjson.model.SiteNetworkAccess;
import com.maolin.test.fastjson.model.SiteNetworkAccesses;
import com.maolin.test.fastjson.model.Sites;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FastJsonTest {

    @Test
    public void testFastJson(){
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
    }

}
