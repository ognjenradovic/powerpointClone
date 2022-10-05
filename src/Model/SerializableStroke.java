package Model;


import java.awt.BasicStroke;
import java.awt.Shape;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializableStroke implements Serializable {

	private BasicStroke stroke;
	
	
	public SerializableStroke(BasicStroke s){
		this.stroke = s;
	}

	private void writeObject(java.io.ObjectOutputStream output) throws IOException{
			output.writeFloat(stroke.getLineWidth());
			output.writeInt(stroke.getEndCap());
			output.writeInt(stroke.getLineJoin());
			output.writeFloat(stroke.getMiterLimit());
			output.writeObject(stroke.getDashArray());
			output.writeFloat(stroke.getDashPhase());
     }
	public Shape createStrokedShape(Shape p) {
		return stroke.createStrokedShape(p);
	}

	
	
    private void readObject(java.io.ObjectInputStream input) 
     		throws IOException, ClassNotFoundException{
    	
    	stroke = new BasicStroke(input.readFloat(),input.readInt(),input.readInt(),
    			input.readFloat(),(float[])input.readObject(),input.readFloat());
    	
     }
		
	
    
    
	

}

