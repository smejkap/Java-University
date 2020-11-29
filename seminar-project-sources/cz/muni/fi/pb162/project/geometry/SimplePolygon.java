package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * Abstract class for representing SimplePolygon that implements Polygon
 * @author Petr Smejkal
 */
public abstract class SimplePolygon implements Polygon {

    /**
     * Constructor for childrens of SimplePolygon
     * @param vertices Given array of Vertex2D objects
     */
    public SimplePolygon(Vertex2D[] vertices) {
        if(vertices == null) {
            throw new IllegalArgumentException("Parameter vertices is null");
        }
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == null) {
                throw new IllegalArgumentException("Some vertex is null");
            }
        }
        if(vertices.length < 3) {
            throw new MissingVerticesException("not enough vertices");
        }
    }
    /**
     * Method for returning Vertex2D object by given index
     * @param index vertex index, not negative number
     * @return Returns Vertex2D object on given index
     */
    public abstract Vertex2D getVertex(int index);

    /**
     * Method for calculating number of vertices of an object
     * @return Returns number of vertices
     */
    public abstract int getNumVertices();

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public String toString() {
        String result = "Polygon: vertices =";
        for (int i = 0; i < this.getNumVertices(); i++) {
            result += " " + getVertex(i);
        }
        return result;
    }
}
