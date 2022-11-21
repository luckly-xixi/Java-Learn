package USB;

public class TestUsb {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.powerOn();

        //使用鼠标设备
        computer.useDevice(new Mouse());

        //使用键盘
        computer.useDevice(new KeyBoard());

        computer.powerOff();
    }
}
