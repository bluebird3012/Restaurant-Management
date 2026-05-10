package com.blue.rms.exception

import com.blue.rms.exception.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException::class)
    fun onUserExists(ex: UserAlreadyExistsException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            message = ex.message ?: "User already exists",
            code = "USER_EXISTS"
        )
        return ResponseEntity(error, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(InvalidCredentialsException::class)
    fun onInvalidCredentials(ex: InvalidCredentialsException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            message = ex.message ?: "The entered credentials aren't valid.",
            code = "INVALID_CREDENTIALS"
        )
        return ResponseEntity(error, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun onUserNotFound(ex: UserNotFoundException)
        = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "User Not Found",
            code = "USER_NOT_FOUND"
        ),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler(InvalidTokenException::class)
    fun onUserNotFound(ex: InvalidTokenException)
            = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Invalid Token",
            code = "INVALID_TOKEN"
        ),
        HttpStatus.BAD_REQUEST
    )

    @ExceptionHandler(SamePasswordException::class)
    fun onSamePassword(ex: SamePasswordException)
            = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Same password",
            code = "SAME_PASSWORD"
        ),
        HttpStatus.BAD_REQUEST
    )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun onValidationException(
        e: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val errors = e.bindingResult.allErrors.map {
            it.defaultMessage ?: "Invalid value"
        }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    message = errors.firstOrNull() ?: "Invalid value",
                    code = "VALIDATION_ERROR"
                )
            )
    }

    @ExceptionHandler(CategoryAlreadyExistsException::class)
    fun onCategoryExists(ex: CategoryAlreadyExistsException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Category already exists",
            code = "CATEGORY_EXISTS"
        ),
        HttpStatus.CONFLICT
    )

    @ExceptionHandler(CategoryNotFoundException::class)
    fun onCategoryNotFound(ex: CategoryNotFoundException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Category Not Found",
            code = "CATEGORY_NOT_FOUND"
        ),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler(ComboNotFoundException::class)
    fun onComboNotFound(ex: ComboNotFoundException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Combo Not Found",
            code = "COMBO_NOT_FOUND"
        ),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler(DishNotFoundException::class)
    fun onDishNotFound(ex: DishNotFoundException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Dish Not Found",
            code = "DISH_NOT_FOUND"
        ),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler(OptionsNotFoundException::class)
    fun onOptionsNotFound(ex: OptionsNotFoundException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Options Not Found",
            code = "OPTIONS_NOT_FOUND"
        ),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler(UnauthorizedException::class)
    fun onUnauthorized(ex: UnauthorizedException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Unauthorized Access",
            code = "UNAUTHORIZED"
        ),
        HttpStatus.UNAUTHORIZED
    )

    @ExceptionHandler(ForbiddenException::class)
    fun onForbidden(ex: ForbiddenException) = ResponseEntity(
        ErrorResponse(
            message = ex.message ?: "Access Forbidden",
            code = "FORBIDDEN"
        ),
        HttpStatus.FORBIDDEN
    )
}