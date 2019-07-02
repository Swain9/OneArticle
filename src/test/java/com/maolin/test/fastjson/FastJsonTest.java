package com.maolin.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.maolin.entity.ListTestObj;
import com.maolin.test.fastjson.model.JsonBean;
import com.maolin.test.fastjson.model.JsonSubBean;
import com.maolin.test.fastjson.model.Site;
import com.maolin.test.fastjson.model.SiteNetworkAccess;
import com.maolin.test.fastjson.model.SiteNetworkAccesses;
import com.maolin.test.fastjson.model.Sites;
import org.junit.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FastJsonTest {

    @Test
    public void testFastJson() {
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

    @Test
    public void testJson() {
        Path path = Paths.get("src/test/resources/json_script.txt");
        String s = "";
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            s = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListTestObj listTestObj = new ListTestObj();
        List<String> list = new ArrayList<>();
        list.add(s);
        listTestObj.setList(list);

        String s1 = JSON.toJSONString(listTestObj);
        System.out.println(s1);

    }

    @Test
    public void testJson2(){
        JsonBean jsonBean = new JsonBean();
        jsonBean.setName("你好");
        List<JsonSubBean> list = new ArrayList<>();

        JsonSubBean jsonSubBean1 = new JsonSubBean();
        jsonSubBean1.setName("aaa");
        jsonSubBean1.setFlag(false);
        jsonSubBean1.setNum(111);

        list.add(jsonSubBean1);

        jsonBean.setList(list);
//        jsonBean.setJsonSubBean(null);
        jsonBean.setJsonSubBean(new JsonSubBean());

        String json = JSON.toJSONString(jsonBean);
        System.out.println(json);

        JsonBean object = JSON.parseObject(json, JsonBean.class);
        System.out.println(object);

    }

}
