package pl.training.shop.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.training.shop.orders.Order;
import pl.training.shop.products.Product;
import pl.training.shop.products.ProductRepositoryCustom;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByLastNameContaining(String lastNameFragment, Pageable pageable);
}
