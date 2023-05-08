public abstract class Task {
    private int priority;
    private String name;

    public Task(String name) {
        this.name = name;
        this.priority = 2;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
