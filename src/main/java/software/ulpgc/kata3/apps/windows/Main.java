package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.io.MockBarchartLoader;
import software.ulpgc.kata3.architecture.control.SelectStaticCommand;
import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        MockBarchartLoader loader = new MockBarchartLoader();
        mainFrame.put("toggle", new ToggleStatisticCommand(loader, mainFrame.barchartDisplay()));
        mainFrame.put("select", new SelectStaticCommand(mainFrame.selectStaticDialog(), loader, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
