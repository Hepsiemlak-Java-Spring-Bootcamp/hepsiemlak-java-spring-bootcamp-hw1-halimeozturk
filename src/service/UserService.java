package service;

import enums.UserType;
import model.Message;
import model.RealEstate;
import model.User;

import java.util.*;

public class UserService {

    /*******************************************************************AUTOMATIC CREATE************************************************************************************/

    RealEstateService realEstateService = new RealEstateService();
    public List<User> createUserList(int userSize){
        List<User> userList = new ArrayList<>();
        userList.add(staticUser());
        for(int i=1;i<userSize+1;i++){
            User user;
            if(i % 2 == 0){
                user =  createUser(String.valueOf(i), UserType.INDIVIDUAL);
            }else{
                user = createUser(String.valueOf(i), UserType.INSTITUTIONAL);
            }
            userList.add(user);
        }

        return userList;
    }

    public User staticUser(){
        User user = new User();
        user.setId((long) randomNumber(900));
        user.setName("Ayse" );
        user.setEmail("ayse.sari@gmail.com");
        user.setUserType(UserType.INDIVIDUAL);
        user.setPath("https://media-blog.zingat.com/uploads/2016/11/emlaksatis.kritikadim-780x520.jpg");
        user.setSurname("Sari");
        user.setPhoneNumber(genericPhoneNumber());
        user.setFavorite(new HashSet<>(realEstateService.createRealEstateList(randomNumber(10))));
        return user;
    }

    public User createUser(String i,UserType userType){
        User user = new User();
        user.setId(Long.valueOf(i));
        user.setName("User" + i);
        user.setEmail("user" + i + "@mailinator.com");
        user.setUserType(userType);
        user.setPath("https://media-blog.zingat.com/uploads/2016/11/emlaksatis.kritikadim-780x520.jpg");
        user.setSurname("Surname" + i);
        user.setPhoneNumber(genericPhoneNumber());
        if(userType.equals(UserType.INSTITUTIONAL)){
            user.setOfficePhone(genericPhoneNumber());
            user.setVkn(genericVKN());
        }
        user.setFavorite(new HashSet<>(realEstateService.createRealEstateList(randomNumber(3))));
        user.setMessageList(staticMessage());
//        System.out.println(user);
        return user;
    }


    public List<Message> staticMessage(){
        List<Message> messageList = new ArrayList<>();
        Message message = new Message();
        User user1 = new User(UserType.INDIVIDUAL,"Halime","Öztürk","halime@mailinator.com","","","","",null,null,null);
        User user2 = new User(UserType.INDIVIDUAL,"Elif","Öztürk","elif@mailinator.com","","","","",null,null,null);
        message.setReceiver(user1);
        message.setSender(user2);
        message.setSeen(true);
        message.setTitle("Satilik");
        message.setReadDate(new Date());
        message.setSentDate(new Date());
        message.setContent("Bu evi satin almak istiyoruz ");
        messageList.add(message);
        return messageList;
    }

    public int randomNumber(int number){
        return 1 + new Random().nextInt(number);
    }

    public String genericPhoneNumber(){
        int num1, num2, num3;
        int set2, set3;
        Random generator = new Random();
        num1 = generator.nextInt(7) + 1;
        num2 = generator.nextInt(8);
        num3 = generator.nextInt(8);
        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;
        String number = "(0" + String.valueOf(num1) + "" + String.valueOf(num2) + "" + String.valueOf(num3) + ")" + "-" + String.valueOf(set2) + "-" + String.valueOf(set3);
        return number;
    }

    public String genericVKN(){
        int num1, num2, num3;
        int set2, set3;
        Random generator = new Random();
        num1 = generator.nextInt(7) + 1;
        num2 = generator.nextInt(8);
        num3 = generator.nextInt(8);
        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;
        String number = String.valueOf(num1)  + String.valueOf(num2) + String.valueOf(num3)  + String.valueOf(set2) + String.valueOf(set3);
        return number;
    }

    /*******************************************************************************************************************************************************************/

    /*******************************************************************************************************************************************************************/
    //method overloading
    public User createUser(String name, String surname, String email, UserType userType, String path,
                           String phoneNumber, String officePhone, String vkn,
                           Set<RealEstate> realEstateSet, List<Message> messageList){
        User user = new User();
        user.setId((long) randomNumber(20000));
        user.setName(name);
        user.setEmail(email);
        user.setUserType(userType);
        user.setPath(path);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        if(userType.equals(UserType.INSTITUTIONAL)){
            user.setOfficePhone(officePhone);
            user.setVkn(vkn);
        }
        user.setFavorite(realEstateSet);
//        user.setMessageList(messageList);
        return user;
    }
    /*******************************************************************************************************************************************************************/
}
