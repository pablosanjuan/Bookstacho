package com.bookstacho.domain.repositories

import com.bookstacho.domain.base.Either
import com.bookstacho.domain.base.Failure
import com.bookstacho.domain.entities.User

interface UserRepository {
    fun getUser(): Either<Failure, User>
}