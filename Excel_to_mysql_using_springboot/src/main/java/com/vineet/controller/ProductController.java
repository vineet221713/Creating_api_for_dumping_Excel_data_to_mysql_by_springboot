package com.vineet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vineet.helper.Helper;
import com.vineet.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/uplode")
	public ResponseEntity<?> Uplode(@RequestParam("file")MultipartFile file){
		if(Helper.checkExcelFormate(file)) {
			this.productService.save(file);
			
			return ResponseEntity.ok("File is uplodeed");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please uplode excel file");
	}
	
}
