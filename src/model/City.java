package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseEntity{
    private String name;
    private String numberPlate;
    private List<County> county;
}
