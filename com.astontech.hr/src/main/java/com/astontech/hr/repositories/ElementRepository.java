package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
//import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by barrsmit1 on 6/2/2016.
 */
public interface ElementRepository extends CrudRepository<Element, Integer> {

    // causes method implementation to be auto-generated
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    @Modifying
    @Transactional
    int deleteAllByElementName(String elementName);

//    @Query(
//            value = "SELECT Element_Id, DISTINCT[Element_Name], Version FROM element WHERE Element_Name = :elementName2",
//            nativeQuery = true)
//    @Query(
//            value = "SELECT Element_Id, DISTINCT Element_Name, Version FROM element e WHERE e.Element_Name = :elementName2",
//            nativeQuery = true)
//    @Query(
//            value = "SELECT DISTINCT e.Element_Name, e.Version FROM element e WHERE e.Element_Name = :elementName2",
//            nativeQuery = true)
//    @Query(
//            value = "SELECT DISTINCT e.Element_Id, e.Element_Name, e.Version FROM element e WHERE e.Element_Name = :elementName2",
//            nativeQuery = true)
//    @Query(
//            value = "SELECT DISTINCT e.* FROM element e WHERE elementname = :elementName2",
//            nativeQuery = true)
//    @Query(
//        value = "SELECT DISTINCT e FROM element e WHERE elementname = :elementName2",
//        nativeQuery = true)
//    List<Element> findDistinctByElementName(@Param ("elementName2") String elementName2);

    @Query(
        value = "SELECT DISTINCT element_name FROM element WHERE element_name = :elementName2",
        nativeQuery = true)
    List<String> findDistinctByElementName(@Param ("elementName2") String elementName2);

//    List<String> findDistinctElementNameByElementName(String elementName);

    Element findTopByOrderByElementNameDesc();

    Element findTopByOrderByElementName();

    List<Element> findTop2ByOrderByElementName();

    int countByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);
}
