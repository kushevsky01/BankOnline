import BankExceptions.BankOnlineException;
import BankExceptions.BannedCardException;
import BankExceptions.InvalidCardNumberException;

import BankExceptions.LowMoneyException;
import BankExceptions.MaxMoneyException;
import BankExceptions.NullException;

import java.io.*;
import java.util.Scanner;

public class Example {

    public static void Send(String cardNumber, Double Money) throws BankOnlineException {

        String regex = "^[0-9]+$";
        if (cardNumber.length() != 16 | cardNumber.matches(regex) == false) {
            throw new InvalidCardNumberException("Неправильно введен номер карты");
        }


        Boolean isBanned = false;
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\Example\\src\\text.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (line.contentEquals(cardNumber)) {
                    isBanned = true;
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл c заблокированными картами не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");

        }
        if (isBanned) {
            throw new BannedCardException("Номер карты заблокирован");
        }
        if (Money < 0) {
            throw new LowMoneyException("Сумма должна быть больше 0 руб.");
        }
        if (Money > 50000) {
            throw new MaxMoneyException("Сумма должна не превышать 50000 руб.");
        }
        if ((cardNumber == null) | (Money == null)) {
            throw new NullException("Один из аргументов равен null");
        }
        System.out.println("Операция прошла успешно");
    }


    public static void main(String[] args) throws BankOnlineException {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите номер карты  ");
        String cardNumber = input.nextLine();
        System.out.print("Введите cумму перевода ");
        Double Money = input.nextDouble();

        try {
            Send(cardNumber, Money);
        } catch (NullException | InvalidCardNumberException | BannedCardException |
                LowMoneyException | MaxMoneyException e) {
            e.Message();

        }
    }
}

