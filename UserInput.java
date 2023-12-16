import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInput {
    private DateTimeFormatter dateFormatter1;
    private DateTimeFormatter dateFormatter2;

    double income = 0.0;
    double expense = 0.0;

    public UserInput() {
        dateFormatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateFormatter2 = DateTimeFormatter.ofPattern("MM.yyyy");
    }

    // 1. запрашивает у пользователя данные о доходах
    public double getInputIncome() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите описание дохода (или \"выход\" для выхода): ");
            String description = scanner.nextLine();

            if (description.equalsIgnoreCase("выход")) {
                break;
            }

            System.out.print("Введите сумму: ");
            double amount = Double.parseDouble(scanner.nextLine());

            income += amount;
            saveEntry(description, amount);

        }
        monthlyTotals(income);
        return income;
    }

    // запрашивает у пользователя данные о расходах
    public double getInputExpense() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите описание расхода (или \"выход\" для выхода): ");
            String description = scanner.nextLine();

            if (description.equalsIgnoreCase("выход")) {
                break;
            }

            System.out.print("Введите сумму: ");
            double amount = Double.parseDouble(scanner.nextLine());

            expense += amount;
            saveEntry(description, amount);

        }
        monthlyTotals(expense);
        monthlyTotalsIE(income - expense);

        return expense;

    }

    // 2. сохраняет эти данные в файл entries.txt
    private void saveEntry(String description, double amount) {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = dateFormatter1.format(currentDate);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.txt", true))) {
            writer.write(formattedDate + ", " + description + ", " + amount);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.csv", true))) {
            writer.write(formattedDate + ", " + description + ", " + amount);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.html", true))) {
            writer.write(formattedDate + ", " + description + ", " + amount);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
    }
    // 3. ежемесячный итог доходов/расходов
    public void monthlyTotals(double sum) {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = dateFormatter1.format(currentDate);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.txt", true))) {
            writer.write("Итоговая сумма за " + formattedDate + ", " + sum);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.csv", true))) {
            writer.write("Итоговая сумма за " + formattedDate + ", " + sum);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.html", true))) {
            writer.write("Итоговая сумма за " + formattedDate + ", " + sum);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
    }

    public double monthlyTotalsIE(double total) {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = dateFormatter2.format(currentDate);
        total = income - expense;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.txt", true))) {
            writer.write("Итоговая сумма (доход - расход) за " + formattedDate + ", " + total);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.csv", true))) {
            writer.write("Итоговая сумма (доход - расход) за " + formattedDate + ", " + total);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entries.html", true))) {
            writer.write("Итоговая сумма (доход - расход) за " + formattedDate + ", " + total);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записи в файл: " + e.getMessage());
        }
        return total;
    }
}
