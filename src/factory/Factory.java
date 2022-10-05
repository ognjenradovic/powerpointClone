package factory;

import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.WorkspaceModel;

public class Factory {
public static final PrezentacijaFactory prezentacijaFactory=new PrezentacijaFactory();
public static final ProjekatFactory projekatFactory=new ProjekatFactory();
public static final SlajdFactory slajdFactory=new SlajdFactory();

public RuNodeFactory createFactory(RuNode parent) {
	if(parent instanceof WorkspaceModel) {
		return projekatFactory;
	}
	else if(parent instanceof ProjekatModel) {
		return prezentacijaFactory;
	}	
	else if(parent instanceof PrezentacijaModel) {
		return slajdFactory;
	}
	return null;
}


}
