package com.invoice_service.jpa;


import com.invoice_service.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepo  extends JpaRepository<Invoice, String> {

    List<Invoice> findAllByUserIdIn(List<String> userIds);
}
