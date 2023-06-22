package com.yet.assessment.Services;


import com.yet.assessment.DTOs.RequestDTOs.ParentPaymentListDto;
import com.yet.assessment.Utilities.StatusInit;
import com.yet.assessment.convertors.ParentConvertor;
import com.yet.assessment.models.Parent;
import com.yet.assessment.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    ParentConvertor parentConvertor;
    @Autowired
    StatusInit statusInit;

    public ParentPaymentListDto listParentPayment() {

        ParentPaymentListDto parentPaymentListDto = new ParentPaymentListDto();
        List<Parent> all = parentRepository.findAll();


        if (!all.isEmpty()) {
            parentPaymentListDto.setPaymentDtos(parentConvertor.toParentPaymentDtoList(all));
            parentPaymentListDto.setCount(all.size());
            parentPaymentListDto.setStatus(statusInit.successful());
        }
        else {
            parentPaymentListDto.setPaymentDtos(new ArrayList<>());
            parentPaymentListDto.setCount(0);
            parentPaymentListDto.setStatus(statusInit.singleErrorInit("No Record", "No Parent Payment Record Found"));
        }
        return parentPaymentListDto;

    }


}
