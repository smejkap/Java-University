package cz.muni.fi.pb162.project.geometry;

/**
 * Class for representing RegularOctagon with 8 edges that extends class GeneralRegularPolygon
 * @author Petr Smejkal
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Constructor of RegularOctagon with 8 edges
     * @param center Center of RegularOctagon
     * @param radius Radius of RegularOctagon
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
