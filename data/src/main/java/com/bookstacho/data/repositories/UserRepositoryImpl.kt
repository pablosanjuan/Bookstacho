package com.bookstacho.data.repositories

import com.bookstacho.data.dto.UserDto
import com.bookstacho.domain.base.Either
import com.bookstacho.domain.base.Failure
import com.bookstacho.domain.entities.User
import com.bookstacho.domain.repositories.UserRepository
import kotlin.random.Random

class UserRepositoryImpl : UserRepository {

    override fun getUser(): Either<Failure, User> {
        return try {
            Thread.sleep(1000)
            val user = getActiveUser()
            if (user != null) {
                Either.Right(user.toEntity())
            } else {
                Either.Left(Failure.AuthError())
            }
        } catch(exception : Exception){
            Either.Left(Failure.ServerError(exception))
        }
    }

    private fun getActiveUser() : UserDto? {
        val exists = Random.nextBoolean()
        return if (exists) {
            UserDto("1", "Gabo")
        } else null
    }

}