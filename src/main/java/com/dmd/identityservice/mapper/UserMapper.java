package com.dmd.identityservice.mapper;
import com.dmd.identityservice.dto.request.UserCreateReq;
import com.dmd.identityservice.dto.request.UserUpdateReq;
import com.dmd.identityservice.dto.response.UserResponse;
import com.dmd.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateReq req);
    void updateUser(@MappingTarget User user, UserUpdateReq req);
    @Mapping(source = "firstName", target = "lastName")
    @Mapping(target = "firstName", ignore = true)
    UserResponse toUserResponse(User user);
}
