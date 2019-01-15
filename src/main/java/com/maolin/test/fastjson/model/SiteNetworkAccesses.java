package com.maolin.test.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SiteNetworkAccesses {
    @JSONField(name = "site-network-access")
    @JsonProperty(value = "site-network-access")
    private List<SiteNetworkAccess> siteNetworkAccess;
}
