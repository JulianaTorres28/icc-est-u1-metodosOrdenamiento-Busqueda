package controllers;

import models.Person;

public class SortingMethods {
    public void sortByNameWithBubble(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getName().compareTo(persons[j + 1].getName()) > 0) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

    public void sortByNameWithSelectionDes(Person[] persons) {
        for (int i = 0; i < persons.length-1; i++) {
            int indiceMayor = i;
            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareTo(persons[indiceMayor].getName())>0) {
                    indiceMayor = j;
                }
            }

            if (i != indiceMayor) {
                Person aux = persons[indiceMayor];
                persons[indiceMayor] = persons[i];
                persons[i] = aux;
            }
        }
    }

    public void sortByAgeWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            int j = i - 1;
            Person aux = persons[i];
            while (j >= 0 && persons[j].getAge() > aux.getAge()) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = aux;
        }
    }

    public void sortByNameWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            int j = i - 1;
            Person aux = persons[i];
            while (j >= 0 && persons[j].getName().compareTo(aux.getName())>0) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = aux;
        }
    }
}
