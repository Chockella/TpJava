package com.tact.eshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tact.eshop.entity.Customer;
import com.tact.eshop.repository.CustomerRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/user/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository cRepo;
	
	@RequestMapping("profil")
	public String profil() {		
		return "/user/profil";
	}
	
	@RequestMapping("connexion")
	public String connexion(HttpSession session) {
		String returnString;
		if(session.getAttribute("account") != null) {
			returnString = "redirect:/";
		}
		else {
			returnString = "/user/connexion";
		}
		return returnString;
		
	}
	
	@RequestMapping("deconnexion")
	public String deconnexion(HttpSession session) {
		if(session.getAttribute("account") != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@PostMapping("authentification")
	public String authentification(Customer customer, HttpSession session, Model model) {
		List<Customer> customerList = cRepo.findByLastName(customer.getLastName());
		ArrayList<Customer> customerFocused = new ArrayList<Customer>();
		
		for(Customer customerInList : customerList) {
			if(customerInList.getFirstName().equals(customer.getFirstName())) {
				customerFocused.add(customerInList);
			}
		}
		
		if(!customerFocused.isEmpty()) {
			session.setAttribute("account", customerFocused.get(0));
			return "redirect:/";
		}
		else{
			model.addAttribute("error", "Personne inconnue");
			return "/user/connexion";
		}
	}
	
	@PostMapping("modification")
	public String modification(Customer customer, HttpSession session) {
		Customer newCustomer = (Customer) session.getAttribute("account");
		
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setAddress(customer.getAddress());
		newCustomer.setCity(customer.getCity());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setZip(customer.getZip());
		
		cRepo.save(newCustomer);
		session.setAttribute("account", newCustomer);
		
		return "/user/profil";
	}

}
