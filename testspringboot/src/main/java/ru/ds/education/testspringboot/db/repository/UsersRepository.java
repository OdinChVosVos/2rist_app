package ru.ds.education.testspringboot.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ds.education.testspringboot.db.entity.Users;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByMail(String mail);

    @Query(value = "Select n from Users n where n.mail = :mail")
    Users getByMail(@Param("mail") String mail);

    @Query(value = "Select n from Users n where n.login = :login")
    Users getByLogin(@Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "Insert into Users VALUES (nextval('users_seq'), :mail, :password, :phone, :firstname, :lastname, :login, :role);",
            nativeQuery = true)
    void add(
            @Param("mail") String mail,
            @Param("password") String password,
            @Param("phone") String phone,
            @Param("firstname") String firstname,
            @Param("lastname") String lastname,
            @Param("login") String login,
            @Param("role") String role
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Users WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);

}
