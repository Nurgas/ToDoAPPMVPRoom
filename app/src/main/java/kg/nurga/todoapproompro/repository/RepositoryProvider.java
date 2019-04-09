package kg.nurga.todoapproompro.repository;

public class RepositoryProvider {

    private static TasksRepository tasksRepository;

    public RepositoryProvider() {

    }

    public static TasksRepository provideTasksRepository() {
        if (tasksRepository == null)
            tasksRepository = new TasksRepositoryImpl();

        return tasksRepository;
    }

}
