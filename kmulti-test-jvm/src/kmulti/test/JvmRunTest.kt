package kmulti.test

import kotlinx.coroutines.experimental.runBlocking

/**
 * @author Marcin Moskala
 */
actual fun <T> runTest(block: suspend () -> T) {
    runBlocking { block() }
}
