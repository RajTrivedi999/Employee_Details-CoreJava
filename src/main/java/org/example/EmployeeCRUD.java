package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private String name;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

public class EmployeeCRUD {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("SELECT ANY NUMBER");
            System.out.println("1. DISPLAY");
            System.out.println("2. CREATE");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. SORT");
            System.out.println("6. EXIT");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    display(employees);
                    break;
                case 2:
                    create(employees,sc);
                    break;
                case 3:
                    update(employees,sc);
                    break;
                case 4:
                    delete(employees,sc);
                    break;
                case 5:
                    sort(employees,sc);
                    break;
                case 6:
                    System.out.println("Thank you...");
                    break;
                default:
                    System.out.println("Please Enter Valid Number.");
            }
        } while (choice != 6);
    }

    private static void display(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.println("Employee Details:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void create(List<Employee> employees, Scanner sc) {
        System.out.print("name: ");
        String name = sc.nextLine();
        System.out.print("gender: ");
        String gender = sc.nextLine();
        System.out.print("date of birth: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("email: ");
        String email = sc.nextLine();
        System.out.print("phone: ");
        String phone = sc.nextLine();

        Employee employee = new Employee(name, gender, dateOfBirth, email, phone);
        employees.add(employee);
        System.out.println("Employee added!");
    }

    private static void update(List<Employee> employees, Scanner sc) {
        try{
            if (employees.isEmpty()) {
                System.out.println("No employees found!");
            } else {
                System.out.print("Employee name to update: ");
                String name = sc.nextLine();

                boolean flag = false;
                for (Employee employee : employees) {
                    if (employee.getName().equals(name)) {
                        System.out.print("gender: ");
                        String gender = sc.nextLine();
                        System.out.print("date of birth: ");
                        String dateOfBirth = sc.nextLine();
                        System.out.print("email: ");
                        String email = sc.nextLine();
                        System.out.print("phone: ");
                        String phone = sc.nextLine();

                        employee.setGender(gender);
                        employee.setDateOfBirth(dateOfBirth);
                        employee.setEmail(email);
                        employee.setPhone(phone);

                        System.out.println("Employee updated!");
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    System.out.println("Employee not found!");
                }
            }
        } catch (Exception e){
            System.out.println("Something went wrong. Enter proper data!!!");
        }
    }

    private static void delete(List<Employee> employees, Scanner sc) {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.print("Employee name to delete: ");
            String name = sc.nextLine();
            boolean flag=false;

            for(Employee employee : employees){
                if(name.equals(employee.getName())){
                    employees.remove(employee);
                    System.out.println("Employee deleted!");
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                System.out.println("Employee not found!");
            }
        }
    }

    private static void sort(List<Employee> employees, Scanner sc) {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.println("Sort by name");
            Collections.sort(employees, Comparator.comparing(Employee::getName));
            System.out.println("Sorted successfully!");
            display(employees);
        }
    }
}

