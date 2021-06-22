package com.bookstacho.domain.base

import com.bookstacho.domain.base.Failure.FeatureFailure

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure(val error: Exception?, var param: String = "") {
    class NetworkConnection(error: Exception? = null) : Failure(error)
    class ServerError(error: Exception? = null) : Failure(error)
    class AuthError(error: Exception? = null) : Failure(error)

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure(error: Exception?) : Failure(error)
}