package org.example.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "variants")
@NoArgsConstructor
@AllArgsConstructor
public class VariantEntity {

    @Id
    @SequenceGenerator(name = "variants_seq", sequenceName = "variants_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variants_seq")
    private Long id;

    private String text;

    private Boolean isTrue;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @JsonIgnore
    @ManyToMany(mappedBy = "answers")
    private Set<AnswerEntity> answers = new HashSet<>();
}
