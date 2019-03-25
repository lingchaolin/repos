package dao;



import model.Bicycle_station;

import java.util.List;

public interface BicycleStationMapper {

    List showBicycleStation();

    void addBicycleStation(Bicycle_station bicycle_station);
}
