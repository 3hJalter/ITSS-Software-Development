package ecoBikeSystem.entity;

import ecoBikeSystem.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"phone", "email"})})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "phone")
    private String phone;

    public Customer(Long id) {
        this.id = id;
        this.createTime = Timestamp.valueOf(LocalDateTime.now());
    }

    public Customer(String username, String email, String phone) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.createTime = Timestamp.valueOf(LocalDateTime.now());
    }

    public CustomerDto convertToDto(CustomerDto customerDto) {
        customerDto.setUsername(this.username);
        customerDto.setEmail(this.email);
        customerDto.setPhone(this.phone);
        return customerDto;
    }
}
