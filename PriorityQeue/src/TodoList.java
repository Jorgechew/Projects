import java.util.PriorityQueue;

public class TodoList {

    PriorityQueue <TodoList> list;    // usar genericos  String description, importanceLevel, int pri

    private String taskDescription;
    private int priority;

    public TodoList(Importance importance, int priorityLevel, String taskDescription){
        this.priority=priorityLevel;
        this.taskDescription=taskDescription;

    }


    enum Importance{
        LOW,
        MEDIUM,
        HIGH;
    }
}