package std;

import java.util.*;

public class IOU {
    HashMap<String, Double> iou = new HashMap<>();

    public void setSum(String toWhom, double amount) {
        iou.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return iou.get(toWhom);
    }
}
