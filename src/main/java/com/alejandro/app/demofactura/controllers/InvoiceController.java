package com.alejandro.app.demofactura.controllers;

import com.alejandro.app.demofactura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private final Invoice invoice;

    public InvoiceController(Invoice invoice) {
        this.invoice = invoice;
    }

    @GetMapping("")
    public Invoice show () {
        return invoice;
    }
}
