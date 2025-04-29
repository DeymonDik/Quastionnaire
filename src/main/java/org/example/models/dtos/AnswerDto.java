package org.example.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.entities.VariantEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    private Long id;
    private Long questionId;
    private Long answererId;
    private List<VariantEntity> answers;
    private String answer;
    private LocalDateTime createTime;
}
