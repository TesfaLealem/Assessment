package com.yet.assessment.DTOs.RestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentPaymentDto {

    private Long id;
    private String receiver;
    private String sender;
    private Long totalAmount;
    private Long totalPaidAmount;
}
