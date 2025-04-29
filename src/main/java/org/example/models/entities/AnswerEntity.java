package org.example.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @SequenceGenerator(name = "answers_seq", sequenceName = "answers_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_seq")
    private Long id;

    @OneToOne
    private QuestionEntity question;

    @ManyToOne
    private AnswererEntity answerer;

    @ManyToMany
    @JoinTable(
            name = "variants_answers",
            joinColumns = @JoinColumn(name = "variant_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<VariantEntity> answers = new HashSet<>();

    private String answer;

    private LocalDateTime createDate;
}
