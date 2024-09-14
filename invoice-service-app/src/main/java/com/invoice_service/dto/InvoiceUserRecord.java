package com.invoice_service.dto;


import lombok.Data;

import java.util.List;

@Data
public class InvoiceUserRecord {

    private String userId;
    private List<InvoiceDTO> invoices;
}
