package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateRemitter;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;

import javax.xml.bind.JAXBException;

public interface RemitterService {
    String createRemitter(CreateRemitter request);

    String searchRemitter(SearchRemitter searchRemitter);

    void saveRemitter(CreateRemitter createRemitter, String response) throws JAXBException;
}
