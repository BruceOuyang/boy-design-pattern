package bugmakers.club.dp.creational.seq1.simplefactory.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/2 10:59
 */
public class ShapeFactory {

    private static final String SQUARE = "square";
    private static final String CIRCLE = "circle";
    private static final String TRIANGLE = "triangle";

    public static Shape createShape(String type){
        Shape shape = null;

        if(SQUARE.equalsIgnoreCase(type)){
            shape = new SquareShape();
            System.out.println("初始化方形");
        }
        else if(CIRCLE.equalsIgnoreCase(type)){
            shape = new CircleShape();
            System.out.println("初始化圆形");

        }
        else if(TRIANGLE.equalsIgnoreCase(type)){
            shape = new TriangleShape();
            System.out.println("初始化三角形");
        }
        else{
            throw new UnSupportedShapeException(type);
        }
        return shape;
    }
}
