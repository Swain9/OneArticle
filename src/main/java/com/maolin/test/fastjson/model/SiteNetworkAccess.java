package com.maolin.test.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SiteNetworkAccess {
    @JSONField(name = "site-network-access-id")
    @JsonProperty(value = "site-network-access-id")
    private String siteNetworkAccessId;
}
