package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 * Class with static methods.
 * @author Petr Smejkal
 */
public class SimpleMath {
    /**
     * Method for finding minimal X coordinate
     * @param polygon Object of class Triangle
     * @return Return found minimal X coordinate
     */
    public static double minX(Polygon polygon) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            double tmp = polygon.getVertex(i).getX();
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    /**
     * Method for finding minimal Y coordinate
     * @param polygon Object of class Triangle
     * @return Return found minimal Y coordinate
     */
    public static double minY(Polygon polygon) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            double tmp = polygon.getVertex(i).getY();
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    /**
     * Method for finding maximal X coordinate
     * @param polygon Object of class Triangle
     * @return Return found maximal X coordinate
     */
    public static double maxX(Polygon polygon) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            double tmp = polygon.getVertex(i).getX();
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    /**
     * Method for finding maximal Y coordinate
     * @param polygon Object of class Triangle
     * @return Return found maximal Y coordinate
     */
    public static double maxY(Polygon polygon) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            double tmp = polygon.getVertex(i).getY();
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
