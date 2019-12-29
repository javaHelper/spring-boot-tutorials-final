package com.example.service;

import java.util.List;

import com.example.model.Payment;

public interface PaymentService {

	List<Payment> findOrders();

	Payment findOrderByCheckNumber(String checkNumber);

	void deleteByPaymentId(String paymentId);

	Payment savePayment(Payment dto);
}
