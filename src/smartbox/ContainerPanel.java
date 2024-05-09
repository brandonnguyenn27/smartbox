package smartbox;
import java.awt.GridLayout;


import javax.swing.*;
import mvc.*;
import java.awt.event.ActionEvent;

public class ContainerPanel extends AppPanel {
    java.awt.List components;
    public ContainerPanel(AppFactory factory) {
        super(factory);

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
        if (input != null) {
            Command cmd;
            switch (actionCommand) {
                case "Add":
                    cmd = factory.makeEditCommand(model, "Add", input);
                    System.out.println("Add");
                    break;
                case "Rem":
                    cmd = factory.makeEditCommand(model, "Rem", input);
                    break;
                case "Run":
                    cmd = factory.makeEditCommand(model, "Run", input);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + actionCommand);
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
