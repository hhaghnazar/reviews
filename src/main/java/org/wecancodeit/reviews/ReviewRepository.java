package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Laptop> laptopList = new HashMap<>();

    //constructor to handle our database
    public ReviewRepository(){
        Laptop toshiba = new Laptop( 1L, "Toshiba", "$323.99\nThis Toshiba laptop is the ultimate productivity tool.  It has a dual core Intel Celeron processor that runs at 1.9ghz.  \nIt comes with a 13inch screen 128GB storage and an 802.11ax wifi card.  There is Windows Pro with the education version and it has dual microphones and webcam with bluetooth.  We give this laptop four out of five stars.", "Dynabook Tecra A30G", "Thin and Light", "/images/toshiba.jpg");
        Laptop dell = new Laptop( 2L, "Dell", "$217.14\nThis Dell laptop is a chromebook that has some horsepower. \nIt has a dual core Intel celeron processor that runs up to 2.8 GHZ with a 4MB cache.  There is 4GB of ram and 16GB of storage.  The screen has an antiglare coating and it has a webcam and wifi.  We give it three and half stars out of five stars.  ", "Chromebook 3100", "Thin and Light", "/images/dell.png");
        Laptop apple = new Laptop( 3L, "Apple", "$319.99\nThis Apple Macbook Air is the latest and greatest from 2011.  It has a 4th gen Intel Core i5 dual core 1.3ghz processor with 4GB of ram and a 128GB solid state storage device.  \nIt is possible to upgrade this laptop to macOS11.  We give this device a five out of five stars for performance", "Macbook Air MD711LLA", "Powerhouse", "/images/apple.jpg");
        Laptop gateway = new Laptop(4L, "Gateway", "$299.99\nThis big blue behemoth is a fifteen inch monster.  It houses a 3.1 GHZ intel Pentium processor and has 128GB of storage with 4GB ram.  \nThere is an HDMI port, wifi, bluetooth.  We give it a five out of five stars for performance", "Ultraslim GWTN15611BL", "Powerhouse", "/images/gateway.jpg");
        Laptop acer = new Laptop (5L, "Acer", "$89.00\nThis Acer Chromebook is an 11.6 inch laptop that runs on an Intel Celeron Processor. \n It has a 1.7 Ghz dual core processor with 4GB ram and 16 GB storage.  This laptop has just enough horsepower to run you through your day no problem.  Includes Webcam, Wifi, Bluetooth, no touchscreen. We give it a 3 out five stars for effort.", "Chromebook C740C4PE", "chromebook", "/images/acer.jpg");

        laptopList.put(toshiba.getId(), toshiba);
        laptopList.put(dell.getId(), dell);
        laptopList.put(apple.getId(), apple);
        laptopList.put(gateway.getId(), gateway);
        laptopList.put(acer.getId(), acer);

    }

    //constructor for testing purposes only... uses varArgs to add none or as many objects as we want
    public ReviewRepository(Laptop...laptopsToAdd) {
        for(Laptop laptop: laptopsToAdd){
            laptopList.put(laptop.getId(), laptop);
        }
    }

    public Laptop findOne(long id) {
        return laptopList.get(id);
    }

    public Collection<Laptop> findAll() {
        return laptopList.values();
    }
}
