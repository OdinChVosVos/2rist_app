package ru.astradev.tourist_app.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Places")
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "places_generator")
    @SequenceGenerator(name = "places_generator", sequenceName = "places_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Categories category;

    private String name;
    private String url;
    private String adress;
    private String time_work;
    private String position;

     public Places(Categories category, String name, String url, String adress, String time_work, String position) {
        this.category = category;
        this.name = name;
        this.url = url;
        this.adress = adress;
        this.time_work = time_work;
        this.position = position;
    }
}
