package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by tonmoy on 02-Jan-16.
 */
public class Products extends Controller {


    /**
     * Lists all products
     */
    public static Result list() {
        return ok();
    }


    /**
     * Shows a blank product form
     */
    public static Result newProduct() {
        return TODO;
    }

    /**
     * Shows a product edit form
     */
    public static Result details(String ean) {
        return TODO;
    }

    /**
     * Saves a product
     */
    public static Result save() {
        return TODO;
    }

}
