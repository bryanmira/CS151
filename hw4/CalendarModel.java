import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CalendarModel {
	private ArrayList<Event> eventList;
	//listeners
	private ArrayList<ChangeListener> listeners;
	int day;
	int month;
	int year;
	private GregorianCalendar curr;
	
	public CalendarModel() {
	eventList = new ArrayList<>();
	listeners = new ArrayList<>();
	curr = new GregorianCalendar();
	}
	///day
	
	public void setDay(int t) {
		this.day = t;
		for (ChangeListener l : listeners)
	      {
	         l.stateChanged(new ChangeEvent(this));
	      }
	}
	
	public int getDay () {
		return day;
	}
	
	public String toString() {
	    String results = "+";
	    for(Event d : eventList) {
	        results += d.toString()+"\n"; //if you implement toString() for Dog then it will be added here
	    }
	    return results;
	  }
	
	
	public void attach(ChangeListener l)
	{
		listeners.add(l);
	}
	
	public GregorianCalendar getCurr() {
		//GregorianCalendar curr = new GregorianCalendar();
		//curr.set(GregorianCalendar.DATE, day);
		return curr;
	}
	
	public void setCurr(int month1, int day1, int year1) {
		curr.set(GregorianCalendar.DATE, day1);
		curr.set(GregorianCalendar.YEAR, year1);
		curr.set(GregorianCalendar.MONTH, month1);
		for (ChangeListener l : listeners)
	      {
	         l.stateChanged(new ChangeEvent(this));
	      }
	}
	
	public void update(Event e) {
		eventList.add(e);
		for (ChangeListener l : listeners)
	      {
	         l.stateChanged(new ChangeEvent(this));
	      }
	}
}
