package org.example;
import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques Map: " + findUniques(employees));
        System.out.println("Removed duplicates: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        for (Employee e : list) {
            if (e == null) continue;
            if (!seen.add(e.getId()) && added.add(e.getId())) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (Employee e : list) {
            if (e == null) continue;
            if (!seen.add(e.getId())) {
                map.put(e.getId(), e);
            } else {
                map.putIfAbsent(e.getId(), e);
            }
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Employee e : list) {
            if (e == null) continue;
            if (countMap.get(e.getId()) == 1) {
                result.add(e);
            }
        }
        return result;
    }
}