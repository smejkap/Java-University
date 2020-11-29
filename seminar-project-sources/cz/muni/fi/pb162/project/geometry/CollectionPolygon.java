package cz.muni.fi.pb162.project.geometry;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class for representing CollectionPolygon that extends SimplePolygon
 * @author Petr Smejkal
 */
public class CollectionPolygon extends SimplePolygon {
    private final List<Vertex2D> vertices;

    /**
     * First constructor for class CollectionPolygon
     * @param vertices Array of Vertex2D object
     */
    public CollectionPolygon (Vertex2D[] vertices) {
        super(vertices);
        this.vertices = new ArrayList<Vertex2D>(Arrays.asList(vertices));
    }

    /**
     * Second constructor for class CollectionPolygon
     * @param vertices List of Vertex2D objects;
     */
    public CollectionPolygon (List<Vertex2D> vertices) {
        this(vertices.toArray(new Vertex2D[0]));
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index");
        }
        return vertices.get(index % getNumVertices());
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    /**
     * Method for returning CollectionPolygon without left-most vertices
     * @return Returns CollectionPolygon without left-most vertices
     */
    CollectionPolygon withoutLeftmostVertices() {
        if (vertices.isEmpty()) {
            throw new IllegalArgumentException("Vertex list is empty");
        }
        Vertex2D leftMost = Collections.min(vertices, (Vertex2D a, Vertex2D b) -> (Double.compare(a.getX(), b.getX())));
        List<Vertex2D> newVertices = new ArrayList<>(vertices);
        while (newVertices.contains(leftMost)) {
            newVertices.remove(leftMost);
        }
        return new CollectionPolygon(newVertices);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CollectionPolygon)) {
            return false;
        }
        CollectionPolygon that = (CollectionPolygon) o;
        return Objects.equals(vertices, that.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertices);
    }
}
