import com.thebrownfoxx.ieeefloat.FloatBinary
import com.thebrownfoxx.ieeefloat.toFloatBinary
import org.junit.jupiter.api.Test

class FloatBinaryTest {
    @Test
    fun floatToSingleFloatBinaryTest() {
        val input = 45.45f
        val actual = input.toFloatBinary()
        val expected = FloatBinary("01000010001101011100110011001101")
        println("actual = $actual")
        println("expected = $expected")
        check(actual == expected)
    }

    @Test
    fun doubleToSingleFloatBinaryTest() {
        val input = 45.45
        val actual = input.toFloatBinary()
        val expected = FloatBinary("0100000001000110101110011001100110011001100110011001100110011010")
        println("actual = $actual")
        println("expected = $expected")
        check(actual == expected)
    }
}