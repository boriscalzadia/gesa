
package net.negociostecnologicos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoServicioConverter")
public class TipoServicioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
     return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String fijo = "";
        
        if (value != null){
            fijo = (String)  value;
            switch (fijo ) {
                case "0" :
                    fijo = "VARIABLE";
                break;
                case "1":
                     fijo = "FIJO";
                break;
            }
        }
    return fijo;
    }
    
}
