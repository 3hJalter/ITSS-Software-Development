package ecoBikeSystem.repository;

import ecoBikeSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findUserById(Long id);

    @Query("SELECT MAX(c.id) FROM Customer c")
    Long findMaxId();
}
