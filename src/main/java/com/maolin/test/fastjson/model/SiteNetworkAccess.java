package com.maolin.test.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class SiteNetworkAccess {
    @JSONField(name = "site-network-access-id")
    private String siteNetworkAccessId;
}
