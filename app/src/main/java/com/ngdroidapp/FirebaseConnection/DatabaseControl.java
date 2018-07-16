package com.ngdroidapp.FirebaseConnection;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseControl {

    public DatabaseControl() {

    }

    public Character getCharacter(DataSnapshot dataSnapshot){
        return dataSnapshot.getValue(Character.class);
    }
    //return the Element
    private Element getElement(DataSnapshot dataSnapshot){
        return dataSnapshot.getValue(Element.class);
    }
    //return the Elements with ArrayList
    public ArrayList<Element> getElementArrayList(DataSnapshot dataSnapshot){
        ArrayList<Element> elements = new ArrayList<>();
        for(DataSnapshot ds:dataSnapshot.getChildren()){
            elements.add(ds.getValue(Element.class));
        }
        return elements;
    }
    //return the searched Element with ArrayList
    public Element getSearchedElement(DataSnapshot dataSnapshot, int elementId){
        Element element = new Element();
        for(DataSnapshot ds: dataSnapshot.getChildren()){
            if(elementId == ds.getValue(Element.class).getId()){
                element = getElement(ds);
                break;
            }
        }
        if (element == null){
            return null;
        }
        return element;
    }

    //return the Elements in HashMap with ArrayList
    public ArrayList<HashMap<Integer, Element>> getElementHashMapArrayList (DataSnapshot dataSnapshot){
        ArrayList<HashMap<Integer, Element>> elements = new ArrayList<>();

        for (DataSnapshot ds: dataSnapshot.getChildren()){
            HashMap<Integer, Element> ıntegerElementHashMap = new HashMap<>();
            ıntegerElementHashMap.put(getElement(ds).getId(),getElement(ds));
            elements.add(ıntegerElementHashMap);
        }
        if (elements.isEmpty()){
            return null;
        }
        return elements;
    }

    //return the visible Elements in HashMap with ArrayList
    public ArrayList<HashMap<Integer, Element>> getVisibleElementHashMapArrayList (DataSnapshot dataSnapshot){
        ArrayList<HashMap<Integer, Element>> elements = new ArrayList<>();

        for (DataSnapshot ds: dataSnapshot.getChildren()){
            HashMap<Integer, Element> elementHashMap = new HashMap<>();
            if(getElement(ds).isVisibility()){
                elementHashMap.put(getElement(ds).getId(), getElement(ds));
                elements.add(elementHashMap);
            }
        }if(elements.isEmpty()){
            return null;
        }
        return elements;
    }

    //return the visible Elements with ArrayList
    public ArrayList<Element> getVisibleElementArrayList (DataSnapshot dataSnapshot){
        ArrayList<Element> elements = new ArrayList<>();
        for (DataSnapshot ds: dataSnapshot.getChildren()){
            if(getElement(ds).isVisibility()){
                elements.add(getElement(ds));
            }
        }
        if (elements.isEmpty()){
            return null;
        }
        return elements;
    }
}
