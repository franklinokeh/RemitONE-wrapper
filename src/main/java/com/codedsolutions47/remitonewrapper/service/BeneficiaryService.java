package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.UpdateBeneficiary;

import javax.xml.bind.JAXBException;

public interface BeneficiaryService {
    String createBeneficiary(CreateBeneficiary createBeneficiaryRequest);

    String searchBeneficiary(SearchBeneficiary searchBeneficiary);

    String updateBeneficiary(UpdateBeneficiary updateBeneficiary);

    void saveBeneficiary(CreateBeneficiary createBeneficiary, String partnerId, String response) throws JAXBException;

}
