package in.rajeshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.rajeshit.entity.Product;
import in.rajeshit.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/delete")
	public String delete(@RequestParam("pid") Integer pid,Model model) {
		repo.deleteById(pid);
		model.addAttribute("raj", "Delete Successfully");
		model.addAttribute("p", repo.findAll());
		return "data";
     }
	
	@GetMapping("/products")
	public String getAllProducts(Model model) {
	model.addAttribute("p", repo.findAll());
		return "data";
		
	}
	@GetMapping("/")
	public String loadForm(Model model) {
	model.addAttribute("P", new Product());
		return "index";
	}
	
	@PostMapping("/product")
	public String saveProduct(@Validated @ModelAttribute("P") Product product,BindingResult result, Model model) {
		if(result.hasErrors()) { 
			return "index";
		}
		 Product p = repo.save(product);
		if(p.getPid()!=null) {
			model.addAttribute("raj", "Data Saved successfully");
		}
		return "index";
	}
	
}
