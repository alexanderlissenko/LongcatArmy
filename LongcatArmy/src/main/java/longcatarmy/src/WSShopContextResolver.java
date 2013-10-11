/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import longcat.auction.src.AuctionObjectProxy;

/**
 * This is used to remove '@'s from attribute names when serializing to JSON
 * and also produce an array of objects (if list returned)
 * The default serialization is "mapped" (badgerfish) here changed to "natural", see code 
 * 
 * Need dependency on jersey-json see pom. 
 * 
 * @author hajo
 * 
 * slightly modified to fit our project
 */
@Provider
public class WSShopContextResolver implements ContextResolver<JAXBContext> {

    private JAXBContext context;
    private Class[] types = {AuctionObjectProxy.class};

    public WSShopContextResolver() throws Exception {
        this.context = new JSONJAXBContext(JSONConfiguration.natural().build(),
                types);
    } 

    @Override
    public JAXBContext getContext(Class<?> objectType) {
        return (types[0].equals(objectType)) ? context : null;
    }
}
