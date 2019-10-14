package app.bastiannolte.examples.jee;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

@DisplayName("Der TodoService sollte…")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TodoServiceTest {

    private TodoService todoService;
    private EntityManager mockedEntityManager;

    @BeforeAll
    void init() {
        todoService = new TodoService();
        mockedEntityManager = mock(EntityManager.class, RETURNS_DEEP_STUBS);
        todoService.entityManager = mockedEntityManager;
    }

    @Test
    void liefereAlleTodos() {

    }

    @Test
    void liefereTodoMitUuid() {
    }

    @Test
    void erstelleTodo() {
        // prepare
        final String text = "Neue Filmmusik schreiben.";
        final Todo savedTodo = todoService.erstelleTodo(text);

        // check
        ArgumentCaptor<Todo> argumentCaptor = ArgumentCaptor.forClass(Todo.class);
        verify(mockedEntityManager, times(1)).persist(argumentCaptor.capture());
        Todo persistedTodo = argumentCaptor.getValue().clone();

        assertThat("Der übergebene Text sollte unverändert gespeichert werden.", persistedTodo.getText(), is(equalTo(text)));
        assertThat("Der Member UUID sollte nicht null sein.", persistedTodo.getUuid(), notNullValue());
        assertThat("Das zurückgegebene Todo sollte gleich dem persistierten Objekt sein.", persistedTodo, is(savedTodo.clone()));

    }
}
