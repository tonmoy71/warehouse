package controllers;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.products.list;

import java.util.List;

/**
 * Created by tonmoy on 02-Jan-16.
 */
public class Products extends Controller {

    private static final Form<Product> productForm = Form.form(Product.class);

    /**
     * Lists all products
     */
    public static Result list() {
        List<Product> products = Product.findAll();
        return ok(views.html.products.list.render(products));
    }


    /**
     * Shows a blank product form
     */
    public static Result newProduct() {
        return ok(views.html.products.details.render(productForm));
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
        Form<Product> boundForm = productForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            flash("error", "Please correct the form below.");
            return badRequest(views.html.products.details.render(boundForm));
        }
        Product product = boundForm.get();
        product.save();
        flash("Success", String.format("Successfully added product %s", product));

        return redirect(routes.Products.list());
    }

}
