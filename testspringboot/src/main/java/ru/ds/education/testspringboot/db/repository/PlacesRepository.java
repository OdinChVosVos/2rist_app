package ru.ds.education.testspringboot.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ds.education.testspringboot.db.entity.Places;

@Repository
public interface PlacesRepository extends JpaRepository<Places, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "Insert into Users_Roles VALUES (nextval('users_roles_seq'), :user_id, :role_id)",
//            nativeQuery = true)
//    void add(
//            @Param("user_id") Long user_id,
//            @Param("role_id") Long role_id
//    );
//
//    @Query(value = "Select * from Roles", nativeQuery = true)
//    List<Roles> getAll();
//
//    @Query(value = "Select * from Roles where name = :name", nativeQuery = true)
//    Roles getByName(@Param("name") String name);

}
