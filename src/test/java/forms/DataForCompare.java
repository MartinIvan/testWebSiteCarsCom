package forms;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataForCompare {



    private static List<String>firstCharacteristics=new ArrayList<>();
    private static List<String>secondCharacteristics=new ArrayList<>();


    public static void setFirstcharacteristics(List<WebElement>list){
        for(WebElement x:list){
            firstCharacteristics.add(x.getText());
        }

    }

    public static List<String> getFirstCharacteristics() {
        return firstCharacteristics;
    }
    public static void setSecondCharacteristics(List<WebElement>list){
        for(WebElement x:list){
            secondCharacteristics.add(x.getText());
        }

    }

    public static List<String> getSecondCharacteristics() {
        return secondCharacteristics;
    }

    public static String getEngine(List<String>list){
        for(String element: list){
            if(element.contains("Engine")){

                return element.replace("Engine: ","");
            }
        }
        return "—";
    }
    public static String getMileage(List<String>list){
        for(String element: list){
            if(element.contains("Mileage")){

                return element.replace("Mileage: ","").replace(",","");
            }
        }
        return "—";
    }
    public static String getTransmission(List<String>list){
        for(String element: list){
            if(element.contains("Transmission")){

                return element.replace("Transmission: ","");
            }
        }
        return "—";
    }
    public static String getFuel(List<String>list){
        for(String element: list){
            if(element.contains("Fuel")){

                return element.replace("Fuel Type: ","");
            }
        }
        return "—";
    }
    public static String getExteriorColor(List<String>list){
        for(String element: list){
            if(element.contains("Exterior Color")){

                return element.replace("Exterior Color: ","");
            }
        }
        return "—";
    }
    public String getInteriorColor(List<String>list){
        for(String element: list){
            if(element.contains("Interior Color")){

                return element.replace("Interior Color: ","");
            }
        }
        return "—";
    }

}
