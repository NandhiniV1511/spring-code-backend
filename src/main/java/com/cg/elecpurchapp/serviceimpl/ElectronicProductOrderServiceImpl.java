package com.cg.elecpurchapp.serviceimpl;


/*
 * ServiceImplementation class which implements the Service interface
 */

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.elecpurchapp.model.ElectronicProductOrder;
import com.cg.elecpurchapp.repository.ElectronicProductOrderRepository;
import com.cg.elecpurchapp.service.ElectronicProductOrderService;
@Service
public class ElectronicProductOrderServiceImpl implements ElectronicProductOrderService {
	/*
	 * using autowire annotation for getting object of repository
	 */
	@Autowired
private ElectronicProductOrderRepository productOrderRepository;
	/*
	 * Method implementation of find product order by given order id
	 */
	public ElectronicProductOrder findByOrderId(String orderId) {
		ElectronicProductOrder eproductOrder=null;
		Optional<ElectronicProductOrder> productOrder =  productOrderRepository.findByOrderId(orderId);
		if(productOrder.isPresent()) {
			eproductOrder = productOrder.get();
	} 
			//else {
//			throw new ElectronicProductOrderNotFoundException();
//		}
		return eproductOrder;
	}

	/*
	 * Method implementation of save new product order
	 */
	@Override
	public ElectronicProductOrder saveorUpdate(ElectronicProductOrder productOrder) {
		
		
		ElectronicProductOrder order =  productOrderRepository.save(productOrder);

		return order;
//		
//			 productOrder.setOrderId(productOrder.getOrderId());
//			return  productOrderRepository.save(productOrder);
	
	}

/*
 * Method implementation of remove product order by given order id
 */
	@Override
	public ElectronicProductOrder removeById(String orderId) {
		ElectronicProductOrder productOrder=findByOrderId(orderId);
		if(productOrder!=null)
		{
			productOrderRepository.delete(productOrder);
			
		}
//		else {
//			throw new ElectronicProductOrderNotFoundException();
//		}
return null;
	}
	/*
	 *Implementing  the findAll method for show all the product orders
	 */
	@Override
	public Iterable<ElectronicProductOrder> findAllProductOrders() {
		Iterable<ElectronicProductOrder> orders=productOrderRepository.findAll();
		return orders;
	}

	@Override
	public ElectronicProductOrder update(int id, ElectronicProductOrder productOrder) {
		// TODO Auto-generated method stub
		productOrder.setId(id);
	
		return productOrderRepository.save(productOrder) ;
	}

	
	

}
