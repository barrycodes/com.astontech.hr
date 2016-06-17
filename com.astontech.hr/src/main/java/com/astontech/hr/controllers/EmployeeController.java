package com.astontech.hr.controllers;

import com.astontech.hr.common.DateHelper;
import com.astontech.hr.common.StringHelper;
import com.astontech.hr.common.UriHelper;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.Person;
import com.astontech.hr.domain.ro.EmployeesRo;
import com.astontech.hr.domain.vo.EmployeeVo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by barrsmit1 on 6/13/2016.
 */

@Controller
public class EmployeeController {

    private RestTemplate restTemplate;

    public EmployeeController() {
        restTemplate = getRestTemplate();
    }

    private static RestTemplate getRestTemplate() {

        RestTemplate result;

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.registerModule(new Jackson2HalModule());
//
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
//        converter.setObjectMapper(mapper);
//
//        result = new RestTemplate(Collections.<HttpMessageConverter<?>> singletonList(converter));
//
//        result.getMessageConverters().add(new StringHttpMessageConverter());

        result = new RestTemplate();

        return result;
    }

    @RequestMapping(value = "/admin/employee", method = RequestMethod.GET)
    public String employeeGet(HttpServletRequest request, Model model) {
        return employeeListGet(request, model);
    }

    @RequestMapping(value = "/admin/employee/add", method = RequestMethod.GET)
    public String employeeAddGet(HttpServletRequest request, Model model) {
        model.addAttribute("employeeVo", new EmployeeVo());
        return "/admin/employee/employee_add";
    }

    @RequestMapping(value = "/admin/employee/edit/{id}", method = RequestMethod.GET)
    public String employeeEditGet(HttpServletRequest request, Model model, @PathVariable("id") int id) {
        Employee e =
                restTemplate.getForObject(
                        UriHelper.getBaseUri(request) + "/api/employee/" + id,
                        Employee.class);

        model.addAttribute("employeeVo", getEmployeeVoFromEmployee(e));

        return "/admin/employee/employee_edit";
    }

