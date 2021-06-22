package com.bookstacho.domain.usecases

import com.bookstacho.domain.base.Either
import com.bookstacho.domain.base.Failure
import com.bookstacho.domain.base.NoParamsUseCase
import com.bookstacho.domain.entities.User
import com.bookstacho.domain.repositories.UserRepository

class UserUseCase(
    private val userRepository: UserRepository
) : NoParamsUseCase<User>() {
    override fun run(): Either<Failure, User> {
        return userRepository.getUser()
    }
}