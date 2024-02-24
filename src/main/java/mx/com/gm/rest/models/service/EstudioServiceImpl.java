package mx.com.gm.rest.models.service;

import mx.com.gm.rest.models.Estudio;

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

@Service
public class EstudioServiceImpl implements EstudioService {

    @Autowired
    private RestTemplate estudioRest;

    List<Estudio> estudios;

    @Override
    public List<Estudio> findAll() {

        estudios = Arrays.asList(estudioRest.getForObject("http://localhost:8585/bolsatrabajo/estudio", Estudio[].class));

        return estudios;
    }

    @Override
    public void save(Estudio estudio) {
        String createEstudioUrl = "http://localhost:8585/bolsatrabajo/crear_estudio";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//       //construimosel json request
        HttpEntity<Estudio> request = new HttpEntity<>(estudio, headers);
//       
//       //enviamos la petición post
        ResponseEntity<Estudio> response = estudioRest.postForEntity(createEstudioUrl, request, Estudio.class);
//		

    }

    @Override
    public Estudio uptadeEstudio(Estudio estudio) {

        String updateEstudioUrl = "http://localhost:8585/bolsatrabajo/update_estudio";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//       //construimosel json request
        HttpEntity<Estudio> entity = new HttpEntity<>(estudio,headers);
//       
        //enviamos la petición post

        ResponseEntity<Estudio> responseCom = estudioRest.exchange(updateEstudioUrl + "/" + estudio.getIdEstudio(), HttpMethod.PUT, entity, Estudio.class);

    return estudio;
    }

    @Override
    public void deleteEstudio(Integer id) {
        int a = id;
    }

    @Override
    public Estudio findById(Integer id) {

       
        // comunidad = (Comunidad)comunidads.stream().map(p ->Objects.equals(p.getIdComunidad(), id));

        Iterator it = estudios.iterator();
        Estudio estu=null;
        while (it.hasNext()) {
            estu = (Estudio) it.next();
           if(estu.getIdEstudio()==id)
           {
         
            break;
           }
        }

        return estu;
    }

}
