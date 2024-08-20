package jalase11.model.utils;

import java.util.regex.Pattern;

public class Validation {
    public String nameValidator(String name) throws Exception {
        if(Pattern.matches("^[a-zA-Z\\s]{3,30}$", name)){
            return name;
        }else{
            throw new Exception("Invalid Name");
        }
    }

    public String priceValidator(String price) throws Exception {
            if(Pattern.matches("^[100-90000\\s]{3,5}$", price)){
                return price;
            }else{
            throw new Exception("Invalid Price");
        }
    }
}
