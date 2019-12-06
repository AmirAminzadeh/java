//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 09
//Date: 2019-11-29
/////////////////////////////////////////
package com.senecacollege.workshop9.Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Country {
    //HashMap is a Map based collection class that is used for storing Key & value pairs, 
    //it is denoted as HashMap<Key, Value> or HashMap<K, V>
    private Map<String, String> countriesAndCapitals = new HashMap<String, String>();
    private String country;// This variable is the chosen country

    public Country() {
        countriesAndCapitals.put("Albania", "Tirana");//Number 1
        countriesAndCapitals.put("Algeria", "Algiers");//Number 2
        countriesAndCapitals.put("Angola", "Luanda");//Number 3
        countriesAndCapitals.put("Canada", "Ottawa");//Number 4
        countriesAndCapitals.put("Bahrain", "Manama");//Number 5
        countriesAndCapitals.put("Bangladesh", "Dhaka");//Number 6
        countriesAndCapitals.put("Belarus", "Minsk");//Number 7
        countriesAndCapitals.put("Brazil", "Brasilia");//Number 8
        countriesAndCapitals.put("Iran", "Tehran");//Number 9
        countriesAndCapitals.put("Israel", "Jerusalem");//Number 10
        countriesAndCapitals.put("Japan", "Tokyo");//Number 11
        countriesAndCapitals.put("Kosovo", "Pristina");//Number 12
        countriesAndCapitals.put("Libya", "Tripoli");//Number 13
        countriesAndCapitals.put("Lebanon", "Beirut");//Number 14
        countriesAndCapitals.put("Yemen", "Sana'a");//Number 15
        countriesAndCapitals.put("United Arab Emirates", "Abu Dhabi");//Number 16
        countriesAndCapitals.put("Turkey", "Ankara");//Number 17
        countriesAndCapitals.put("Sudan", "Khartoum");//Number 18
        countriesAndCapitals.put("Switzerland", "Bern");//Number 91
        countriesAndCapitals.put("Germany", "Berlin");//Number 20
        countriesAndCapitals.put("Jamaica", "Kingston");//Number 21
        countriesAndCapitals.put("Uruguay", "Montevideo");//Number 22
        countriesAndCapitals.put("Venezuela", "Caracas");//Number 23
        countriesAndCapitals.put("Zimbabwe", "Harare");//Number 24
        countriesAndCapitals.put("Maldives", "Buenos Aires");//Number 25
    }

    public String getCapital() {// This getter method for the specified country
        boolean containsCountry = countriesAndCapitals.containsKey(country);

        if (containsCountry) {// If the country was available so getting
            return countriesAndCapitals.get(country);
        } else {// else printing the neath sentence
            return "There is not the information of the country";
        }
    }

    public void processRequest() {// This method scann the country name by a user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a country: ");
        country = sc.nextLine();// The country is based on string
        System.out.println("The capital of " + country + " is " + getCapital());
    }
}