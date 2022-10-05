package Controller;

import java.util.ArrayList;
import java.util.List;

import observer.Publisher;
import observer.Sub;

public class ErrorFactory implements Publisher {

	  private static ErrorFactory instance = null;
	    List<Sub> subscribers = new ArrayList<>();

	    public static ErrorFactory getInstance() {
	        if (instance == null){
	            instance = new ErrorFactory();
	        }
	        return instance;
	    }

	    public void generateError(ENumError error){
	        String poruka = null;
	        if(error == ENumError.NEDOSTAJE_IME_AUTOR){
	            poruka = "Nisi popunio sva polja!";
	        } else if(error == ENumError.NEDOSTAJE_SLIKA){
	            poruka =  "Nisi izabrao sliku!";
	        }
	        else if(error == ENumError.NIJE_SELEKTOVANA_PREZENTACIJA){
	            poruka =  "Nisi selektovao prezentaciju!";
	        }
	        Error Error = new Error(error,poruka);
	        notifySub(Error);
	    }


	    @Override
	    public void addSub(Sub sub) {
	        if(sub != null && !this.subscribers.contains(sub)){
	            subscribers.add(sub);
	        }
	    }

	    @Override
	    public void removeSub(Sub sub) {
	        if(sub != null && this.subscribers.contains(sub)){
	            subscribers.remove(sub);
	        }
	    }

	    @Override
	    public void notifySub(Object notification) {
	        if (notification != null && this.subscribers != null && !this.subscribers.isEmpty()) {
	            for(int i=0;i< subscribers.size();i++){
	                subscribers.get(i).update(notification);
	            }
	        }
	    }

}
