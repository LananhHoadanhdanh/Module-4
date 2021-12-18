package product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
