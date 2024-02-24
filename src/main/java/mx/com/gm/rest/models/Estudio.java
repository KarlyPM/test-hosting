
package mx.com.gm.rest.models;

import java.io.Serializable;
import lombok.Data;


import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
public class Estudio implements Serializable{
    
    private Integer idEstudio;
    private String institucion;
    private String titulo;
    private Pais pais;
    
    private static final long serialVersionUID = 1L;
    
}
