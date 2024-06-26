package smartbox;
import mvc.*;

public class ContainerFactory implements AppFactory {
    public Model makeModel() {
        return new Container();
    }

    public View makeView(Model m) {
        return new ContainerView(m);
    }

    public String[] getEditCommands() {
        return new String[] {"Add", "Rem", "Run"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        String componentName = (String) source;
        switch (type) {
            case "Add":
                return new AddCommand(model, componentName);
            case "Rem":
                return new RemCommand(model, componentName);
            case "Run":
                return new RunCommand(model, componentName);
        }
        return null;
    }

    public String getTitle() {
        return "SmartBox";
    }

    public String[] getHelp() {
        return new String[] {"Container", "Add a component", "Remove a component", "Run a component"};
    }

    public String about() {
        return "SmartBox by Brandon Nguyen";
    }
}
