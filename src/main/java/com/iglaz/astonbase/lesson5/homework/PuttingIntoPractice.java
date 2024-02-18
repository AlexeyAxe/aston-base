package com.iglaz.astonbase.lesson5.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> transactions2011 = transactions.stream()
                .filter(s -> s.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        System.out.println(transactions2011);

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> cityTrader = transactions.stream()
                .map(s -> s.getTrader().getCity())
                .distinct().toList();
        System.out.println(cityTrader);

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> x.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println(traders);

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        List<String> nameTraders = transactions.stream()
                .map(s -> s.getTrader().getName())
                .distinct()
                .sorted()
                .toList();
        System.out.println(nameTraders);

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        Boolean isTraderFromMilan = transactions.stream()
                .anyMatch(s -> s.getTrader().getCity().equals("Milan"));
        System.out.println(isTraderFromMilan);

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        List<Integer> sumTransactionFromCambridge = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();
        System.out.println(sumTransactionFromCambridge);

        //7. Какова максимальная сумма среди всех транзакций?
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .orElse(null);
        System.out.println(max);

        //8. Найти транзакцию с минимальной суммой.
                Transaction min = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElse(null);
        System.out.println(min);
    }
}
