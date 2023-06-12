package ecoBikeSystem.repository;

import ecoBikeSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findUserById(Long id);
}
