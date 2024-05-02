package lift;

import java.util.ArrayList;
import java.util.Scanner;

public class LiftMain {
	static ArrayList<Lift> position = new ArrayList<Lift>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int first = 0;
		while (first < 5) {
			String name = "L" + (++first);
			position.add(new Lift(name));
		}
		while (true) {
			LiftView.Text("1.print lift\n2.assign floor \n3.maintanence \n9.exit\n enter value :");
			int a = s.nextInt();
			if (a == 1) {
				printLift();
			}
			if (a == 9) {
				break;
			}
			if (a == 2) {
				changePosition();
			}
			if (a == 3) {
				maintanence();
			}
		}
	}

	public static void printLift() {
		LiftView.Text("Lift: ");
		for (Lift lift : position) {
			LiftView.Text(lift.getName() + " ");
		}
		LiftView.textln("");
		LiftView.Text("floor: ");
		for (Lift lift : position) {
			LiftView.Text(lift.getCurPosition() + " ");
		}
		LiftView.textln("");
	}

	public static Lift assignFloor(int current, int destination) {

		Lift l = null;
		int min = 11;
		for (Lift lift : position) {
			if (lift.curPosition != -1) {
				if ((lift.nameOfLift.equals("L1") || lift.nameOfLift.equals("L2"))
						&& (current >= 0 && destination <= 5)) {
					int min2 = Math.min(Math.abs(current - lift.curPosition), min);
					if (min2 < min) {
						l = lift;
						
						min = min2;
					} else if (min == min2 && min2 != 0) {
						int dir = current - destination;
						if (dir < 0) {
							int ldir = Math.abs(l.prePosition - l.curPosition);
							//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
							l = ldir < current ? l : lift;
						} else if (dir > 0) {
							int ldir = Math.abs(l.prePosition - l.curPosition);
							//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
							l = ldir > current ? l : lift;
						}
					}
				} else if ((lift.nameOfLift.equals("L3") || lift.nameOfLift.equals("L4"))
						&& ((current >= 6 && destination <= 10) || (current == 0 && destination >= 6)
								|| current >= 6 && destination == 0)) {
					int min2 = Math.min(Math.abs(current - lift.curPosition), min);
					if (min2 < min) {
						l = lift;
						min = min2;
					} else if (min == min2 && min2 != 0) {
						int dir = current - destination;
						if (dir < 0) {
							int ldir = Math.abs(l.prePosition - l.curPosition);
							//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
							l = ldir < current ? l : lift;
						} else if (dir > 0) {
							int ldir = Math.abs(l.prePosition - l.curPosition);
							//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
							l = ldir > current ? l : lift;
						}
					}
				} else if (lift.nameOfLift.equals("L5")) {
					if(current==0) {
						int min2 = Math.min(Math.abs(current - lift.curPosition), min);
						if (min2 < min) {
							l = lift;
							min = min2;
						} else if (min == min2 && min2 != 0) {
							int dir = current - destination;
							if (dir < 0) {
								int ldir = Math.abs(l.prePosition - l.curPosition);
								//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
								l = ldir < current ? l : lift;
							} else if (dir > 0) {
								int ldir = Math.abs(l.prePosition - l.curPosition);
								//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
								l = ldir > current ? l : lift;
							}
						}
					}
					else if(l==null) {
						int min2 = Math.min(Math.abs(current - lift.curPosition), min);
						if (min2 < min) {
							l = lift;
							min = min2;
						} else if (min == min2 && min2 != 0) {
							int dir = current - destination;
							if (dir < 0) {
								int ldir = Math.abs(l.prePosition - l.curPosition);
								//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
								l = ldir < current ? l : lift;
							} else if (dir > 0) {
								int ldir = Math.abs(l.prePosition - l.curPosition);
								// l2dir = Math.abs(lift.prePosition - lift.curPosition);
								l = ldir > current ? l : lift;
							}
						}
					}
				}
			}

		}
		return l;
	}

	public static void changePosition() {
		Scanner s = new Scanner(System.in);
		LiftView.Text("current floor: ");
		int current = s.nextInt();
		LiftView.Text("destination floor: ");
		int destination = s.nextInt();
		Lift l = assignFloor(current, destination);
		LiftView.textln(l.nameOfLift + " is assigned");
		l.prePosition = current;
		l.curPosition = destination;
		System.out.println(l.curPosition + " c   " + l.prePosition + "    p");
	}
	public static Lift check(Lift lift,int current,int destination, int min,Lift l) {
		Lift l1=l;
		int min2 = Math.min(Math.abs(current - lift.curPosition), min);
		if (min2 < min) {
			l1 = lift;
			min = min2;
		} else if (min == min2 && min2 != 0) {
			int dir = current - destination;
			if (dir < 0) {
				int ldir = Math.abs(l1.prePosition - l1.curPosition);
				//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
				l1 = ldir < current ? l : lift;
			} else if (dir > 0) {
				int ldir = Math.abs(l1.prePosition - l1.curPosition);
				//int l2dir = Math.abs(lift.prePosition - lift.curPosition);
				l1 = ldir > current ? l1 : lift;
			}
		}
		return l1;
	}
	public static void maintanence() {
		Scanner s = new Scanner(System.in);
		LiftView.Text("enter the lift for maintanence : ");
		String lift = s.next();
		for (Lift lifting : position) {
			if (lift.equalsIgnoreCase(lifting.nameOfLift)) {
				lifting.curPosition = -1;
			}
		}
	}
}
