package com.vm.ec.nhtsa.constants;

public class NhtsaApiConstants {
    public static final String BASE_API_URL = "https://vpic.nhtsa.dot.gov/api/vehicles";
    public static final String GET_ALL_MAKES_URL = BASE_API_URL + "/getallmakes?format=json";
    public static final String GET_ALL_MANUFACTURERS_URL = BASE_API_URL + "/GetAllManufacturers?format=json&page=1";
    public static final String GET_WMIS_FOR_MANUFACTURER_URL = "/GetWMIsForManufacturer";
}