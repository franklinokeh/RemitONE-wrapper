package com.codedsolutions47.remitonewrapper.dtos.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateBeneficiary extends CreateBeneficiary {
    private int beneficiaryId;
    private int linkedRemitterId;
}
