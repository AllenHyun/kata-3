package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;

public class MockBarchartLoader implements BarchartLoader{
    @Override
    public Barchart load(int id) {
        return switch (id){
            case 0 -> barchart0();
            case 1 -> barchart1();
            default -> null;
        };
    }

    private Barchart barchart1() {
        Barchart barchart = new Barchart("title 2", "x", "y");
        barchart.put("A", 18);
        barchart.put("B", 14);
        barchart.put("C", 12);
        return barchart;
    }

    private Barchart barchart0() {
        Barchart barchart = new Barchart("title 1", "x", "y");
        barchart.put("X", 40);
        barchart.put("Y", 60);
        barchart.put("Z", 55);
        return barchart;
    }


}
