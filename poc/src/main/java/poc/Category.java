package poc;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;

    public Category(String name){
        this.name = name;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Politics"));
        categories.add(new Category("Photography"));
        categories.add(new Category("Politics"));
        return categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
