
package mx.com.gm.rest.models.service;

import java.util.List;
import mx.com.gm.rest.models.Estudio;


public interface EstudioService {
    public List<Estudio> findAll();
    public void save(Estudio estudio);
    public Estudio uptadeEstudio(Estudio estudio);
    public void deleteEstudio(Integer id);
    public Estudio findById(Integer id);
}
