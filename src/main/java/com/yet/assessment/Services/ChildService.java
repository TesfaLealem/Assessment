package com.yet.assessment.Services;


import com.yet.assessment.DTOs.RequestDTOs.ChildPaymentListDto;
import com.yet.assessment.DTOs.RequestDTOs.ParentPaymentListDto;
import com.yet.assessment.Utilities.StatusInit;
import com.yet.assessment.convertors.ChildConvertor;
import com.yet.assessment.convertors.ParentConvertor;
import com.yet.assessment.models.Child;
import com.yet.assessment.models.Parent;
import com.yet.assessment.repository.ChildRepository;
import com.yet.assessment.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    ChildConvertor childConvertor;
    @Autowired
    StatusInit statusInit;

    public ChildPaymentListDto listChildPayment() {

        ChildPaymentListDto childPaymentListDto = new ChildPaymentListDto();
        List<Child> all = childRepository.findAll();


        if (!all.isEmpty()) {
            childPaymentListDto.setChildPaymentDtos(childConvertor.toChildPaymentDtoList(all));
            childPaymentListDto.setCount(all.size());
            childPaymentListDto.setStatus(statusInit.successful());
        }
        else {
            childPaymentListDto.setChildPaymentDtos(new ArrayList<>());
            childPaymentListDto.setCount(0);
            childPaymentListDto.setStatus(statusInit.singleErrorInit("No Record", "No Child Payment Record Found"));
        }
        return childPaymentListDto;

    }


}
