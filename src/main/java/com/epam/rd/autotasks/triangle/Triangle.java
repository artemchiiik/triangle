package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        double one = (Math.sqrt(Math.pow((b.getX() - a.getX()),2) + pow((b.getY() - a.getY()),2)));
        double two = (Math.sqrt(Math.pow((c.getX() - b.getX()),2) + pow((c.getY() - b.getY()),2)));
        double three = (Math.sqrt(Math.pow((c.getX() - a.getX()),2) + pow((c.getY() - a.getY()),2)));

        if (((one + two) < three) || ((one + three) < two) || ((two + three) < one) ){
            throw new IllegalArgumentException();
        }

        if (((c.getX() - a.getX()) / (b.getX() - a.getX())) == ((c.getY() - a.getY()) / (b.getY() - a.getY()))){
            throw new IllegalArgumentException();
        }

        if ((a.getY() == b.getY()) && (a.getY() == c.getY())){
            throw new IllegalArgumentException();
        }

        if ((a.getX() == b.getX()) && (a.getX() == c.getX())){
            throw new IllegalArgumentException();
        }

    }

    public double area() {
        return ((Math.abs((a.getX() - c.getX()) * (b.getY() - a.getY()) - (a.getX() - b.getX()) * (c.getY() - a.getY()))) / 2);
    }

    public Point centroid(){
        return (new Point(( (a.getX() + b.getX() + c.getX()) / 3), ( (a.getY() + b.getY() + c.getY()) / 3)));
    }

}
