package app.bastiannolte.examples.jee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TodoService {

    @PersistenceContext(unitName = "TodolistPersistenceUnit")
    EntityManager entityManager;

    public List liefereAlleTodos() {
        return entityManager.createQuery("select t from Todo t order by t.erstelltAm").getResultList();
    }

    public Todo liefereTodoMitUuid(UUID uuid) {
        return entityManager.find(Todo.class, uuid);
    }

    public Todo erstelleTodo(String text) {
        Todo todo = Todo.createTodo(text);
        entityManager.persist(todo);
        return todo;
    }
}
