package cz.muni.fi.pb162.project.geometry;

/**
 * Class Vertex2D for representing vertex in 2D using coordinates.
 *
 * @author Petr Smejkal
 */

public class Vertex2D {
    private final double x;
    private final double y;

    /**
     * Constructor for class Vertex2D
     * @param x Coordinate x of Vertex
     * @param y Coordinate y of Vertex
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Method for creating middle of two vertex2D objects
     * @param otherVertex Second vertex for creating middle
     * @return Returns middle of two vertex objects
     */
    public Vertex2D createMiddle(Vertex2D otherVertex) {
        Vertex2D middle = new Vertex2D(((x + otherVertex.x) / 2.0), ((y + otherVertex.y) / 2.0));
        return middle;
    }

    /**
     * Method for calculating distance between to vertexes
     * @param vertex Input Vertex2D object
     * @return Return -1.0 if param vertex is null else return distace between vertexes
     */
    public double distance(Vertex2D vertex) {
        if (vertex == null) {
            return -1.0;
        }
        return Math.sqrt(Math.pow((vertex.x - x), 2) + Math.pow((vertex.y - y), 2));
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(other == this) {
            return true;
        }
        if(!(other instanceof Vertex2D)) {
            return false;
        }
        Vertex2D vertex2 = (Vertex2D) other;
        return Double.compare(this.x, vertex2.x) == 0 && Double.compare(this.y, vertex2.y) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) * 7 + Double.hashCode(y);
    }

    /**
     * Method for returning information about Vertex2D object
     *
     * @return Returns structured information about Vertex2D as String
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}
