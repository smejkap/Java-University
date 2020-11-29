package cz.muni.fi.pb162.project.geometry;

/**
 * Interface for objects that can be colored
 * @author Petr Smejkal
 */
public interface Colored {
    /**
     * Getter for Color
     * @return Returns Color of object
     */
    Color getColor();

    /**
     * Setter for Color
     * @param color Color we want to set to object
     */
    void setColor(Color color);
}
