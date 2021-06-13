package dio.codeanywhere.libraryapi.controllers;

import java.util.List;

import dio.codeanywhere.libraryapi.entities.Client;
import dio.codeanywhere.libraryapi.exceptions.clientNotFound;
import dio.codeanywhere.libraryapi.repositories.ClientJPARepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;




@RestController
@AllArgsConstructor
public class CustomerController {

    ClientJPARepo repository;

    @GetMapping
    public List<Client> getAllClients() {
    return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@PathVariable Long id) throws clientNotFound {
        return repository.findById(id)
                .orElseThrow(() -> new clientNotFound(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client) {
        return  repository.save(client);
    }

    /*
    @PutMapping
    public Client updateById(@PathVariable Long id) throws clientNotFound{
        repository.findById(id)
                .orElseThrow(() -> new clientNotFound(id));

        repository.deleteById(id);
    }
    */


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteClientById(@PathVariable Long id) throws clientNotFound {
        repository.findById(id)
                .orElseThrow(() -> new clientNotFound(id));
        repository.deleteById(id);

        return ("Client's Id Removed:" + id);
    }

}
