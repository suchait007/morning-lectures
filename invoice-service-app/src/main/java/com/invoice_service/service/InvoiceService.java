package com.invoice_service.service;


import com.invoice_service.dto.InvoiceDTO;
import com.invoice_service.dto.InvoiceUserRecord;
import com.invoice_service.entities.Invoice;
import com.invoice_service.jpa.InvoiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;

    public List<InvoiceUserRecord> getInvoices(List<String> userIds) {
        List<Invoice> invoices = invoiceRepo.findAllByUserIdIn(userIds);


        Map<String, List<Invoice>> groupByInvoiceRecords =
        invoices.stream()
                .collect(Collectors.groupingBy(Invoice::getUserId));


        return prepareInvoiceUserRecords(groupByInvoiceRecords);
    }

    private List<InvoiceUserRecord> prepareInvoiceUserRecords(Map<String, List<Invoice>> groupingRecords) {


        List<InvoiceUserRecord> invoiceUserRecords = new ArrayList<>();

        groupingRecords.entrySet()
                .stream()
                .forEach(entry -> {

                    InvoiceUserRecord invoiceUserRecord = new InvoiceUserRecord();
                    invoiceUserRecord.setUserId(entry.getKey());

                    List<InvoiceDTO> invoiceDTOS = new ArrayList<>();

                    entry.getValue().forEach(nestedEntry -> {

                        InvoiceDTO invoiceDTO = new InvoiceDTO();
                        invoiceDTO.setInvoiceId(nestedEntry.getInvoiceId());
                        invoiceDTO.setInvoiceNumber(nestedEntry.getInvoiceNumber());
                        invoiceDTO.setProductIds(nestedEntry.getProductIds());
                        invoiceDTO.setCreatedTime(nestedEntry.getCreatedTime().toString());

                        invoiceDTOS.add(invoiceDTO);

                    });

                    invoiceUserRecord.setInvoices(invoiceDTOS);
                    invoiceUserRecords.add(invoiceUserRecord);

                });

        return invoiceUserRecords;

    }


}
