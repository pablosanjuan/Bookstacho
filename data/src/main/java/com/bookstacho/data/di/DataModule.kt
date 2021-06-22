package com.bookstacho.data.di

import com.bookstacho.data.repositories.UserRepositoryImpl
import com.bookstacho.domain.repositories.UserRepository
import com.bookstacho.domain.usecases.UserUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

  @Provides
  @Singleton
  internal fun provideUserRepository() : UserRepository = UserRepositoryImpl()

  @Provides
  @Singleton
  internal fun provideUserUseCase(userRepository: UserRepository) : UserUseCase = UserUseCase(userRepository)

}