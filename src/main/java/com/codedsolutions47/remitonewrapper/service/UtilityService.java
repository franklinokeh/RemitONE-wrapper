package com.codedsolutions47.remitonewrapper.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

public interface UtilityService {
    JsonNode getXMLResponseAsJson(String response);

}
