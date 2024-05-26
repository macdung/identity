package com.dmd.identityservice.dto.request;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateReq {
    @Size(min = 3, message = "username not be at least 3 character")
    String username;
    @Size(min = 8, message = "password not be at least 8 character")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
