package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.RemitterRequest;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;

public interface RemitterService {
    String createRemitter(RemitterRequest request);

    String searchRemitter(SearchRemitter searchRemitter);
}
