package com.codedsolutions47.remitonewrapper.dtos.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int value, String message) {
    }
}
