/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crdws.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Huy Nguyen
 */
@javax.ws.rs.ApplicationPath("api/v1")
public class AppConfig extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(crdws.service.MedicineService.class);
        resources.add(crdws.service.NoodleService.class);
        resources.add(crdws.service.ProvinceService.class);
        resources.add(crdws.service.RiceService.class);
    }
}
