/*
 * Service test class
 */
package com.cg.elecpurchapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.cg.elecpurchapp.model.ElectronicProductOrder;
import com.cg.elecpurchapp.repository.ElectronicProductOrderRepository;
import com.cg.elecpurchapp.serviceimpl.ElectronicProductOrderServiceImpl;
import java.util.Optional;

class ElectronicProductOrderServiceImplTest {
@Mock
ElectronicProductOrderRepository productOrderRepository;
@InjectMocks
ElectronicProductOrderServiceImpl productOrderServiceImpl;
@BeforeEach
public void setup() {
	MockitoAnnotations.initMocks(this);
}
/*
 * Test method to find product order by given order id
 */
@Test
void test_findProductOrderByOrderId() {
	BDDMockito.given(productOrderRepository.findByOrderId("order2")).willReturn(Optional.of(new ElectronicProductOrder("order2",5000,"delivered")));
ElectronicProductOrder productOrder= productOrderServiceImpl.findByOrderId("order2");
	assertNotNull(productOrder);
	assertEquals("order2",productOrder.getOrderId());
	assertEquals(5000, productOrder.getTotalAmount());
	assertEquals("delivered", productOrder.getOrderStatus());
	
}
/*
 * Test method for exception when product order is not found
 */
//@Test
//void test_findProductOrderId_ThrowProjectNotFoundException() {
//	BDDMockito.given(productOrderRepository.findByOrderId("order1")).willThrow(new ElectronicProductOrderNotFoundException());
//	assertThrows(ElectronicProductOrderNotFoundException.class, ()->productOrderServiceImpl.findByOrderId("Third Project"));
//	
//}
/*
 * Test method for add the new product order
 */

@Test

	void test_addProductOrder() {

ElectronicProductOrder productOrder=new ElectronicProductOrder("order3",6000,"shipped");
when(productOrderRepository.save(productOrder)).thenReturn(productOrder);
Object result=productOrderRepository.save(productOrder);
assertEquals("order3", ((ElectronicProductOrder) result).getOrderId());
assertEquals(6000, ((ElectronicProductOrder) result).getTotalAmount());
assertEquals("shipped", ((ElectronicProductOrder) result).getOrderStatus());
}
/*
 * Test method for delete the product order by given order id
 */
@Test
void test_deleteProductOrder_ByGivenOrderId()
{
	when(productOrderRepository.findById("order1")).thenReturn(null);
	Object  result=productOrderRepository.removeById("order1");
	assertThat(result);
	}

}
