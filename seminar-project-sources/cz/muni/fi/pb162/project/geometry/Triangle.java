package cz.muni.fi.pb162.project.geometry;


/**
 * Class for representing Triangle by Vertex2D
 *
 * @author Petr Smejkal
 */
public class Triangle extends ArrayPolygon {
    private final Triangle[] subtriangles;
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final double VARIANCE = 0.001;

    /**
     * Constructor for creating Triangle
     * @param a Vertex a
     * @param b Vertex b
     * @param c Vertex c
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(new Vertex2D[] {a, b, c});
        subtriangles = new Triangle[3];
    }

    /**
     * Constructor with attribute depth
     * @param a Vertex a
     * @param b Vertex b
     * @param c Vertex c
     * @param depth Depth of recursion
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int depth) {
        this(a, b, c);
        divide(depth);
    }

    /**
     * Method for checking if triangle is divided
     * @return Return True if triangle is divided else return False
     */
    public boolean isDivided() {
        return subtriangles != null && subtriangles[A] != null &&
                subtriangles[B] != null && subtriangles[C] != null;
    }

    /**
     * Method for getting subtriangle by index
     * @param index Entered index of subtriangle
     * @return Returns subtriangle of entered index or null
     */
    public Triangle getSubTriangle(int index) {
        if((index >= 0 && index <= 2) && isDivided() && subtriangles != null) {
            return subtriangles[index];
        }
        return null;
    }

    /**
     * Method for dividing triangle to three subtriangles
     * @return Returns False if triangle is already divided or True if subtriangles were correctly divided
     */
    public boolean divide() {
        if(isDivided()) {
            return false;
        }
        subtriangles[A] = new Triangle(getVertex(A), getVertex(A).createMiddle(getVertex(B)),
                getVertex(A).createMiddle(getVertex(C)));
        subtriangles[B] = new Triangle(getVertex(A).createMiddle(getVertex(B)), getVertex(B),
                getVertex(B).createMiddle(getVertex(C)));
        subtriangles[C] = new Triangle(getVertex(A).createMiddle(getVertex(C)),
                getVertex(B).createMiddle(getVertex(C)), getVertex(C));
        return true;
    }

    /**
     * Recursive method for dividing triangles to certain depth
     * @param depth Depth of recursion
     */
    public void divide(int depth) {
        if(depth > 0) {
            divide();
            for(Triangle triangle:subtriangles) {
                triangle.divide(depth - 1);
            }
        }
    }

    /**
     * Method for check if triangle is equilateral
     * @return returns True if triangle is equilateral else returns False
     */
    public boolean isEquilateral() {
        return ((Math.abs(getVertex(A).distance(getVertex(B)) - getVertex(A).distance(getVertex(C))) < VARIANCE) &&
                (Math.abs(getVertex(A).distance(getVertex(B)) - getVertex(B).distance(getVertex(C))) < VARIANCE) &&
                (Math.abs(getVertex(A).distance(getVertex(C))) - getVertex(B).distance(getVertex(C)) < VARIANCE));
    }

    /**
     * Method for returning information about Triangle object
     *
     * @return Returns structured information about Triangle as String
     */
    @Override
    public String toString() {
        return "Triangle: vertices=" + getVertex(A) + " " + getVertex(B) + " " + getVertex(C);
    }
}
