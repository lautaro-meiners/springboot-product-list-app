package lautaro.meiners.spring.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ProductPriceListController {

	private ProductRepository productRepository;

	@Autowired
	public ProductPriceListController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// @RequestMapping(value = "/{consumer}.php", method = RequestMethod.GET)
	// public String consumersProducts(@PathVariable("consumer") String
	// consumer, Model model) {
	// List<Product> productList = productRepository.findByConsumer(consumer);
	// if (productList != null) {
	// model.addAttribute("products", productList);
	// }
	// return "productList";
	// }

	@RequestMapping(value = "/consumer.php", method = RequestMethod.POST)
	public String addToProductList(Product product, String userName) {
		product.setConsumer(userName);
		productRepository.save(product);
		return "redirect:/consumer.php?userName=" + userName;
	}

	@RequestMapping(value = "/consumer.php", method = RequestMethod.GET)
	public String nameProducts(@RequestParam(value = "userName", required = false) String userName, Model model) {
		
		List<Product> nameList;
		if (userName != null) {
			model.addAttribute("header", userName+"'s Products");
			nameList = productRepository.findByConsumer(userName);
		} else {
			nameList = productRepository.findAll();
			model.addAttribute("header", "All Products");
		}
		if (nameList != null) {
			model.addAttribute("products", nameList);
			model.addAttribute("userName", userName);
		}
		return "nameList";
	}

}
