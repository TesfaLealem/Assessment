package com.yet.assessment.DTOs.RequestDTOs;

import com.yet.assessment.DTOs.RestData.ChildPaymentDto;
import com.yet.assessment.DTOs.RestData.ParentPaymentDto;
import com.yet.assessment.Utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildPaymentListDto {
    private List<ChildPaymentDto> childPaymentDtos;
    private long count;
    private Status status;
}
