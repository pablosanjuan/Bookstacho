package com.bookstacho.domain.base

abstract class NoParamsUseCase<out T : Any>() : UseCase<T, Nothing?>() {

    abstract fun run(): Either<Failure, T>
    override fun run(params: Nothing?): Either<Failure, T> = run()

}