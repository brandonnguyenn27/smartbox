package smartbox;
import mvc.*;

public class RunCommand extends Command {
    private Model model;
    private Component cmp;

    public RunCommand(Model model, Object source) {
        super(model);
        this.cmp = (Component)source;
        this.model = model;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).launch(cmp.name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
