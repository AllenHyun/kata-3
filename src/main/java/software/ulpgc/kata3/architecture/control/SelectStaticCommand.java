package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.view.BarchartDisplay;
import software.ulpgc.kata3.architecture.io.BarchartLoader;
import software.ulpgc.kata3.architecture.view.SelectStaticDialog;

public class SelectStaticCommand implements Command{
    private final SelectStaticDialog dialog;
    private final BarchartLoader loader;
    private final BarchartDisplay display;

    public SelectStaticCommand(SelectStaticDialog dialog, BarchartLoader loader, BarchartDisplay display) {
        this.dialog = dialog;
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(loader.load(dialog.getSelection()));
    }
}

