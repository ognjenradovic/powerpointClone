package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Stroke;
import java.net.URL;
import java.util.List;

import Controller.Akcije;
import observer.Publisher;
import observer.Sub;

public class SlotModel extends RuNode implements Publisher {
	 //Ekvivalenta Diagramu D/E sa drugog proj

	private transient List<Sub> subscribers;
	private	int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private SerializableStroke stroke;
	private TipSlota tipSlota;
	private String text;
    private String url;

	//private Stroke stroke;




	public SlotModel(String name, RuNode parent, int x, int y, int width, int height, Color color) {
		super(name, parent);
		this.x = x;
		this.y = y;
		this.stroke=new SerializableStroke(new BasicStroke(3.0f));
		this.width = width;
		this.height = height;
		this.color = color;
		this.tipSlota=tipSlota.NEODREDJENO;
	}
	

	
	public SerializableStroke getStroke() {
		return stroke;
	}



	public void setStroke(SerializableStroke stroke) {
		this.stroke = stroke;
		notifySub(Akcije.APDEJTUJ);
	}



	public TipSlota getTipSlota() {
		return tipSlota;
	}



	public void setTipSlota(TipSlota tipSlota) {
		this.tipSlota = tipSlota;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
		notifySub(Akcije.APDEJTUJ);
	}

	


	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		 String urlTemp=url.toString();
		 urlTemp=urlTemp.substring(5);
	        this.url=urlTemp;
	        notifySub(Akcije.APDEJTUJ);
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		notifySub(Akcije.APDEJTUJ);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		notifySub(Akcije.APDEJTUJ);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		notifySub(Akcije.APDEJTUJ);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		notifySub(Akcije.APDEJTUJ);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		notifySub(Akcije.APDEJTUJ);
	}

	/*public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}*/
	
	
	
	}
