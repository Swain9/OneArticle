package com.maolin.test.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Site {
    @JSONField(name = "site-id")
    private String siteId;
    @JSONField(name = "site-network-accesses")
    private SiteNetworkAccesses siteNetworkAccesses;
}
