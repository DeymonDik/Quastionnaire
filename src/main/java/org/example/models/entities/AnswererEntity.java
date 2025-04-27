package org.example.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "answerers")
public class AnswererEntity {

    @Id
    @SequenceGenerator(name = "answerers_seq", sequenceName = "answerers_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answerers_seq")
    private Long id;

    private String name;

    @Column(name = "group_of")
    private String group;

    private Short age;

    private String additional;

    private LocalDateTime createDate;
}
