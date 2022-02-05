package service;

import enums.UserType;
import model.Advert;
import model.RealEstate;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class AdvertService {

    /*******************************************************************AUTOMATIC CREATE************************************************************************************/

    UserService userService = new UserService();
    public List<Advert> createAdvertList(int advertSize){
        List<Advert> advertList = new ArrayList<>();
        for(int i=1;i<advertSize+1;i++){
            Advert advert = createAdvert(i);
           advertList.add(advert);
        }
        return advertList;
    }

    public Advert createAdvert(int i){
        Advert advert = new Advert();
        RealEstateService realEstateService = new RealEstateService();
        advert.setId((long) i);
        advert.setRealEstates(realEstateService.createRealEstate(1));
        advert.setActive(true);
        advert.setDescription("Sahibinden Lux Kiralik Daire !");
        advert.setTitle("Istanbul Maltepe Sifir Daire");
        advert.setDuration(new Date());
        advert.setPutFordward(randomNumber(200));
        advert.setReviewed(userService.createUserList(5));
        int randomNumber = randomNumber(100);
        advert.setOwner(userService.createUser(String.valueOf(randomNumber),randomNumber % 2 == 0 ? UserType.INSTITUTIONAL : UserType.INDIVIDUAL));
//        System.out.println(advert);
        return advert;
    }


    public int randomNumber(int number){
        return 1 + new Random().nextInt(number);
    }

    /*********************************************************************************METHOD OVERLOADING******************************************************************************************************/
    public Advert createAdvert(RealEstate realEstate, String description, String title,
                               Date duration, int putFordward, List<User> reviewed,User owner){
        Advert advert = new Advert();
        RealEstateService realEstateService = new RealEstateService();
        advert.setId((long) randomNumber(20000));
        advert.setRealEstates(realEstate);
        advert.setActive(true);
        advert.setDescription(description);
        advert.setTitle(title);
        advert.setDuration(duration);
        advert.setPutFordward(putFordward);
        advert.setReviewed(reviewed);
        advert.setOwner(owner);
//        System.out.println(advert);
        return advert;
    }

}
