package iCET.service;

import model.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class thogakadePOS {
    private static thogakadePOS instance;
    private final List<Customer> customerList;
    private thogakadePOS(){
        customerList=new ArrayList<>();
    }

    public static thogakadePOS getInstance() {
        return null==instance? instance = new thogakadePOS() : instance;
    }


}
