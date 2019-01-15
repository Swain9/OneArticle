package com.maolin.test.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Site {
    @JSONField(name = "site-id")
    @JsonProperty(value = "site-id")
    private String siteId;
    @JSONField(name = "site-network-accesses")
    @JsonProperty(value = "site-network-accesses")
    private SiteNetworkAccesses siteNetworkAccesses;
}
