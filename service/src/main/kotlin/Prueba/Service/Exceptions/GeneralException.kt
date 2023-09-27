package Prueba.Service.Exceptions

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.ErrorValueWithMessage

@Component
@ControllerAdvice
class GeneralException : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {

        val errors = ex.bindingResult.allErrors
            .map{ error -> error.defaultMessage!! }
            .sorted()

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errors)

    }


    @ExceptionHandler
    fun handleNoPeliculaException (ex:NoPeliculaException):ResponseEntity<ErrorMesaggeModel> {
        val errorMessage = ErrorMesaggeModel(HttpStatus.NOT_FOUND.value(),ex.message)

        return ResponseEntity(errorMessage,HttpStatus.NOT_FOUND)
    }

}

