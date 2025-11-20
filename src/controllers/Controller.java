package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private Person[] persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.persons = new Person[0]; // inicializa vacío
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            int option = view.showMenu();
            switch (option) {
                case 1 -> inputPersons();
                case 2 -> view.displayPersons(persons);
                case 3 -> sortPersons();
                case 4 -> searchPerson();
                case 0 -> exit = true; // salir del bucle
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    public void inputPersons() {
        System.out.print("¿Cuántas personas desea ingresar?: ");
        int n = new java.util.Scanner(System.in).nextInt(); 
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = view.inputPerson();
        }
    }

    public void sortPersons() {
        if (persons.length == 0) {
            System.out.println("No hay personas registradas.");
            return;
        }

        System.out.println("Seleccione método de ordenamiento:");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección descendente por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        int method = new java.util.Scanner(System.in).nextInt();

        switch (method) {
            case 1 -> sortingMethods.sortByNameWithBubble(persons);
            case 2 -> sortingMethods.sortByNameWithSelectionDes(persons);
            case 3 -> sortingMethods.sortByAgeWithInsertion(persons);
            case 4 -> sortingMethods.sortByNameWithInsertion(persons);
            default -> System.out.println("Método inválido.");
        }
        view.displayPersons(persons);
    }

    public void searchPerson() {
        if (persons.length == 0) {
            System.out.println("No hay personas registradas.");
            return;
        }

        int criterion = view.selectSearchCriterion();
        Person result = null;

        switch (criterion) {
            case 1 -> { 
                if (!searchMethods.isSortedByAge(persons)) {
                    sortingMethods.sortByAgeWithInsertion(persons);
                }
                int age = view.inputAge();
                result = searchMethods.binarySearchByAge(persons, age);
            }
            case 2 -> { 
                if (!searchMethods.isSortedByName(persons)) {
                    sortingMethods.sortByNameWithBubble(persons);
                }
                String name = view.inputName();
                result = searchMethods.binarySearchByName(persons, name);
            }
            default -> System.out.println("Criterio inválido.");
        }

        view.displaySearchResult(result);
    }
}