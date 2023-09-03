package com.thebrownfoxx.ieeefloat

data class Bit(val value: Boolean) {
    companion object {
        val Zero = Bit(false)
        val One = Bit(true)
    }

    constructor(char: Char): this(
        if (char !in listOf('0', '1')) throw IllegalArgumentException("A bit can only be either 0 or 1.")
        else char == '1'
    )

    constructor(int: Int): this(
        if (int !in listOf(0, 1)) throw IllegalArgumentException("A bit can only be either 0 or 1.")
        else int == 1
    )

    override fun toString() = "Bit(${toUnlabeledString()})"

    fun toUnlabeledString() = if (value) "1" else "0"
}