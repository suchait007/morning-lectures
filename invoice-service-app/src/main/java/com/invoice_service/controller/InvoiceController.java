package com.invoice_service.controller;


import com.invoice_service.dto.InvoiceUserRecord;
import com.invoice_service.entities.Invoice;
import com.invoice_service.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/invoices")
    public List<InvoiceUserRecord> getInvoiceList(@RequestParam("user_ids") List<String> userIds) {
        return invoiceService.getInvoices(userIds);
    }
}
