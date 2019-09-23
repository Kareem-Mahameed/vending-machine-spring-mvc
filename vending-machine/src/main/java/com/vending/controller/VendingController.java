package com.vending.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vending.service.VendingService;
/**
 * Vending machine  
 * @version 1.0
 * 
 */

@Controller
public class VendingController {
    private VendingService vendingService;
    
    @Inject
    public VendingController(VendingService vendingService) {
        this.vendingService = vendingService;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {
    	
    		model.addAttribute("items", vendingService.getItems());
    		model.addAttribute("balance", vendingService.getBalance());
        model.addAttribute("selectedItem", vendingService.getSelectedItem());
        model.addAttribute("returnedCoins", vendingService.getReturnedCoins());    
        model.addAttribute("alert", vendingService.getAlert());
        return "index";
    }
    
    @RequestMapping(value="/addCoin/{coin}", method=RequestMethod.GET)
    public String addCoin(@PathVariable String coin) {
        vendingService.addCoin(coin);
        return "redirect:/";
    }
    
    @RequestMapping(value="/purchaseItem", method=RequestMethod.GET)
    public String purchaseItem() {
        vendingService.purchaseItem();
        return "redirect:/";
    }
    
    @RequestMapping(value="/coinsReturn", method=RequestMethod.GET)
    public String coinsReturn() {
        vendingService.coinsReturn();
        return "redirect:/";
    }
    
    @RequestMapping(value="/makeSelection/{id}", method=RequestMethod.GET)
    public String makeSelection(@PathVariable("id") int id) {
        vendingService.setSelectedItem(id);
        return "redirect:/";
    }
}
