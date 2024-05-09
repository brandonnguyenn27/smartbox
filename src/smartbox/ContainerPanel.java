package smartbox;
import java.awt.*;


import javax.swing.*;
import mvc.*;
import java.awt.event.ActionEvent;

public class ContainerPanel extends AppPanel {
    java.awt.List components;
    public ContainerPanel(AppFactory factory) {
        super(factory);
        components = new java.awt.List(10);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        controlPanel.add(addButton);
        JButton remButton = new JButton("Rem");
        remButton.addActionListener(this);
        controlPanel.add(remButton);
        JButton runButton = new JButton("Run");
        runButton.addActionListener(this);
        controlPanel.add(runButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        Command cmd;
        String input;
            switch (actionCommand) {
                case "Add":
                    input = JOptionPane.showInputDialog("Enter component name:");
                    cmd = factory.makeEditCommand(model, "Add", input);
                    try {
                        components.add(input); // add to list of components
                        cmd.execute();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "Rem":
                    input = JOptionPane.showInputDialog("Enter component name:");
                    cmd = factory.makeEditCommand(model, "Rem", input);
                    try {
                        components.remove(input); // remove from list of components
                        cmd.execute();

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "Run":
                    input = JOptionPane.showInputDialog("Enter component name:");

                    cmd = factory.makeEditCommand(model, "Run", input);
                    try {
                        cmd.execute();

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                default:
                    super.actionPerformed(e);

        }
    }

    // this override needed to re-initialize component fields table:
    public void setModel(Model m) {
        super.setModel(m);
        ((Container) m).initContainer(); // restore fields of components
    }

    public static void main(String[] args) {
        AppPanel panel = new ContainerPanel(new ContainerFactory());
        panel.display();
    }
}
