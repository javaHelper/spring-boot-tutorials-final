package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Payment;
import com.example.repository.PaymentRepository;


@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> findOrders() {
		List<Payment> orders = new ArrayList<>();
		paymentRepository.findAll().forEach(order -> orders.add(order));
		return orders;
	}

	@Override
	public Payment findOrderByCheckNumber(String checkNumber) {
		return paymentRepository.findByCheckNumber(checkNumber);
	}

	@Override
	public void deleteByPaymentId(String paymentId) {
		Optional<Payment> isPaymentPresent = paymentRepository.findById(Long.valueOf(paymentId));
		if(isPaymentPresent.isPresent()) {
			paymentRepository.delete(isPaymentPresent.get());
		}
	}

	@Override
	public Payment savePayment(Payment dto) {
		Payment payment = paymentRepository.save(dto);
		return payment;
	}
}
