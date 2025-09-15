package Task1;

public class TestCylinder {
    public static void main(String[] args) {
        
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder 1:"
            + " radius=" + c1.getRadius() 
            + " height=" + c1.getHeight() 
            + " surface area=" + c1.getArea() 
            + " volume=" + c1.getVolume()); 

        
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder 2:"
            + " radius=" + c2.getRadius() 
            + " height=" + c2.getHeight() 
            + " surface area=" + c2.getArea() 
            + " volume=" + c2.getVolume()); 

        
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder 3:"
            + " radius=" + c3.getRadius() 
            + " height=" + c3.getHeight() 
            + " surface area=" + c3.getArea() 
            + " volume=" + c3.getVolume()); 
            System.out.println(c1.toString());
            System.out.println(c2); 
            System.out.println(c3);
    }
}