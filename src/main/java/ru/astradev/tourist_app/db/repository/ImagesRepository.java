package ru.astradev.tourist_app.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astradev.tourist_app.db.entity.Categories;
import ru.astradev.tourist_app.db.entity.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "Insert into Users_Roles VALUES (nextval('users_roles_seq'), :user_id, :role_id)",
//            nativeQuery = true)
//    void add(TagsRepository
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