package cz.muni.fi.pb162.project.geometry;


import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for representing Paper that implements Drawable
 * @author Petr Smejkal
 */
public class Paper implements Drawable, PolygonFactory {
    private final Set<ColoredPolygon> canvas;
    private Color color;

    /**
     * Default constructor of class Paper with Black as default color
     */
    public Paper() {
        this.canvas = new HashSet<ColoredPolygon>();
        color = Color.BLACK;
    }

    /**
     * Constructor of class Paper with Black as default color
     * @param drawable Given object of interface Drawable
     */
    public Paper(Drawable drawable) {
        this();
        this.canvas.addAll(drawable.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (color == Color.WHITE) {
            throw new TransparentColorException(color.name().toLowerCase());
        }
        canvas.add(new ColoredPolygon(polygon, color));
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        canvas.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if(canvas.isEmpty()) {
            throw new EmptyDrawableException("canvas is already blank");
        }
        canvas.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableCollection(canvas);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> uniqueVertices = new HashSet<>();
        for (ColoredPolygon i : canvas) {
            for (int j = 0; j < i.getPolygon().getNumVertices(); j++) {
                uniqueVertices.add(i.getPolygon().getVertex(j));
            }
        }
        return uniqueVertices.size();
    }

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        if(vertices == null) {
            throw new NullPointerException("null parameter");
        }
        List<Vertex2D> tmpVertices = new ArrayList<Vertex2D>(vertices);
        try {
            return new CollectionPolygon(tmpVertices);
        } catch (IllegalArgumentException e) {
            while(tmpVertices.contains(null)){
                tmpVertices.remove(null);
            }
            return new CollectionPolygon(tmpVertices);
        }
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        Throwable last = null;
        boolean draw = false;
        for (List<Vertex2D> polygonVert : collectionPolygons) {
            try {
                Polygon polygon = tryToCreatePolygon(polygonVert);
                drawPolygon(polygon);
                draw = true;
            } catch (MissingVerticesException | NullPointerException e) {
                last = e;
            } catch (TransparentColorException e) {
                changeColor(Color.BLACK);
                last = e;
            }
        }
        if(!draw) {
            throw new EmptyDrawableException("no polygon drawn", last);
        }
    }

    /**
     * Method for getting all polygons with entered color
     * @param color Instance of class Color
     * @return returns set of polygons with parameter color
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        Set<Polygon> polygons = new HashSet<>();
        for(ColoredPolygon i : canvas) {
            if(i.getColor() == color) {
                polygons.add(i.getPolygon());
            }
        }
        return polygons;
        //return canvas.stream().filter((p)->p.getColor()==color).map(p->p.getPolygon()).collect(Collectors.toSet());
    }
}
