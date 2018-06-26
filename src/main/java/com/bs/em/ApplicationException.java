package com.bs.em;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationException extends RuntimeException{

    public enum Type {
        unexpected,
        client_error,
    }

    public static final int CODE_UNSPECIFIED = 0;
    //-------------20 - 29-------------
    public static final int CODE_USER_NOT_FOUND = 20;
    public static final int CODE_USER_CREATE_ERROR = 21;
    public static final int CODE_USER_ALREADY_EXIST = 22;
    public static final int CODE_USER_INVALID_ID = 23;

    //------------30 - 39-------------
    public static final int CODE_TASK_NOT_FOUND = 30;



    private Type type;
    private int code = CODE_UNSPECIFIED;

    public ApplicationException(Type type, int code) {
        this.type = type;
        this.code = code;
    }

    public ApplicationException(Type type, int code, String message) {
        super(message);
        this.type = type;
        this.code = code;
    }

    public ApplicationException(Type type, int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }


    @Override
    public String toString() {
        return "ApplicationException{" +
                "type=" + type +
                '}';
    }
}
