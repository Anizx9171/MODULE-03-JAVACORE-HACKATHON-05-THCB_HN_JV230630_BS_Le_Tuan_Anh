package ra.config;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Config {
    public static Scanner scanner(){
        return new Scanner(System.in);
    }
    public static DecimalFormat formatter = new DecimalFormat("###,###,###");
}
