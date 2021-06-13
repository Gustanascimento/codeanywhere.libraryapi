package dio.codeanywhere.libraryapi.controllers;

import java.util.List;
import dio.codeanywhere.libraryapi.entities.Client;
import dio.codeanywhere.libraryapi.repositories.ClientJPARepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class CustomerController {

    ClientJPARepo repository;

    @GetMapping
    public List<Client> getAllClients(){
    return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client){
        return  repository.save(client);
    }

    //@PutMapping

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable Long id){
        repository.deleteById(id);
    }

}
