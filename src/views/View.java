package views;

import java.util.Scanner;
import models.Person;

public class View {

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Ordenar personas");
        System.out.println("4. Buscar persona");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.println("Ingrese nombre: ");
        String name = scanner.next();
        System.out.println("Ingrese edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int selectSearchCriterion() {
        System.out.println("Seleccione criterio de búsqueda: ");
        System.out.println("1. Buscar por edad");
        System.out.println("2. Buscar por nombre");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        System.out.println("===== LISTA DE PERSONAS =====");
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("No se encontró la persona.");
        }
    }

    public int inputAge() {
        System.out.print("Ingrese edad a buscar: ");
        return scanner.nextInt();
    }

    public String inputName() {
        System.out.print("Ingrese nombre a buscar: ");
        return scanner.next();
    }
}
