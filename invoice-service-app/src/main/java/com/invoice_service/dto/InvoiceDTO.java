package com.invoice_service.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
public class InvoiceDTO {


    private String invoiceId;
    private String invoiceNumber;
    private String productIds;
    private String createdTime;
}
