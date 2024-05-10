package smartbox;
import mvc.*;

import javax.swing.*;

public class AddCommand extends Command {
    private Model model;
    private String componentName;
    public AddCommand(Model model, String componentName) {
        super(model);
        this.componentName = componentName;
        this.model = model;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).addComponent(componentName);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Component not found");
                e.printStackTrace();
            }
        }
    }
}
