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
        String input = JOptionPane.showInputDialog("Enter component name:");
        String actionCommand = e.getActionCommand();
        Command cmd = null;
        if (input != null) {
            switch (actionCommand) {
                case "Add":
                    cmd = factory.makeEditCommand(model, "Add", input);
                    try {
                        components.add(input); // add to list of components
                        ((Container) model).addComponent(input); // add to container
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Add");
                    break;
                case "Rem":
                    cmd = factory.makeEditCommand(model, "Rem", input);
                    try {
                        components.remove(input); // remove from list of components
                        ((Container) model).remComponent(input); // remove from container
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "Run":
                    cmd = factory.makeEditCommand(model, "Run", input);
                    try {
                        ((Container) model).launch(input);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                default:
                    super.actionPerformed(e);
            }
            cmd.execute();
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
