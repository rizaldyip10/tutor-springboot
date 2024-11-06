package org.tutor.tutorspringboot.users.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String fullName;
    private String email;
}
