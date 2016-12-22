import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Participant implements Comparable<Participant> {
	private String name;
	private String location;
	private List<Entry> listOfEntries = new ArrayList<Entry>();
	private List<Entry> filteredList;
	private double average_score;
	private boolean qualifies;

	public Participant(String name, String loc) {
		this.name = name;
		this.location = loc;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return "Name: " + this.name + ", Average score: " +df.format(this.average_score);
	}

	/**
	 * Add the parameter to this Participant's listOfEntries
	 * 
	 * @param entry
	 *            the Entry to add to a list
	 */
	public void addEntry(Entry entry) {
		this.listOfEntries.add(entry);
	}

	public List<Entry> getEntries() {
		return this.listOfEntries;
	}

	/**
	 * @return The filtered list if it exists, otherwise returns the current
	 *         listOfEntries
	 */
	public List<Entry> getFilteredEntries() {
		if (filteredList != null) {
			return filteredList;
		} else {
			return listOfEntries;
		}
	}

	public double getAverageScore() {
		return average_score;
	}

	public boolean qualifies() {
		return qualifies;
	}

	/**
	 * Compute the average score of all the Entries in the listOfEntries. This
	 * formula is: average = total_entries / num_entries
	 * 
	 * This method should also set the average_score field.
	 */
	public void computeAndSetAverageScore() {
		double sum =0;
		int index = 0;
        for( Entry ent: listOfEntries){
            sum = sum + ent.getScore();
			index++;
        }
        average_score = sum/index;
	}

	/**
	 * Compute the average score of all the Entries in the filteredList. This
	 * formula is: average = total_entries / num_entries
	 * 
	 * This method should also set the average_score field.
	 */
	public void computeAndSetFilteredScore() {
        double sum =0;
        int index = 0;
        for( Entry ent: filteredList){
            sum = sum + ent.getScore();
			index++;
        }
        average_score = sum/index;
    }

	/**
	 * Set whether or not the Participant qualifies given it's filtered list.
	 * 
	 * If filteredList is empty or null, set the qualifies field to false,
	 * otherwise, true
	 * 
	 */
	public void setQualification() {
		if ( filteredList.size() > 0){
            qualifies = true;
        }else{
            qualifies = false;
        }
	}

	/**
	 * This method will return a negative integer, 0, or a positive
	 * integer if the average score of this participant is less than, equal to, 
	 * or greater than the average score of the participant being compared (respectively).
	 *
	 * You will need to implement this method.
	 * 
	 * @param o the Participant object you are comparing against
	 * @return 1 if this.average_score > o.average_score,
	 * 	0 if this.average_score == o.average_score,
	 * 	-1 if this.average_score < o.average_score
	 */
	public int compareTo(Participant o) {

		if( this.average_score < o.average_score){
			return -1;
		}
		else if(this.average_score > o.average_score){
			return 1;
		}
		else{
			return 0;
		}
	}

	/**
	 * This method will take in a list that has been filtered, and assign it to
	 * a field variable called filteredList
	 * 
	 * @param filteredList
	 *            the list to assign to the filteredList field
	 */
	public void setFilteredList(List<Entry> filteredList) {
		this.filteredList = filteredList;
	}

}
