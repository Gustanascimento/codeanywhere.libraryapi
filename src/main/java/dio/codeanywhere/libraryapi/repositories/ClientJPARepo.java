package dio.codeanywhere.libraryapi.repositories;

import dio.codeanywhere.libraryapi.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJPARepo extends JpaRepository<Client, Long> {
}
