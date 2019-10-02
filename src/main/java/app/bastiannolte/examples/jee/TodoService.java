package app.bastiannolte.examples.jee;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TodoService {

    public List<Todo> liefereAlleTodos() {
//        return entityManager.createQuery("select t from Todo t order by t.erstelltAm").getResultList();
        return Collections.emptyList();
    }

    public Todo liefereTodoMitUuid(UUID uuid) {
//        return entityManager.find(Todo.class, uuid);
        return Todo.createTodo("Test 1");
    }

    public Todo erstelleTodo(String text) {
        return Todo.createTodo(text);
    }
}
