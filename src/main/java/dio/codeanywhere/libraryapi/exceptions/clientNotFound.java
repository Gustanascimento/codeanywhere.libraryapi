package dio.codeanywhere.libraryapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class clientNotFound extends Exception {

    public clientNotFound(Long id) {
        super(String.format("Client with ID %s was not found!", id));
    }
}

