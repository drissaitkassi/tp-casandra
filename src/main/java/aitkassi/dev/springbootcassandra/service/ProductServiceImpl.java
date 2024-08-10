package aitkassi.dev.springbootcassandra.service;


import aitkassi.dev.springbootcassandra.dto.ProductDTO;
import aitkassi.dev.springbootcassandra.entity.Product;
import aitkassi.dev.springbootcassandra.exception.ProductNotFoundException;
import aitkassi.dev.springbootcassandra.mapper.ProductDTOMapper;
import aitkassi.dev.springbootcassandra.repository.ProductRepository;
import aitkassi.dev.springbootcassandra.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductDTOMapper productDTOMapper;
    private final ProductMapper productMapper;
    public ProductServiceImpl(ProductRepository productRepository, ProductDTOMapper productDTOMapper, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productDTOMapper = productDTOMapper;
        this.productMapper = productMapper;

    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productDTOMapper)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(UUID id){
        Product product = productRepository.findById(id).orElse(null);
        ProductDTO productDTO = null;
        if(product != null)
            productDTO = productDTOMapper.apply(product);

        return  productDTO;
    }
    public ProductDTO saveProduct(ProductDTO productDTO){
        Product product = productMapper.apply(productDTO);
        productRepository.insert(product);
        return productDTOMapper.apply(product);
    }

    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElse(null);


        if (product == null)
            throw new ProductNotFoundException("Product not found");

        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());

        productRepository.save(product);

        return productDTO;
    }

    @Override
    public void deleteProduct(UUID id){
        productRepository.deleteById(id);
    }
}
