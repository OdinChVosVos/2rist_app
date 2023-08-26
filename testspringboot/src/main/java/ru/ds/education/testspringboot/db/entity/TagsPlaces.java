package ru.ds.education.testspringboot.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TagsPlaces")
public class TagsPlaces {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_places_generator")
    @SequenceGenerator(name = "tags_places_generator", sequenceName = "tags_places_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Places place;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tags tag;

    private String name;

}
