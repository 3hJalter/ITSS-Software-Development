package ecoBikeSystem.dto;

import ecoBikeSystem.entity.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CustomerDto {
    private String username;
    private String email;
    private String phone;

    public void convertToEntity(Customer customer) {
        customer.setUsername(this.username);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
    }
}
