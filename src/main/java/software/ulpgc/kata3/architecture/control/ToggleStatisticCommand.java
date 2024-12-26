package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.view.BarchartDisplay;
import software.ulpgc.kata3.architecture.io.BarchartLoader;

public class ToggleStatisticCommand implements Command{
    private final BarchartDisplay display;
    private final BarchartLoader loader;
    private int i = 0;

    public ToggleStatisticCommand(BarchartLoader loader, BarchartDisplay display) {
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() {
        display.show(loader.load(i++ % 2));
    }
}
