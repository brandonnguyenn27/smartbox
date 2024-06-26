package smartbox;
import mvc.*;

import javax.swing.*;

public class RunCommand extends Command {
    private Model model;
    private String componentName;
    public RunCommand(Model model, String componentName) {
        super(model);
        this.componentName = componentName;
        this.model = model;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).launch(componentName);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Component not found");
                e.printStackTrace();
            }
        }
    }
}
