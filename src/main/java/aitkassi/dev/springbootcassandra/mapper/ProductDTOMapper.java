package aitkassi.dev.springbootcassandra.mapper;

import aitkassi.dev.springbootcassandra.dto.ProductDTO;
import aitkassi.dev.springbootcassandra.entity.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDTOMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
