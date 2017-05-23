package jp.gr.java_conf.atle42.library.result

import org.junit.Assert.assertEquals
import org.junit.Test


class ResultTestKt {

	@Test
	@Throws(Exception::class)
	fun testSuccess() {
		val success: Result<String> = Result("success")
		success
				.success {
					println(it)
					assertEquals("success", it)
				}
				.failure { println(it.message) }
	}

	@Test
	@Throws(Exception::class)
	fun testFailure() {
		val failure: Result<String> = Result(Error("failure"))
		failure
				.success { println(it) }
				.failure {
					println(it.message)
					assertEquals("failure", it.message)
				}
	}
}
