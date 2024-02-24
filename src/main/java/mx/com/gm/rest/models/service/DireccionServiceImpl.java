package mx.com.gm.rest.models.service;

import mx.com.gm.rest.models.Direccion;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Gustavo Jimenez
 */

@Service
public class DireccionServiceImpl implements DireccionService{
    
    @Autowired
    private RestTemplate direccionRest;

    List<Direccion> direccions;

    @Override
    public List<Direccion> findAll() {

        direccions = Arrays.asList(direccionRest.getForObject("http://localhost:8585/bolsatrabajo/direccion", Direccion[].class));

        return direccions;
    }

    @Override
    public void save(Direccion direccion) {
        String createDireccionUrl = "http://localhost:8585/bolsatrabajo/crear_direccion";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//       //construimosel json request
        HttpEntity<Direccion> request = new HttpEntity<>(direccion, headers);
//       
//       //enviamos la petición post
        ResponseEntity<Direccion> response = direccionRest.postForEntity(createDireccionUrl, request, Direccion.class);
//		

    }

    @Override
    public Direccion uptadeDireccion(Direccion direccion) {

        String updateDireccionUrl = "http://localhost:8585/bolsatrabajo/update_direccion";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//       //construimosel json request
        HttpEntity<Direccion> entity = new HttpEntity<>(direccion,headers);
//       
        //enviamos la petición post

        ResponseEntity<Direccion> responseDir = direccionRest.exchange(updateDireccionUrl + "/" + direccion.getIdDireccion(), HttpMethod.PUT, entity, Direccion.class);

    return direccion;
    }

    @Override
    public void deleteDireccion(Integer id) {
        int a = id;
    }

    @Override
    public Direccion findById(Integer id) {

       
        // comunidad = (Comunidad)comunidads.stream().map(p ->Objects.equals(p.getIdComunidad(), id));

        Iterator it = direccions.iterator();
        Direccion direc=null;
        while (it.hasNext()) {
            direc = (Direccion) it.next();
           if(direc.getIdDireccion()==id)
           {
         
            break;
           }
        }

        return direc;
    }
}
