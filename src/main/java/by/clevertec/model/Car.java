package by.clevertec.model;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private int id;
    private String vin;
    private String carMake;
    private String carModel;
    private int releaseYear;
    private String color;
    private Destination.Name destinationName;

    /**
     * Kilograms
     */
    private int mass;

    /**
     * Dollars ($)
     */
    private int price;
    
    public Destination.Name getDestinationName() {
    	if (this.destinationName != null) return this.destinationName;
    	
    	if(this.getCarModel().equals("Jaguar") || this.getColor().equals("White")) {
    		return Destination.Name.TURKMENISTAN;
    	} else if(this.getMass() < 1500 
    			&& (this.getCarModel().equals("BMW")||this.getCarModel().equals("Lexus")||this.getCarModel().equals("Chrysler ")||this.getCarModel().equals("Toyota"))) {
    		return Destination.Name.UZBEKISTAN;
    	} else if(this.getColor().equals("Black") && this.getMass() < 1500 &&(this.getCarModel().equals("GMC")||this.getCarModel().equals("Dodge"))) {
    		return Destination.Name.KAZAKHSTAN;
    	} else if(this.getReleaseYear() < 1982 || this.getCarModel().equals("Civic") || this.getCarModel().equals("Cherokee")) {
    		return Destination.Name.KYRGYSTAN;
    	} else if(!(this.getColor().equals("Yellow")&&this.getColor().equals("Red")&&this.getColor().equals("Green")&&this.getColor().equals("Blue"))
    			||this.getPrice() > 40000) {
    		return Destination.Name.RUSSIA;
    	} else if (this.getVin().contains("59")) {
    		return Destination.Name.MONGOLIA;
    	}
    	return Destination.Name.EMPTY;
    }
}
