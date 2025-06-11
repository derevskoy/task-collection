package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
	public static double TRANSPORT_COSTS_PER_TONN = 0.00714;
	@AllArgsConstructor
	public enum Name {
		TURKMENISTAN("Туркменистан",1), UZBEKISTAN("Узбекистан",2), KAZAKHSTAN("Казахстан",3), KYRGYSTAN("Кыргызстан",4), RUSSIA("Россия",5), MONGOLIA("Монголия",6), EMPTY("Пусто",0);
		@Getter
		private String title;
		@Getter
		private int order; 
	};
	
    private Destination.Name name;
    private long massSum;
    private double transportСosts;
    @ToString.Exclude
    private List<Car> cars;
    
    public Destination(Destination.Name name, List<Car> cars) {
    	this.name = name;
    	this.cars = cars;
    }
    
    public long getMassSum() {
    	return cars == null ? 0 : cars.stream().collect(Collectors.summarizingInt(car->car.getMass())).getSum();
    }
    
    public double getTransportСosts() {
    	return this.getMassSum()*TRANSPORT_COSTS_PER_TONN;
    }
}
