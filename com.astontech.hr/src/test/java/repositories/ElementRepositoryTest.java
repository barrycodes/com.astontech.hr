package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by barrsmit1 on 6/2/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {
        // ARRANGE
        Element element = new Element();
        element.setElementName("Phone");

        // ASSERT
        assertNull(element.getId());

        // ACT
        elementRepository.save(element);

        // ASSERT
        assertNotNull(element.getId());

        // ACT
        Element fetchedElement = elementRepository.findOne(element.getId());

        // ASSERT
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        // ARRANGE
        fetchedElement.setElementName("Email");

        // ACT
        elementRepository.save(fetchedElement);
        Element updatedElement = elementRepository.findOne(fetchedElement.getId());

        // ASSERT
        assertEquals(updatedElement.getElementName(), "Email");

        elementRepository.deleteAll();
    }

    @Test
    public void testSaveElementList() {
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();

        int count = 0;
        for (Element element : fetchedElementList) {
            ++count;
        }
        assertEquals(4, count);

        elementRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        Element element = new Element("FindTest");
        elementRepository.save(element);

        Element foundElement = elementRepository.findByElementName("FindTest");

        assertEquals(element.getId(), foundElement.getId());

        elementRepository.deleteAll();
    }

    @Test
    public void testFindAllByName() {
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);

        List<Element> foundElements = elementRepository.findAllByElementName("FindTest");

        assertEquals(3, foundElements.size());

        elementRepository.deleteAll();
    }

    @Test
    public void testDeleteAllByElementName() {
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name2"));

        assertEquals(5, elementRepository.count());

        int deleteCount = elementRepository.deleteAllByElementName("Name1");

        assertEquals(3, deleteCount);
        assertEquals(2, elementRepository.count());

        elementRepository.deleteAll();
    }

//    @Test
//    public void testFindDistinctElementsByElementName() {
//        elementRepository.save(new Element("Name1"));
//        elementRepository.save(new Element("Name1"));
//        elementRepository.save(new Element("Name1"));
//        elementRepository.save(new Element("Name2"));
//        elementRepository.save(new Element("Name2"));
//
//        assertEquals(5, elementRepository.count());
//
//        List<Element> foundElements =
//                elementRepository.findDistinctByElementName("Name2");
//
//        assertEquals(1, foundElements.size());
//
//        elementRepository.deleteAll();
//    }

    @Test
    public void testFindDistinctElementsByElementName() {
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name2"));

        assertEquals(5, elementRepository.count());

        List<String> foundElements =
                elementRepository.findDistinctByElementName("Name2");

//        assertEquals("Name2", foundElements);
        assertEquals(1, foundElements.size());

        elementRepository.deleteAll();
    }

    @Test
    public void testFindTopByOrderByElementName() {
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name3"));
        elementRepository.save(new Element("Name4"));
        elementRepository.save(new Element("Name5"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name7"));
        elementRepository.save(new Element("Name6"));

        assertEquals(7, elementRepository.count());

        Element foundElement =
                elementRepository.findTopByOrderByElementName();

        assertEquals("Name1", foundElement.getElementName());

        elementRepository.deleteAll();
    }

    @Test
    public void testFindTop2ByOrderByElementName() {
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name3"));
        elementRepository.save(new Element("Name4"));
        elementRepository.save(new Element("Name5"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name7"));
        elementRepository.save(new Element("Name6"));

        assertEquals(7, elementRepository.count());

        List<Element> foundElements =
                elementRepository.findTop2ByOrderByElementName();

        assertEquals(2, foundElements.size());
        assertEquals("Name1", foundElements.get(0).getElementName());
        assertEquals("Name2", foundElements.get(1).getElementName());

        elementRepository.deleteAll();
    }

    @Test
    public void testFindTopByOrderByElementNameDesc() {
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name3"));
        elementRepository.save(new Element("Name4"));
        elementRepository.save(new Element("Name5"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name7"));
        elementRepository.save(new Element("Name6"));

        assertEquals(7, elementRepository.count());

        Element foundElement =
                elementRepository.findTopByOrderByElementNameDesc();

        assertEquals("Name7", foundElement.getElementName());

        elementRepository.deleteAll();
    }

    @Test
    public void testCountByElementName() {
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name1"));
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name2"));
        elementRepository.save(new Element("Name2"));

        assertEquals(7, elementRepository.count());

        assertEquals(3, elementRepository.countByElementName("Name1"));
        assertEquals(4, elementRepository.countByElementName("Name2"));

        elementRepository.deleteAll();
    }
}
