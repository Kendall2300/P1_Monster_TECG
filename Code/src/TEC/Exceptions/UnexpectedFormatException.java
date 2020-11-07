package TEC.Exceptions;

@SuppressWarnings("serial")
/**
 * UnexpectedFormatException
 * Esta es la clase maestra que hereda los métodos de la clase Exception. Se encarga del control de todas las demás excepciones
 *
 * @author Kendall Martinez && Daniel Montoya
 * @version 1.8
 */
public class UnexpectedFormatException extends Exception{
    String sourceFile;
    int sourceLine;


    /**
     * UnexpectedFormatException
     * El metodo es el constructor cuando no se requiere ningún parámetro o argumento.
     *
     *
     */
    public UnexpectedFormatException(){
    }

    /**
     * UnexpectedFormatException
     * El metodo llama al constructor de la clase que hereda.
     *
     * @param arg0 Un string con el argumento del error
     */
    public UnexpectedFormatException(String arg0){
        super(arg0);
    }

    /**
     * UnexpectedFormatException
     * El metodo coloca la línea y fila donde ocurre el error en un source file.
     *
     * @param sFile String que dice donde se encuentra el error
     * @param sLine Integer que dice la linea donde se encontraba el error
     */
    public UnexpectedFormatException(String sFile, int sLine){
        this.sourceFile=sFile;
        this.sourceLine=sLine;
    }

    /**
     * UnexpectedFormatException
     * El metodo coloca la línea y fila donde ocurre el error en un source file, además coloca el mensaje del tipo de error
     *
     * @param sFile String que dice donde se encuentra el error
     * @param sLine Integer que dice la linea donde se encontraba el error
     */
    public UnexpectedFormatException(String message, String sFile, int sLine){
        super(message);
        this.sourceFile=sFile;
        this.sourceLine=sLine;
    }


    /**
     * getSourceFile
     * El metodo retorna el lugar donde se encontró el error
     *
     */
    public String getSourceFile() {
        return sourceFile;
    }


    /**
     * setSourceFile
     * El metodo coloca el lugar del error en un sourcefile.
     *
     * @param sourceFile String que muestra el lugar donde ocurrió el error
     */
    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }


    /**
     * getSourceLine
     * El metodo retorna la línea donde ocurrió el error.
     */
    public int getSourceLine() {
        return sourceLine;
    }


    /**
     * setSourceLine
     * El metodo coloca la línea donde ocurre el error en un sourceline.
     *
     * @param sourceLine Integer con la línea del error
     */
    public void setSourceLine(int sourceLine) {
        this.sourceLine = sourceLine;
    }
}
