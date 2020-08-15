package com.cg.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pms.dao.ProductDao;
import com.cg.pms.entity.Product;
import com.cg.pms.exception.ProductException;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> findAllProducts() {
		
		List<Product> list=productDao.findAll();
		return list;
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		Product p=null;
		if(productDao.existsById(productId))
		{
			p=productDao.findById(productId).get();
		}
		else
		{
			throw new ProductException(productId+"ID NOT FOUND");
		}
		return p;
	}

	@Override
	public Product addProduct(Product product) {
		productDao.saveAndFlush(product);
		return product;
	}

	@Override
	public Product deleteProductById(int productId) {

	Product  p =null;
	if(productDao.existsById(productId))
	{
		p=productDao.findById(productId).get();
		 productDao.deleteById(productId);
	}
	return p;
	}
	@Override
	public List<Product> findAllProductByCharacterName(char ch) {
		
		return productDao.findAllProductByCharacterName(ch);
	}

	@Override
	public List<Product> findAllProductByPrice(double low, double high) {
		
		return productDao.findAllProductByPrice(low, high);
	}

}
