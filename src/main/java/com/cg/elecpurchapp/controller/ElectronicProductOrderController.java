/*
 * Controller class for ElectronicPurchase App
 */
package com.cg.elecpurchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.elecpurchapp.model.ElectronicProductOrder;
import com.cg.elecpurchapp.service.ElectronicProductOrderService;





@RestController
@CrossOrigin
@RequestMapping("/productorders")
public class ElectronicProductOrderController {
	/*
	 * Autowire the ElectronicProductService interface for getting object
	 */
	@Autowired
	private ElectronicProductOrderService productOrderService;
	/*
	 * Creating get method for retriving the details of electronic product order based on given order id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ElectronicProductOrder> getProjectDetail(@PathVariable String orderId)
	{ 
		ElectronicProductOrder productOrder=productOrderService.findByOrderId(orderId);
		return new ResponseEntity<>(productOrder,HttpStatus.OK);
		
	}
	/*
	 * Creating a post method for insert the new product order in database
	 */
	@PostMapping()
   public ResponseEntity<ElectronicProductOrder> saveorUpdate(@RequestBody(required=false) ElectronicProductOrder productOrder) {
		
	ElectronicProductOrder newOrder=  productOrderService.saveorUpdate(productOrder);
       return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }
	/*
	 * Creating the delete method for delete the particular order based on the given order id
	 */
	@DeleteMapping("/delete/{orderId}")
	 public ResponseEntity<ElectronicProductOrder> removeProductOrder(@PathVariable String orderId)
		{ 
			productOrderService.removeById(orderId);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
	/*
	 * Creating the findAll method for show all the product orders
	 */
	@GetMapping("/all")
	public Iterable<ElectronicProductOrder> getAllProductOrders(){
		return productOrderService.findAllProductOrders();
	}
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<ElectronicProductOrder> updateProductOrder(@RequestBody ElectronicProductOrder productOrder,@PathVariable int id)
	{ 
		ElectronicProductOrder updateOrder=  productOrderService.update(id,productOrder);
	       return new ResponseEntity<>(updateOrder, HttpStatus.OK);
		
	}
	

}
