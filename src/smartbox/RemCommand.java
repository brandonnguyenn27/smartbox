package smartbox;
import mvc.*;

import javax.swing.*;

public class RemCommand extends Command{
    private Model model;
    private String componentName;

    public RemCommand(Model model, String componentName) {
        super(model);
        this.model = model;
        this.componentName = componentName;
    }

    public void execute() {
        if (model instanceof Container) {
            try {
                ((Container) model).remComponent(componentName);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Component not found");
                e.printStackTrace();
            }
        }

    }
}
