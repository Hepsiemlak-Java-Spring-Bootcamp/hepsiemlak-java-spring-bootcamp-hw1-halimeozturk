package service;

import enums.BuildState;
import enums.BuildType;
import enums.Currency;
import enums.PublicationType;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RealEstateService {
    /*******************************************************************AUTOMATIC CREATE************************************************************************************/
    public List<RealEstate> createRealEstateList(int realEstateSize){
        List<RealEstate> realEstateList = new ArrayList<>();
        for(int i=1;i<realEstateSize+1;i++){
            RealEstate realEstate = createRealEstate(i);
            realEstateList.add(realEstate);
        }
        return realEstateList;
    }

    public RealEstate createRealEstate(int index){
        CategoryService categoryService = new CategoryService();
        RealEstate realEstate = new RealEstate();
        List<Image> imageList = uploadImage();
        realEstate.setId((long) index);
        realEstate.setCurrency(randomCurrency(randomNumber(3)));
        realEstate.setPrice((double) randomNumber(20000));
        realEstate.setRoom(randomNumber(10));
        realEstate.setLivingRoom(randomNumber(2));
        realEstate.setRoomAndLivingRoom(String.valueOf(randomNumber(10)));
        realEstate.setAge(randomNumber(50));
        realEstate.setBathRoom( randomNumber(10));
        realEstate.setDescription("Sahibinden temiz sifir kiralik daire(memur kefil sarti gereklidir)");
        realEstate.setImageList(imageList);
        realEstate.setFloor(String.valueOf(randomNumber(20)) + ". " + "Kat");
        realEstate.setNumberOfFloor(randomNumber(20));
        realEstate.setNetSquareMeters((double) randomNumber(500));
        realEstate.setSquareMeters((double) randomNumber(500));
        realEstate.setPublicationType(randomPublicationType(randomNumber(3)));
        realEstate.setBuildType(randomBuildType(randomNumber(6)));
        realEstate.setBuildState(randomBuildState(randomNumber(2)));
        realEstate.setCounty(createCountry());
        Category category = categoryService.mainCreateCategory();
        realEstate.setMainCategory(category);
        realEstate.setSubCategory(categoryService.subCategoryCreate(category));
//        System.out.println(realEstate);
        return realEstate;
    }

    public int randomNumber(int number){
        return 1 + new Random().nextInt(number);
    }

    public Currency randomCurrency(int value){
        switch (value) {
            case 1:
                return Currency.TL;
            case 2:
                return Currency.USD;
            case 3:
                return Currency.EUR;

        }
        return null;
    }

    public BuildState randomBuildState(int value){
        switch (value) {
            case 1:
                return BuildState.ZERO;
            case 2:
                return BuildState.SECOND_HAND;

        }
        return null;
    }

    public PublicationType randomPublicationType(int value){
        switch (value) {
            case 1:
                return PublicationType.DAILY_RENT;
            case 2:
                return PublicationType.FOR_RENT;
            case 3:
                return PublicationType.FOR_SALE;
        }
        return null;
    }

    public BuildType randomBuildType(int value){
        switch (value) {
            case 1:
                return BuildType.WOODEN_HOUSE;
            case 2:
                return BuildType.EARTH_HOUSE;
            case 3:
                return BuildType.STONE_HOUSE;
            case 4:
                return BuildType.ADOBE_HOUSE;
            case 5:
                return BuildType.TILE_HOUSE;
            case 6:
                return BuildType.REINFORCED_CONCRETE_HOUSE;
        }
        return null;
    }

    public List<Image> uploadImage(){
        List<Image> imageList = new ArrayList<>();
        imageList.add(new Image("https://hecdnw01.hemlak.com/ds01/4/4/9/0/2/3/8/3/81d2e088-a551-485d-b2e9-664cc9200cdc.jpg",imageList.size()+1));
        imageList.add(new Image("https://hecdnw01.hemlak.com/ds01/1/7/8/7/3/3/8/3/d9af4f60-4d94-4aeb-91b3-b45f2d2c2aee.jpg",imageList.size()+1));
        imageList.add(new Image("https://hecdnw01.hemlak.com/ds01/1/7/8/7/3/3/8/3/f40e0906-e018-425c-b6e7-abdc1893b8ea.jpg",imageList.size()+1));
        imageList.add(new Image("https://hecdnw01.hemlak.com/ds01/1/7/8/7/3/3/8/3/9e8733c5-63ea-4033-9ac4-8558714ef054.jpg",imageList.size()+1));
        imageList.add(new Image("https://hecdnw01.hemlak.com/ds01/1/7/8/7/3/3/8/3/b7998c27-add4-477b-bd8d-7e3d04a79418.jpg",imageList.size()+1));
        return imageList;
    }

    public County createCountry(){
        City city = new City();
        city.setName("Istanbul");
        city.setNumberPlate("34");

        County county = new County();
        county.setName("Maltepe");
        county.setCity(city);
        return county;
    }


    /*******************************************************************************************************************************************************************/
    //method overloading
    public RealEstate createRealEstate(List<Image> imageList, Currency currency, Double price,
                                       int room, int livingRoom, String roomAndLivingRoom,
                                       int age, int bathRoom, String description, String floor, int numberOfFloor,
                                       Double netSquareMeters, Double squareMeters, PublicationType publicationType,
                                       BuildType buildType, BuildState buildState, County county, Category mainCategory,
                                       Category subCategory){
        RealEstate realEstate = new RealEstate();
        realEstate.setId((long) randomNumber(200));
        realEstate.setCurrency(currency);
        realEstate.setPrice(price);
        realEstate.setRoom(room);
        realEstate.setLivingRoom(livingRoom);
        realEstate.setRoomAndLivingRoom(roomAndLivingRoom);
        realEstate.setAge(age);
        realEstate.setBathRoom(bathRoom);
        realEstate.setDescription(description);
        realEstate.setImageList(imageList);
        realEstate.setFloor(floor);
        realEstate.setNumberOfFloor(numberOfFloor);
        realEstate.setNetSquareMeters(netSquareMeters);
        realEstate.setSquareMeters(squareMeters);
        realEstate.setPublicationType(publicationType);
        realEstate.setBuildType(buildType);
        realEstate.setBuildState(buildState);
        realEstate.setCounty(county);
        realEstate.setMainCategory(mainCategory);
        realEstate.setSubCategory(subCategory);
        return realEstate;
    }
    /*******************************************************************************************************************************************************************/


}
