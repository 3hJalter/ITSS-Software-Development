package ecoBikeSystem.service.impl;

import ecoBikeSystem.dto.CustomerDto;
import ecoBikeSystem.entity.Customer;
import ecoBikeSystem.repository.CustomerRepository;
import ecoBikeSystem.service.ICustomerService;
import ecoBikeSystem.validation.CustomerValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ecoBikeSystem.utils.Response;
import ecoBikeSystem.utils.ResponseMessage;
import ecoBikeSystem.utils.responseMessageImpl.CustomerResponseMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplement implements ICustomerService {

    private static final ModelMapper modelMapper = new ModelMapper();
    private final CustomerRepository customerRepository;
    private final CustomerValidation userValidation;

    @Autowired
    public CustomerServiceImplement(CustomerRepository customerRepository, CustomerValidation userValidation) {
        super();
        this.customerRepository = customerRepository;
        this.userValidation = userValidation;
    }

    @Override
    public Response<List<CustomerDto>> getAllUsers() {
        List<CustomerDto> customerDtoList = customerRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, CustomerDto.class))
                .collect(Collectors.toList());
        return new Response<>(customerDtoList, CustomerResponseMessage.SUCCESSFUL);
    }

    @Override
    public Response<CustomerDto> findUserById(Long id) {
        if (customerRepository.existsById(id)) {
            CustomerDto customerDto = modelMapper.map(customerRepository.findUserById(id), CustomerDto.class);
            return new Response<>(customerDto, CustomerResponseMessage.SUCCESSFUL);
        }
        return new Response<>(CustomerResponseMessage.USER_DOES_NOT_EXIST);
    }

    @Override
    public Response<Customer> createUser(CustomerDto customerDto) {
        ResponseMessage responseMessage = userValidation.validate(customerDto, null);
        if (responseMessage == CustomerResponseMessage.SUCCESSFUL) {
            Long lastId = customerRepository.findMaxId();
            Long newId = (lastId != null) ? lastId + 1 : 1;
            Customer customer = new Customer(newId);
            customerDto.convertToEntity(customer);
            try {
                customerRepository.save(customer);
            }
            catch (Exception e) {
                return new Response<>(e);
            }
            return new Response<>(customer, responseMessage);
        }
        return new Response<>(responseMessage);
    }

    @Override
    public Response<Customer> updateUserById(Long id, CustomerDto customerDto) {
        if (!customerRepository.existsById(id)) {
            return new Response<>(CustomerResponseMessage.USER_DOES_NOT_EXIST);
        }
        ResponseMessage responseMessage = userValidation.validate(customerDto, id);
        if (responseMessage == CustomerResponseMessage.SUCCESSFUL) {
            Customer customer = customerRepository.findUserById(id);
            customerDto.convertToEntity(customer);
            customerRepository.save(customer);
            return new Response<>(customer, responseMessage);
        }
        return new Response<>(responseMessage);
    }

    @Override
    public Response<CustomerDto> deleteUserById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return new Response<>(CustomerResponseMessage.SUCCESSFUL);
        }
        return new Response<>(CustomerResponseMessage.USER_DOES_NOT_EXIST);
    }
}