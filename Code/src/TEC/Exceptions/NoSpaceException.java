package TEC.Exceptions;


/**
 * NoSpaceException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción cuando no hay espacio en el tablero.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class NoSpaceException extends UnexpectedFormatException{

    /**
     * NoSpaceException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     */
    public NoSpaceException() {
    }

    /**
     * NoSpaceException
     * El metodo llama al constructor de la clase que hereda.
     *
     * @param arg0
     */
    public NoSpaceException(String arg0) {
        super(arg0);
    }
}
