package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Class with static methods for printing info about Measurable objects.
 * @author Petr Smejkal
 */
public class Gauger{
    /**
     * Method for printing info about Measurable object
     * @param measurable Object from Measurable interface
     */
    public static void printMeasurement(Measurable measurable) {
        System.out.println("Width: " + measurable.getWidth() + System.lineSeparator()
                + "Height: " + measurable.getHeight());
    }

    /**
     * Method for printing info about Triangle object
     * @param triangle Triangle object
     */
    public static void printMeasurement(Triangle triangle) {
        System.out.println(triangle);
        printMeasurement((Measurable) triangle);
    }

}
