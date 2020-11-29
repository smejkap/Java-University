package cz.muni.fi.pb162.project.geometry;

/**
 * Class for representing Square by Vertex2D center and radius
 * extends GeneralRegularPolygon and implements Circular interface
 * @author Petr Smejkal
 */
public class Square extends GeneralRegularPolygon implements Circular {

    /**
     * Constructor of Square class
     * @param center Center of Square
     * @param diameter Diameter of Square
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter / 2);
    }

    /**
     * Constructor of Square class
     * @param circular Circular object
     */
    public Square(Circular circular) {
        this(circular.getCenter(), circular.getRadius() * 2);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Square: vertices=");
        for(int i = 0;i < 4; i++) {
           result.append(getVertex(i));
           if (i < 3){
               result.append(" ");
           }
        }
        return result.toString();
    }
}
