/*
 * Repository test class 
 */
package com.cg.elecpurchapp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.elecpurchapp.model.ElectronicProductOrder;
@ExtendWith(SpringExtension.class)

@DataJpaTest
class ElectronicProductOrderRepositoryTest {
 @Autowired
 ElectronicProductOrderRepository productOrderRepository;
 /*
  * Test method for find product order by given order id
  */
	@Test
	void test_findByOrderId() throws Exception{
		System.out.println("---------------->"+productOrderRepository);
		Optional<ElectronicProductOrder> productOrder= productOrderRepository.findByOrderId("order1");
		assertTrue(productOrder.isPresent());
		
	}
}
