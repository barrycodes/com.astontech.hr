package com.astontech.hr.domain.vo;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
public class ElementVo {
    private String newElementType;
    private String newElements;
    private String[] newElementArray;

    public ElementVo() {}

    public ElementVo(String newElementType, String newElements) {
        this.setNewElementType(newElementType);
        this.setNewElements(newElements);
    }

    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }

    //region CUSTOM METHODS

    public void splitNewElementsIntoArray() {
        this.setNewElementArray(this.newElements.split("\\r?\\n"));
    }

    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }

    //endregion
}
