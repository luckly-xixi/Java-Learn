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


  public class class9 {

        public static void main1(String[] args) {
//            Apple apple = new Apple();
//            Banana banana = new Banana();

            Fruit[] fruit = {new Apple(),new Banana()};
            for (Fruit fruit1:fruit) {
                fruit1.name();
            }
        }

    }
