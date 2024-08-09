package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.RemitterRequest;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;
import com.codedsolutions47.remitonewrapper.service.RemitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RemitterServiceImpl implements RemitterService {
    @Override
    public String createRemitter(RemitterRequest request) {
        return "";
    }

    @Override
    public String searchRemitter(SearchRemitter searchRemitter) {
        return "";
    }
}
