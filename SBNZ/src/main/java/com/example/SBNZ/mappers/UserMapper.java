package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.UserDTO;
import com.example.SBNZ.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements MapperInterface<User, UserDTO>{

    @Override
    public User toEntity(UserDTO dto) {
        if (dto.getId() == -1) {
            return new User(dto.getFirstName(), dto.getLastName(), dto.getUsername(), dto.getPassword(), true, dto.getAge());
        }
        return new User(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getUsername(), dto.getPassword(), true, dto.getAge());
    }

    @Override
    public UserDTO toDTO(User entity) {
        if (entity.getId() == -1) {
            return new UserDTO(entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getPassword(), entity.getAge());
        }
        return new UserDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getPassword(), entity.getAge());
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtos) {
        List<User> users = new ArrayList<>();
        for (UserDTO dto: dtos) {
            users.add(this.toEntity(dto));
        }
        return users;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> entities) {
        List<UserDTO> dtos = new ArrayList<>();
        for (User user: entities) {
            dtos.add(this.toDTO(user));
        }
        return dtos;
    }
}
