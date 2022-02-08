package dto;

import enums.PublicationType;
import lombok.Data;
import model.Category;
import model.County;

import java.util.List;

@Data
public class RealEstateFilterDTO {

    private Double maxPrice;
    private Double minPrice;
    private List<Integer>  age;
    private List<Integer> bathRoom;
    private List<String> floor;
    private List<Integer> numberOfFloor;
    private Double minNetSquareMeters;
    private Double maxNetSquareMeters;
    private Double minSquareMeters;
    private Double maxSquareMeters;
    private PublicationType publicationType;
    private County county;
    private Category mainCategory;
    private List<Category> subCategory;
    private List<String> roomAndLivingRoomList;
}
