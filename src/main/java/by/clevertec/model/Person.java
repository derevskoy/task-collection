package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String gender;
    private int recruitmentGroup;
    private String city;
    private Optional<House> house = Optional.empty();
    private String occupation;
    
    public int getAge() {
    	return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
    
    public boolean acceptToLegion() {
    	return this.getGender().equals("Male") && this.getAge() >= 18 && this.getAge() <= 27;
    }
    
    public int getEvacuationPriority() {
    	if (this.getHouse().isPresent() && this.getHouse().get().getBuildingType().equals("Hospital")) {
    		return 3;
    	} else if (this.getAge()<=18 || this.getAge() >=60) {
    		return 2;
    	} else {
    		return 1;
    	}
    }
}
