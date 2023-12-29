package bankdemo.bankdemosp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BankExceptionAdvisor {

    @ResponseBody
    @ExceptionHandler(BankException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String,String> ExceptionHandler(BankException s)
    {
        Map<String,String> errormap = new HashMap<>();
        errormap.put("errormessage",s.getMessage());
        return errormap;
    }
}
