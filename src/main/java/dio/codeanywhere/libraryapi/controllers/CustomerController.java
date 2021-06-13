package dio.codeanywhere.libraryapi.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dio.codeanywhere.libraryapi.entities.Book;
import dio.codeanywhere.libraryapi.entities.Client;
import dio.codeanywhere.libraryapi.exceptions.clientNotFound;
import dio.codeanywhere.libraryapi.exceptions.missingMandatoryField;
import dio.codeanywhere.libraryapi.repositories.ClientJPARepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Client saveClient(@RequestBody Client client) throws missingMandatoryField {
        return repository.save(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateById(@PathVariable Long id, @RequestBody Client client) throws clientNotFound {

        AtomicInteger modifications = new AtomicInteger();

        repository.findById(id)
                  .map(record -> {
                    if (client.getName() != null) {
                        record.setName(client.getName());
                        modifications.getAndIncrement();
                    }
                    if (client.getAge() != null) {
                        record.setAge(client.getAge());
                        modifications.getAndIncrement();
                    }
                    if (client.getAddress() != null) {
                        record.setAddress(client.getAddress());
                        modifications.getAndIncrement();
                    }
                    if (client.getPhone() != null) {
                        record.setPhone(client.getPhone());
                        modifications.getAndIncrement();
                    }

                    if (!client.getBook().toString().equals("[]")) {
                        record.setBook(client.getBook());
                        modifications.getAndIncrement();
                    }

                    Client updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                  })
                  .orElseThrow(() -> new clientNotFound(id));

        return ("Updated client with ID: " + id + ", with a total of " + modifications + " modification(s).");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteClientById(@PathVariable Long id) throws clientNotFound {
        repository.findById(id)
                .orElseThrow(() -> new clientNotFound(id));
        repository.deleteById(id);

        return ("Removed client with Id: " + id);
    }

}
