package org.wecancodeit.reviews;

public class Laptop {

    //    public Long getID;
    private Long id;
    private String name;
    private String description;
    private String model;
    private String category;
    private String img_url;

    public String getModel() {
        return model;
    }

    public String getCategory() {
        return category;
    }

    public String getImg_url() {
        return img_url;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Laptop(long id, String name, String description, String model, String category, String img_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.model = model;
        this.category = category;
        this.img_url = img_url;

    }


}
