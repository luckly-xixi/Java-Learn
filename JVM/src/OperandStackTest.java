public class OperandStackTest {

    public void testAddOperation() {
        byte i = 15;
        int j = 8;
        int k = i + j;
    }


    public void add() {
        // 第1类
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;

        // 第2类
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;

        // 第3类
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        // 第4类
        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}
