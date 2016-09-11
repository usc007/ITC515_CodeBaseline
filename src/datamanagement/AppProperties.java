package datamanagement;
import java.util.*;
import java.io.*;
public class AppProperties 
{
private static AppProperties self = null;
private Properties properties;

public static AppProperties getInstance() //class name Appproperties
{
    //if statement execute for self is equal to null condition
if (self == null )
    { self = new AppProperties(); } return self;}
    private AppProperties() {properties = new Properties();
        try {properties.load(new FileInputStream("Properties.prop"));} //try statement for input file stream
            //Throw and catch statement executed for Run time exception  
            catch (IOException e) {throw new RuntimeException("Could not read property file");}}
            public Properties getProperties() {return properties;//Returns the properties
}}
