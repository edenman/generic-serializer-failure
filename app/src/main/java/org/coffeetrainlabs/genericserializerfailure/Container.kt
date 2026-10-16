@file:OptIn(ExperimentalTime::class)

package org.coffeetrainlabs.genericserializerfailure

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Serializable
data class Container<out T>(
    val ownerId: Long?,
    val snapshot: SealedInterface<T>,
)

@Serializable
sealed interface SealedInterface<out T> {
    @Serializable
    @SerialName("loading")
    data object Loading : SealedInterface<Nothing>

    @Serializable
    @SerialName("signed_out")
    data object SignedOut : SealedInterface<Nothing>

    @Serializable
    @SerialName("content")
    data class Content<out T>(
        val data: T,
        val fetchedAt: Instant,
    ) : SealedInterface<T>

    @Serializable
    @SerialName("failed")
    data class Failed<out T>(
        val previous: Content<T>?,
    ) : SealedInterface<T>
}
