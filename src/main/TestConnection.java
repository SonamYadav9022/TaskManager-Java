package main;

import dao.TaskDAO;
import model.Task;

public class TestConnection {
    public static void main(String[] args) {

        TaskDAO dao = new TaskDAO();

        dao.deleteTask(1);
    }
}