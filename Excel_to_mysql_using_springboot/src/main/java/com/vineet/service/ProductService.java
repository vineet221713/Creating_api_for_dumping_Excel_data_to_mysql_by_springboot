package com.vineet.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vineet.entity.Product;
import com.vineet.helper.Helper;
import com.vineet.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productrepo;
	
	public void save(MultipartFile file) {
		
		try {
			List<Product> product = Helper.convertExcelToListOfProduct(file.getInputStream());
			this.productrepo.saveAll(product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  public List<Product> getAllProduct(){
	  
	  return this.productrepo.findAll();
	  
  }	
	

}
