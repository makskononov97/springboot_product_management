package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.controller;

import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.entity.Product;
import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.service.ProductService;
import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.validation.OnCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {

        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProds", allProducts);

        return "allproducts";
    }

    @GetMapping("/productsIncorrectSearch")
    public String getAllProductsIncorrectSearch(Model model) {

        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProds", allProducts);

        return "allproductsIncorrectSearch";
    }

    @GetMapping("/addNewProduct")
    public String addNewProduct(Model model){

        Product product = new Product();
        model.addAttribute("product", product);

        return "create-product-info";
    }

    @RequestMapping("/createProduct")
    public String createProduct(@Validated(OnCreate.class) @ModelAttribute("product") Product product
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "create-product-info";
        } else {
            productService.createProduct(product);
            return "redirect:products";
        }
    }

    @RequestMapping("/saveChangesProduct")
    public String saveChangesProduct(@Valid @ModelAttribute("product") Product product
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "update-product-info";
        } else {
            productService.saveChangesProduct(product);
            return "redirect:products";
        }
    }

    @RequestMapping("/updateInfo")
    public String updateProduct(@RequestParam("banId") int id, Model model){

        Product product = productService.getProduct(id);
        model.addAttribute("product", product);

        return "update-product-info";
    }
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("banId") int id){

        productService.deleteProduct(id);

        return "redirect:products";

    }

    @RequestMapping("/searchProduct")
    public Object searchProduct(@RequestParam String searchName) {
        if (searchName.contains("awesome")) {
        return "redirect:productsIncorrectSearch"; }
        List<Product> searchRes = productService.searchProduct(searchName);
        ModelAndView mav = new ModelAndView("resAndAllProducts");
        mav.addObject("searchRes", searchRes);

        return mav;
    }

}

