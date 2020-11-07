package TEC.Exceptions;


/**
 * NoHechizosSpaceException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción cuando se intenta ingresar un hechizo y no hay campo para activarlo o colocarlo.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class NoHechizosSpaceException extends UnexpectedFormatException{
    public NoHechizosSpaceException() {
    }

    /**
     * NoHechizosSpaceException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     *
     * @param arg0
     */
    public NoHechizosSpaceException(String arg0) {
        super(arg0);
    }
}
