package com.codedsolutions47.remitonewrapper.service.impl;


import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class UtilityServiceImpl implements UtilityService {

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    @Override
    public JsonNode getXMLResponseAsJson (String xmlResponse) {
        try {
            JsonNode jsonNode = xmlMapper.readTree(xmlResponse.getBytes());
            String prettyJson = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            log.info("Converted XML to JSON: {}", prettyJson);
            return jsonNode;
        } catch (IOException e) {
            log.error("Error converting XML to JSON: ", e);
            return null;
        }
    }

}
