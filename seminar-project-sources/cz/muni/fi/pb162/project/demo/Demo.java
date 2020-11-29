package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Demo class for iteration-08.
 *
 * @author Petr Smejkal
 */
public class Demo {

    /**
     * Create Rectangle object, set his center and diameter and print his vertexes.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        RegularOctagon regularOctagon = new RegularOctagon(new Vertex2D(0, 0), 1);
        System.out.println(regularOctagon);
    }
}
