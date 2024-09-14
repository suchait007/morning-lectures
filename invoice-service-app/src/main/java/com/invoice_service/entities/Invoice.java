package com.invoice_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "INVOICE", schema = "invoice_svc_db")
public class Invoice {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "INVOICE_ID", nullable = false, length = 200)
    private String invoiceId;

    @Column(name = "USER_ID", nullable = false, length = 200)
    private String userId;

    @Column(name = "INVOICE_NUMBER", nullable = false, length = 500)
    private String invoiceNumber;

    @Column(name = "PRODUCT_IDS", nullable = false, columnDefinition = "TEXT")
    private String productIds;

    @Column(name = "CREATED_TIME", nullable = false)
    private LocalDateTime createdTime;

    @Column(name = "UPDATED_TIME", nullable = false)
    private LocalDateTime updatedTime;


}
