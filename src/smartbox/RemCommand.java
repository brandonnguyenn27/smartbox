package smartbox;
import mvc.*;
public class RemCommand extends Command{
    private Model model;
    private Component cmp;

    public RemCommand(Model model, Object source) {
        super(model);
        this.cmp = (Component)source;
        this.model = model;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).remComponent(cmp.name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
