package com.codedsolutions47.remitonewrapper.dtos.response;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "response")
public class CreateRemitterXmlResponse {
    @XmlElement(name = "responseId")
    private int responseId;

    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "new_remitter_id")
    private Long newRemitterId;

}
