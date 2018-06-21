package structures.list;

import java.time.LocalDateTime;

/** Implements a single linked Linked List
 * 
 * @author iain
 *
 */
public final class CatTracker {

	private LocalDateTime time;
	private String comment;
	private CatTracker next;
	
	public CatTracker(LocalDateTime time, String comment) {
		super();
		this.time = time;
		this.comment = comment;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getComment() {
		return comment;
	}

	public CatTracker getNext() {
		return next;
	}
	
	public void setNext(final CatTracker catTracker){
		this.next = catTracker;
	}

	@Override
	public String toString() {
		return "CatTracker [time=" + time + ", comment=" + comment + ", previousMovement=" + next + "]";
	}

	
}
