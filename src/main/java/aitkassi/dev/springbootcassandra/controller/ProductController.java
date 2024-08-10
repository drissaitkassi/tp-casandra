package aitkassi.dev.springbootcassandra.controller;

import aitkassi.dev.springbootcassandra.dto.ProductDTO;
import aitkassi.dev.springbootcassandra.mapper.ProductDTOMapper;
import aitkassi.dev.springbootcassandra.exception.ProductNotFoundException;
import aitkassi.dev.springbootcassandra.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService, ProductDTOMapper productDTOMapper) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping(path = "/{id}")
    public ProductDTO getPaymentsById(@PathVariable UUID id){
        return productService.getProductById(id);
    }
    @PostMapping("/save")
    public ProductDTO saveProduct(ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @PostMapping("/{id}/update")
    public ProductDTO updateProduct(@PathVariable UUID id, ProductDTO productDTO) throws ProductNotFoundException {
        return productService.updateProduct(id, productDTO);
    }

    @PostMapping("/{id}/delete")
    public void deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
    }
}
