/*
 * Interface of ElectronicProduct Order 
 */
package com.cg.elecpurchapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.elecpurchapp.model.ElectronicProductOrder;
import java.util.Optional;

@Repository
/*
 *Extends the CrudRepository interface which give all the implementation for crud operations
 */
public interface ElectronicProductOrderRepository extends CrudRepository<ElectronicProductOrder,String>{
/*
 * Method for find the product order y order id
 */
	public Optional<ElectronicProductOrder> findByOrderId(String orderId);
	/*
	 * Method for remove the product order by given order id
	 */
	public Optional<ElectronicProductOrder> removeById(String orderId);
	//public ElectronicProductOrder saveorUpdate(ElectronicProductOrder productOrder);
	
	
}
