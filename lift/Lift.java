package lift;

public class Lift {
	
	String nameOfLift;
int curPosition =0;
int prePosition=0;
static int capacity=0;

public Lift(String name) {
	nameOfLift=name ;
}
public void setPosition(int value) {
	prePosition =curPosition;
	curPosition =value;
}
public String  getName() {
	return nameOfLift;
}
public int getCurPosition() {
	return curPosition;
}
public static boolean check(int c) {
	if(capacity<=4) {
		return true;
	}
	else {
		return false;
	}
	
}
@Override
public String toString() {
	return "Lift [nameOfLift=" + nameOfLift + ", curPosition=" + curPosition +"]";
}
}
