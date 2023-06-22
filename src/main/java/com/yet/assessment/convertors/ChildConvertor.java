package com.yet.assessment.convertors;


import com.yet.assessment.DTOs.RestData.ChildPaymentDto;
import com.yet.assessment.models.Child;
import com.yet.assessment.repository.ChildRepository;
import com.yet.assessment.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildConvertor {

    @Autowired
    ParentRepository parentRepository;
    @Autowired
    ChildRepository childRepository;

    public ChildPaymentDto toChildPaymentDto(Child child) {

        Child childById = childRepository.findChildById(child.getId());



        ChildPaymentDto childPaymentDto = new ChildPaymentDto();
        childPaymentDto.setId(childById.getId());
        childPaymentDto.setReceiver(childById.getParent().getReceiver());
        childPaymentDto.setSender(childById.getParent().getSender());
        childPaymentDto.setTotalAmount(childById.getParent().getTotalAmount());
        childPaymentDto.setPaidAmount(childById.getPaidAmount());

        return childPaymentDto;
    }

    public List<ChildPaymentDto> toChildPaymentDtoList(List<Child> childList) {
        List<ChildPaymentDto> childPaymentDtoList = new ArrayList<ChildPaymentDto>();
        for (Child child : childList) {
            ChildPaymentDto childPaymentDto = new ChildPaymentDto();
            childPaymentDto = this.toChildPaymentDto(child);
            childPaymentDtoList.add(childPaymentDto);
        }
        return childPaymentDtoList;
    }

}
