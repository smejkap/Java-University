package cz.muni.fi.pb162.project.geometry;

/**
 * Class for representing GeneralRegularPolygon that implements RegularPolygon, Colored.
 * @author Petr Smejkal
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private final Vertex2D center;
    private final int edges;
    private final double radius;
    private Color color;

    /**
     * Constructor of class GeneralRegularPolygon with default color black.
     * @param center Center of GeneralRegularPolygon
     * @param edges Number of edges of GeneralRegularPolygon
     * @param radius Radius of GeneralRegularPolygon
     */
    public GeneralRegularPolygon(Vertex2D center, int edges, double radius) {
        this.center = center;
        this.edges = edges;
        this.radius = radius;
        this.color = Color.BLACK;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getNumEdges() {
        return edges;
    }

    @Override
    public double getEdgeLength() {
        return 2*radius*Math.sin(Math.PI/edges);
    }

    @Override
    public Vertex2D getVertex(int index) {
        double x = center.getX() - radius*Math.cos(index*2*Math.PI/edges);
        double y = center.getY() - radius*Math.sin(index*2*Math.PI/edges);
        return new Vertex2D(x, y);
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getWidth() {
        return 2*radius;
    }

    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public String toString() {
        return edges + "-gon: center=" + center + ", radius=" + radius + ", color=" + color;
    }
}
