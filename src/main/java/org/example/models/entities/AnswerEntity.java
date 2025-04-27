package org.example.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @SequenceGenerator(name = "answers_seq", sequenceName = "answers_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_seq")
    private Long id;

    @OneToOne
    private QuestionEntity question;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "variant_answer",
            joinColumns = @JoinColumn(name = "variant_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private List<VariantEntity> answers = new ArrayList<>();

    private String answer;

    private LocalDateTime createDate;
}
