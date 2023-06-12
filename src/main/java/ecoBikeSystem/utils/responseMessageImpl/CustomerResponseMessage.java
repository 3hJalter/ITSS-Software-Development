package ecoBikeSystem.utils.responseMessageImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ecoBikeSystem.utils.ResponseMessage;

@Getter
@AllArgsConstructor
public enum CustomerResponseMessage implements ResponseMessage {

    USER_DOES_NOT_EXIST("400_D0", "User does not exist"),
    USER_CODE_IS_NULL("400_D1", "User code is null"),
    USER_CODE_IS_DUPLICATED("400_D2", "User code is duplicated with other"),
    USER_CODE_HAS_WHITESPACE("400_D3", "User code must not have whitespace"),
    USER_NAME_IS_NULL("400_D4", "User name must not be null"),
    SUCCESSFUL("200_D0", "Successful");
    
    private final String code;
    private final String message;
}
