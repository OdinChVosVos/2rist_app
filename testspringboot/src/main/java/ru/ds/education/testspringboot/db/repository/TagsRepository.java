package ru.ds.education.testspringboot.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ds.education.testspringboot.db.entity.Tags;
import ru.ds.education.testspringboot.db.entity.TagsPlaces;
import ru.ds.education.testspringboot.db.entity.Users;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

    @Modifying
    @Transactional
    @Query(value = "Insert into Tags VALUES (nextval('tags_seq'), :tag)",
            nativeQuery = true)
    void add(@Param("tag") String tag);


    @Query(value = "Select * from Tags WHERE name = :tag", nativeQuery = true)
    Tags getTagByName(@Param("tag") String tag);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Tags WHERE name = :name", nativeQuery = true)
    void remove(@Param("name") String name);

    @Query(value = "Select n from Tags n where n.name = :name")
    Tags getByName(@Param("name") String name);

    @Query(value = "Select * from Tags t JOIN TagsPlaces tp ON t.id=tp.tag_id JOIN Places p ON tp.place_id=p.id  WHERE p.name = :name", nativeQuery = true)
    List<Tags> getByPlace(@Param("name") String name);


}
