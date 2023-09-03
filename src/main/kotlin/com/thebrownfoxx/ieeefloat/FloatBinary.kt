package com.thebrownfoxx.ieeefloat

enum class FloatBinaryPrecision {
    Single,
    Double,
}

data class FloatBinary(val bits: List<Bit>) {
    val precision = when (bits.size) {
        32 -> FloatBinaryPrecision.Single
        64 -> FloatBinaryPrecision.Double
        else -> throw IllegalStateException("FloatBinary of unrecognized length.")
    }

    constructor(string: String): this(string.map { char -> Bit(char) })

    override fun toString() = "FloatBinary(${toUnlabeledString()}, precision = $precision)"

    fun toUnlabeledString() = bits.joinToString(separator = "") { bit -> bit.toUnlabeledString() }
}

fun Double.toFloatBinary(precision: FloatBinaryPrecision = FloatBinaryPrecision.Double): FloatBinary {
    val exponentLength = if (precision == FloatBinaryPrecision.Single) 8 else 11
    val mantissaLength = if (precision == FloatBinaryPrecision.Single) 23 else 52

    val signBit = if (this < 0) Bit.One else Bit.Zero

    val (integralPartBits, fractionalPartBits) = toFractionalBinary()
    val allBits = integralPartBits + fractionalPartBits
    val oldRadixPointPosition = integralPartBits.size
    val newRadixPointPosition = allBits.indexOf(Bit.One) + 1

    if (newRadixPointPosition == -1) return FloatBinary("0".repeat(32))

    val exponent = oldRadixPointPosition - newRadixPointPosition
    val biasedExponent = exponent + 2.pow(exponentLength) / 2 - 1
    val exponentBits = biasedExponent.toIntBinary().bits.toMutableList()

    while (exponentBits.size < exponentLength) exponentBits.add(0, Bit.Zero)

    require(exponentBits.size <= exponentLength) {
        if (exponent < 0) "$this is too small" else "$this is too large"
    }

    val mantissa = allBits.subList(newRadixPointPosition, allBits.size).take(mantissaLength).toMutableList()

    while (mantissa.size < mantissaLength) mantissa.add(Bit.Zero)

    val bits = listOf(signBit) + exponentBits + mantissa
    return FloatBinary(bits)
}

fun Float.toFloatBinary(precision: FloatBinaryPrecision = FloatBinaryPrecision.Single) = toDouble().toFloatBinary(precision)