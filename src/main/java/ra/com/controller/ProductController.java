package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.model.Product;
import ra.com.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public String findAllProduct(Model model) {
        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "product";
    }

    @GetMapping("/initCreate")
    public String initCreateProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        boolean result = productService.create(product);
        if(result) {
            return "redirect:findAll";
        }else{
            return "error";
        }
    }
    @GetMapping("/initUpdate")
    public String initUpdateProduct(Model model, String productId) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        boolean result = productService.update(product);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteCProduct(String productId) {
        boolean result = productService.delete(productId);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }
}
