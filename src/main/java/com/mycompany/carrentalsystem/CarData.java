package com.mycompany.carrentalsystem;

public class CarData 
{
    public void cars()
    {
        CarInfo car1 = new CarInfo();
        car1.carBrand = "Honda";
        car1.carTransmission = "Automatic";
        car1.carModel = "Civic";
        car1.carRentStatus = true;
        CarLibrary.addCar(car1);
        
    }
    
}
