package com.techlab.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.techlab.dto.UserDto;
import com.techlab.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper extends IBaseMapper<Long, User, UserDto> {

    @Mapping(target = "password", ignore = true)
    @Override
    UserDto toDto(User entity);

    @Override
    User toEntity(UserDto dto);

    @Mapping(target = "password", ignore = true)
    @Override
    List<UserDto> toListDto(List<User> users);

    @Override
    @Mapping(target = "id", ignore = true)
    void updateEntity(UserDto dto, @MappingTarget User ent);
    
}
