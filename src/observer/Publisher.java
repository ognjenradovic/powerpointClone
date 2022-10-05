package observer;

public interface Publisher {
	void addSub(Sub sub);
	void removeSub(Sub sub);
	void notifySub(Object notification);
}
