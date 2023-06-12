package ecoBikeSystem.validation;

import ecoBikeSystem.dto.CustomerDto;
import ecoBikeSystem.utils.ResponseMessage;
import ecoBikeSystem.utils.responseMessageImpl.CustomerResponseMessage;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidation extends GeneralValidation{
    public ResponseMessage validate (CustomerDto customerDto, Long id) {
        return CustomerResponseMessage.SUCCESSFUL;
    }

}
