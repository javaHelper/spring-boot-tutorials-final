package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Payment;
import com.example.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Order")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@ApiOperation(value = "Find Payements", nickname = "Find Payements")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),	@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/api/payments")
	public ResponseEntity<List<Payment>> findOrders() {
		List<Payment> payments = paymentService.findOrders();
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Find Payment By Check Number", nickname = "Find Payment By Check Number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),	@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/api/payment/{check-number}")
	public ResponseEntity<Payment> findOrderByCheckNumber(
			@ApiParam(value="Find Payment By Check Number")
			@PathVariable("check-number") String checkNumber) {
		Payment payment = paymentService.findOrderByCheckNumber(checkNumber);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create Payment", nickname = "Save Payment")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Save Payment Successful"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, response = Exception.class, message = "Payment details are required ") })
	@PostMapping("/payment")
	public ResponseEntity<Payment> saveProgram(
			@ApiParam(value="Accepts a valid details to create a new Payment.")
			@Valid @RequestBody Payment dto){
		Payment payment = paymentService.savePayment(dto);
		return new ResponseEntity<>(payment, HttpStatus.CREATED);
	}
	
	
	@ApiOperation(value = "Update Payment", nickname = "Update Payment")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Save Payment Successful"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, response = Exception.class, message = "Payment details are required ") })
	@PutMapping("/payment")
	public ResponseEntity<Payment> updateProgram(
			@ApiParam(value="Accepts a valid details to create a new Payment.")
			@Valid @RequestBody Payment dto){
		Payment payment = paymentService.savePayment(dto);
		return new ResponseEntity<>(payment, HttpStatus.CREATED);
	}
	
	
	@ApiOperation(value = "Delete Payment", nickname = "Delete Payment")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),@ApiResponse(code = 500, message = "Internal Server Error") })
	@DeleteMapping("/api/payment/{payment-id}")
	public ResponseEntity<HttpStatus> deleteProgram(
			@ApiParam(value="Accepts a valid payment id need to delete the Payment .")
			@PathVariable("payment-id") String paymentId){
		paymentService.deleteByPaymentId(paymentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
