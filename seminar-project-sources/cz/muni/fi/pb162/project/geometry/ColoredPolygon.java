package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 * Class for representing ColoredPolygon
 * @author Petr Smejkal
 */
public class ColoredPolygon {
    private Polygon polygon;
    private Color color;

    /**
     * Constructor of ColoredPolygon
     * @param polygon Polygon we want to be colored
     * @param color Color for given polygon
     */
    public ColoredPolygon (Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ColoredPolygon)) {
            return false;
        }
        ColoredPolygon that = (ColoredPolygon) o;
        return Objects.equals(polygon, that.polygon) &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(polygon, color);
    }
}
