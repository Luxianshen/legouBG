package com.neuedu.product.mapper;

import java.util.List;

import com.neuedu.product.entity.Product;

public interface ProductMapper {
    //�������е���Ʒ
   	public List<Product> getAllProduct();

	public Product getOneProduct(Integer proId);

	public List<Product> findtypepro(String proType);

	public List<Product> search(String aa);
	
	//�����ض�������Ʒ
	
    //����һ����Ʒ
	
}
