public class main {

    public static void main(String... args){
        TodoList<ShoppingTask> shoppingTasks = new TodoList<>();
        shoppingTasks.insertTask(new ShoppingTask("Buy Milk"));
        shoppingTasks.insertTask(new ShoppingTask("Buy Bananas"));
        TodoList<Task> generalTasks = new TodoList<>();
        generalTasks.insertTask(new CleanupTask("Clean Windows"));
        generalTasks.insertTask(shoppingTasks.getTaskAt(0));

        StringTrafo hashappender = StringTrafo.appender("#").repeat(10);
        System.out.println(hashappender.transform("Simon"));

    }
}
