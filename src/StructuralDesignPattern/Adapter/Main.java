package StructuralDesignPattern.Adapter;

import java.awt.geom.RoundRectangle2D;

public class Main {
    static class RoundHole{
        private double radius;
        public RoundHole(double radius){
            this.radius=radius;
        }

        public double getRadius() {
            return radius;
        }
        public boolean fits(RoundPeg peg){
            boolean result;
            result=(this.getRadius()>=peg.getRadius());
            return result;
        }
    }
    static class RoundPeg{
        private double radius;
        public RoundPeg(){};
        public RoundPeg(double radius){
            this.radius=radius;
        }
        public double getRadius(){
            return radius;
        }
    }
    public static class SquarePeg{
        private double width;
        SquarePeg(double width){
            this.width=width;
        }
        public double getWidth(){
            return width;
        }
        public double getSquare(){
            double result=0;
            result=Math.pow(this.width,2);
            return  result;
        }

    }
    public static class SquarePegAdapter extends RoundPeg{
        private SquarePeg peg;
        public SquarePegAdapter(SquarePeg peg){
            this.peg=peg;
        }
        @Override
        public double getRadius(){
            double result;
            // Calculate a minimum circle radius, which can fit this peg.
            result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
            return result;
        }


    }

    public static void main(String[] args) {
        RoundHole hole=new RoundHole(5);
        RoundPeg rPeg=new RoundPeg(5);
        if(hole.fits(rPeg)){
            System.out.println("fits rPeg");
        }
        SquarePeg smallSqPeg=new SquarePeg(2);
        SquarePeg largeSqPeg=new SquarePeg(20);
        SquarePegAdapter smallSqPegAdapter=new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter=new SquarePegAdapter(smallSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }


    }
}
