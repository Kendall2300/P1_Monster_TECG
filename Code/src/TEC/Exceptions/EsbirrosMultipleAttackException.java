package TEC.Exceptions;

@SuppressWarnings("serial")

/**
 * EsbirrosMultipleAttackException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción cuando se quiere atacar mas de una vez con un mismo esbirro
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class EsbirrosMultipleAttackException extends UnexpectedFormatException{

    /**
     * EsbirrosMultipleAttackException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     */
    public EsbirrosMultipleAttackException() {
    }

    /**
     * EsbirrosMultipleAttackException
     * El metodo llama al constructor de la clase que hereda y le pasa como parámetro el mensaje de error.
     *
     * @param message Un String que muestra el mensaje de error
     */
    public EsbirrosMultipleAttackException(String message){
        super(message);
    }
}
