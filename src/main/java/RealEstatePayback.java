import java.util.Scanner;

public class RealEstatePayback {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите стоимость недвижимости: ");
        float propertyPrice = sc.nextFloat();

        System.out.println("Введите стоимость аренды за месяц: ");
        float monthlyRent = sc.nextFloat();

        System.out.println("Введите годовую индексацию (%): ");
        float yearlyIndexation = sc.nextFloat();

        float totalEarned = 0;
        int month = 0;

        while (totalEarned < propertyPrice){
            month++;
            totalEarned += monthlyRent;

            if (month % 12 == 0) {
                monthlyRent += monthlyRent * (yearlyIndexation / 100);
            }
        }

        System.out.println("Зaработали: " + totalEarned + " рублей за " + month + " месяцев");
        System.out.println();
    }
}