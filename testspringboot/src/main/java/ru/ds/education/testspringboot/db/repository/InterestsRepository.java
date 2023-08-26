package ru.ds.education.testspringboot.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ds.education.testspringboot.db.entity.Interests;
import ru.ds.education.testspringboot.db.entity.Places;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface InterestsRepository extends JpaRepository<Interests, Long> {

    @Modifying
    @Transactional
    @Query(value = "Insert into Interests VALUES (nextval('interests_seq'), :user_id, :tag_id, :coeff)",
            nativeQuery = true)
    void add(
            @Param("user_id") Long user_id,
            @Param("tag_id") Long tag_id,
            @Param("coeff") double coeff
    );


    @Query(value = "Select * from Interests i JOIN Users u ON i.user_id=u.id  WHERE u.mail = :mail", nativeQuery = true)
    List<Interests> getByUser(@Param("mail") String mail);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Interests i JOIN Users u ON i.user_id=u.id  WHERE u.mail = :mail", nativeQuery = true)
    void remove(@Param("mail") String mail);

}
