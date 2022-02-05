package service;

import dto.MessageFilterDTO;
import dto.RealEstateFilterDTO;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterService {

    RealEstateService realEstateService = new RealEstateService();
    MessageService messageService = new MessageService();
    UserService userService = new UserService();

    public List<RealEstate> filterRealEstate(){
        RealEstateFilterDTO realEstateFilterDTO = createRealEstateFilter();

        List<RealEstate> filterRealEstate;
        List<RealEstate> realEstateList = realEstateService.createRealEstateList(209);

        filterRealEstate = realEstateList.stream().filter(t-> listIntegerCheck(realEstateFilterDTO.getAge(),t.getAge()))
                .filter(t-> listIntegerCheck(realEstateFilterDTO.getBathRoom(),t.getBathRoom()))
                .filter(t-> listIntegerCheck(realEstateFilterDTO.getNumberOfFloor(),t.getNumberOfFloor()))
                .filter(t-> listStringCheck(realEstateFilterDTO.getFloor(),t.getFloor()))
                .filter(t-> listStringCheck(realEstateFilterDTO.getRoomAndLivingRoomList(),t.getRoomAndLivingRoom()))
                .filter(t->minControl(realEstateFilterDTO.getMinPrice(),t.getPrice()))
                .filter(t->maxControl(realEstateFilterDTO.getMaxPrice(),t.getPrice()))
                .filter(t->minControl(realEstateFilterDTO.getMinNetSquareMeters(),t.getNetSquareMeters()))
                .filter(t->maxControl(realEstateFilterDTO.getMaxNetSquareMeters(),t.getNetSquareMeters()))
                .filter(t->minControl(realEstateFilterDTO.getMinSquareMeters(),t.getSquareMeters()))
                .filter(t->maxControl(realEstateFilterDTO.getMaxSquareMeters(),t.getSquareMeters()))
                .filter(t->enumsControl(realEstateFilterDTO.getPublicationType(),t.getPublicationType()))
                .filter(t->countryControl(realEstateFilterDTO.getCounty(),t.getCounty()))
                .collect(Collectors.toList());

        return filterRealEstate;
    }

    public RealEstateFilterDTO createRealEstateFilter(){
        RealEstateFilterDTO realEstateFilterDTO = new RealEstateFilterDTO();
        List<Integer> ageList = new ArrayList<>();
//        ageList.add(1);
//        ageList.add(2);
//        ageList.add(13);
//        ageList.add(53);
//        ageList.add(10);
        ageList.add(25);
        realEstateFilterDTO.setAge(null);

        List<String> roomAndLivingRoomList = new ArrayList<>();
        roomAndLivingRoomList.add("4");
//        roomAndLivingRoomList.add("3+1");
//        roomAndLivingRoomList.add("2+1");
//        roomAndLivingRoomList.add("2");
        realEstateFilterDTO.setRoomAndLivingRoomList(roomAndLivingRoomList);
//        realEstateFilterDTO.setMaxPrice(1500.0);
        realEstateFilterDTO.setMinPrice(null);

        List<Integer> bathRoom = new ArrayList<>();
        bathRoom.add(1);
//        bathRoom.add(2);
//        bathRoom.add(3);
//        bathRoom.add(4);
        realEstateFilterDTO.setBathRoom(null);
        List<String> floor = new ArrayList<>();
//        floor.add("1");
//        floor.add("3");
        floor.add("4");
//        floor.add("5");
        realEstateFilterDTO.setFloor(null);

        List<Integer> numberOfFloor = new ArrayList<>();
//        numberOfFloor.add(1);
//        numberOfFloor.add(2);
//        numberOfFloor.add(3);
//        numberOfFloor.add(4);
//        numberOfFloor.add(25);
//        numberOfFloor.add(23);
        numberOfFloor.add(20);
        realEstateFilterDTO.setNumberOfFloor(null);

//        realEstateFilterDTO.setMinNetSquareMeters(400.0);

        return realEstateFilterDTO;
    }


    private boolean categoryControl(Category category, Category c) {
        if(category != null){
            return c.equals(category);
        }else return true;
    }

    private boolean countryControl(County county, County c) {
        if(county != null){
            return c.equals(county);
        }else return true;
    }

    public <T extends Comparable<T>> boolean enumsControl(T type, T enums) {
        if (type != null) {
            return enums.equals(type);
        } else return true;
    }


    public boolean listIntegerCheck(List<Integer> check, int element){
        if(check != null ){
            return check.contains(element);
        }else return true;
    }

    public boolean listStringCheck(List<String> check, String element){
        if(check != null ){
            return check.contains(element);
        }else return true;
    }

    public boolean minControl(Double t, Double value){

        if(t != null && t >= value){
            return true;
        } else return t == null || t < value;
    }

    public boolean maxControl(Double t, Double value){
        if(t != null && t < value){
            return true;
        }else return t == null || t > value;
    }


    public List<MessageFilterDTO> filterMessage(){
        List<Message> messageList = messageService.createMessageList(6);
        List<MessageFilterDTO> messageFilterDTOS = new ArrayList<>();
        messageList.stream().forEach(i->{
            MessageFilterDTO messageFilterDTO = new MessageFilterDTO();
            messageFilterDTO.setContent(i.getContent());
            messageFilterDTO.setReceiver(i.getReceiver());
            messageFilterDTO.setSender(i.getSender());
            messageFilterDTOS.add(messageFilterDTO);
        });

        return messageFilterDTOS;
    }

    public List<Set<RealEstate>> favoriteList(String email){
        List<User> userList = userService.createUserList(9);
        List<Set<RealEstate>> favorite = userList.stream().filter(t -> t.getEmail().equals(email)).collect(Collectors.toList())
                                            .stream().map(User::getFavorite).collect(Collectors.toList());
        return favorite;
    }
}
