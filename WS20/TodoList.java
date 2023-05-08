import java.util.ArrayList;
import java.util.List;

public class TodoList<T extends Task>{
    private List<T> list = new ArrayList<>();

    public TodoList() {

    }

    public List<T> getList() {
        return list;
    }

    public T getTaskAt(int n){
        return list.get(n);
    }
    public void insertTask(T task){
        this.list.add(task);
    }

    //TodoList<T extends Task> => T extends Task wenn TodoList als Parameter
    public static <T extends Task > void printTodoList(TodoList<T> tdlst){
        for(T task : tdlst.getList()){
            System.out.println(task.getName());
        }

    }
    public void takeFrom(TodoList <? extends T> other){
        for (var item : other.list)
            this.list.add(item);
    }

    public void moveTo(TodoList<? super T> other){
        for (var item : list)
            other.list.add(item);
    }
    //bezüglich natürlicher ordnung ==> Comparable
    public static <T extends Comparable <T>> T min(T[] xs){
        T max = null;
        for(T t : xs){
            if(max == null)max = t;
            if(max.compareTo(t)< 0)max = t;
        }
        return max;
    }


}
