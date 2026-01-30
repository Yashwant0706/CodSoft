import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    // Method to fetch exchange rate WITHOUT JSON library
    public static double getExchangeRate(String base, String target) {
        try {
            String apiURL = "https://api.exchangerate-api.com/v4/latest/" + base;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            String data = response.toString();

            // Find target currency rate manually
            String search = "\"" + target + "\":";
            int index = data.indexOf(search);

            if (index == -1) {
                return -1;
            }

            int start = index + search.length();
            int end = data.indexOf(",", start);

            return Double.parseDouble(data.substring(start, end));

        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base currency (USD, INR, EUR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter target currency (USD, INR, EUR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        double rate = getExchangeRate(base, target);

        if (rate == -1) {
            System.out.println("Currency not supported or API error.");
            return;
        }

        double result = amount * rate;

        System.out.println("\n----- Conversion Result -----");
        System.out.println(amount + " " + base + " = " + result + " " + target);

        sc.close();
    }
}