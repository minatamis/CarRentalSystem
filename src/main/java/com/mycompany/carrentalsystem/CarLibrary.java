package com.mycompany.carrentalsystem;
import java.util.*;

public class CarLibrary 
{
    static List<CarInfo> listOfCars = new ArrayList<CarInfo>();
    
    public static void addCar(CarInfo car)
    {
        listOfCars.add(car);
    }
    
}
