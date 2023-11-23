public class SwitchStatement {
    public static void main(String[] args) {

        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            // ... cases for other days ...
            default:
                dayName = "Invalid day";
        }

        System.out.println("Today is " + dayName);

    }
}
