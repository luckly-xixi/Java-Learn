public class creatOneTree {


        public static void main(String[] args) {
            try {
                String currentNumber = "AAAD-AAAA-AAAA";
                String nextNumber = TreeNumberGenerator.generateNextNumber(currentNumber);
                System.out.println("下一个编号：" + nextNumber);
            } catch (Exception e) {
                System.out.println("生成下一个编号出错：" + e.getMessage());
            }

        }
    }



