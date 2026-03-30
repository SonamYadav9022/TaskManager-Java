package main;

import dao.TaskDAO;
import model.Task;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskDAO dao = new TaskDAO();

        while (true) {
            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter status: ");
                    String status = sc.nextLine();

                    System.out.print("Enter priority: ");
                    String priority = sc.nextLine();

                    Task task = new Task(0, title, status, priority);
                    dao.addTask(task);
                    break;

                case 2:
                    dao.getAllTasks();
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new status: ");
                    String newStatus = sc.nextLine();

                    dao.updateTaskStatus(id, newStatus);
                    break;

                case 4:
                    System.out.print("Enter task ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting... 👋");
                    return;

                default:
                    System.out.println("Invalid choice ❌");
            }
        }
    }
}