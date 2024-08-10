package aitkassi.dev.springbootcassandra.mapper;

import aitkassi.dev.springbootcassandra.dto.ProductDTO;
import aitkassi.dev.springbootcassandra.entity.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<ProductDTO, Product> {
    @Override
    public Product apply(ProductDTO productDTO) {
        return new Product(productDTO.id(), productDTO.name(), productDTO.description(), productDTO.price());
    }
}
