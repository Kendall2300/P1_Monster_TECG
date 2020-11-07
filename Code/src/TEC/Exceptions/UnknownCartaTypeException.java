package TEC.Exceptions;

/**
 * UnknownCartaTypeException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción cuando se desconoce el tipo de carta.
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class UnknownCartaTypeException extends UnexpectedFormatException{
    String unknownType;


    /**
     * UnknownCartaTypeException
     * El metodo coloca en un objeto de tipo unknownType el parámetro de entrada unknownType.
     *

     * @param unknownType
     */
    public UnknownCartaTypeException(String unknownType) {
        this.unknownType = unknownType;
    }

    /**
     * UnknownCartaTypeException
     * El metodo llama al constructor de la clase que hereda. Coloca en un objeto de tipo unknownType el parámetro de entrada unknownType.
     *
     * @param arg0
     * @param unknownType String que contiene el tipo desconocido de carta ingresada
     */
    public UnknownCartaTypeException(String arg0, String unknownType) {
        super(arg0);
        this.unknownType = unknownType;
    }

    /**
     * UnknownCartaTypeException
     * El metodo llama al constructor de la clase que hereda y le pasa como parámetros la línea del error y el lugar del error.
     *
     * @param sFile String que tiene el lugar donde se encuentra el error
     * @param sLine Integer que contiene la línea del error
     * @param unknownType String que contiene el tipo desconocido de carta ingresada
     */
    public UnknownCartaTypeException(String sFile, int sLine, String unknownType) {
        super(sFile, sLine);
        this.unknownType = unknownType;
    }

    /**
     * UnknownCartaTypeException
     * El metodo llama al constructor de la clase que hereda y le pasa como parámetro el mensaje con el error, la línea y el lugar del error.
     *
     * @param message String que muestra el mensaje de error
     * @param sLine Integer que contiene la línea del error
     * @param sFile String que tiene el lugar donde se encuentra el error
     * @param unknownType String que contiene el tipo desconocido de carta ingresada
     */
    public UnknownCartaTypeException(String message, String sFile, int sLine, String unknownType) {
        super(message, sFile, sLine);
        this.unknownType = unknownType;
    }

    /**
     * getUnknownType
     * El metodo retorna el valor de tipo de carta.
     *
     */
    public String getUnknownType() {
        return unknownType;
    }
}
