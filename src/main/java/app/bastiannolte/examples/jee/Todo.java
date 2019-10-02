package app.bastiannolte.examples.jee;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class Todo {
    @Id
    private UUID uuid;

    @NotNull
    private ZonedDateTime erstelltAm;

    @Max(1000)
    @NotEmpty
    private String text;

    private boolean finished = false;

    static final Todo createTodo(String text) {
        final Todo todo = new Todo();
        todo.uuid = UUID.randomUUID();
        todo.erstelltAm = ZonedDateTime.now();
        todo.text = text;
        return todo;
    }
}
