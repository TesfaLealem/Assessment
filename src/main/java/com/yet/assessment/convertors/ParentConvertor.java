package com.yet.assessment.convertors;


import com.yet.assessment.DTOs.RestData.ParentPaymentDto;
import com.yet.assessment.models.Child;
import com.yet.assessment.models.Parent;
import com.yet.assessment.repository.ChildRepository;
import com.yet.assessment.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentConvertor {

    @Autowired
    ParentRepository parentRepository;
    @Autowired
    ChildRepository childRepository;

    public ParentPaymentDto toParentPaymentDto(Parent parent) {

        Parent parentById = parentRepository.findParentById(parent.getId());
        Long totalAmount=0L;
        List<Child> childByParent = childRepository.findChildByParent(parentById);
        for (Child child : childByParent){
            Long paidAmount = child.getPaidAmount();
            totalAmount = totalAmount + paidAmount;
        }

        ParentPaymentDto paymentDto = new ParentPaymentDto();
        paymentDto.setId(parentById.getId());
        paymentDto.setReceiver(parentById.getReceiver());
        paymentDto.setSender(parentById.getSender());
        paymentDto.setTotalAmount(parentById.getTotalAmount());
        paymentDto.setTotalPaidAmount(totalAmount);

        return paymentDto;
    }

    public List<ParentPaymentDto> toParentPaymentDtoList(List<Parent> parentList) {
        List<ParentPaymentDto> parentPaymentDtoList = new ArrayList<ParentPaymentDto>();
        for (Parent parent : parentList) {
            ParentPaymentDto parentPaymentDto = new ParentPaymentDto();
            parentPaymentDto = this.toParentPaymentDto(parent);
            parentPaymentDtoList.add(parentPaymentDto);
        }
        return parentPaymentDtoList;
    }

}
