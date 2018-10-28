package com.maolin.test.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class SiteNetworkAccesses {
    @JSONField(name = "site-network-access")
    private List<SiteNetworkAccess> siteNetworkAccess;
}
