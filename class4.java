public class class4 {


    public static void main(String[] args) {

    }

    //既能被3整除，也能被5整除，要求使用continue或者break
    public static void main1(String[] args) {
        int i = 1;
          while(i <= 100) {
              if(i % 3 == 0 && i % 5 == 0) {
                  System.out.println(i);
                  i++;
              }
              i++;
          }
    }
}
