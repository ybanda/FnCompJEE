/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mastertutorial.mvc.model.Product;
import com.mastertutorial.mvc.model.ProductService;

/**
 * @author Yashwanth
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static List<Product> products;

	static {
		products = populateDummyProducts();
	}

	@Override
	@Cacheable(value="products",key="#name",unless="#result==null")
	public Product getByName(String name) {
		System.out.println(" Inside of getByName ...");
		for(Product prod : products) {
			System.out.println("Product="+prod.toString());
			if(prod.getName().equalsIgnoreCase(name))
				return prod;

		}
		return null;
	}

	private static List<Product> populateDummyProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("aa",112));
		products.add(new Product("BB",1123));
		products.add(new Product("cc",42));
		products.add(new Product("DD",723));

		return products;
	}

	@Override
	@CachePut(value = "products", key = "#product.name" , unless="#result==null")
	public Product updateProduct(Product product) {
		for(Product prod:products) {
			if(prod.getName().equalsIgnoreCase(product.getName()))
			{
				prod.setPrice(product.getPrice());

				return prod;
			}
		}
		return null;
	}

	@Override
	@CacheEvict(value="products",allEntries=true)
	public void refreshAllProducts() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return products;
	}


}
