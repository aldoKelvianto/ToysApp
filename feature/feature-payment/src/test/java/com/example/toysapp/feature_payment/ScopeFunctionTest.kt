package com.example.toysapp.feature_payment

import org.junit.Assert.assertEquals
import org.junit.Test

class ScopeFunctionTest {

    @Test
    fun `apply vs with`() {
        val list: MutableList<Int> = mutableListOf<Int>().apply {
            add(1)
            add(2)
            add(3)
        }
        assertEquals(3, list.size)
        val number: Int = with(mutableListOf<Int>()) {
            add(1)
            add(2)
            get(0)
        }
        assertEquals(1, number)
    }
}
