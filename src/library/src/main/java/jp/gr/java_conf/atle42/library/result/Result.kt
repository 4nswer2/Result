package jp.gr.java_conf.atle42.library.result


class Result<out T> private constructor(val value: T?, val error: Error?){

	constructor(value: T)     : this(value, null)
	constructor(error: Error) : this(null, error)

	fun success(action: (T) -> Unit): Result<T> {
		value?.let { action(value) }
		return this
	}

	fun failure(action: (Error) -> Unit): Result<T> {
		error?.let { action(error) }
		return this
	}

	inline fun <U> mapValue(converter: (T) -> U): Result<U> {
		when (value) {
			null -> return Result(error as Error)
			else -> return Result(converter(value))
		}
	}

	inline fun mapError(converter: (Error) -> Error): Result<T> {
		when (error) {
			null -> return Result(value as T)
			else -> return Result(converter(error))
		}
	}
}