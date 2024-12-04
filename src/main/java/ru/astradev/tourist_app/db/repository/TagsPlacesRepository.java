package ru.astradev.tourist_app.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.astradev.tourist_app.db.entity.Tags;
import ru.astradev.tourist_app.db.entity.TagsPlaces;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TagsPlacesRepository extends JpaRepository<TagsPlaces, Long> {

    @Modifying
    @Transactional
    @Query(value = "Insert into Tags_Places VALUES (nextval('tags_places_seq'), :place_id, :user_id)",
            nativeQuery = true)
    void add(
            @Param("place_id") Long place_id,
            @Param("user_id") Long user_id
    );

    @Query(value = "Select * from TagsPlaces tp JOIN Places p ON tp.place_id=p.id  WHERE p.name = :name", nativeQuery = true)
    List<TagsPlaces> getByPlace(@Param("name") String name);

}
