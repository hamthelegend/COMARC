import com.thebrownfoxx.ieeefloat.toFloatBinary

fun main() {
    print("Enter a fractional number: ")
    val input = readln()
    println()
    val singleFloat = input.toFloat().toFloatBinary()
    println("IEEE 754 Float-point number representations")
    println("Single precision: ${singleFloat.toUnlabeledString()}")
    val doubleFloat = input.toDouble().toFloatBinary()
    println("Double precision: ${doubleFloat.toUnlabeledString()}")
}