package Class;

/**
 * Interface representing language selection functionality.
 * <p>This interface defines the method for selecting the language preference 
 * in the system.</p>
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
 */
public interface Language {

    /**
     * Method to choose the preferred language.
     * <p>This method allows the user to select a language, which can then be used to display messages
     * and prompts in that language.</p>
     * 
     * @return a string representing the chosen language (e.g., "en" for English, "es" for Spanish).
     */
    public String chooseLanguage();
}
