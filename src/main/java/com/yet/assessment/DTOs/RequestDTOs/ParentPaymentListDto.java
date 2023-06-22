package com.yet.assessment.DTOs.RequestDTOs;

import com.yet.assessment.DTOs.RestData.ParentPaymentDto;
import com.yet.assessment.Utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentPaymentListDto {
    private List<ParentPaymentDto> paymentDtos;
    private long count;
    private Status status;
}
