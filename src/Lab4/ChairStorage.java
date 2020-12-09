package Lab4;

import Lab1.Chair;
import Lab1.Manufacturer;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChairStorage {
    List<Chair> storage;

    public ChairStorage() {
       storage = new LinkedList<>();
    }

    public void add(Chair obj){
        storage.add(obj);
    }

    public double getTotal4Legs() {
        return storage.stream()
                .filter(obj -> obj.getLegs().getNum() == 4)
                .mapToDouble(Chair::getPrice)
                .sum();
    }

    public Optional<Chair> getMaxPrice() {
        return storage.stream()
                .max(Comparator.comparing(Chair::getPrice));
    }

    public OptionalDouble averagePrice() {
        return storage.stream()
                .mapToDouble(Chair::getPrice)
                .average();
    }

    public Map<Boolean, List<Chair>> checkCondition(Predicate<Chair> condition) {
        return storage.stream()
                .collect(Collectors.partitioningBy(x -> condition.test(x)));
    }

    public String mostPopularManufacturer() {
        return storage.stream()
                .map(Chair::getProducer)
                .map(Manufacturer::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get().getKey();
    }
}
