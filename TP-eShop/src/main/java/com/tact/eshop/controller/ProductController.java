package com.tact.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tact.eshop.entity.Product;
import com.tact.eshop.repository.ProductRepository;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @RequestMapping("index")
    public String index(Model model) {

        List<Product> products = (List<Product>) productRepo.findAll();
        model.addAttribute("products", products);

        return "product/index";
    }

    @RequestMapping("{id}")
    public String show(@PathVariable String id, Model model) {
    	String returnString;
        Product product = productRepo.findOne(Long.valueOf(id));
        
        if(product.getEndOfLife() == false) {
            model.addAttribute("product", product);
            returnString = "product/show";
        }
        else {
        	returnString = "redirect:/product/index";
        }
        return returnString;
    }

}
