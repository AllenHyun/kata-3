package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.view.BarchartDisplay;
import software.ulpgc.kata3.architecture.control.Command;
import software.ulpgc.kata3.architecture.view.SelectStaticDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private JFreeBarchartDisplay barchartDisplay;
    private SelectStaticDialog selectStaticDialog;

    public MainFrame() throws HeadlessException {
        this.setTitle("Kata 3");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(barchartDisplay = statisticPanel());
        this.commands = new HashMap<>();
    }

    public void put(String name, Command command) {
        commands.put(name, command);
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(toggle());
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Chart 1");
        comboBox.addItem("Chart 2");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                commands.get("select").execute();
            }
        });
        selectStaticDialog = new SelectStaticDialog() {
            @Override
            public int getSelection() {
                return comboBox.getSelectedIndex();
            }
        };
        return comboBox;
    }

    private JButton toggle() {

        JButton button = new JButton("toggle");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("toggle").execute();
            }
        });
        return button;
    }

    private JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }


    public BarchartDisplay barchartDisplay() {
        return barchartDisplay;
    }

    public SelectStaticDialog selectStaticDialog() {
        return selectStaticDialog();
    }
}

