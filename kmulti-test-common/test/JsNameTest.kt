import kmulti.test.JsName
import kotlin.test.Test
import kotlin.test.assertTrue

class JsNameTest {
    @Test
    @JsName("twoPlusTwoEqualsFour")
    fun `2 + 2 == 4`() {
        val two = 2
        assertTrue { two + two == 4 }
    }
}
