package br.com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibm.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
