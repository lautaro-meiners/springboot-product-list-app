package lautaro.meiners.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProductPriceListApplication {

	

	@RequestMapping("/")
	String greeting(){
		return "Welcome to the Product archive!!!!";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductPriceListApplication.class, args);
	}
	
}
