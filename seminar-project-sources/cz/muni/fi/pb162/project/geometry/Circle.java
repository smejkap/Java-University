package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing circle by Vertex2D class and radius,
 * extends GeneralRegularPolygon and implements Measurable, Circular
 * @author Petr Smejkal
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular {
    /**
     * Constructor of Circle class
     * @param center Vertex
     * @param radius Radius of circle
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, radius);
        this.setColor(Color.RED);
    }

    /**
     * Default constructor of Circle class
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }

    @Override
    public double getEdgeLength() {
        return 0;
    }

    /**
     * Method for returning information about Circle object
     *
     * @return Returns structured information about Circle as String
     */
    @Override
    public String toString() {
        return "Circle: center=" + getCenter() + ", radius=" + getRadius();
    }
}
