package tvseries;

import java.util.ArrayList;
import java.util.Scanner;

class TVSeries {
    String name;
    int ageRestriction;

    TVSeries(String name, int ageRestriction) {
        this.name = name;
        this.ageRestriction = ageRestriction;
    }

    void printDetails() {
        System.out.println("Series Name: " + name);
        System.out.println("Age Restriction: " + ageRestriction);
    }
}

public class TVSeriesManagement {
    static ArrayList<TVSeries> seriesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            displayMenu();
        }
    }

    static void displayMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025.");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> captureNewSeries();
                case 2 -> searchForSeries();
                case 3 -> updateSeriesAgeRestriction();
                case 4 -> deleteSeries();
                case 5 -> printSeriesReport();
                case 6 -> {
                    System.out.println("Exiting application.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void captureNewSeries() {
        System.out.print("Enter series name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age restriction: ");
        int ageRestriction = scanner.nextInt();
        scanner.nextLine(); 
        seriesList.add(new TVSeries(name, ageRestriction));
        System.out.println("Series added successfully.");
    }

    static void searchForSeries() {
        System.out.print("Enter series name to search: ");
        String name = scanner.nextLine();
        for (TVSeries series : seriesList) {
            if (series.name.equalsIgnoreCase(name)) {
                series.printDetails();
                return;
            }
        }
        System.out.println("Series not found.");
    }

    static void updateSeriesAgeRestriction() {
        System.out.print("Enter series name to update age restriction: ");
        String name = scanner.nextLine();
        for (TVSeries series : seriesList) {
            if (series.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new age restriction: ");
                series.ageRestriction = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Age restriction updated.");
                return;
            }
        }
        System.out.println("Series not found.");
    }

    static void deleteSeries() {
        System.out.print("Enter series name to delete: ");
        String name = scanner.nextLine();
        seriesList.removeIf(series -> series.name.equalsIgnoreCase(name));
        System.out.println("Series deleted if it existed.");
    }

    static void printSeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            System.out.println("Series Report - 2025:");
            seriesList.stream().map((TVSeries series) -> {
                series.printDetails();
                return series;
            }).forEachOrdered(_item -> {
                System.out.println();
            });
        }
    }
}