    @RequestMapping(value = "/admin/employee/update", method = RequestMethod.POST)
    public String employeeUpdatePost(EmployeeVo vo, HttpServletRequest request) {

        restTemplate.postForObject(
                UriHelper.getBaseUri(request) + "/api/employee",
                getEmployeeFromEmployeeVo(vo),
                Employee.class);

//        return "redirect:/admin/employee/edit/" + vo.getEmployeeId();
//        return "redirect:/admin/employee/list/";
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/employee/add", method = RequestMethod.POST)
    public String employeeAddPost(EmployeeVo vo, HttpServletRequest request, Model model) {

        Employee e = getEmployeeFromEmployeeVo(vo);
        e.getPerson().setCreateDate(new Date());
        e.setCreateDate(new Date());

        restTemplate.postForObject(
                UriHelper.getBaseUri(request) + "/api/employee",
                e,
                Employee.class);

        return "/admin/employee/employee_add";
    }

    @RequestMapping(value = "/admin/employee/delete/{id}", method = RequestMethod.GET)
    public String employeeDeleteGet(HttpServletRequest request, @PathVariable("id") Integer id) {

        restTemplate.delete(
                UriHelper.getBaseUri(request) + "/api/employee/" + id);

        return "redirect:/admin/employee/list";
    }

    @RequestMapping(value = "/admin/employee/list", method = RequestMethod.GET)
    public String employeeListGet(HttpServletRequest request, Model model) {

        String uri = UriHelper.getBaseUri(request) + "/api/employee/";

//        ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(
//                uri, HttpMethod.GET, null,
//                new ParameterizedTypeReference<Employee[]>() {},
//                8080, 0, 100);
//        Employee[] resources = responseEntity.getBody();
        //List<Customer> customers = new ArrayList(resources.getContent());
//        EmployeeRo ero = restTemplate.getForObject(uri, EmployeeRo.class);
//        EmployeeRo2 ero = restTemplate.getForObject(uri, EmployeeRo2.class);
//        Object o = restTemplate.getForObject(uri, Object.class);
//        Class c = o.getClass();
//        Field[] f = c.getFields();

//        Employee[] employees =
//                restTemplate.getForObject(uri, EmployeesRo.class)
//                        .getEmployees().getEmployees();

        Employee[] employees =
                restTemplate.getForObject(uri, Employee[].class);

        List<EmployeeVo> employeeVos = new ArrayList<>();

        for (Employee e : employees)
                employeeVos.add(getEmployeeVoFromEmployee(e));

//        Employee[] e4 = (Employee[])ero2.getEr2();
//        Employee[] e3 = restTemplate.getForObject(uri, Employee[].class);

        model.addAttribute("employees", employeeVos);



        return "/admin/employee/employee_list";
    }

//    private Integer id;
//    private Date hireDate;
//    private Date termDate;
//    private Date createDate;
//    private String title;
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    private String displayFirstName;
//    private Character gender;
//    private Date birthDate;
//    private String ssn;

    private Employee getEmployeeFromEmployeeVo(EmployeeVo vo) {
        Employee result = new Employee();

        Person p = new Person();
        p.setCreateDate(DateHelper.getDateFromString(vo.getPersonCreateDate()));
        p.setTitle(StringHelper.getNullForEmpty(vo.getTitle()));
        p.setFirstName(StringHelper.getNullForEmpty(vo.getFirstName()));
        p.setMiddleName(StringHelper.getNullForEmpty(vo.getMiddleName()));
        p.setLastName(StringHelper.getNullForEmpty(vo.getLastName()));
        p.setDisplayFirstName(StringHelper.getNullForEmpty(vo.getDisplayFirstName()));
//        Character c = vo.getGender();
//        c = (c == 'M' || c == 'F') ? c : null;
        p.setGender(vo.getGender());
        p.setIsDeleted(false);
        p.setBirthDate(DateHelper.getDateFromString(vo.getBirthDate()));
        p.setSsn(StringHelper.getNullForEmpty(vo.getSsn()));
        p.setPersonId(vo.getPersonId());
        p.setVersion(vo.getPersonVersion());
        result.setCreateDate(DateHelper.getDateFromString(vo.getEmployeeCreateDate()));
        result.setHireDate(DateHelper.getDateFromString(vo.getHireDate()));
        result.setTermDate(DateHelper.getDateFromString(vo.getTermDate()));
        result.setPerson(p);
        result.setEmployeeId(vo.getEmployeeId());
        result.setVersion(vo.getEmployeeVersion());

        return result;
    }

    private EmployeeVo getEmployeeVoFromEmployee(Employee e) {

        EmployeeVo result = new EmployeeVo();

        if (e != null) {

            Person p = e.getPerson();
            String fullName = null;

            if (p != null) {
                String n1 = StringHelper.addSpace(p.getTitle());
                String n2 = (StringHelper.isNullOrEmpty(p.getDisplayFirstName())
                        ? StringHelper.addSpace(p.getFirstName())
                        : StringHelper.addSpace(p.getDisplayFirstName()));
                String n3 = StringHelper.addSpace(p.getMiddleName());
                String n4 = StringHelper.addSpace(p.getLastName());

                fullName = n1 + n2 + n3 + n4;

                result.setTitle(p.getTitle());
                result.setFirstName(p.getFirstName());
                result.setMiddleName(p.getMiddleName());
                result.setLastName(p.getLastName());
                result.setPersonId(p.getPersonId());
                result.setPersonVersion(p.getVersion());
                result.setPersonCreateDate(DateHelper.getStringFromDate(p.getCreateDate()));
                result.setGender(p.getGender());
                result.setBirthDate(DateHelper.getStringFromDate(p.getBirthDate()));
                result.setSsn(p.getSsn());
            }

            result.setEmployeeId(e.getEmployeeId());
            result.setEmployeeVersion(e.getVersion());
            result.setEmployeeCreateDate(DateHelper.getStringFromDate(e.getCreateDate()));
            result.setHireDate(DateHelper.getStringFromDate(e.getHireDate()));
            result.setTermDate(DateHelper.getStringFromDate(e.getTermDate()));
            result.setFullName(fullName);
        }
        return result;
    }
}
