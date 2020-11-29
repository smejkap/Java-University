package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 * Class for representing ArrayPolygon
 * @author Petr Smejkal
 */
public class ArrayPolygon extends SimplePolygon {
    private final Vertex2D[] vertices;

    /**
     * Constructor of ArrayPolygon class
     * @param vertices Array of Vertex2D objects
     */
    public ArrayPolygon(Vertex2D[] vertices) {
        super(vertices);
        this.vertices = vertices.clone();
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index");
        }
        return vertices[index % getNumVertices()];
    }

    @Override
    public int getNumVertices() {
        return vertices.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        ArrayPolygon polygon = (ArrayPolygon) o;
        return Arrays.equals(vertices, polygon.vertices);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertices);
    }
}
