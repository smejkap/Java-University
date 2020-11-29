package cz.muni.fi.pb162.project.geometry;

/**
 * Class for representing Snowman by RegularPolygon objects
 * @author Petr Smejkal
 */
public class Snowman {
    private static final int COUNT = 3;
    private static final double DEFAULT_FACTOR = 0.8;
    private RegularPolygon[] regularPolygon = new RegularPolygon[COUNT];

    /**
     * Constructor of class Snowman
     * @param regularPolygon RegularPolygon object as base of Snowman
     * @param factor Factor of change
     */
    public Snowman(RegularPolygon regularPolygon, double factor) {
        double usedFactor = factor;
        if(!(factor > 0 && factor <= 1)) {
            usedFactor = DEFAULT_FACTOR;
        }
        this.regularPolygon[0] = regularPolygon;
        for (int i = 1; i < COUNT; i++) {
            double tmpRadius = this.regularPolygon[i-1].getRadius() * usedFactor;
            this.regularPolygon[i] = new GeneralRegularPolygon(new Vertex2D(
                    this.regularPolygon[i - 1].getCenter().getX(), this.regularPolygon[i - 1].getCenter().getY()
                    + this.regularPolygon[i - 1].getRadius() + tmpRadius), regularPolygon.getNumEdges(),
                    (int)tmpRadius) {
            };
        }
    }

    /**
     * Method for returning sorted field of RegularPolygon objects
     * @return Returns sorted field of RegularPolygon objects
     */
    public RegularPolygon[] getBalls() {
        return regularPolygon;
    }
}
