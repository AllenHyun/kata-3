package software.ulpgc.kata3.architecture.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final Map<String, Integer> count;

    private final String title;
    private final String xAxis;
    private final String yAxis;

    public Barchart(String title, String xAxis, String yAxis) {
        this.count =  new HashMap<>();
        this.title = title;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public String getTitle() {
        return title;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public int get(String category){
        return count.get(category);
    }

    public void put(String category, int value){
        count.put(category, value);
    }
    public Set<String> keySet(){
        return count.keySet();
    }
}
