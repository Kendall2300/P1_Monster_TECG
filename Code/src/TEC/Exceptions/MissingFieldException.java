package TEC.Exceptions;

@SuppressWarnings("serial")

/**
 * MissingFieldException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción se quiere invocar una carta pero no hay espacio.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class MissingFieldException extends UnexpectedFormatException{

    /**
     * MissingFieldException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     */
    public MissingFieldException() {}

    /**
     * MissingFieldException
     * El metodo llama al constructor de la clase que hereda.
     *
     * @param arg0 Un valor String
     */
    public MissingFieldException(String arg0) {
        super(arg0);
    }

    /**
     * MissingFieldException
     * El metodo muestra el error, el lugar donde se encotró el error y la línea
     *
     * @param sFile Un String que muestra el tipo de error
     * @param sLine  Un Integer que muestra la línea donde se encuentra el error
     */
    public MissingFieldException(String sFile, int sLine) {
        super(sFile, sLine);
    }


    /**
     * MissingFieldException
     *  El metodo muestra el error, la línea del error y muestra el mensaje de error.
     *
     * @param sFile Un String que muestra el tipo de error
     * @param sLine  Un Integer que muestra la línea donde se encuentra el error
     * @param message Un String que muestra el mensaje de error.
     */
    public MissingFieldException(String message, String sFile, int sLine) {
        super(message, sFile, sLine);
    }
}
