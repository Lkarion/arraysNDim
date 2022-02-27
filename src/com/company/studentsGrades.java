package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class studentsGrades {
    public static void main(String[] args) {
        //1 Given two arrays. The first is String[n] students – names of students.
        // The second is int[n][] grades – the array of grades for student homework.
        // Every row of grades array is one student's grades (grades[k] is the grades of students[k]).
        // Note, that each student has a different number of grades. You should implement the program
        // that finds and displays the student with highest GPA and the score.
        //Example:
        //{Jack, Nick} { { 3,4,2}, {5,5,5,4} } -> Nick 4.75
        String[] students = {"Jack", "Nick", "John"};
        int[][] grades = { { 3,4,2}, {5,5,5,4}, {5,5,5,5,5,5,5,5 } };
        printHighestGPA(students,grades);
        System.out.println();
        //* In previous task you should print students sorted by GPA
        //Example:
        //{Jack, Nick, John} { { 3,5,2}, { 5,5,5,4}, {5,5,5,5,5,5,5,5 } } ->
        //John 5
        //Nick 4.75
        //Jack 3.333
        printGPA(students,grades);
    }

    private static void printHighestGPA(String[] students, int[][] grades) {
        double max = getGPA(grades[0]);
        int index = 0;
        for (int i = 1; i < grades.length; i++) {
            if (max < getGPA(grades[i])){
                max = getGPA(grades[i]);
                index=i;
            }
        }
        String gpa = String.format("%.2f",max);
        System.out.println(students[index]+" "+gpa);
    }
    public static double getGPA(int[] grades){
        double sum=0;
        for (int grade: grades) {
            sum+=grade;
        }
        return sum / grades.length;
    }

    public static void printGPA(String[] students, int[][] grades){
        ArrayList<Double> allGPA = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
         allGPA.add(getGPA(grades[i]));
        }
        while(! allGPA.isEmpty()) {
            int index = getIndexMaxGPA(allGPA);
            System.out.println(students[index] + " " + allGPA.get(index));
            allGPA.remove(index);
        }
    }

    public static int getIndexMaxGPA(ArrayList<Double> allGRA){
        double max = allGRA.get(0);
        if (allGRA.size() > 1)
            for (int i = 1; i < allGRA.size(); i++) {
                if (max < allGRA.get(i))
                    max = allGRA.get(i);
            }
        return allGRA.indexOf(max);
    }
}
