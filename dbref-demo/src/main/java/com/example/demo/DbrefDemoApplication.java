package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Brand;
import com.example.demo.model.Model;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ModelRepository;

@SpringBootApplication
public class DbrefDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DbrefDemoApplication.class, args);
	}

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ModelRepository modelRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("------------------");
		/*Brand brand = Brand.builder().name("ABC").build();
		brandRepository.save(brand);
		
		Model model = Model.builder().name("MNO").brand(brand).build();
		modelRepository.save(model);*/
		
		List<Brand> brands = brandRepository.findAll();
		System.out.println("Size of Brands = "+brands);
		
		System.out.println("#####################################");
		List<Model> models = modelRepository.findAll();
		for (Model model : models) {
			System.out.println(model);
		}
		
		Model model = modelRepository.findByBrand_Id("5c9e0deb92bc0759081cec17");
		System.out.println(model);
	}
}
