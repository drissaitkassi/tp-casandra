package aitkassi.dev.springbootcassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("products")
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private String description;
    private double price;
}
