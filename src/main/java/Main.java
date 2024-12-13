import aspects.Log;
import aspects.SecuredBy;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.secureMethod();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
    @SecuredBy(roles = {})
    public void secureMethod() {
        System.out.println("Secure method executed");
    }
}
