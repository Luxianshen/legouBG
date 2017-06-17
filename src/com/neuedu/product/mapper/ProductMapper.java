package com.neuedu.product.mapper;

import java.util.List;

import com.neuedu.product.entity.Product;

public interface ProductMapper {
    //查找所有的商品
   	public List<Product> getAllProduct();

	public Product getOneProduct(Integer proId);

	public List<Product> findtypepro(String proType);

	public List<Product> search(String aa);
	
	//查找特定类别的商品
	
    //查找一个商品
	
}
