package com.thebrownfoxx.ieeefloat

data class IntBinary(val bits: List<Bit>) {
    constructor(string: String): this(string.map { char -> Bit(char) })

    override fun toString() = "IntBinary(${toUnlabeledString()})"

    fun toUnlabeledString() = bits.joinToString(separator = "") { bit -> bit.toUnlabeledString() }
}

fun Int.toIntBinary(): IntBinary {
    var quotient = this
    val reversedBinary = mutableListOf<Bit>()
    while (quotient != 0) {
        val bit = if (quotient % 2 == 0) Bit.Zero else Bit.One
        reversedBinary.add(bit)
        quotient /= 2
    }
    if (reversedBinary.isEmpty()) reversedBinary.add(Bit.Zero)
    return IntBinary(reversedBinary.reversed())
}