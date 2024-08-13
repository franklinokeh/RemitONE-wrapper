package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateRemitter;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;

public interface RemitterService {
    String createRemitter(CreateRemitter request);

    String searchRemitter(SearchRemitter searchRemitter);
}
