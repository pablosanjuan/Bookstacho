package com.bookstacho.domain.base

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract fun run(params: Params): Either<Failure, Type>
}
