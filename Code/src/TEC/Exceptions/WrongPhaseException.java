package TEC.Exceptions;

/**
 * WrongPhaseException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción uando se realiza un acción dentro de una fase incorrecta.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class WrongPhaseException extends UnexpectedFormatException{

    /**
     * WrongPhaseException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     */
    public WrongPhaseException() {
    }

    /**
     * WrongPhaseException
     * El metodo llama al constructor de la clase que hereda, le pasa como parámetro el mensaje del error
     *
     * @param message Un String que muestra el mensaje de error
     */
    public WrongPhaseException(String message) {
        super(message);
    }
}
