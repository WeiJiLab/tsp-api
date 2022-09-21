package com.thoughtworks.ssr.infrastructure.persistence.user.converter;

import com.thoughtworks.ssr.domain.user.model.User;
import com.thoughtworks.ssr.infrastructure.persistence.common.IEntityConverter;
import com.thoughtworks.ssr.infrastructure.persistence.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityConverter extends IEntityConverter<User, UserEntity> {
}
