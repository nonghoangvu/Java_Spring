package com.vunh.service;

import com.vunh.entity.Customer;
import com.vunh.entity.Invoice;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class InvoiceService {
    private final List<Customer> customers = List.of(new Customer(1, "Nong Hoang Vu"), new Customer(2, "Mr Vuz"));
    public List<Invoice> invoices;

}
