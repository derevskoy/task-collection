package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Destination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		task1();
		task2();
		task3();
		task4();
		task5();
		task6();
		task7();
		task8();
		task9();
		task10();
		task11();
		task12();
		task13();
		task14();
		task15();
		task16();
		task17();
		task18();
		task19();
		task20();
		task21();
		task22();
		 
	}

	public static void task1() {
		System.out.println("TASK1");
		List<Animal> animals = Util.getAnimals();
		List<Animal> animalsForZoo = animals.stream().filter(Animal::acceptForZoo)
				.sorted((a1, a2) -> a1.getAge() - a2.getAge())
				.collect(Collectors.toList());
		IntStream.range(0, animalsForZoo.size()).forEach(ind -> animalsForZoo.get(ind).setZooId(ind/7+1));
		
		  animalsForZoo.stream() .collect(Collectors.groupingBy(Animal::getZooId))
		  .entrySet().stream()
		  .filter(entry -> entry.getKey() == 3)
		  .forEach(System.out::println);
		  
	}

	public static void task2() {
		System.out.println("TASK2");
		List<Animal> animals = Util.getAnimals();
		animals.stream().filter(animal -> animal.getOrigin().equals("Japanese"))
				.peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
				.filter(animal -> animal.getGender().equals("Female")).map(animal -> animal.getBread())
				.forEach(System.out::println);
	}

	public static void task3() {
		System.out.println("TASK3");
		List<Animal> animals = Util.getAnimals();
		animals.stream().filter(animal -> animal.getAge() >= 30 && animal.getOrigin().startsWith("A"))
				.map(animal -> animal.getOrigin()).distinct().forEach(System.out::println);
	}

	public static void task4() {
		System.out.println("TASK4");
		List<Animal> animals = Util.getAnimals();
		System.out.println(
				"Female Count: " + animals.stream().filter(animal -> animal.getGender().equals("Female")).count());

	}

	public static void task5() {
		System.out.println("TASK5");
		List<Animal> animals = Util.getAnimals();
		System.out.println("Hungarian origin exists: "
				+ animals.stream().anyMatch(animal -> (animal.getAge() >= 20 && animal.getAge() <= 30)
						&& (animal.getOrigin().equals("Hungarian"))));
	}

	public static void task6() {
		System.out.println("TASK6");
		List<Animal> animals = Util.getAnimals();
		System.out.println("Gender is Female/Male for all: " + animals.stream()
				.allMatch(animal -> animal.getGender().equals("Female") || animal.getGender().equals("Male")));
	}

	public static void task7() {
		System.out.println("TASK7");
		List<Animal> animals = Util.getAnimals();
		System.out.println("Are all animals not from Oceania: "
				+ animals.stream().noneMatch(animal -> animal.getOrigin().equals("Oceania")));
	}

	public static void task8() {
		System.out.println("TASK8");
		List<Animal> animals = Util.getAnimals();
		System.out.println(
				"Age of oldests animal: " + animals.stream().sorted((a1, a2) -> a1.getBread().compareTo(a2.getBread()))
						.limit(100).max((a1, a2) -> a1.getAge() - a2.getAge()).get().getAge());
	}

	public static void task9() {
		System.out.println("TASK9");
		List<Animal> animals = Util.getAnimals();
		System.out.println("Min length of animal breed: " + animals.stream()
				.map(animal -> animal.getBread().toCharArray()).min((a1, a2) -> a1.length - a2.length).get().length);
	}

	public static void task10() {
		System.out.println("TASK10");
		List<Animal> animals = Util.getAnimals();
		System.out.println("Summ ages of animal: "
				+ animals.stream().collect(Collectors.summarizingInt(animal -> animal.getAge())).getSum());

	}

	public static void task11() {
		System.out.println("TASK11");
		List<Animal> animals = Util.getAnimals();
		System.out.println("Average age of animal: "
				+ animals.stream().collect(Collectors.summarizingInt(animal -> animal.getAge())).getAverage());
	}

	public static void task12() {
		System.out.println("TASK12");
		List<Person> persons = Util.getPersons();
		persons.stream()
				.filter(Person::acceptToLegion)
				.sorted((p1, p2) -> p1.getRecruitmentGroup() - p2.getRecruitmentGroup())
				.limit(200)
				.forEach(System.out::println);
	}

	public static void task13() {
		System.out.println("TASK13");
		List<House> houses = Util.getHouses();
		houses.stream()
		.flatMap(house -> house.getPersonList().stream().peek(person -> person.setHouse(Optional.of(house))))
		.sorted((p1,p2) -> p2.getEvacuationPriority() - p1.getEvacuationPriority())
		.limit(500)
		.forEach(System.out::println);	
	}

	public static void task14() {
		System.out.println("TASK14");
		List<Car> cars = Util.getCars();
        cars.stream()
        .filter(car->car.getDestinationName()!=Destination.Name.EMPTY)
        .collect(Collectors.groupingBy(car -> car.getDestinationName()))
        .entrySet().stream().sorted((d1,d2)->d1.getKey().getOrder() - d2.getKey().getOrder())
        .map(entry->{return new Destination(entry.getKey(),entry.getValue());})
        .forEach(System.out::println);
	}

	public static void task15() {
		System.out.println("TASK15");
		List<Flower> flowers = Util.getFlowers();
        Double cost = 
        		flowers.stream()
        		.sorted(Comparator.comparing(Flower::getOrigin)
        				.thenComparing(Flower::getPrice)
        				.thenComparing(Flower::getWaterConsumptionPerDay).reversed())
        		.filter(flower->flower.isShadePreferred())
        		.filter(flower->flower.getFlowerVaseMaterial().contains("Glass") 
        				|| flower.getFlowerVaseMaterial().contains("Aluminum")
        				||flower.getFlowerVaseMaterial().contains("Steel"))
        		.map(flower->flower.getPrice() + flower.getWaterConsumptionPerDay()*365*5*1.39)
        		.collect(Collectors.summarizingDouble(price->price)).getSum();
        System.out.println("Cost of ownership: "+cost + " USD");
	}

	public static void task16() {
		System.out.println("TASK16");
		List<Student> students = Util.getStudents();
		students.stream().filter(student -> student.getAge() <= 18)
				.sorted((st1, st2) -> st1.getSurname().compareTo(st2.getSurname())).forEach(System.out::println);
	}

	public static void task17() {
		System.out.println("TASK17");
		List<Student> students = Util.getStudents();
		students.stream().map(Student::getGroup).sorted((gr1, gr2) -> gr1.compareTo(gr2)).distinct()
				.forEach(System.out::println);
	}

	public static void task18() {
		System.out.println("TASK18");
		List<Student> students = Util.getStudents();
		students.stream().collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)))
				.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.forEach(System.out::println);
	}

	public static void task19() {
		System.out.println("TASK19");
		String group = "M-1";
		List<Student> students = Util.getStudents();
		Util.fillExaminations(students);

		students.stream()
		.filter(student -> student.getGroup().equals(group))
		.filter(student -> student.getExamination().isPresent() && student.getExamination().get().getExam3() > 4)
		.forEach(System.out::println);

	}

	public static void task20() {
		System.out.println("TASK20");
		List<Student> students = Util.getStudents();
		Util.fillExaminations(students);
		
		System.out.println(students.stream().filter(student -> student.getExamination().isPresent())
				.collect(Collectors.groupingBy(Student::getFaculty,
						Collectors.averagingInt(student -> student.getExamination().isPresent()
								? student.getExamination().get().getExam1()
								: 0)))
				.entrySet().stream().max((flt1, flt2) -> flt1.getValue().compareTo(flt2.getValue())));
	}

	public static void task21() {
		System.out.println("TASK21");
		List<Student> students = Util.getStudents();
		students.stream().collect(Collectors.groupingBy(Student::getGroup, Collectors.counting())).entrySet()
				.forEach(System.out::println);
	}

	public static void task22() {
		System.out.println("TASK22");
		List<Student> students = Util.getStudents();
		students.stream()
				.collect(Collectors.groupingBy(Student::getFaculty,
						Collectors.minBy((st1, st2) -> st1.getAge() - st2.getAge())))
				.entrySet().forEach(System.out::println);
	}
}
