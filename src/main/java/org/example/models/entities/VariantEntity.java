package org.example.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @ManyToMany
    @JsonIgnore
    private List<AnswerEntity> answers;
}
