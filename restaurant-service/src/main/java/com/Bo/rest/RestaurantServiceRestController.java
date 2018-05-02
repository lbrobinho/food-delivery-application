package com.Bo.rest;

import com.Bo.domain.Menu;
import com.Bo.domain.MenuItem;
import com.Bo.domain.Restaurant;
import com.Bo.service.MenuItemService;
import com.Bo.service.MenuService;
import com.Bo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantServiceRestController {

    private RestaurantService restaurantService;
    private MenuService menuService;
    private MenuItemService menuItemService;

   @Autowired
   public RestaurantServiceRestController(RestaurantService restaurantService, MenuService menuService,
                                          MenuItemService menuItemService) {
       this.restaurantService = restaurantService;
       this.menuService = menuService;
       this.menuItemService = menuItemService;
   }

//   ------------------------------------------------Restaurant--------------------------------------------------------//

//    Upload restaurant lists
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Restaurant> restaurantList) throws Exception {
        this.restaurantService.saveRestaurants(restaurantList);
    }

//    Find all restaurants or if you know name, get specific one
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Page<Restaurant> findAll(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "page", required = false) int page,
            @RequestParam(name = "size", required = false) Integer size) {

        if(name != null) {
            return restaurantService.findByName(name, new PageRequest(page, size == null ? 10 : size));
        } else {
            return restaurantService.findAll(new PageRequest(page, size == null ? 10 : size));
        }
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET)
    public Restaurant findRestaurantById(@PathVariable(value = "id") int id) {
        return restaurantService.findById(id);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.DELETE)
    public void deleteAllRestaurants() {
       restaurantService.deleteAll();
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE)
    public void deleteRestaurantById(@PathVariable(value = "id") int id) {
        restaurantService.deleteById(id);
    }

    @RequestMapping(value = "/restaurants/{id}/menus", method = RequestMethod.GET)
    public List<Menu> findMenuByRestaurantName(@PathVariable(value = "id") int id) {
       return restaurantService.findById(id).getMenus();
    }

//    ----------------------------------Menu---------------------------------------------------------------------------//

//    Upload menu
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void uploadMenu(@RequestBody List<Menu> menuList) {
        this.menuService.uploadMenu(menuList);
    }

//    Find all menus
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public Page<Menu> findAllMenu(@RequestParam(value = "page") int page,
                       @RequestParam(value = "size", required = false) Integer size) {
        return menuService.findAll(new PageRequest(page, size == null ? 10 : size));
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
    public Menu findMenuById(@PathVariable(value = "id") int id) {
        return menuService.findById(id);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.DELETE)
    public void deleteAllMenu() {
        this.menuService.deleteAll();
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.DELETE)
    public void deleteMenuById(@PathVariable("id") int id) {
        menuService.deleteById(id);
    }


//    ----------------------------------MenuItem-----------------------------------------------------------------------//

    @RequestMapping(value = "/menu_items", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void uploadMenuItem(@RequestBody List<MenuItem> menuItemList) {
        this.menuItemService.uploadMenuItem(menuItemList);
    }

    @RequestMapping(value = "/menu_items", method = RequestMethod.GET)
    public Page<MenuItem> findAllMenuItem(@RequestParam(value = "page") int page,
                           @RequestParam(value = "size", required = false) Integer size) {
        return menuItemService.findAll(new PageRequest(page, size == null ? 10 : size));
    }

    @RequestMapping(value = "/menu_items/{id}", method = RequestMethod.GET)
    public MenuItem findById(@PathVariable("id") int id) {
        return menuItemService.findById(id);
    }

    @RequestMapping(value = "/menu_items/{id}/price", method = RequestMethod.GET)
    public float getPrice(@PathVariable("id") int id) {
        return menuItemService.findById(id).getPrice();
    }

    @RequestMapping(value = "/menu_items", method = RequestMethod.DELETE)
    public void deleteAllItems() {
        menuItemService.deleteAll();
    }

    @RequestMapping(value = "/menu_items/{id}", method = RequestMethod.DELETE)
    public void deleteItemById(@PathVariable("id") int id) {
        menuItemService.deleteById(id);
    }
}


