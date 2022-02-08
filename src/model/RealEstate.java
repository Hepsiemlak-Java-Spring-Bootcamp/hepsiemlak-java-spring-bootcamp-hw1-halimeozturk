package model;

import enums.BuildState;
import enums.BuildType;
import enums.Currency;
import enums.PublicationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealEstate extends BaseEntity{
    private Currency currency;
    private Double price;
    private String description;
    private Integer room;
    private Integer livingRoom;
    private Integer age;
    private Integer bathRoom;
    private List<Image> imageList;
    private String floor;
    private Integer numberOfFloor;
    private Double netSquareMeters;
    private Double squareMeters;
    private PublicationType publicationType;
    private BuildType buildType;
    private BuildState buildState;
    private County county;
    private Category mainCategory;
    private Category subCategory;
    private String roomAndLivingRoom;
}
