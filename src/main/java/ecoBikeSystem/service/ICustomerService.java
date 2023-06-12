package ecoBikeSystem.service;

import ecoBikeSystem.dto.CustomerDto;
import ecoBikeSystem.entity.Customer;
import ecoBikeSystem.utils.Response;

import java.util.List;


public interface ICustomerService {
    Response<List<CustomerDto>> getAllUsers();
    Response<CustomerDto> findUserById(Long id);
    Response<Customer> createUser(CustomerDto customerDto);
    Response<Customer> updateUserById(Long id, CustomerDto customerDto);
    Response<CustomerDto> deleteUserById(Long id);

}
