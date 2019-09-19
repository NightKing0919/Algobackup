import java.time.LocalTime;

public class expedia3 {
    public static void main(String[] args) throws Exception {
        LocalTime time = LocalTime.parse("09:45");
        LocalTime timee = LocalTime.parse("09:45");

        System.out.println(time.equals(timee));
    }
}
