public class VolumeShape{
    private double resultCuboid;
    private double resultCube;
    private double resultCylinder;
    private double resultCone;
    private double resultSphere;
    private double resultHemisphere;

    public VolumeShape(String welcomeMessage){
        System.out.println(welcomeMessage);
    }
    public double surfaceAreaCuboid(double base, double height, double length){
        resultCuboid = 2*(length*base + base*height+length*height);
        return resultCuboid;
    }
    public double surfaceAreaCube(double side){
        resultCube = 6*side*side;
        return resultCube;
    }

    public double surfaceAreaCylinder(double radius, double height){
        resultCylinder = 2*Math.PI*radius*(radius+height);
        return resultCylinder;
    }
    public double surfaceAreaCone(double l, double radius){
        resultCone = Math.PI*radius*(radius+l);
        return resultCone;
    }
    public double surfaceAreaSphere(double radius){
        resultSphere = 4*Math.PI*radius*radius;
        return resultSphere;
    }
    public double surfaceAreaHemisphere(double radius){
        resultHemisphere = 3*Math.PI*radius*radius;
        return resultHemisphere;
    }

}