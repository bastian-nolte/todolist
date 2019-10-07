package app.bastiannolte.examples.jee;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
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
        verify(mockedEntityManager, times(1)).persist(isA(Todo.class));

        assertThat(savedTodo, Matchers.notNullValue());

        assertThat("Der übergebene Text sollte unverändert gespeichert werden.", savedTodo.getText(), Matchers.equalTo(text));
        assertThat("Der Member UUID sollte nicht null sein.", savedTodo.getUuid(), Matchers.notNullValue());
        assertThat("Es sollte eine gültige UUID erzeugt worden sein.", savedTodo.getUuid().toString(), StringMatchesUUIDPattern.matchesThePatternOfAUUID());

    }
}
