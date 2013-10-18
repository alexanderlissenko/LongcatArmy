package longcatarmy.view;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.ToggleEvent; 

/**
 *
 * @author k02sthe
 */

public class FieldsetBean {  
    public void handleToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}