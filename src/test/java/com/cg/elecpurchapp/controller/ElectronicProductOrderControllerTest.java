/*
 * Controller test class
 */
package com.cg.elecpurchapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.http.HttpHeaders;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.elecpurchapp.model.ElectronicProductOrder;
import com.cg.elecpurchapp.service.ElectronicProductOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ElectronicProductOrderController.class)
class ElectronicProductOrderControllerTest {
@Autowired
	MockMvc mockMvc;
@MockBean
ElectronicProductOrderService productOrderService;
private static ObjectMapper mapper = new ObjectMapper();
/*
 * Test method to find the product order by given order id
 */
	@Test
	void test_GetProductOrderDetails() throws Exception {
		BDDMockito.given(productOrderService.findByOrderId(Mockito.anyString())).willReturn(new ElectronicProductOrder("order1",3000,"shipped"));
		mockMvc.perform(MockMvcRequestBuilders.get("/productorders/order1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isMap())
		.andExpect(jsonPath("orderId").value("order1"))
		.andExpect(jsonPath("totalAmount").value(3000))
		.andExpect(jsonPath("orderStatus").value("shipped"));
	}
	/*
	 * Test method for exception when product order is not found
	 */
//	@Test
//	void test_GetProductOrderDetails_ThrowProjectNotFoundException() throws Exception{
//		
//		BDDMockito.given(productOrderService.findByOrderId(Mockito.anyString())).willThrow(new ElectronicProductOrderNotFoundException());
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/productorders/order1"))
//		.andExpect(status().isNotFound());
//		
//	}
	/*
	 * Test method for add the new product order 
	 */
	 @Test
	    public void test_addNewProductOrder() throws Exception {
		 ElectronicProductOrder productOrder = new ElectronicProductOrder();
		 productOrder.setOrderId("order1");
		 productOrder.setTotalAmount(3000);
		 productOrder.setOrderStatus("shipped");
		 
	        Mockito.when(productOrderService.saveorUpdate(ArgumentMatchers.any())).thenReturn(productOrder);
	        String json = mapper.writeValueAsString(productOrder);
	        mockMvc.perform(post("/productorders").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	                .content(json).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("orderId", Matchers.equalTo("order1")))
	                .andExpect(jsonPath("totalAmount", Matchers.equalTo(3000.0)))
	                .andExpect(jsonPath("orderStatus", Matchers.equalTo("shipped")));
	    }
	 /*
	  * Test method for delete the product order by given order id
	  */
	 @Test
	    public void deleteProductOrder() throws Exception {      
		 when(productOrderService.findByOrderId("order1")).thenReturn(null);
			Object  result=productOrderService.removeById("order1");
			assertThat(result);
	    }
	 

	 }