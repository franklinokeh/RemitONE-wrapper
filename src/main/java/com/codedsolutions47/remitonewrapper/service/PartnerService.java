package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.GetCollectionPoints;
import com.codedsolutions47.remitonewrapper.dtos.request.GetDeliveryBankBranches;
import com.codedsolutions47.remitonewrapper.dtos.request.GetDeliveryBanks;

public interface PartnerService {
    String getDestinationCountries();

    String getDeliveryBanks(GetDeliveryBanks getDeliveryBanks);

    String getDeliveryBankBranches(GetDeliveryBankBranches getDeliveryBankBranches);

    String getCollectionPoints(GetCollectionPoints getCollectionPoints);
}
