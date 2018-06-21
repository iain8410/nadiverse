package structures.list;

import java.time.LocalDateTime;

public class CatTrackerHistory {

	private static CatTracker catTracker;
	
	public static void main(String[] args) {
		CatTrackerHistory catTrackerHistory = new CatTrackerHistory();
		catTrackerHistory.makeUpHistory();
		
		catTrackerHistory.showHistory(catTracker);
	}
	
	private void makeUpHistory(){
		LocalDateTime wakeUp = LocalDateTime.now();
		catTracker = new CatTracker(wakeUp, null);
		
		LocalDateTime outside = LocalDateTime.now().plusMinutes(2);
		CatTracker outside1 = new CatTracker(outside, null);
		catTracker.setNext(outside1);
		
		LocalDateTime inside = LocalDateTime.now().plusMinutes(5);
		CatTracker inside1 = new CatTracker(inside, null);
		outside1.setNext(inside1);
		
		LocalDateTime outside2 = LocalDateTime.now().plusMinutes(7);
		CatTracker out2 = new CatTracker(outside2, null);
		inside1.setNext(out2);
	}
	
	private void showHistory(CatTracker history){
		if (history != null && history.getNext() != null){
			System.out.println(history.getTime());
			showHistory( history.getNext() );
		}
		else {
			System.out.println(history.getTime());
		}
	}

}
