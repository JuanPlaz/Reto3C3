package Reto3.Reto3.servicios;

import Reto3.Reto3.entidades.Bike;
import Reto3.Reto3.repositorios.RepositoryBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBike {
    @Autowired
    private RepositoryBike rb;

    public List<Bike> allBike(){
        return  rb.findAll();
    }

    public Optional<Bike> getBike(int id){ return rb.findById(id); }

    public Bike saveBike(Bike bik) {
        if(bik.getId()!=null)
        {
            Optional<Bike> e = rb.findById(bik.getId());
            bik.setCategory(e.get().getCategory());
        }
        return  rb.save(bik);
    }

    public Bike updateBike(Bike bik){ return  rb.save(bik); }
    public void deleteBike(Bike bik){
        rb.delete(bik);
    }
    public Bike findBikeById(Integer doc){
        return  rb.findById(doc).get();
    }

    public void deleteBikeById(Integer doc){
        rb.deleteById(doc);
    }
}
