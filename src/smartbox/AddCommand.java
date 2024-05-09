package smartbox;
import mvc.*;
public class AddCommand extends Command {
    private Model model;
    private String componentName;
    public AddCommand(Model model, String componentName) {
        super(model);
        this.model = model;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).addComponent(componentName); //component has name field, use it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
