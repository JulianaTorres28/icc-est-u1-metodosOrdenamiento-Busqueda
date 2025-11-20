package controllers;

import models.Person;

public class SearchMethods {
    public Person binarySearchByAge(Person[] persons, int valor) {
        int izquierda = 0;
        int derecha = persons.length - 1;

        while (izquierda <= derecha) {
            int medio = (derecha + izquierda) / 2;
            if (persons[medio].getAge() == valor) {
                return persons[medio];
            }

            if (persons[medio].getAge() < valor) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person[] persons, String valor) {
        int izquierda = 0;
        int derecha = persons.length - 1;
        while (izquierda <= derecha) {
            int medio = (derecha + izquierda) / 2;
            int comparacion = persons[medio].getName().compareTo(valor);

            if (comparacion == 0) {
                return persons[medio];
            }

            if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }

        }
        return null;
    }

    public boolean isSortedByAge(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getAge() > persons[i + 1].getAge()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByName(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getName().compareTo(persons[i + 1].getName()) > 0) {
                return false;
            }
        }
        return true;
    }
}
