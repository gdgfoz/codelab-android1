
package org.gdgfoz.codelabgdg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoriesResponse {

    @SerializedName("data")
    @Expose
    private List<Category> categories = new ArrayList<Category>();

    /**
     * 
     * @return
     *     The data
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setCategories(List<Category> data) {
        this.categories = data;
    }

}
