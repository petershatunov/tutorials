package com.baeldung.sequeces

import org.junit.Test
import kotlin.test.assertEquals
import java.time.Instant

class SequencesTest {

    @Test
    fun `from elements`() {
        val seqOfElements = sequenceOf("first" ,"second", "third")
                .toList()
        assertEquals(3, seqOfElements.count())
    }

    @Test
    fun `from function`() {
        val seqFromFunction = generateSequence(Instant.now()) {it.plusSeconds(1)}
                .take(3)
                .toList()
        assertEquals(3, seqFromFunction.count())
    }

    @Test
    fun `from chunks`() {
        val seqFromChunks = sequence {
            yield(1)
            yieldAll((2..5).toList())
        }.toList()
        assertEquals(5, seqFromChunks.count())
    }

    @Test
    fun `from collection`() {
        val seqFromIterable = (1..10)
                .asSequence()
                .toList()
        assertEquals(10, seqFromIterable.count())
    }

    @Test
    fun `with and without sequence`() {
        val withSequence = (1..10).asSequence()
                .filter{it % 2 == 1}
                .map { it * 2 }
                .toList()
        val withoutSequence = (1..10)
                .filter{it % 2 == 1}
                .map { it * 2 }
                .toList()
        assertEquals(withSequence.count(), withoutSequence.count())
    }

}