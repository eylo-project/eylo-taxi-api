package io.eylo.taxi.api.presentation

class ApiResponse<T> private constructor(
        val data: T?,
        val message: String?
) {
    companion object {
        fun <T> OK(data: T): ApiResponse<T> {
            return ApiResponse(data, null);
        }

        fun ERROR(throwable: Throwable): ApiResponse<*> {
            return ApiResponse(null, throwable.message);
        }

        fun ERROR(message: String): ApiResponse<*> {
            return ApiResponse(null, message);
        }
    }
}