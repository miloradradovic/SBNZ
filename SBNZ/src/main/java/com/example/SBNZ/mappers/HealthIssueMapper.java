package com.example.SBNZ.mappers;

import com.example.SBNZ.enums.diet.HealthIssue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HealthIssueMapper implements MapperInterface<HealthIssue, String> {

    @Override
    public HealthIssue toEntity(String dto) {
        return HealthIssue.valueOf(dto);
    }

    @Override
    public String toDTO(HealthIssue entity) {
        return entity.toString();
    }

    @Override
    public List<HealthIssue> toEntityList(List<String> dtos) {
        List<HealthIssue> healthIssues = new ArrayList<>();
        for (String dto: dtos) {
            healthIssues.add(this.toEntity(dto));
        }
        return healthIssues;
    }

    @Override
    public List<String> toDTOList(List<HealthIssue> entities) {
        List<String> dtos = new ArrayList<>();
        for (HealthIssue healthIssue: entities) {
            dtos.add(healthIssue.toString());
        }
        return dtos;
    }
}
