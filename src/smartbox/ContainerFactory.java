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

    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Add":
                return new AddCommand(model, source);
            case "Rem":
                return new RemCommand(model, source);
            case "Run":
                return new RunCommand(model, source);
        }
        return null;
    }

    public String getTitle() {
        return "Container";
    }

    public String[] getHelp() {
        return new String[] {"Container", "Add a component", "Remove a component", "Run a component"};
    }

    public String about() {
        return "Container";
    }
}
