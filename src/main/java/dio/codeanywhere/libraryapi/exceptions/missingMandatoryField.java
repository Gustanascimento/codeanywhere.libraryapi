package dio.codeanywhere.libraryapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LENGTH_REQUIRED)
public class missingMandatoryField extends Exception {

    public missingMandatoryField(String field) {
        super("The Following field is mandatory: '"+ field +"'!");
    }
}