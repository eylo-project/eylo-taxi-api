package io.eylo.taxi.api.presentation

class ApiResponse<T> private constructor(
    val data: T,
    val message: String?
) {
    companion object {
        private val EMPTY_OK = ApiResponse(null, null)

        fun OK(): ApiResponse<*> {
            return EMPTY_OK;
        }

        fun <T> OK(data: T): ApiResponse<T> {
            return ApiResponse(data, null);

        }

        fun ERROR(message: String): ApiResponse<*> {
            return ApiResponse(null, message)
        }
    }
}