package TEC.Exceptions;

/**
 * NoEsbirrosSpaceException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción cuando ya no hay espacio para invocar un esbirro.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class NoEsbirrosSpaceException extends UnexpectedFormatException{
    public NoEsbirrosSpaceException() {
    }

    /**
     * NoEsbirrosSpaceException
     * El metodo llama al constructor de la clase que hereda.
     *
     * @param arg0
     */
    public NoEsbirrosSpaceException(String arg0) {
        super(arg0);
    }
}
