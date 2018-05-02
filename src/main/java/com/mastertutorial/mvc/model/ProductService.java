/**
 * 
 */
package com.mastertutorial.mvc.model;

import java.util.List;

/**
 * @author Yashwanth
 *
 */
public interface ProductService {

	Product getByName(String name);
	Product updateProduct(Product product);
	void refreshAllProducts();
	List<Product> getAllProducts();
}
