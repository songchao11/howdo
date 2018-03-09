package com.song.howdo.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
	int addUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
