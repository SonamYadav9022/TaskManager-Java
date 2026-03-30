package dao;

import model.Task;
import util.DBConnection;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TaskDAO {

    // INSERT TASK
    public void addTask(Task task) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO tasks (title, status, priority) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getStatus());
            ps.setString(3, task.getPriority());

            ps.executeUpdate();

            System.out.println("Task added successfully ✅");

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllTasks() {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM tasks";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String status = rs.getString("status");
                String priority = rs.getString("priority");

                System.out.println(id + " | " + title + " | " + status + " | " + priority);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void updateTaskStatus(int id, String newStatus) {
            try {
                Connection conn = DBConnection.getConnection();

                String query = "UPDATE tasks SET status = ? WHERE id = ?";

                PreparedStatement ps = conn.prepareStatement(query);

                ps.setString(1, newStatus);
                ps.setInt(2, id);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Task updated successfully ✅");
                } else {
                    System.out.println("Task not found ❌");
                }
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void deleteTask(int id) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "DELETE FROM tasks WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Task deleted successfully ✅");
            } else {
                System.out.println("Task not found ❌");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
