package ecoBikeSystem.controller;

import ecoBikeSystem.dto.CustomerDto;
import ecoBikeSystem.entity.Customer;
import ecoBikeSystem.service.ICustomerService;
import ecoBikeSystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService userService;

    @Autowired
    public CustomerController(ICustomerService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Response<List<CustomerDto>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Response<CustomerDto> findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/")
    public Response<Customer> createUser(@RequestBody CustomerDto customerDto) {
        return userService.createUser(customerDto);
    }

    @PutMapping("/{id}")
    public Response<Customer> updateUserById(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        return userService.updateUserById(id, customerDto);
    }

    @DeleteMapping("/{id}")
    public Response<CustomerDto> deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
