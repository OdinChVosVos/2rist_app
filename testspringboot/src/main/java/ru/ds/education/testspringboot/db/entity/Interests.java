package ru.ds.education.testspringboot.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Interests")
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interests_generator")
    @SequenceGenerator(name = "interests_generator", sequenceName = "interests_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tags tag;

    private float coeff;

    public Interests(Users user, Tags tag, float coeff) {
        this.user = user;
        this.tag = tag;
        this.coeff = coeff;
    }

}