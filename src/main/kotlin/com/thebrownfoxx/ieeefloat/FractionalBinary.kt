package com.thebrownfoxx.ieeefloat

data class FractionalBinary(
    val integralPartBits: List<Bit>,
    val fractionalPartBits: List<Bit>,
) {
    override fun toString() = "FractionalBinary(${toUnlabeledString()})"

    fun toUnlabeledString() = "${integralPartBits.joinToString(separator = "") { bit -> bit.toUnlabeledString() }}." +
            fractionalPartBits.joinToString(separator = "") { bit -> bit.toUnlabeledString() }
}

fun FractionalBinary(string: String): FractionalBinary {
    val (integralPartString, fractionalPartString) = string.split('.', limit = 2)
    val integralPartBits = integralPartString.map { char -> Bit(char) }
    val fractionalPartBits = fractionalPartString.map { char -> Bit(char) }
    return FractionalBinary(integralPartBits, fractionalPartBits)
}

fun Double.toFractionalBinary(maxDecimalPlaces: Int = 64): FractionalBinary {
    val integralPart = toInt()

    var remainingFractionalPart = this - integralPart
    val fractionalPartBits = mutableListOf<Bit>()

    while (remainingFractionalPart != 0.0 && fractionalPartBits.size < maxDecimalPlaces) {
        val newFraction = remainingFractionalPart * 2
        val newIntegralPart = newFraction.toInt()
        fractionalPartBits.add(Bit(newIntegralPart))
        remainingFractionalPart = newFraction - newIntegralPart
    }

    val integralPartBits = integralPart.toIntBinary().bits

    if (fractionalPartBits.isEmpty()) fractionalPartBits.add(Bit.Zero)

    return FractionalBinary(integralPartBits, fractionalPartBits)
}

fun Float.toFractionalBinary(maxDecimalPlaces: Int = 64) = toDouble().toFractionalBinary(maxDecimalPlaces)