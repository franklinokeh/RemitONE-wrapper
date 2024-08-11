package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.UpdateBeneficiary;

public interface BeneficiaryService {
    String createBeneficiary(CreateBeneficiary createBeneficiaryRequest);

    String searchBeneficiary(SearchBeneficiary searchBeneficiary);

    String updateBeneficiary(UpdateBeneficiary updateBeneficiary);
}
