package tvseries;

import java.util.ArrayList;
import java.util.Scanner;


class Media {
    private String title;
    private String genre;

    public Media(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

// Subclass (Child) using inheritance
class TVSeries extends Media {
    private String ageRestriction;
    private int seasons;

    public TVSeries(String title, String genre, String ageRestriction, int seasons) {
        super(title, genre);
        this.ageRestriction = ageRestriction;
        this.seasons = seasons;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nGenre: %s\nAge Restriction: %s\nSeasons: %d",
                getTitle(), getGenre(), ageRestriction, seasons);
    }
}

public class TVSeriesApp {
    private static final ArrayList<TVSeries> seriesList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> captureSeries();
                case "2" -> searchSeries();
                case "3" -> displayAllSeries();
                case "4" -> printReport();
                case "5" -> {
                    System.out.println("Exiting application...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nLATEST SERIES - 2025");
        System.out.println("---------------------------");
        System.out.println("(1) Capture a new series");
        System.out.println("(2) Search for a series");
        System.out.println("(3) Display all series");
        System.out.println("(4) Print series report");
        System.out.println("(5) Exit");
        System.out.print("Enter your choice: ");
    }

    private static void captureSeries() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter age restriction: ");
        String ageRestriction = sc.nextLine();
        System.out.print("Enter number of seasons: ");
        int seasons = Integer.parseInt(sc.nextLine());

        TVSeries series = new TVSeries(title, genre, ageRestriction, seasons);
        seriesList.add(series);
        System.out.println("Series captured successfully!");
    }

    private static void searchSeries() {
        System.out.print("Enter title to search: ");
        String searchTitle = sc.nextLine();
        boolean found = false;
        for (TVSeries s : seriesList) {
            if (s.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("\nSeries found:");
                System.out.println(s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Series not found.");
        }
    }

    private static void displayAllSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.");
        } else {
            for (TVSeries s : seriesList) {
                System.out.println(s);
                System.out.println("---------------------------");
            }
        }
    }

    private static void printReport() {
        System.out.println("\n--- SERIES REPORT ---");
        System.out.printf("%-20s %-15s %-15s %-10s%n", "Title", "Genre", "Age Restriction", "Seasons");
        System.out.println("---------------------------------------------------------------");
        for (TVSeries s : seriesList) {
            System.out.printf("%-20s %-15s %-15s %-10d%n",
                    s.getTitle(), s.getGenre(), s.getAgeRestriction(), s.getSeasons());
        }
    }
}