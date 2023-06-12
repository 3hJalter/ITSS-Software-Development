package ecoBikeSystem.entity;

import ecoBikeSystem.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
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
        customerDto.setCreateTime(this.createTime);
        return customerDto;
    }
}
