package com.codedsolutions47.remitonewrapper.service;

import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.Request;

import java.util.Map;

public interface UtilityService {
    JsonNode getXMLResponseAsJson(String response);

    Request createRequest(String path, Map<String, Object> params);
}
