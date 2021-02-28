package com.koc.finans.api.service.handler;

import com.koc.finans.api.service.exception.*;
import com.koc.finans.api.service.helper.Translator;
import com.koc.finans.api.service.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public RestResponseEntityExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //<editor-fold desc="Override Functions">

    @Override
    @NonNull
    protected ResponseEntity<Object> handleBindException(@NonNull BindException exception,
                                                         @NonNull HttpHeaders headers,
                                                         @NonNull HttpStatus status,
                                                         @NonNull WebRequest request) {
        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(objectError -> messageSource.getMessage(objectError, LocaleContextHolder.getLocale()))
                .collect(Collectors.toList());

        return handleExceptionInternal(
                exception,
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST,
                        Translator.toLocale("UNEXPECTED_ERROR"),
                        errors
                ),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request
        );
    }
    //</editor-fold>

    //<editor-fold desc="Handling Project Exception">

    @ExceptionHandler({
            UserNotFoundException.class,
            HttpRequestException.class,
            CityScoreRequestException.class,
            IncomeNotFoundException.class,
            IdentityScoreRequestException.class,
            UserExistsException.class
    })
    protected ResponseEntity<Object> handleProjectExceptionCustom(RuntimeExceptionImp exception, WebRequest request) {
        return handleExceptionInternal(
                exception,
                new ErrorResponse(
                        exception.getHttpStatus(),
                        Translator.toLocale(exception.getMessageKey()),
                        exception.getMessage(),
                        exception.getErrorCode()
                ),
                new HttpHeaders(),
                exception.getHttpStatus(),
                request
        );
    }

    //</editor-fold>

    //<editor-fold desc="Handling System Exceptions">

    /*
     * IllegalArgumentException
     * IllegalStateException
     * InvalidDataAccessApiUsageException
     * PropertyReferenceException
     * MethodArgumentTypeMismatchException
     * JpaSystemException
     */
    @ExceptionHandler({
            IllegalArgumentException.class,
            IllegalStateException.class,
            InvalidDataAccessApiUsageException.class,
            PropertyReferenceException.class,
            MethodArgumentTypeMismatchException.class,
            JpaSystemException.class
    })
    protected ResponseEntity<Object> handleSystemRuntimeExceptionCustom(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(
                exception,
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST,
                        Translator.toLocale("UNEXPECTED_ERROR"),
                        exception.getClass().getName() + ": " + exception.getLocalizedMessage()
                ),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request
        );
    }

    /*
     * CompletionException
     * ExecutionException
     * InterruptedException
     */
    @ExceptionHandler({
            CompletionException.class,
            ExecutionException.class,
            InterruptedException.class
    })
    protected ResponseEntity<Object> handleSystemTaskExceptionCustom(Exception exception, WebRequest request) {

        HttpStatus httpStatus = (exception.getCause() instanceof RuntimeExceptionImp ?
                ((RuntimeExceptionImp) exception.getCause()).getHttpStatus() :
                HttpStatus.INTERNAL_SERVER_ERROR
        );

        return handleExceptionInternal(
                exception,
                new ErrorResponse(
                        httpStatus,
                        (exception.getCause() instanceof RuntimeExceptionImp ?
                                Translator.toLocale(((RuntimeExceptionImp) exception.getCause()).getMessageKey()) :
                                Translator.toLocale("UNEXPECTED_ERROR")
                        ),
                        exception.getClass().getName() + ": " + exception.getLocalizedMessage(),
                        (exception.getCause() instanceof RuntimeExceptionImp ?
                                ((RuntimeExceptionImp) exception.getCause()).getErrorCode() :
                                100
                        )
                ),
                new HttpHeaders(),
                httpStatus,
                request
        );
    }


    /*
     * Exception
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleSystemInternal(final RuntimeException exception, final WebRequest request) {
        logger.error("Unhandled error", exception);

        return handleExceptionInternal(
                exception,
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        Translator.toLocale("INTERNAL_SERVER_ERROR"),
                        exception.getClass().getName() + ": " + exception.getLocalizedMessage()
                ),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    //</editor-fold>
}