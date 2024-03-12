package com.meltshaketeam.meltshake.controller;

import com.meltshaketeam.meltshake.bean.cartBean;
import com.meltshaketeam.meltshake.bean.productBean;
//import com.meltshaketeam.meltshake.service.orderService;
import com.meltshaketeam.meltshake.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class productController {

    private final productService productService;
//    private final orderService orderService;

    @Autowired
    public productController(productService productService) {
        this.productService = productService;
//        this.orderService = orderService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to MELT MilkShakes";
    }

    @RequestMapping("/products")
    @ResponseBody
    public ResponseEntity<List<productBean>> displayProducts() {
        List<productBean> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    
    @RequestMapping("/products/{code}")
    @ResponseBody
    public ResponseEntity<productBean> getProductByProductCode(@PathVariable String code) {
    	productBean productbean = productService.getProductByProductcode(code);
    	return ResponseEntity.ok(productbean);
    }
    
	@RequestMapping("/cart")
	@ResponseBody
    public ResponseEntity<List<cartBean>> displayCart(Model model) {
        List<cartBean> cartbean = productService.getCart();
        if(cartbean == null) {
        	cartBean cartbean1 = new cartBean();
        	cartbean1.setProductcode("Empty Cart");
        	cartbean1.setQuantity(0);
        	cartbean.add(cartbean1);
        }
        return ResponseEntity.ok(cartbean);
    }
    
    @PostMapping("/cart/add/{productCode}")
    @ResponseBody
    public ResponseEntity<String> addToCart(@PathVariable String productCode) {
    	String res = productService.addItem(productCode);
    	return ResponseEntity.status(201).body(res);
    }
    
    @DeleteMapping("/cart/remove/{productCode}")
    @ResponseBody
    public ResponseEntity<String> removeFromCart(@PathVariable String productCode) {
    	String res = productService.removeItem(productCode);
    	if(res == "Removed") {
    		return ResponseEntity.status(200).body(res);
    	}else {
    		return ResponseEntity.status(204).body(res);
    	}
    }
    
    @DeleteMapping("/cart/clear")
    @ResponseBody
    public ResponseEntity<String> deleteAll(){
    	String str = productService.deleteAll();
    	return ResponseEntity.status(200).body(str);
    }
}