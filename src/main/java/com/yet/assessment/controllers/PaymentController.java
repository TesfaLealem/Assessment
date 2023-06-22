package com.yet.assessment.controllers;

import com.yet.assessment.DTOs.RequestDTOs.ChildPaymentListDto;
import com.yet.assessment.DTOs.RequestDTOs.ParentPaymentListDto;
import com.yet.assessment.Services.ChildService;
import com.yet.assessment.Services.ParentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController

@Api(value = "payment management")
public class PaymentController {

    @Autowired
    ParentService parentService;
    @Autowired
    ChildService childService;


    @GetMapping("/api/assessment/listParentPayment")
    public ParentPaymentListDto listParentPayment()  {
        return parentService.listParentPayment();
    }

    @GetMapping("/api/assessment/listChildPayment")
    public ChildPaymentListDto listChildPayment()  {
        return childService.listChildPayment();
    }



}
