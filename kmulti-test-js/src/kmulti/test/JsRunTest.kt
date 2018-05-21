package kmulti.test

import kotlinx.coroutines.experimental.promise

/**
 * @author Marcin Moskala
 */
actual fun <T> runTest(block: suspend () -> T): dynamic = promise {
    block()
}
