import com.thebrownfoxx.ieeefloat.IntBinary
import com.thebrownfoxx.ieeefloat.toIntBinary
import org.junit.jupiter.api.Test

class IntBinaryTest {
    @Test
    fun intToIntBinaryTest() {
        val int = 13
        val binary = int.toIntBinary()
        val expectedIntBinary = IntBinary("1101")
        println("binary = $binary")
        println("expectedBinary = $expectedIntBinary")
        check(binary == expectedIntBinary)
    }

    @Test
    fun zeroToIntBinaryTest() {
        val zero = 0
        val binary = zero.toIntBinary()
        val expectedIntBinary = IntBinary("0")
        println("binary = $binary")
        println("expectedBinary = $expectedIntBinary")
        check(binary == expectedIntBinary)
    }
}