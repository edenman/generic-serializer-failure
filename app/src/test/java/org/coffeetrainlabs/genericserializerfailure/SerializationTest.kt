@file:OptIn(ExperimentalTime::class)

package org.coffeetrainlabs.genericserializerfailure

import com.google.common.truth.Truth.assertThat
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class SerializationTest {
    @Test
    fun roundTrip() {
        val json = Json { ignoreUnknownKeys = true }
        val persistedSerializer = Container.serializer(String.serializer())
        val container = Container(
            ownerId = 42L,
            snapshot = SealedInterface.Content(data = "stories", fetchedAt = Instant.fromEpochMilliseconds(1_000)),
        )
        val str = json.encodeToString(persistedSerializer, container)
        val roundTripped = json.decodeFromString(persistedSerializer, str)
        assertThat(roundTripped).isEqualTo(container)
    }
}
