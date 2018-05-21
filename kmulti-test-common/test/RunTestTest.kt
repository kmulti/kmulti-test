import kmulti.test.JsName
import kmulti.test.runTest
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * @author Marcin Moskala
 */

class RunTestTest {
    @Test
    @JsName("numberOfCallsInTimeTest")
    fun `Periodic caller for 50ms is called around 20 times during 1 second`() = runTest {
        val caller = PeriodicCaller()
        var count = 0
        val job = caller.start(50) { count++ }
        delay(1000)
        job.cancel()
        assertTrue(count in 18..22)
    }
}

class PeriodicCaller {
    fun start(timeMillis: Int, callback: () -> Unit): Job {
        return launch {
            while (true) {
                delay(timeMillis)
                callback()
            }
        }
    }
}
