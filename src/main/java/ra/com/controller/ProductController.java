package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.com.dto.request.ProductRequestCreateDTO;
import ra.com.model.Category;
import ra.com.model.Product;
import ra.com.service.CategoryService;
import ra.com.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public String findAllProduct(Model model) {
        List<Product> listProducts = productService.findAll();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }

    @GetMapping("/initCreate")
    public String initCreateProduct(Model model) {
        ProductRequestCreateDTO productDto = new ProductRequestCreateDTO();
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("productDto", productDto);
        model.addAttribute("listCategories", listCategories);
        return "newProduct";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute(name = "productDto") ProductRequestCreateDTO productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newProduct";
        }
        boolean result = productService.create(productDto);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdateProduct(Model model, String productId) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @PostMapping("/update")
    public String updateProduct(
            @ModelAttribute ProductRequestCreateDTO productDto,
            @RequestParam("catalogId") int catalogId) {

        // Lấy category từ catalogId
        Category catalog = categoryService.findById(catalogId);
        productDto.setCatalog(catalog);

        // Gọi service update
        boolean result = productService.update(productDto);
        return result ? "redirect:findAll" : "error";
    }

    @GetMapping("/delete")
    public String deleteProduct(String productId) {
        boolean result = productService.delete(productId);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }
}
