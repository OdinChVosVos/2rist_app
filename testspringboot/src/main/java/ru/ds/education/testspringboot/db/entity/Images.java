package ru.ds.education.testspringboot.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_generator")
    @SequenceGenerator(name = "images_generator", sequenceName = "images_seq", allocationSize = 1)
    private Long id;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Places place;

    public Images(String image, Places place) {
        this.image = image;
        this.place = place;
    }
}
