package TEC.Exceptions;

@SuppressWarnings("serial")
/**
 * EmptyFieldException
 * Esta clase hereda los métodos de UnexpectedFormatException. Genera una excepción cuando se quiere realizar una acción de ataque en un campo vacío
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class EmptyFieldException extends UnexpectedFormatException{
    int sourceField;

    /**
     * EmptyFieldException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     *
     */
    public EmptyFieldException(){

    }

    /**
     * EmptyFieldException
     * El metodo llama al constructor de la clase que hereda.
     *
     * @param arg0
     */
    public EmptyFieldException(String arg0){
        super(arg0);
    }

    /**
     * EmptyFieldException
     * El metodo muestra el error, el lugar donde se encotró el error y la línea
     *
     * @param sFile Un String que muestra el tipo de error
     * @param sField Un Integer que muestra el lugar donde se encuentra el error
     * @param sLine  Un Integer que muestra la línea donde se encuentra el error
     */
    public EmptyFieldException(String sFile, int sLine, int sField){
        super (sFile,sLine);
        this.sourceField=sField;
    }

    /**
     * EmptyFieldException
     *  El metodo muestra el error, el lugar donde se encotró el error, la línea del error y muestra el mensaje de error
     *
     * @param sFile Un String que muestra el tipo de error.
     * @param sField Un Integer que muestra el lugar donde se encuentra el error.
     * @param sLine  Un Integer que muestra la línea donde se encuentra el error.
     * @param message Un String que muestra el mensaje de error.
     */
    public EmptyFieldException(String message,String sFile, int sLine, int sField){
        super(message, sFile, sLine);
        this.sourceField=sField;
    }

    /**
     * getSourceField
     *  El metodo se encarga de retornar la fuente de donde se econtró el error
     */
    public int getSourceField() {
        return sourceField;
    }

    /**
     * setSourceField
     *  El metodo se encarga de colocar la fuente de donde se econtró el error
     *
     * @param sourceField Un entero con la fuente del lugar del error.
     */
    public void setSourceField(int sourceField) {
        this.sourceField = sourceField;
    }
}
