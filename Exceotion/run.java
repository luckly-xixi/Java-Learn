package Exceotion;

public class run {

    public String name = "admin";
    public String passWord = "123456";

    public  void loginInfo(String name,String passWord)throws UnsupportedOperationException,
            PassWordException{

        if(!this.name.equals(name)){
//            System.out.println("用户名错误");
//            throw new UnsupportedOperationException();
            throw new UnsupportedOperationException("小黑子，你用户名错了");
        }
        if(!this.passWord.equals(passWord)){
//            System.out.println("密码错误");
//            throw new PassWordException();
            throw new PassWordException("小黑子，你密码错了");
        }
        System.out.println("登录成功");
    }

    public static void main(String[] args) {

        run run = new run();
        try{
            run.loginInfo("admin","12456");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
            System.out.println("用户名异常");
        } catch (PassWordException e){
            e.printStackTrace();
            System.out.println("密码异常");
        }finally {
            System.out.println("关闭相关资源");
        }
    }
}
