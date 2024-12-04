package ru.astradev.tourist_app.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_generator")
    @SequenceGenerator(name = "tags_generator", sequenceName = "tags_seq", allocationSize = 1)
    private Long id;

    private String name;

    public Tags(String name, String description) {
        this.name = name;
    }
}