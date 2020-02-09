package br.com.ifpb.testes.exception;

public class UsuarioException extends Throwable {

    public UsuarioException() {}

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);

    }

    public UsuarioException(String message) {
        super(message);
    }

}
