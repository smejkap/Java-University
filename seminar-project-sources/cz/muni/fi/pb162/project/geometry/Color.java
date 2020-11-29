package cz.muni.fi.pb162.project.geometry;

/**
 * Enum with colors.
 * @author Petr Smejkal
 */
public enum Color {
    BLUE, RED, GREEN, BLACK, WHITE, YELLOW, ORANGE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
