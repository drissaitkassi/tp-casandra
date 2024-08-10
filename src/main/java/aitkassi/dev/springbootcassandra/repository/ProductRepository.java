package aitkassi.dev.springbootcassandra.repository;

import aitkassi.dev.springbootcassandra.entity.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
