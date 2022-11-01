package io.eylo.taxi.api.presentation

class ApiResponse<T> private constructor(
        val data: T,
        val message: String?
) {
    companion object {
        fun OK(): ApiResponse<Any?> {
            return ApiResponse(null, null)
        }

        fun <T> OK(data: T): ApiResponse<T> {
            return ApiResponse(data, null);

        }

        fun ERROR(message: String): ApiResponse<*> {
            return ApiResponse(null, message)
        }
    }
}