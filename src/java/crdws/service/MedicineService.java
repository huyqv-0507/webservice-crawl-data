/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crdws.service;

import crdws.TblMedicine;
import crdws.TblMedicine_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Huy Nguyen
 */
@Stateless
@Path("medicines")
public class MedicineService extends BaseService<TblMedicine> {

    @PersistenceContext(unitName = "CRDWSPU")
    private EntityManager em;

    public MedicineService() {
        super(TblMedicine.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(TblMedicine entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, TblMedicine entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public TblMedicine find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    //Thuốc giảm đau, hạ sốt
    @GET
    @Path("painfever")
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> fetchPainFevers() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TblMedicine> criteriaQuery = criteriaBuilder.createQuery(TblMedicine.class);

        Root<TblMedicine> medicine = criteriaQuery.from(TblMedicine.class);

        criteriaQuery.select(medicine).where(criteriaBuilder.and(
                criteriaBuilder.like(medicine.get("description"), "%giảm đau%"),
                criteriaBuilder.like(medicine.get("description"), "%hạ sốt%"),
                criteriaBuilder.like(medicine.get("description"), "%paracetamol%"),
                criteriaBuilder.equal(medicine.get("categoryName"), "Thuốc giảm đau, hạ sốt")));

        return em.createQuery(criteriaQuery).getResultList();
    }

    //Thuốc cảm lạnh, ho
    @GET
    @Path("coldcough")
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> fetchColdCoughs() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TblMedicine> criteriaQuery = criteriaBuilder.createQuery(TblMedicine.class);

        Root<TblMedicine> medicine = criteriaQuery.from(TblMedicine.class);

        criteriaQuery.select(medicine).where(criteriaBuilder.and(
                criteriaBuilder.like(medicine.get("description"), "%ho%"),
                criteriaBuilder.like(medicine.get("description"), "%cảm%"),
                criteriaBuilder.equal(medicine.get("categoryName"), "Thuốc cảm lạnh, ho")));
        return em.createQuery(criteriaQuery).getResultList();
    }

    //Thuốc da liễu
    @GET
    @Path("dermatology")
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> fetchDermatologies() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TblMedicine> criteriaQuery = criteriaBuilder.createQuery(TblMedicine.class);

        Root<TblMedicine> medicine = criteriaQuery.from(TblMedicine.class);

        criteriaQuery.select(medicine).where(criteriaBuilder.and(
                criteriaBuilder.or(
                        criteriaBuilder.like(medicine.get("description"), "%sát khuẩn%"),
                        criteriaBuilder.like(medicine.get("description"), "%sát trùng%")),
                criteriaBuilder.notLike(medicine.get("description"), "lang ben"),
                criteriaBuilder.equal(medicine.get("categoryName"), "Thuốc da liễu")));

        return em.createQuery(criteriaQuery).getResultList();
    }

    //Thuốc tiêu hoá
    @GET
    @Path("degestive")
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> fetchDegestives() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TblMedicine> criteriaQuery = criteriaBuilder.createQuery(TblMedicine.class);

        Root<TblMedicine> medicine = criteriaQuery.from(TblMedicine.class);

        criteriaQuery.select(medicine).where(criteriaBuilder.and(
                criteriaBuilder.like(medicine.get("description"), "%tiêu chảy%"),
                criteriaBuilder.equal(medicine.get("categoryName"), "Thuốc tiêu hoá")));

        return em.createQuery(criteriaQuery).getResultList();
    }

    //Vitamin
    @GET
    @Path("vitamin")
    @Produces({MediaType.APPLICATION_XML})
    public List<TblMedicine> fetchVitamins() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TblMedicine> criteriaQuery = criteriaBuilder.createQuery(TblMedicine.class);

        Root<TblMedicine> medicine = criteriaQuery.from(TblMedicine.class);

        criteriaQuery.select(medicine).where(criteriaBuilder.and(
                criteriaBuilder.or(
                        criteriaBuilder.like(medicine.get("description"), "%b1%"),
                        criteriaBuilder.like(medicine.get("description"), "%B1%")),
                criteriaBuilder.equal(medicine.get("categoryName"), "Viatamin và khoáng chất")));

        return em.createQuery(criteriaQuery).getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
