package smartbox;
import mvc.*;
public class AddCommand extends Command {
    private Model model;
    private Component cmp;

    public AddCommand(Model model, Object source) {
        super(model);
        this.cmp = (Component)source; // this is wrong?
        this.model = model;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).addComponent(cmp.name); //component has name field, use it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
