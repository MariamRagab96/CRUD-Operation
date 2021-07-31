package com.mycompany.inventory.doa.model;

import com.mycompany.inventory.doa.entity.Inventory;
import java.util.List;

public interface InventoryModel {

    int update(Inventory inventory);

    int delete(int id);

    List<Inventory> retriveAll();

    void insert(Inventory inventory);

}
