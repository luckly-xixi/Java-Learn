import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

//抽象类
        abstract class Fruit{

//        public void name () {
//            System.out.println("水果");
//        }
            public abstract void name();
            //如果抽象类加了abstract修饰就可以不写具体的实现方法
        }

        class Apple extends Fruit {


            @Override
            public void name () {
                System.out.println("苹果");
            }
        }

        class Banana extends Fruit {

            @Override
            public void name() {
                System.out.println("香蕉");
            }
        }

        //  接口
       /* interface IShape {

            public String name = "giao";
            public static String name2 = "giao";
            public static final String name3 = "giao";
            //接口当中的成员  默认就是public static final 类型的
            String name4 = "giao";

            void draw ();

            default public void func() {
                System.out.println("小黑子");
            }
//           IShape() {
//
//           }
        }*/

        interface IShape{

            void draw ();

            default public void func() {
                System.out.println("默认的小黑子");
            }

           static void function () {
               System.out.println("static方法");
           }
        }
    class Rects implements IShape {

           @Override
           public void draw() {
               System.out.println("矩形");
           }

           @Override
           public void func() {
               System.out.println("矩形小黑子");
           }

           }

        class Flowers implements IShape {

            @Override
            public void draw() {
                System.out.println("❀");
            }
        }
  public class class9 {

      public static void drawMap (IShape shape) {
          shape.draw();
      }

      public static void main2(String[] args) {
//          IShape iShape = new IShape() ;
          IShape shape = new Rects();//向上转型
//          Rects rects = new Rects();  //向上转型
          IShape shape1 = new Flowers();//向上转型

          drawMap(shape);
//          drawMap(rects);
          drawMap(shape1);

      }

        public static void main1(String[] args) {
//            Apple apple = new Apple();
//            Banana banana = new Banana();

            Fruit[] fruit = {new Apple(),new Banana()};
            for (Fruit fruit1:fruit) {
                fruit1.name();
            }
        }

    }
