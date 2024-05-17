package ra.btss18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.btss18.dto.ProductDTO;
import ra.btss18.entity.Category;
import ra.btss18.entity.Product;
import ra.btss18.service.ICategoryService;
import ra.btss18.service.IProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/Product"})
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public String productHome(Model model){
        List<Product> categories = productService.getProduct();
        model.addAttribute("product",categories);
        return "/productHome";
    }
    @GetMapping("/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getCategory());
        return "createProduct";
    }

    @PostMapping("/saveProduct")
    public String actionCreateProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("product", productDTO);
            model.addAttribute("categories", categoryService.getCategory());
            return "/createProduct";
        }
        Product product = Product.builder()
                .proId(productDTO.getProId())
                .proName(productDTO.getProName())
                .price(productDTO.getPrice())
                .stock(productDTO.getStock())
                .proStatus(productDTO.getProStatus())
                .cat(categoryService.getCategoryById(productDTO.getCatId()))
                .build();
        productService.insertProduct(product);
        return "redirect:/Product";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return "redirect:/Product";
    }
    @GetMapping("//editProduct/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "/editProduct";
    }
    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/";
    }
    @GetMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "/viewProduct";
    }
}
