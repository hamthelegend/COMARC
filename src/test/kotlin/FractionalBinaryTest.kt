import com.thebrownfoxx.ieeefloat.FractionalBinary
import com.thebrownfoxx.ieeefloat.toFractionalBinary
import org.junit.jupiter.api.Test

class FractionalBinaryTest {
    @Test
    fun doubleToFractionalBinaryTest() {
        val double = 1259.125
        val fractionalBinary = double.toFractionalBinary()
        val expectedFractionalBinary = FractionalBinary("10011101011.001")
        println("fractionalBinary = $fractionalBinary")
        println("expectedFractionalBinary = $expectedFractionalBinary")
        check(fractionalBinary == expectedFractionalBinary)
    }

    @Test
    fun zeroToFractionalBinaryTest() {
        val double = 0.0
        val fractionalBinary = double.toFractionalBinary()
        val expectedFractionalBinary = FractionalBinary("0.0")
        println("fractionalBinary = $fractionalBinary")
        println("expectedFractionalBinary = $expectedFractionalBinary")
        check(fractionalBinary == expectedFractionalBinary)
    }
}