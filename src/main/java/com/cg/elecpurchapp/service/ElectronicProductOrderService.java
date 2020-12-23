/*
 * Service interface 
 */
package com.cg.elecpurchapp.service;

import org.springframework.stereotype.Service;

import com.cg.elecpurchapp.model.ElectronicProductOrder;

public interface ElectronicProductOrderService {
/*
 * Method to find the product order by given order id
 */
	 ElectronicProductOrder findByOrderId(String orderId);
/*
 * Method to save the new product order
 */
	ElectronicProductOrder saveorUpdate(ElectronicProductOrder productOrder);
/*
 * Method to remove the product order by given order id
 */
	ElectronicProductOrder removeById(String string);
	/*
	 *Method to find and show all the product orders
	 */
	Iterable<ElectronicProductOrder> findAllProductOrders();
	ElectronicProductOrder update(int id, ElectronicProductOrder productOrder);
	
	
}
