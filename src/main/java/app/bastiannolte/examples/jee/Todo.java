package app.bastiannolte.examples.jee;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class Todo implements Cloneable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String uuid;

    @NotNull
    private ZonedDateTime erstelltAm;

    @Max(1000)
    @NotEmpty
    private String text;

    private boolean finished = false;

    static final Todo createTodo(String text) {
        final Todo todo = new Todo();
//        todo.uuid = UUID.randomUUID();
        todo.erstelltAm = ZonedDateTime.now();
        todo.text = text;
        return todo;
    }

    public Todo clone() {
        final Todo todo = new Todo();
        todo.setUuid(this.uuid);
        todo.setErstelltAm(this.erstelltAm);
        todo.setText(this.text);
        todo.setFinished(this.finished);
        return todo;
    }
}
