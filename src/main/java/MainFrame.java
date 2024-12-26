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
        this.commands = new HashMap<>();
        this.setTitle("Kata 3 por mcv");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(barchartDisplay = staticPanel());
    }

    private JFreeBarchartDisplay staticPanel() {
        return new JFreeBarchartDisplay();
    }

    private Component toolbar() {
        JPanel jPanel = new JPanel();
        jPanel.add(toggle());
        jPanel.add(selector());
        return jPanel;
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

    private Component selector() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Chart 1");
        comboBox.addItem("Chart 2");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED){
                    return;
                }
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



    public void put(String name, Command command){
        commands.put(name, command);
    }

    public BarchartDisplay barchartDisplay(){
        return barchartDisplay;
    }
    public SelectStaticDialog selectStaticDialog(){
        return selectStaticDialog;
    }

}
