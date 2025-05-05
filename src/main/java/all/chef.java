package all;

import java.util.ArrayList;
import java.util.List;

public class chef extends Person {

    private String expertise; // e.g., "grilling", "vegan"
    private List<String> assignedTasks = new ArrayList<>();

    public chef(String userName, String expertise, String pass, String role) {
        super(userName,pass,role);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public List<String> getAssignedTasks() {
        return assignedTasks;
    }

    public void assignTask(String task) {
        assignedTasks.add(task);
        System.out.println("🔔 Task assigned to " + userName + ": " + task);
    }

    public int getTaskCount() {
        return assignedTasks.size();
    }
}
