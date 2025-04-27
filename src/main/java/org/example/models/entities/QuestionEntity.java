package org.example.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @SequenceGenerator(name = "questions_seq", sequenceName = "questions_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_seq")
    private Long id;

    private String type;

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<VariantEntity> variants = new ArrayList<>();

    @Column(name = "group_of")
    private String group;

    private LocalDateTime createTime;
}
