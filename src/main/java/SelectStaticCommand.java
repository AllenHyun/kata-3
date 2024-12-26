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

