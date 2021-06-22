package com.bookstacho.data.dto

import com.bookstacho.domain.entities.User

data class UserDto(val id : String, val name : String) {

    fun toEntity(): User {
        return User(id, name)
    }
}