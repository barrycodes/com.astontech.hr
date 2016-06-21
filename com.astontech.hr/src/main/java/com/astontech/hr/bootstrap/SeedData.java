package com.astontech.hr.bootstrap;

import com.astontech.hr.common.DateHelper;
import com.astontech.hr.common.LogHelper;
import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by barrsmit1 on 6/3/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private StudentService studentService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        seedData();
    }

    private void seedData() {

        seedElements();
        seedVehicles();
        seedEmployees();
        seedCurriculums();
    }

    private void seedCurriculums() {

        Curriculum c1 = new Curriculum("MyCurriculum1");
        Curriculum c2 = new Curriculum("Database");

        AssignmentSection s1 = new AssignmentSection("MySection1");
        AssignmentSection s2 = new AssignmentSection("MySection2");
        AssignmentSection s3 = new AssignmentSection("MySection3");

        Assignment a1 = new VideoAssignment("MyAssignment1");
        Assignment a2 = new ExerciseAssignment("MyAssignment2");
        Assignment a3 = new LinkAssignment("MyAssignment3", "https://google.com");
        Assignment a4 = new VideoAssignment("MyAssignment4");
        Assignment a5 = new DownloadAssignment("MyAssignment5");
//        LogHelper.getLogger().info(a1 instanceof LinkAssignment ? "true" : "false");
//        LogHelper.getLogger().info(a1 instanceof Assignment ? "true" : "false");
//        LogHelper.getLogger().info(a1 instanceof VideoAssignment ? "true" : "false");
        s1.getAssignments().add(a1);
        s2.getAssignments().add(a2);
        s2.getAssignments().add(a3);
        s2.getAssignments().add(a4);
        s3.getAssignments().add(a5);

        c1.getSections().add(s1);
        c1.getSections().add(s2);

        curriculumService.saveCurriculum(c1);
        curriculumService.saveCurriculum(c2);

        Student st1 = new Student("barry@awesome.com");
        st1.getAssignmentsCompleted().add(a2);

        studentService.saveStudent(st1);

//        Curriculum c10 = curriculumService.getCurriculumById(1);
//        AssignmentSection s10 = c10.getSections().get(0);
//        Assignment a10 = s10.getAssignments().get(0);
//        LogHelper.getLogger().info(a10 instanceof LinkAssignment ? "true" : "false");
//        LogHelper.getLogger().info(a10 instanceof Assignment ? "true" : "false");
//        LogHelper.getLogger().info(a10 instanceof VideoAssignment ? "true" : "false");
    }

    private void seedElements() {

        ElementType laptopType = new ElementType("Laptop");

        List<Element> elements = new ArrayList<>();
        elements.add(new Element("Acer"));
        elements.add(new Element("Dell"));
        elements.add(new Element("Samsung"));
        elements.add(new Element("Apple"));
        elements.add(new Element("Asus"));

        laptopType.setElements(elements);

        elementTypeService.saveElementType(laptopType);

        List<ElementType> elementTypes = new ArrayList<>();

        elementTypes.add(new ElementType("Work"));
        elementTypes.add(new ElementType("Personal"));
        elementTypes.add(new ElementType("Airline"));
        elementTypes.add(new ElementType("Car Rental"));
        elementTypes.add(new ElementType("Work"));
        elementTypes.add(new ElementType("Home"));
        elementTypes.add(new ElementType("Cell"));

        elementTypeService.saveElementTypes(elementTypes);
    }

    private void seedVehicles() {

        VehicleMake toyotaMake = new VehicleMake("Toyota");
        VehicleMake fordMake = new VehicleMake("Ford");

        List<VehicleModel> toyotaModels = new ArrayList<>();
        List<VehicleModel> fordModels = new ArrayList<>();

        toyotaModels.add(new VehicleModel("Camry"));
        toyotaModels.add(new VehicleModel("Carolla"));
        toyotaModels.add(new VehicleModel("Avalon"));

        fordModels.add(new VehicleModel("Fiesta"));
        fordModels.add(new VehicleModel("Focus"));
        fordModels.add(new VehicleModel("Mustang"));

        toyotaModels.get(0).setVehicleMake(toyotaMake);
        toyotaModels.get(1).setVehicleMake(toyotaMake);
        toyotaModels.get(2).setVehicleMake(toyotaMake);

        fordModels.get(0).setVehicleMake(fordMake);
        fordModels.get(1).setVehicleMake(fordMake);
        fordModels.get(2).setVehicleMake(fordMake);

        Vehicle vehicle1 = new Vehicle("ABC123");
        Vehicle vehicle2 = new Vehicle("DEF456");
        Vehicle vehicle3 = new Vehicle("GHI789");

        vehicle1.setVehicleModel(toyotaModels.get(1));
        vehicle2.setVehicleModel(toyotaModels.get(1));
        vehicle3.setVehicleModel(fordModels.get(0));

        vehicle1.setYear(2001);
        vehicle1.setVin("023929035802938409");
        vehicle1.setColor("Purple");
        vehicle1.setIsPurchase(true);
        vehicle1.setPurchasePrice(2500F);
        vehicle1.setPurchaseDate(DateHelper.getDateFromString("2005-10-01"));

        vehicle2.setYear(2002);
        vehicle2.setVin("35902823749823");
        vehicle2.setColor("Red");
        vehicle2.setIsPurchase(true);
        vehicle2.setPurchasePrice(5010.75F);
        vehicle2.setPurchaseDate(DateHelper.getDateFromString("2007-09-01"));

        vehicle3.setYear(2003);
        vehicle3.setVin("3428903578923");
        vehicle3.setColor("Blue");
        vehicle3.setIsPurchase(true);
        vehicle3.setPurchasePrice(10500F);
        vehicle3.setPurchaseDate(DateHelper.getDateFromString("2006-08-01"));

        vehicleMakeService.saveVehicleMake(toyotaMake);
        vehicleMakeService.saveVehicleMake(fordMake);

        vehicleModelService.saveVehicleModels(toyotaModels);
        vehicleModelService.saveVehicleModels(fordModels);

        vehicleService.saveVehicle(vehicle1);
        vehicleService.saveVehicle(vehicle2);
        vehicleService.saveVehicle(vehicle3);
    }

    private void seedEmployees() {

        Person person1 = new Person();
        person1.setTitle("Mr.");
        person1.setFirstName("Willy");
        person1.setMiddleName("K");
        person1.setLastName("Wonka");
        person1.setCreateDate(new Date());

        Person person2 = new Person();
        person2.setTitle("Mr.");
        person2.setFirstName("Michael");
        person2.setMiddleName("J");
        person2.setLastName("Jordan");
        person2.setCreateDate(new Date());

        Employee employee1 = new Employee();
        employee1.setHireDate(new Date());
        employee1.setCreateDate(new Date());
        employee1.setPerson(person1);

        Employee employee2 = new Employee();
        employee2.setHireDate(new Date());
        employee2.setCreateDate(new Date());
        employee2.setPerson(person2);

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);

    }
}
