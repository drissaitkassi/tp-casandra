package aitkassi.dev.springbootcassandra.service;

import aitkassi.dev.springbootcassandra.dto.ProductDTO;
import aitkassi.dev.springbootcassandra.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(UUID id) throws ProductNotFoundException;
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(UUID id, ProductDTO productDTO) throws ProductNotFoundException;
    void deleteProduct(UUID id);
}
